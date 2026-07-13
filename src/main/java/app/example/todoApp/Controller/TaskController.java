package app.example.todoApp.Controller;

import app.example.todoApp.Modal.task;
import app.example.todoApp.Service.TaskService;
import org.apache.catalina.LifecycleState;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class TaskController {

    private final TaskService service;

    public TaskController(TaskService service) {
        this.service = service;
    }

    //Gives the list of all the tasks that are present in our database...
    @GetMapping
    public String getTasks(Model model){
        List<task> tasks = service.getAllTasks();
        model.addAttribute("tasks", tasks);
        return "tasks";
    }

    //Adding tasks in the database...
    @PostMapping
    public String createTask(@RequestParam String title){
        service.creatATask(title);
        return "redirect:/"; //It will basically refresh the page once task is added
    }

    //Logic to delete a task
    @GetMapping("/{id}/delete")
    public String deleteTask(@PathVariable long id){
        service.deleteTask(id);
        return "redirect:/";
    }

    //Logic to change the completion status of the task
    @GetMapping("/{id}/toggle")
    public String toggleTask(@PathVariable long id){
        service.toggleTask(id);
        return "redirect:/";
    }
}
