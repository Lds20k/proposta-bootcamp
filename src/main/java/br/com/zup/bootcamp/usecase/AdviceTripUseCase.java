package br.com.zup.bootcamp.usecase;

import br.com.zup.bootcamp.entity.AdviseTrip;
import br.com.zup.bootcamp.gateway.PersistAdviseTripGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// Carga intrínseca = 2/7
@Service
public class AdviceTripUseCase {

    @Autowired
    private PersistAdviseTripGateway persistAdviseTripGateway;

    /**
     * Cria um aviso de viagem
     * @param adviseTripToProcess Objeto que representa o aviso de viagem
     * @return Objeto que representa o aviso de viagem persistido
     */
    public AdviseTrip execute(AdviseTrip adviseTripToProcess) {
        return persistAdviseTripGateway.execute(adviseTripToProcess);
    }
}
