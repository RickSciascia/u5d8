package ricksciascia.u5d8.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ricksciascia.u5d8.entities.BlogPost;

@Repository
public interface BlogPostRepository extends JpaRepository<BlogPost,Long> {
}
