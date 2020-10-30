package br.com.zup.bootcamp.resource.proposal;

import br.com.zup.bootcamp.entity.Proposal;
import br.com.zup.bootcamp.resource.dto.request.ProposalCreateRequest;
import br.com.zup.bootcamp.usecase.CreateProposalUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;

// Carga intrínseca = 4/7
@RestController
public class ProposalCreateResource extends ProposalResource {

    @Autowired
    private CreateProposalUseCase createProposalUseCase;

    /**
     * Endpoint para criação de proposta
     * @param request Corpo da requisição com os atributos da proposta
     * @param builder Construtor do URI de retorno
     * @return Código de estado http 201(CREATED), uma body vazia e o local do recurso no header Location
     */
    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody ProposalCreateRequest request, UriComponentsBuilder builder){
        Proposal proposal = createProposalUseCase.execute(request.toModel());
        return ResponseEntity.created(
                builder
                        .path(path.concat("/{id}"))
                        .buildAndExpand(proposal.getId())
                        .toUri()
        ).build();
    }
}
