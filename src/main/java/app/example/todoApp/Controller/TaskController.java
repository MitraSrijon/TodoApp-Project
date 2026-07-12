package app.example.todoApp.Controller;

import app.example.todoApp.Service.TaskService;
import org.springframework.stereotype.Controller;

@Controller
public class TaskController {

    private final TaskService service;

    public TaskController(TaskService service) {
        this.service = service;
    }
}
