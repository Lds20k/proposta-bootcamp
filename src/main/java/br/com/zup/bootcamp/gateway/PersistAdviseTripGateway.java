package br.com.zup.bootcamp.gateway;

import br.com.zup.bootcamp.entity.AdviseTrip;

public interface PersistAdviseTripGateway {

    /**
     * Persiste um aviso de viagem
     * @param adviseTripToProcess Objeto que representa o aviso de viagem e sera persistido
     * @return Objeto que representa o aviso de viagem que foi persistido
     */
    AdviseTrip execute(AdviseTrip adviseTripToProcess);
}
