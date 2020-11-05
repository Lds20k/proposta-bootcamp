package br.com.zup.bootcamp.gateway;

import br.com.zup.bootcamp.entity.Fingerprint;

public interface PersistFingerprintGateway {

    /**
     * Gateway para persistir uma impressão digital
     * @param fingerprint Objeto que representa a impressão digital a ser persistida
     * @return Objeto que representa a impressão digital que foi persistida
     */
    Fingerprint execute(Fingerprint fingerprint);
}
