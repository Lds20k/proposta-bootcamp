package br.com.zup.bootcamp.service;

import br.com.zup.bootcamp.client.CardClient;
import br.com.zup.bootcamp.enumerate.Eligibility;
import br.com.zup.bootcamp.gateway.database.model.ProposalDBDomain;
import br.com.zup.bootcamp.gateway.database.repository.ProposalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

// Carga intrínseca = 4/7
@Service
public class AnalyzeCard {

    @Autowired
    private ProposalRepository repository;

    @Autowired
    private CardClient cardClient;

    /**
     * Verifica se os cartões foram gerados pelo sistema legado.
     */
    @Scheduled(fixedDelayString = "${period.execute}")
    public void execute(){
        Iterable<ProposalDBDomain> proposalDBDomains = repository.findAllByEligibility(Eligibility.ELEGIVEL);
        for(ProposalDBDomain proposalDBDomain : proposalDBDomains){
            System.out.println(cardClient.getCard(proposalDBDomain.getId()).getBody().toString());
        }
    }

}
