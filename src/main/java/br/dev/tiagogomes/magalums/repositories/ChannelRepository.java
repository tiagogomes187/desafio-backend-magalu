package br.dev.tiagogomes.magalums.repositories;

import br.dev.tiagogomes.magalums.entities.Channel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChannelRepository extends JpaRepository<Channel, Long> {
}
