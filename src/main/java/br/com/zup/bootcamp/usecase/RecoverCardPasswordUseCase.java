package br.com.zup.bootcamp.usecase;

import br.com.zup.bootcamp.entity.PasswordRecover;
import br.com.zup.bootcamp.gateway.PersistRecoverPasswordGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// Carga intrínseca = 2/7
@Service
public class RecoverCardPasswordUseCase {

    @Autowired
    private PersistRecoverPasswordGateway persistRecoverPasswordGateway;

    /**
     * Persiste o pedido de recuperação da senha do cartão
     * @param passwordRecover Objeto que representa a recuperação a ser persistida
     * @return Objeto que representa a recuperação persistida
     */
    public PasswordRecover execute(PasswordRecover passwordRecover) {
        return persistRecoverPasswordGateway.execute(passwordRecover);
    }
}
