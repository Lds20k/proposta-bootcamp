package br.com.zup.bootcamp.gateway.database.repository;

import br.com.zup.bootcamp.gateway.database.model.AdviseTripDBDomain;
import org.springframework.data.repository.CrudRepository;

public interface AdviseTripRepository extends CrudRepository<AdviseTripDBDomain, String> {
}
