package MDSohail.TaskManagement.controller;


import MDSohail.TaskManagement.entity.Task;
import MDSohail.TaskManagement.service.TaskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
@Slf4j
public class TaskController {



    @Autowired
    private TaskService taskService;

    @PostMapping
    public ResponseEntity<?> createTask(@RequestBody Task task) {
        try {
            Task createdTask = taskService.createTask(task);
            log.info("Task created successfully with id: {}", createdTask.getId());
            return new ResponseEntity<>(createdTask, HttpStatus.CREATED);
        } catch (Exception e) {
            log.error("Error creating task", e);
            return new ResponseEntity<>("Failed to create task", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<?> getAllTasks() {
        try {
            List<Task> tasks = taskService.getAllTasks();
            return new ResponseEntity<>(tasks, HttpStatus.OK);
        } catch (Exception e) {
            log.error("Error fetching tasks", e);
            return new ResponseEntity<>("Failed to fetch tasks", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTaskById(@PathVariable Long id) {
        try {
            Task task = taskService.getTaskById(id);
            if (task != null) {
                return new ResponseEntity<>(task, HttpStatus.OK);
            } else {
                log.warn("Task with id {} not found", id);
                return new ResponseEntity<>("Task not found", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            log.error("Error fetching task with id: " + id, e);
            return new ResponseEntity<>("Failed to fetch task", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTask(@PathVariable Long id) {
        try {
            String message = taskService.deleteTask(id);
            log.info("Task with id {} deleted successfully", id);
            return new ResponseEntity<>(message, HttpStatus.OK);
        } catch (Exception e) {
            log.error("Error deleting task with id: " + id, e);
            return new ResponseEntity<>("Failed to delete task", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/search/title/{title}")
    public ResponseEntity<?> searchByTitle(@PathVariable String title) {
        try {
            List<Task> tasks = taskService.searchByTitle(title);
            return new ResponseEntity<>(tasks, HttpStatus.OK);
        } catch (Exception e) {
            log.error("Error searching tasks by title", e);
            return new ResponseEntity<>("Failed to search tasks", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/search/keyword/{keyword}")
    public ResponseEntity<?> searchByKeyword(@PathVariable String keyword) {
        try {
            List<Task> tasks = taskService.searchByKeyword(keyword);
            return new ResponseEntity<>(tasks, HttpStatus.OK);
        } catch (Exception e) {
            log.error("Error searching tasks by keyword", e);
            return new ResponseEntity<>("Failed to search tasks", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

