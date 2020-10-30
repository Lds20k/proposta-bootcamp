package br.com.zup.bootcamp.gateway.database.repository;


import br.com.zup.bootcamp.gateway.database.model.ProposalDBDomain;
import org.springframework.data.repository.CrudRepository;

public interface ProposalRepository extends CrudRepository<ProposalDBDomain, String> {
}
