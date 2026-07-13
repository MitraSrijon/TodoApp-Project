package app.example.todoApp.Service;

import app.example.todoApp.Modal.task;
import app.example.todoApp.Repository.taskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final taskRepository repository;

    public TaskService(taskRepository repository) {
        this.repository = repository;
    }

    //Getting all the tasks
    public List<task> getAllTasks() {
        return repository.findAll();
    }

    //Creating a task and saving it inside database
    public void creatATask(String title) {
        task task = new task();
        task.setTask(title);
        task.setCompleted(false);
        repository.save(task);
    }

    //Logic to delete a task from the database...
    public void deleteTask(long id) {
        repository.deleteById(id);
    }

    //Logic to update the ttask completion status
    public void toggleTask(long id) {
        task task = repository.findById(id)
                .orElseThrow( () -> new IllegalArgumentException("Invalid Task ID"));
        task.setCompleted(!task.isCompleted());
        repository.save(task);
    }
}

