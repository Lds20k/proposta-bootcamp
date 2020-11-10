package br.com.zup.bootcamp.gateway.database.repository;

import br.com.zup.bootcamp.gateway.database.model.LockedCardDBDomain;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface LockedCardRepository extends CrudRepository<LockedCardDBDomain, String> {
    Optional<LockedCardDBDomain> findByCard(String card);
}
