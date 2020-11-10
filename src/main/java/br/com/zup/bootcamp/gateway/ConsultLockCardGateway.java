package br.com.zup.bootcamp.gateway;

import br.com.zup.bootcamp.entity.LockedCard;

import java.util.Optional;

public interface ConsultLockCardGateway {

    /**
     * Busca um cartão bloqueado persistido
     * @param card String do identificador do cartão associado a proposta
     * @return Objeto que representa o cartão bloqueado
     */
    Optional<LockedCard> execute(String card);
}
