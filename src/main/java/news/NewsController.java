package news;

import data.*;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
public class NewsController {

    NewsMockedData newsMockedData = NewsMockedData.getInstance();
    UsersMockedData users = UsersMockedData.getInstance();
    RolesMockedData roles = RolesMockedData.getInstance();
    PrivilegesMockedData privileges = PrivilegesMockedData.getInstance();
    PicturesMockedData pictures = PicturesMockedData.getInstance();

    DateFormat format = new SimpleDateFormat("yyyy-mm-dd", Locale.ENGLISH);

    public NewsController() throws IOException {
    }

    // get all unread news articles, allowed for READER, ADMIN and PUBLISHER
    @GetMapping("/actualNews")
    public List<News> index(){
          if (isAuthorized(getCurrentUsername() ,new ArrayList<String>(Arrays.asList("READER", "ADMIN", "PUBLISHER")))) {
              int userId = users.getUserByUsername(getCurrentUsername()).getId();

              return newsMockedData.fetchNews(userId);
          }
          else{
             throw new ResponseStatusException(
                     HttpStatus.UNAUTHORIZED, "This user is not authorized. Check your credentials.");
          }

    }

    // get news article by id, allowed for READER, ADMIN and PUBLISHER
    // after user reads article it's read status is updated and it will not appear
    // in the bulk news section accessible through /newsArticle
    @GetMapping("/newsArticle/{id}")
    public News readNewsArticle(@PathVariable String id) {
        int newsArticleId = Integer.parseInt(id);
        int userId = users.getUserByUsername(getCurrentUsername()).getId();
        if (isAuthorized(getCurrentUsername(), new ArrayList<String>(Arrays.asList("READER", "ADMIN", "PUBLISHER")))) {

            String status = updateReadStatus(newsArticleId, userId);
            return newsMockedData.getNewsById(newsArticleId);
        }
        else{
            throw new ResponseStatusException(
                    HttpStatus.UNAUTHORIZED, "This user is not authorized. Check your credentials.");
        }
    }

    // create/publish newsArticle, only ADMIN and PUBLISHER are allowed to
    @PostMapping("/newsArticle")
    public News createNewsArticle(@RequestBody Map<String, String> body) throws ParseException {
        if (isAuthorized(getCurrentUsername(), new ArrayList<String>(Arrays.asList("ADMIN", "PUBLISHER")))) {

            int id = Integer.parseInt(body.get("id"));
            String title = body.get("title");
            String text = body.get("text");
            Date date = format.parse(body.get("creationDate"));
            String linkToPicture = body.get("linkToPicture");
            List<Integer> readStatus = new ArrayList<Integer>();
            return newsMockedData.createNews(id, title, text, date, linkToPicture, readStatus);
        }
         else{
            throw new ResponseStatusException(
                    HttpStatus.UNAUTHORIZED, "This user is not authorized. Check your credentials.");
        }
    }

    // edit newsArticle, only ADMIN and PUBLISHER are allowed to
    @PutMapping("/newsArticle/{id}")
    public News updateNewsArticle(@PathVariable String id, @RequestBody Map<String, String> body) throws ParseException {
        if (isAuthorized(getCurrentUsername(), new ArrayList<String>(Arrays.asList("ADMIN", "PUBLISHER")))) {

            int newsArticleId = Integer.parseInt(id);
            String title = body.get("title");
            String text = body.get("text");
            String linkToPicture = body.get("linkToPicture");
            return newsMockedData.editNewsArticle(newsArticleId, title, text, linkToPicture);
        } else{
                throw new ResponseStatusException(
                        HttpStatus.UNAUTHORIZED, "This user is not authorized. Check your credentials.");
            }
    }

    // delete newsArticle, only ADMIN and PUBLISHER are allowed to
    @DeleteMapping("newsArticle/{id}")
    public String deleteNewsArticle(@PathVariable String id){
        if (isAuthorized(getCurrentUsername(), new ArrayList<String>(Arrays.asList("ADMIN", "PUBLISHER")))) {
            int newsArticleId = Integer.parseInt(id);
            return newsMockedData.delete(newsArticleId);
        }   else{
            throw new ResponseStatusException(
                    HttpStatus.UNAUTHORIZED, "This user is not authorized. Check your credentials.");
        }
    }


    // setReadStatus of newsArticle, only ADMIN and PUBLISHER are allowed to
    @PutMapping("setReadStatus/{newsId}")
    public String setReadStatus(@PathVariable String newsId, @RequestParam String userId){
        if (isAuthorized(getCurrentUsername(), new ArrayList<String>(Arrays.asList("ADMIN", "PUBLISHER")))) {
            int newsArticleId = Integer.parseInt(newsId);
            updateReadStatus(newsArticleId, Integer.parseInt(userId));

            return "Read status for article with id "+newsId+" updated successfully.";
        }   else{
            throw new ResponseStatusException(
                    HttpStatus.UNAUTHORIZED, "This user is not authorized. Check your credentials.");
        }
    }

    // Returns a picture for a single news Article, READER, ADMIN and PUBLISHER are allowed to
    @GetMapping(value = "picture/{pictureId}", produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<InputStreamResource> getPicture(@PathVariable String pictureId) throws IOException {
        if (isAuthorized(getCurrentUsername(), new ArrayList<String>(Arrays.asList("READER", "ADMIN", "PUBLISHER")))) {
            int picId = Integer.parseInt(pictureId);
            ClassPathResource picture = pictures.getPictureById(picId).getPictureData();

            return ResponseEntity
                    .ok()
                    .contentType(MediaType.IMAGE_JPEG)
                    .body(new InputStreamResource(picture.getInputStream()));
        }   else{
            throw new ResponseStatusException(
                    HttpStatus.UNAUTHORIZED, "This user is not authorized. Check your credentials.");
        }
    }

    // Creates a new Role, only ADMIN is allowed to
    @PostMapping("permittedRoles/{roleId}")
    public String createNewRole(@PathVariable String roleId, @RequestParam String roleName){
        if (isAuthorized(getCurrentUsername(), new ArrayList<String>(Arrays.asList("ADMIN")))) {
            int index = roles.getRoles().size();
            int role = Integer.parseInt(roleId);
            List<Privilege> rolePrivileges;
            switch (role){
                case 1:
                    rolePrivileges = roles.getAdminPrivileges();
                    break;
                case 2:
                    rolePrivileges = roles.getPublisherPrivileges();
                    break;
                default:
                    rolePrivileges = roles.getReaderPrivileges();
            }
            roles.getRoles().add(new Role((index),roleName,rolePrivileges));
            return "New role created successfully.";
        }   else{
            throw new ResponseStatusException(
                    HttpStatus.UNAUTHORIZED, "This user is not authorized. Check your credentials.");
        }
    }


    // get the username of the user who sent request to the API
    private String getCurrentUsername(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        return currentPrincipalName;
    }

    // check if user has the correct role for access
    private boolean isAuthorized(String username, List<String> roles) {

         for (int i=0; i<roles.size(); i++) {
            if (roles.get(i).equals(users.getUserByUsername(username).getRole().getName())) {
                return true;
            }
        }
        return false;
    }

    private String updateReadStatus(int newsArticleId, int userId){
        News newsArticle = newsMockedData.getNewsById(newsArticleId);
        if(!newsArticle.getReadStatus().contains(userId)){
            newsArticle.getReadStatus().add(userId);
        }
        return "Ok";
    }

}