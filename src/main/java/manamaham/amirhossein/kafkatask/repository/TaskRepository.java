package manamaham.amirhossein.kafkatask.repository;

import manamaham.amirhossein.kafkatask.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
