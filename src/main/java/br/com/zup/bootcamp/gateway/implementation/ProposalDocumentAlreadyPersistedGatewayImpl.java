package br.com.zup.bootcamp.gateway.implementation;

import br.com.zup.bootcamp.entity.Proposal;
import br.com.zup.bootcamp.gateway.ProposalDocumentAlreadyPersistedGateway;
import br.com.zup.bootcamp.gateway.database.model.ProposalDBDomain;
import br.com.zup.bootcamp.gateway.database.repository.ProposalRepository;
import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProposalDocumentAlreadyPersistedGatewayImpl implements ProposalDocumentAlreadyPersistedGateway {

    @Autowired
    private ProposalRepository proposalRepository;

    private final Logger logger = LoggerFactory.getLogger(ProposalDocumentAlreadyPersistedGatewayImpl.class);

    @Override
    public Boolean execute(Proposal proposal) {
        logger.info("verify if proposal document was already registered");
        String hashDocument = DigestUtils.sha256Hex(proposal.getDocument());
        Optional<ProposalDBDomain> proposalDBDomainOptional = proposalRepository.findByHashDocument(hashDocument);
        return proposalDBDomainOptional.isPresent();
    }
}
