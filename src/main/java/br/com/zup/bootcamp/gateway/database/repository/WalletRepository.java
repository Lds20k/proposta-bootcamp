package br.com.zup.bootcamp.gateway.database.repository;

import br.com.zup.bootcamp.gateway.database.model.ProposalDBDomain;
import br.com.zup.bootcamp.gateway.database.model.WalletDBDomain;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface WalletRepository extends CrudRepository<WalletDBDomain, String> {
    Optional<WalletDBDomain> findByProposal(ProposalDBDomain proposal);
}
