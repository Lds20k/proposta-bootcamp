package br.com.zup.bootcamp.usecase;

import br.com.zup.bootcamp.entity.Proposal;
import br.com.zup.bootcamp.gateway.AnalyzeGateway;
import br.com.zup.bootcamp.gateway.PersistProposalGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// Carga intrínseca = 3/9
@Service
public class CreateProposalUseCase {

    @Autowired
    private AnalyzeGateway analyzeGateway;

    @Autowired
    private PersistProposalGateway persistProposalGateway;

    /**
     * Persiste e analisa uma proposta
     * @param proposal Objeto que representa a proposta a ser criada
     * @return Objeto que representa a proposta salva no banco de dados
     */
    public Proposal execute(Proposal proposal){
        Proposal ProcessedProposal = persistProposalGateway.execute(proposal);
        //analyzeGateway.execute(ProcessedProposal);
        return ProcessedProposal;
    }

}
