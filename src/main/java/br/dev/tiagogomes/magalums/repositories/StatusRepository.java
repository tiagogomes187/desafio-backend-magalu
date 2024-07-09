package br.dev.tiagogomes.magalums.repositories;

import br.dev.tiagogomes.magalums.entities.Status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusRepository extends JpaRepository<Status, Long> {
}
