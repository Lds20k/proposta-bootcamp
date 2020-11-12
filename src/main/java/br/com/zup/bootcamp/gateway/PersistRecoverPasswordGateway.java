package br.com.zup.bootcamp.gateway;

import br.com.zup.bootcamp.entity.PasswordRecover;

public interface PersistRecoverPasswordGateway {

    /**
     * Persiste o pedido de recuperação da senha do cartão
     * @param passwordRecover Objeto que representa a recuperação a ser persistida
     * @return Objeto que representa a recuperação persistida
     */
    PasswordRecover execute(PasswordRecover passwordRecover);
}
