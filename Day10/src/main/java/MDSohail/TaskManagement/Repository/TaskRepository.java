package MDSohail.TaskManagement.Repository;

import MDSohail.TaskManagement.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task,Long> {
    // Custom JPA query methods
    List<Task> findByTitle(String title);
    List<Task> findByDescriptionContaining(String keyword);
}
