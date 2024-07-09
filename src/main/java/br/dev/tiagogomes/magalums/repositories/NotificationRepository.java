package br.dev.tiagogomes.magalums.repositories;

import br.dev.tiagogomes.magalums.entities.Notification;
import br.dev.tiagogomes.magalums.entities.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
	List<Notification> findByStatusInAndDateTimeBefore(List<Status> status, LocalDateTime dateTime);
}