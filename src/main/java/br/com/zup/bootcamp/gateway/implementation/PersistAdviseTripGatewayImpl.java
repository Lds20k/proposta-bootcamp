package br.com.zup.bootcamp.gateway.implementation;

import br.com.zup.bootcamp.client.CardClient;
import br.com.zup.bootcamp.client.response.AdviseTripResponse;
import br.com.zup.bootcamp.entity.AdviseTrip;
import br.com.zup.bootcamp.gateway.PersistAdviseTripGateway;
import br.com.zup.bootcamp.gateway.database.model.AdviseTripDBDomain;
import br.com.zup.bootcamp.gateway.database.model.ProposalDBDomain;
import br.com.zup.bootcamp.gateway.database.repository.ProposalRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

// Carga intrínseca = 6/7
@Service
public class PersistAdviseTripGatewayImpl implements PersistAdviseTripGateway {

    @Autowired
    private ProposalRepository proposalRepository;

    @Autowired
    private CardClient cardClient;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * Persiste um aviso de viagem
     * @param adviseTripToProcess Objeto que representa o aviso de viagem e sera persistido
     * @return Objeto que representa o aviso de viagem que foi persistido
     */
    @Override
    public AdviseTrip execute(AdviseTrip adviseTripToProcess) {
        ProposalDBDomain proposalDBDomain = new ProposalDBDomain(adviseTripToProcess.getProposal());
        AdviseTripDBDomain adviseTripDBDomain = new AdviseTripDBDomain(
                adviseTripToProcess.getCard(),
                adviseTripToProcess.getDestiny(),
                adviseTripToProcess.getEnding(),
                adviseTripToProcess.getIp(),
                adviseTripToProcess.getUserAgent(),
                proposalDBDomain
        );
        proposalDBDomain.addAdviseTrip(adviseTripDBDomain);

        Map<String, String> request = new HashMap<>();
        request.put("destino", adviseTripToProcess.getDestiny());
        request.put("validoAte", adviseTripToProcess.getEnding().toString());
        logger.info("sending a request to avisos of cartao");
        AdviseTripResponse response = cardClient.adviseTrip(adviseTripToProcess.getCard(), request).getBody();

        logger.info("persisting a trip advise");
        proposalRepository.save(proposalDBDomain);

        return adviseTripDBDomain.toEntity();
    }
}
