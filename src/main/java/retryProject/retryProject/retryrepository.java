package retryProject.retryProject;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface retryrepository extends JpaRepository<retry,Integer> {
}
