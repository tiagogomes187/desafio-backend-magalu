package br.dev.tiagogomes.magalums.controllers;

import br.dev.tiagogomes.magalums.dto.ScheduleNotificationDTO;
import br.dev.tiagogomes.magalums.entities.Notification;
import br.dev.tiagogomes.magalums.services.NotificationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

	private final NotificationService notificationService;

	public NotificationController(NotificationService notificationService) {
		this.notificationService = notificationService;
	}

	@PostMapping
	public ResponseEntity<Void> scheduleNotification(@RequestBody ScheduleNotificationDTO dto) {
		notificationService.scheduleNotification(dto);

		return ResponseEntity.accepted().build();
	}

	@GetMapping("/{notificationId}")
	public ResponseEntity<Notification> getNotification(@PathVariable("notificationId") Long notificationId) {

		var notification = notificationService.findById(notificationId);

		if (notification.isEmpty()) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(notification.get());
	}

	@DeleteMapping("/{notificationId}")
	public ResponseEntity<Void> cancelNotification(@PathVariable("notificationId") Long notificationId) {
		notificationService.cancelNotification(notificationId);
		return ResponseEntity.noContent().build();
	}
}