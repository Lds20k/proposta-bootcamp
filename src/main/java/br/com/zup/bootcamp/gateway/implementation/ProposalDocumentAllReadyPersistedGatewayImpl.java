package br.com.zup.bootcamp.gateway.implementation;

import br.com.zup.bootcamp.entity.Proposal;
import br.com.zup.bootcamp.gateway.ProposalDocumentAllReadyPersistedGateway;
import br.com.zup.bootcamp.gateway.database.model.ProposalDBDomain;
import br.com.zup.bootcamp.gateway.database.repository.ProposalRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProposalDocumentAllReadyPersistedGatewayImpl implements ProposalDocumentAllReadyPersistedGateway {

    @Autowired
    private ProposalRepository proposalRepository;

    private final Logger logger = LoggerFactory.getLogger(ProposalDocumentAllReadyPersistedGatewayImpl.class);

    @Override
    public Boolean execute(Proposal proposal) {
        Optional<ProposalDBDomain> proposalDBDomainOptional = proposalRepository.findByDocument(proposal.getDocument());
        return proposalDBDomainOptional.isPresent();
    }
}
