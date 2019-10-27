package news;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.web.bind.annotation.*;

@RestController
public class NewsController {

    NewsMockedData newsMockedData = NewsMockedData.getInstance();
    DateFormat format = new SimpleDateFormat("yyyy-mm-dd", Locale.ENGLISH);

    @GetMapping("/newsArticle")
    public List<News> index(){
        return newsMockedData.fetchNews();
    }

    @GetMapping("/newsArticle/{id}")
    public News readNewsArticle(@PathVariable String id){
        int newsArticleId = Integer.parseInt(id);
        return newsMockedData.getNewsById(newsArticleId);
    }

    @PostMapping("/newsArticle")
    public News createNewsArticle(@RequestBody Map<String, String> body) throws ParseException {
        int id = Integer.parseInt(body.get("id"));
        String title = body.get("title");
        String text = body.get("text");
        Date date = format.parse(body.get("creationDate"));
        String linkToPicture = body.get("linkToPicture");
        return newsMockedData.createNews(id, title, text, date, linkToPicture );
    }

    @PutMapping("/newsArticle/{id}")
    public News updateNewsArticle(@PathVariable String id, @RequestBody Map<String, String> body) throws ParseException {
        int newsArticleId = Integer.parseInt(id);
        String title = body.get("title");
        String text = body.get("text");
        String linkToPicture = body.get("linkToPicture");
        return newsMockedData.editNewsArticle(newsArticleId, title, text, linkToPicture);
    }

    @DeleteMapping("newsArticle/{id}")
    public boolean deleteNewsArticle(@PathVariable String id){
        int newsArticleId = Integer.parseInt(id);
        return newsMockedData.delete(newsArticleId);
    }


}