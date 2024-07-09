package br.dev.tiagogomes.magalums.dto;

import br.dev.tiagogomes.magalums.entities.Channel;
import br.dev.tiagogomes.magalums.entities.Notification;
import br.dev.tiagogomes.magalums.entities.Status;

import java.time.LocalDateTime;

public record ScheduleNotificationDTO(
		LocalDateTime dateTime,
		String destination,
		String message,
		Channel.Values channel
) {
	public Notification toNotification() {
		return new Notification(
				dateTime,
				destination,
				message,
				channel.toChannel(),
				Status.Values.PENDING.toStatus()
		);
	}

}
