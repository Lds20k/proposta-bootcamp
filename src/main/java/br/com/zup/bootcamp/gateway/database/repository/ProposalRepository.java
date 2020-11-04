package br.com.zup.bootcamp.gateway.database.repository;


import br.com.zup.bootcamp.enumerate.Eligibility;
import br.com.zup.bootcamp.gateway.database.model.ProposalDBDomain;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ProposalRepository extends CrudRepository<ProposalDBDomain, String> {
    Optional<ProposalDBDomain> findByDocument(String document);

    Iterable<ProposalDBDomain> findAllByEligibilityAndCardIsNull(Eligibility eligibility);
}
