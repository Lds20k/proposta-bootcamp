package br.com.zup.bootcamp.gateway.implementation;

import br.com.zup.bootcamp.entity.AdviseTrip;
import br.com.zup.bootcamp.gateway.PersistAdviseTripGateway;
import br.com.zup.bootcamp.gateway.database.model.AdviseTripDBDomain;
import br.com.zup.bootcamp.gateway.database.model.ProposalDBDomain;
import br.com.zup.bootcamp.gateway.database.repository.ProposalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// Carga intrínseca = 4/7
@Service
public class PersistAdviseTripGatewayImpl implements PersistAdviseTripGateway {

    @Autowired
    private ProposalRepository proposalRepository;

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

        proposalRepository.save(proposalDBDomain);

        return adviseTripDBDomain.toEntity();
    }
}
