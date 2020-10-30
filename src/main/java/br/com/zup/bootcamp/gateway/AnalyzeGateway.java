package br.com.zup.bootcamp.gateway;

import br.com.zup.bootcamp.entity.Proposal;

public interface AnalyzeGateway {

    /**
     * Envia uma requisição a um servidor legado que analisa uma proposta
     * @param proposal Objeto que representa a proposta a ser analisada
     * @return -----AINDA NÃO IMPLEMENTADO-----
     */
    Proposal execute(Proposal proposal);
}
