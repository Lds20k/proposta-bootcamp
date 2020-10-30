package br.com.zup.bootcamp.gateway.implementation;

import br.com.zup.bootcamp.entity.Proposal;
import br.com.zup.bootcamp.gateway.PersistProposalGateway;
import br.com.zup.bootcamp.gateway.database.model.ProposalDBDomain;
import br.com.zup.bootcamp.gateway.database.repository.ProposalRepository;
import org.springframework.stereotype.Service;

// Carga intrínseca = 3/7
@Service
public class PersistProposalGatewayImpl implements PersistProposalGateway {

    private final ProposalRepository repository;

    public PersistProposalGatewayImpl(ProposalRepository repository) {
        this.repository = repository;
    }

    /**
     * Persiste um Objeto do tipo proposta
     * @param proposal Objeto que representa a proposta a ser persistida
     * @return Objeto que representa a proposta que foi persistida
     */
    @Override
    public Proposal execute(Proposal proposal) {
        ProposalDBDomain proposalDBDomain = new ProposalDBDomain(
                proposal.getDocument(),
                proposal.getEmail(),
                proposal.getName(),
                proposal.getAddress(),
                proposal.getSalary()
        );
        repository.save(proposalDBDomain);
        return proposalDBDomain.toEntity();
    }
}
