package app.example.todoApp.Repository;

import app.example.todoApp.Modal.task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface taskRepository extends JpaRepository<task, Long> {
}
