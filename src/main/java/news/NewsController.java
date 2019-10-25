package news;

import java.util.List;

import org.springframework.web.bind.annotation.*;

@RestController
public class NewsController {

    NewsMockedData newsMockedData = NewsMockedData.getInstance();

    @GetMapping("/newsArticle")
    public List<News> index(){
        return newsMockedData.fetchNews();
    }
/*
    @GetMapping("/blog/{id}")
    public Blog show(@PathVariable String id){
        int blogId = Integer.parseInt(id);
        return NewsMockedData.getBlogById(blogId);
    }

    @PostMapping("/blog/search")
    public List<Blog> search(@RequestBody Map<String, String> body){
        String searchTerm = body.get("text");
        return NewsMockedData.searchBlogs(searchTerm);
    }

    @PostMapping("/blog")
    public Blog create(@RequestBody Map<String, String> body){
        int id = Integer.parseInt(body.get("id"));
        String title = body.get("title");
        String content = body.get("content");
        return NewsMockedData.createBlog(id, title, content);
    }

    @PutMapping("/blog/{id}")
    public Blog update(@PathVariable String id, @RequestBody Map<String, String> body){
        int blogId = Integer.parseInt(id);
        String title = body.get("title");
        String content = body.get("content");
        return NewsMockedData.updateBlog(blogId, title, content);
    }

    @DeleteMapping("blog/{id}")
    public boolean delete(@PathVariable String id){
        int blogId = Integer.parseInt(id);
        return NewsMockedData.delete(blogId);
    }

*/
}