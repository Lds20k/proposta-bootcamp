package br.com.zup.bootcamp.usecase;

import br.com.zup.bootcamp.entity.Proposal;
import br.com.zup.bootcamp.gateway.AnalyzeGateway;
import br.com.zup.bootcamp.gateway.ProposalDocumentAlreadyPersistedGateway;
import br.com.zup.bootcamp.gateway.PersistProposalGateway;
import br.com.zup.bootcamp.gateway.UserHaveProposalGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

// Carga intrínseca = 5/9
@Service
public class CreateProposalUseCase {

    @Autowired
    private AnalyzeGateway analyzeGateway;

    @Autowired
    private PersistProposalGateway persistProposalGateway;

    @Autowired
    private UserHaveProposalGateway userHaveProposalGateway;

    @Autowired
    private ProposalDocumentAlreadyPersistedGateway proposalDocumentAlreadyPersistedGateway;

    /**
     * Persiste e analisa uma proposta
     * @param proposal Objeto que representa a proposta a ser criada
     * @return Objeto que representa a proposta salva no banco de dados
     */
    public Optional<Proposal> execute(Proposal proposal){
        if(
                proposalDocumentAlreadyPersistedGateway.execute(proposal) ||
                userHaveProposalGateway.execute(proposal.getId()).isPresent()
        ) return Optional.empty();

        Proposal processedProposal = persistProposalGateway.execute(proposal);
        Proposal proposalToReturn = persistProposalGateway.execute(analyzeGateway.execute(processedProposal));
        return Optional.of(proposalToReturn);
    }

}
