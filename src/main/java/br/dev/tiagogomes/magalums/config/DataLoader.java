package br.dev.tiagogomes.magalums.config;

import br.dev.tiagogomes.magalums.entities.Channel;
import br.dev.tiagogomes.magalums.entities.Status;
import br.dev.tiagogomes.magalums.repositories.ChannelRepository;
import br.dev.tiagogomes.magalums.repositories.StatusRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class DataLoader implements CommandLineRunner {

	private final ChannelRepository channelRepository;
	private final StatusRepository statusRepository;

	public DataLoader(ChannelRepository channelRepository, StatusRepository statusRepository) {
		this.channelRepository = channelRepository;
		this.statusRepository = statusRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		Arrays.stream(Channel.Values.values())
				.map(Channel.Values::toChannel)
				.forEach(channelRepository::save);

		Arrays.stream(Status.Values.values())
				.map(Status.Values::toStatus)
				.forEach(statusRepository::save);
	}
}
