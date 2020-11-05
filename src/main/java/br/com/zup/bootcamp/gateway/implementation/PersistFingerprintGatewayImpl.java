package br.com.zup.bootcamp.gateway.implementation;

import br.com.zup.bootcamp.entity.Fingerprint;
import br.com.zup.bootcamp.gateway.PersistFingerprintGateway;
import br.com.zup.bootcamp.gateway.database.model.FingerprintDBDomain;
import br.com.zup.bootcamp.gateway.database.model.ProposalDBDomain;
import br.com.zup.bootcamp.gateway.database.repository.FingerprintRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// Carga intrínseca = 4/7
@Service
public class PersistFingerprintGatewayImpl implements PersistFingerprintGateway {

    @Autowired
    private FingerprintRepository fingerprintRepository;

    /**
     * Gateway para persistir uma impressão digital
     * @param fingerprint Objeto que representa a impressão digital a ser persistida
     * @return Objeto que representa a impressão digital que foi persistida
     */
    @Override
    public Fingerprint execute(Fingerprint fingerprint) {
        ProposalDBDomain proposalDBDomain = new ProposalDBDomain(fingerprint.getProposal().getId());

        FingerprintDBDomain fingerprintDBDomain = new FingerprintDBDomain(
                fingerprint.getId(),
                fingerprint.getFingerprintBase64(),
                proposalDBDomain
        );

        fingerprintRepository.save(fingerprintDBDomain);
        return fingerprintDBDomain.toEntity();
    }
}
