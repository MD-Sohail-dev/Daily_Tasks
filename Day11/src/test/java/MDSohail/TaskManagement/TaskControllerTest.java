package MDSohail.TaskManagement;

import MDSohail.TaskManagement.controller.TaskController;
import MDSohail.TaskManagement.entity.Task;
import MDSohail.TaskManagement.service.TaskService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(TaskController.class)  // Only load controller layer
class TaskControllerTest {

    @Autowired
    private MockMvc mockMvc;   // Mock HTTP requests

    @MockBean
    private TaskService taskService;  // Mock service instead of real DB

    @Autowired
    private ObjectMapper objectMapper; // Convert objects to JSON

    @Test
    void testCreateTask() throws Exception {
        Task task = new Task(null, "Learn Spring Boot", "Controller testing");
        Task savedTask = new Task(1L, "Learn Spring Boot", "Controller testing");

        Mockito.when(taskService.createTask(any(Task.class))).thenReturn(savedTask);

        mockMvc.perform(post("/api/tasks")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(task)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.title").value("Learn Spring Boot"));
    }

    @Test
    void testGetAllTasks() throws Exception {
        List<Task> tasks = Arrays.asList(
                new Task(1L, "Task 1", "Description 1"),
                new Task(2L, "Task 2", "Description 2")
        );

        Mockito.when(taskService.getAllTasks()).thenReturn(tasks);

        mockMvc.perform(get("/api/tasks"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(2))
                .andExpect(jsonPath("$[0].title").value("Task 1"));
    }

    @Test
    void testGetTaskById_Found() throws Exception {
        Task task = new Task(1L, "Sample Task", "Test description");

        Mockito.when(taskService.getTaskById(1L)).thenReturn(task);

        mockMvc.perform(get("/api/tasks/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Sample Task"));
    }

    @Test
    void testGetTaskById_NotFound() throws Exception {
        Mockito.when(taskService.getTaskById(99L)).thenReturn(null);

        mockMvc.perform(get("/api/tasks/99"))
                .andExpect(status().isNotFound())
                .andExpect(content().string("Task not found"));
    }

    @Test
    void testDeleteTask() throws Exception {
        Mockito.when(taskService.deleteTask(1L)).thenReturn("Task deleted successfully!");

        mockMvc.perform(delete("/api/tasks/1"))
                .andExpect(status().isOk())
                .andExpect(content().string("Task deleted successfully!"));
    }

    @Test
    void testSearchByTitle() throws Exception {
        List<Task> tasks = Arrays.asList(
                new Task(1L, "Spring Boot", "Learn testing")
        );

        Mockito.when(taskService.searchByTitle("Spring Boot")).thenReturn(tasks);

        mockMvc.perform(get("/api/tasks/search/title/Spring Boot"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].title").value("Spring Boot"));
    }

    @Test
    void testSearchByKeyword() throws Exception {
        List<Task> tasks = Arrays.asList(
                new Task(1L, "Learn", "Contains keyword")
        );

        Mockito.when(taskService.searchByKeyword("keyword")).thenReturn(tasks);

        mockMvc.perform(get("/api/tasks/search/keyword/keyword"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].description").value("Contains keyword"));
    }

    @Test
    void testUpdateTask_Found() throws Exception {
        Task updatedTask = new Task(1L, "Updated Task", "Updated description");

        Mockito.when(taskService.updateTask(eq(1L), any(Task.class))).thenReturn(updatedTask);

        mockMvc.perform(put("/api/tasks/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(updatedTask)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Updated Task"));
    }

    @Test
    void testUpdateTask_NotFound() throws Exception {
        Mockito.when(taskService.updateTask(eq(99L), any(Task.class))).thenReturn(null);

        mockMvc.perform(put("/api/tasks/99")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(new Task(null, "Doesn't exist", "N/A"))))
                .andExpect(status().isNotFound())
                .andExpect(content().string("Task not found"));
    }
}
