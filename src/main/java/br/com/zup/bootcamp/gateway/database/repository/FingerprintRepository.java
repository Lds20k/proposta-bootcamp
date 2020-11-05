package br.com.zup.bootcamp.gateway.database.repository;

import br.com.zup.bootcamp.gateway.database.model.FingerprintDBDomain;
import org.springframework.data.repository.CrudRepository;

public interface FingerprintRepository extends CrudRepository<FingerprintDBDomain, String> {
}
