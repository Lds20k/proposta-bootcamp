package br.com.zup.bootcamp.gateway.implementation;

import br.com.zup.bootcamp.client.AnalyzeClient;
import br.com.zup.bootcamp.entity.Proposal;
import br.com.zup.bootcamp.gateway.AnalyzeGateway;
import br.com.zup.bootcamp.client.response.AnalyzeResponse;
import feign.FeignException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

// Carga intrínseca = 4/7
@Service
public class AnalyzeGatewayImpl implements AnalyzeGateway {

    @Autowired
    private AnalyzeClient analyzeClient;

    private final Logger logger = LoggerFactory.getLogger(AnalyzeGatewayImpl.class);

    /**
     * Envia uma requisição a um servidor legado que analisa uma proposta
     * @param proposal Objeto que representa a proposta a ser analisada
     * @return Objeto proposta com a elegibilidade
     */
    @Override
    public Proposal execute(Proposal proposal) {
        Map<String, String> request = new HashMap<>();
        request.put("documento" , proposal.getDocument());
        request.put("nome"      , proposal.getName());
        request.put("idProposta", proposal.getId());

        logger.info("send a request: " + request.toString());
        AnalyzeResponse response;
        try {
            response = analyzeClient.analyzeRestrictions(request).getBody();
        }catch (FeignException.UnprocessableEntity e){
            response = AnalyzeResponse.convertFromString(e.contentUTF8());
        }

        logger.info("request response: " + response.toString());
        Proposal proposalToReturn = new Proposal(
                proposal.getId(),
                proposal.getDocument(),
                proposal.getEmail(),
                proposal.getName(),
                proposal.getAddress(),
                proposal.getSalary(),
                response.getResultadoSolicitacaoConverted()
        );

        return proposalToReturn;
    }
}
