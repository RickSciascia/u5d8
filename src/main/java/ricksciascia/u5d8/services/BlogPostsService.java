package ricksciascia.u5d8.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ricksciascia.u5d8.entities.Author;
import ricksciascia.u5d8.entities.BlogPost;
import ricksciascia.u5d8.payloads.BlogPostPayload;
import ricksciascia.u5d8.repositories.BlogPostRepository;

@Service
public class BlogPostsService {
    private final BlogPostRepository blogPostRepository;
    private final AuthorsService authorsService;

    @Autowired
    public BlogPostsService(BlogPostRepository blogPostRepository, AuthorsService authorsService) {
        this.blogPostRepository = blogPostRepository;
        this.authorsService = authorsService;
    }

    public BlogPost saveBlogPost(BlogPostPayload payload) {
//        innanzitutto dovrei prendere l idAuthor del payload e trovare l oggetto Author da DB in modo da allegarlo
        long authorId = payload.getAuthorId();
//        trovo l oggetto autoreBlog per poi allegarlo
        Author autoreBlog = this.authorsService.getAuthorById(authorId);
//        creo nuovo blog
        BlogPost newBlog = new BlogPost(payload.getCategory(), payload.getTitle(), payload.getContent(), payload.getTempoDiLettura());
//        setto l autore del blog con l id che ho recuperato dal payload prima
        newBlog.setAuthor(autoreBlog);
//        salvo
        BlogPost salvato = this.blogPostRepository.save(newBlog);
//        log
        System.out.println("Blog " + salvato.getTitle() + " dell'autore: "+ autoreBlog + " salvato correttamente");
//        ritorno
        return salvato;
    }
}
