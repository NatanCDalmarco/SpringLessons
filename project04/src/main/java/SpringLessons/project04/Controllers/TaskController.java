package SpringLessons.project04.Controllers;

import SpringLessons.project04.Dtos.TaskDto;
import SpringLessons.project04.Models.Task;
import SpringLessons.project04.Repositories.TaskRepository;
import SpringLessons.project04.Services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public List<Task> getAll()
    {
        return taskService.getAll();
    }

    @GetMapping("/{id}")
    public Task getById(@PathVariable Long id)
    {
        return taskService.getById(id);
    }

    @PostMapping
    public Task create(@RequestBody TaskDto taskDto)
    {
        return taskService.create(taskDto);
    }

    @PutMapping("/{id}")
    public Task update(@RequestBody TaskDto taskDto,  @PathVariable Long id) {
        return taskService.update(id, taskDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        try {
            taskService.delete(id);
            return ResponseEntity.ok("Task deleted successfully");
        } catch (Exception e) {
            return buildErrorResponse("Can't delete inexistent Task", e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    private ResponseEntity<Map<String, Object>> buildErrorResponse(String error, String message, HttpStatus status) {
        Map<String, Object> body = new HashMap<>();
        body.put("timestamp", LocalDate.now());
        body.put("status", status);
        body.put("error", error);
        body.put("message", message);

        return ResponseEntity.status(status).body(body);
    }
}
