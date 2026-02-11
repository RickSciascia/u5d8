package ricksciascia.u5d8.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ricksciascia.u5d8.entities.BlogPost;
import ricksciascia.u5d8.payloads.BlogPostPayload;
import ricksciascia.u5d8.services.BlogPostsService;

@RestController
@RequestMapping({"/blogs"})
public class BlogPostController {
    private final BlogPostsService blogPostsService;

    @Autowired
    public BlogPostController(BlogPostsService blogPostsService) {
        this.blogPostsService = blogPostsService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BlogPost saveBlogPost(@RequestBody BlogPostPayload payload) {

        return this.blogPostsService.saveBlogPost(payload);
    }
}
