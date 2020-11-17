package br.com.zup.bootcamp.gateway.database.repository;


import br.com.zup.bootcamp.entity.Proposal;
import br.com.zup.bootcamp.enumerate.Eligibility;
import br.com.zup.bootcamp.gateway.database.model.ProposalDBDomain;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ProposalRepository extends CrudRepository<ProposalDBDomain, String> {
    Optional<ProposalDBDomain> findByHashDocument(String hashDocument);

    Iterable<ProposalDBDomain> findAllByEligibilityAndCardIsNull(Eligibility eligibility);

    Optional<ProposalDBDomain> findByCard(String card);
}
