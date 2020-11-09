package br.com.zup.bootcamp.resource.proposal;

import br.com.zup.bootcamp.entity.Proposal;
import br.com.zup.bootcamp.resource.dto.request.ProposalCreateRequest;
import br.com.zup.bootcamp.usecase.CreateProposalUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.Map;
import java.util.Optional;

// Carga intrínseca = 5/7
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
        Map<String, Object> user = ( (Jwt)SecurityContextHolder
                    .getContext()
                    .getAuthentication()
                    .getPrincipal()
        ).getClaims();

        Proposal proposalToProcess = request.toModel(
                user.get("sub").toString(),
                user.get("email").toString(),
                user.get("name").toString()
        );

        Optional<Proposal> proposal = createProposalUseCase.execute(proposalToProcess);

        if(proposal.isEmpty()) return ResponseEntity.unprocessableEntity().build();

        return ResponseEntity.created(
                builder
                        .path(path.concat("/{id}"))
                        .buildAndExpand(proposal.get().getId())
                        .toUri()
        ).build();
    }
}
