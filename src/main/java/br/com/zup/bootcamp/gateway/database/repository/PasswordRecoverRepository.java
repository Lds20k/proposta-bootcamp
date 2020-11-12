package br.com.zup.bootcamp.gateway.database.repository;

import br.com.zup.bootcamp.gateway.database.model.PasswordRecoverDBDomain;
import org.springframework.data.repository.CrudRepository;

public interface PasswordRecoverRepository extends CrudRepository<PasswordRecoverDBDomain, String> {
}
