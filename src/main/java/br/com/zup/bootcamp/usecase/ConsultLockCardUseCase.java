package br.com.zup.bootcamp.usecase;

import br.com.zup.bootcamp.entity.LockedCard;
import br.com.zup.bootcamp.gateway.ConsultLockCardGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ConsultLockCardUseCase {

    @Autowired
    private ConsultLockCardGateway consultLockCardGateway;

    /**
     * Busca um cartão bloqueado persistido pelo numero identificador do cartão
     * @param card String do identificador do cartão associado a proposta
     * @return Objeto que representa o cartão bloqueado
     */
    public Optional<LockedCard> execute(String card) {
        return consultLockCardGateway.execute(card);
    }
}
