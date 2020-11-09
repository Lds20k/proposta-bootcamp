package br.com.zup.bootcamp.gateway.implementation;

import br.com.zup.bootcamp.entity.Proposal;
import br.com.zup.bootcamp.gateway.UserHaveProposalGateway;
import br.com.zup.bootcamp.gateway.database.model.ProposalDBDomain;
import br.com.zup.bootcamp.gateway.database.repository.ProposalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserHaveProposalGatewayImpl implements UserHaveProposalGateway {

    @Autowired
    private ProposalRepository proposalRepository;

    @Override
    public Optional<Proposal> execute(String id) {
        Optional<ProposalDBDomain> proposalDBDomain = proposalRepository.findById(id);
        if(proposalDBDomain.isEmpty()) return Optional.empty();

        Proposal proposal = proposalDBDomain.get().toEntity();
        return Optional.of(proposal);
    }
}
