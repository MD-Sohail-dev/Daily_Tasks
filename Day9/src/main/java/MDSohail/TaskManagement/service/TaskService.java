package MDSohail.TaskManagement.service;




import MDSohail.TaskManagement.Repository.TaskRepository;
import MDSohail.TaskManagement.entity.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
     private TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task getTaskById(Long id) {
        return taskRepository.findById(id).orElse(null);
    }



    public String deleteTask(Long id) {
        taskRepository.deleteById(id);
        return "Task deleted successfully!";
    }

    public List<Task> searchByTitle(String title) {
        return taskRepository.findByTitle(title);
    }

    public List<Task> searchByKeyword(String keyword) {
        return taskRepository.findByDescriptionContaining(keyword);
    }
}

