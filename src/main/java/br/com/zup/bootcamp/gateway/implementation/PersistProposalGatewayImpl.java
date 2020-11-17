package br.com.zup.bootcamp.gateway.implementation;

import br.com.zup.bootcamp.entity.Proposal;
import br.com.zup.bootcamp.gateway.PersistProposalGateway;
import br.com.zup.bootcamp.gateway.database.model.ProposalDBDomain;
import br.com.zup.bootcamp.gateway.database.repository.ProposalRepository;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.tomcat.util.codec.binary.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

// Carga intrínseca = 3/7
@Service
public class PersistProposalGatewayImpl implements PersistProposalGateway {

    private final ProposalRepository repository;

    private final PasswordEncoder encoder;

    private final Logger logger = LoggerFactory.getLogger(PersistProposalGatewayImpl.class);

    public PersistProposalGatewayImpl(ProposalRepository repository, PasswordEncoder encoder) {
        this.repository = repository;
        this.encoder = encoder;
    }

    /**
     * Persiste um Objeto do tipo proposta
     * @param proposal Objeto que representa a proposta a ser persistida
     * @return Objeto que representa a proposta que foi persistida
     */
    @Override
    public Proposal execute(Proposal proposal) {
        ProposalDBDomain proposalDBDomain = new ProposalDBDomain(
                proposal.getId(),
                encoder.encode(proposal.getDocument()),
                DigestUtils.sha256Hex(proposal.getDocument()),
                proposal.getEmail(),
                proposal.getName(),
                proposal.getAddress(),
                proposal.getSalary(),
                proposal.getEligibility()
        );
        logger.info("persisting a proposal");
        repository.save(proposalDBDomain);
        return proposalDBDomain.toEntity();
    }
}
