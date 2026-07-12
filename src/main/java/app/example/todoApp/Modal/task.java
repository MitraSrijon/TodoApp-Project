package app.example.todoApp.Modal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String task;
    private boolean completed;

}
