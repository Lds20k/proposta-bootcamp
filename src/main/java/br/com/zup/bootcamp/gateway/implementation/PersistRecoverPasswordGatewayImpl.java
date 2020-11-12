package br.com.zup.bootcamp.gateway.implementation;

import br.com.zup.bootcamp.entity.PasswordRecover;
import br.com.zup.bootcamp.gateway.PersistRecoverPasswordGateway;
import br.com.zup.bootcamp.gateway.database.model.PasswordRecoverDBDomain;
import br.com.zup.bootcamp.gateway.database.model.ProposalDBDomain;
import br.com.zup.bootcamp.gateway.database.repository.ProposalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// Carga intrínseca = 4/7
@Service
public class PersistRecoverPasswordGatewayImpl implements PersistRecoverPasswordGateway {

    @Autowired
    private ProposalRepository proposalRepository;

    /**
     * Persiste o pedido de recuperação da senha do cartão
     * @param passwordRecover Objeto que representa a recuperação a ser persistida
     * @return Objeto que representa a recuperação persistida
     */
    @Override
    public PasswordRecover execute(PasswordRecover passwordRecover) {
        ProposalDBDomain proposalDBDomain = new ProposalDBDomain(passwordRecover.getProposal());
        PasswordRecoverDBDomain passwordRecoverDBDomain = new PasswordRecoverDBDomain(
                passwordRecover.getIp(),
                passwordRecover.getUserAgent(),
                proposalDBDomain
        );

        proposalDBDomain.addRecoverPassword(passwordRecoverDBDomain);
        proposalRepository.save(proposalDBDomain);

        return passwordRecoverDBDomain.toEntity();
    }
}
