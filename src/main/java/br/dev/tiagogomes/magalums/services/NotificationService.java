package br.dev.tiagogomes.magalums.services;

import br.dev.tiagogomes.magalums.dto.ScheduleNotificationDTO;
import br.dev.tiagogomes.magalums.entities.Notification;
import br.dev.tiagogomes.magalums.entities.Status;
import br.dev.tiagogomes.magalums.repositories.NotificationRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

@Service
public class NotificationService {

	private final NotificationRepository notificationRepository;

	public NotificationService(NotificationRepository notificationRepository) {
		this.notificationRepository = notificationRepository;
	}

	public void scheduleNotification(ScheduleNotificationDTO dto) {
		notificationRepository.save(dto.toNotification());
	}

	public Optional<Notification> findById(Long notificationId) {
		return notificationRepository.findById(notificationId);
	}

	public void cancelNotification(Long notificationId) {
		var notification = findById(notificationId);

		if (notification.isPresent()) {
			notification.get().setStatus(Status.Values.CANCELED.toStatus());
			notificationRepository.save(notification.get());
		}
	}

	public void checkAndSend(LocalDateTime dateTime) {
		var notifications = notificationRepository.findByStatusInAndDateTimeBefore(
				List.of(Status.Values.PENDING.toStatus(), Status.Values.ERROR.toStatus()),
				dateTime
		);

		notifications.forEach(sendNotification());
	}

	private Consumer<Notification> sendNotification() {
		return n -> {

			// TODO - REALIZAR O ENVIO DA NOTIFICACAO

			n.setStatus(Status.Values.SUCCESS.toStatus());
			notificationRepository.save(n);
		};
	}
}