package br.com.zup.bootcamp.service;

import br.com.zup.bootcamp.client.CardClient;
import br.com.zup.bootcamp.enumerate.Eligibility;
import br.com.zup.bootcamp.gateway.database.model.ProposalDBDomain;
import br.com.zup.bootcamp.gateway.database.repository.ProposalRepository;
import br.com.zup.bootcamp.gateway.implementation.AnalyzeGatewayImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private final Logger logger = LoggerFactory.getLogger(AnalyzeCard.class);

    /**
     * Verifica se os cartões foram gerados pelo sistema legado e associa a uma proposta.
     */
    @Scheduled(fixedDelayString = "${period.execute}")
    public void execute(){
        Iterable<ProposalDBDomain> proposalDBDomains = repository.findAllByEligibilityAndCardIsNull(Eligibility.ELEGIVEL);
        for(ProposalDBDomain proposalDBDomain : proposalDBDomains){
            String card = cardClient.getCard(proposalDBDomain.getId()).getBody().getId();
            proposalDBDomain.setCard(card);
            proposalDBDomain.setEligibility(Eligibility.ELEITO);
            repository.save(proposalDBDomain);
            logger.info("A card is associated to ".concat(proposalDBDomain.toString()));
        }
    }

}
