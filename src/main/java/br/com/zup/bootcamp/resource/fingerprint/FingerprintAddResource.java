package br.com.zup.bootcamp.resource.fingerprint;

import br.com.zup.bootcamp.entity.Fingerprint;
import br.com.zup.bootcamp.entity.Proposal;
import br.com.zup.bootcamp.resource.dto.request.FingerprintAddRequest;
import br.com.zup.bootcamp.usecase.AddFingerprintUseCase;
import br.com.zup.bootcamp.usecase.ConsultProposalUseCase;
import io.opentracing.Span;
import io.opentracing.Tracer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.Optional;

// Carga intrínseca = 7/7
@RestController
@RequestMapping(FingerprintAddResource.path)
public class FingerprintAddResource {
    public static final String path = "/api/fingerprints";

    @Autowired
    private AddFingerprintUseCase addFingerprintUseCase;

    @Autowired
    private ConsultProposalUseCase consultProposalUseCase;

    @Autowired
    private Tracer tracer;

    /**
     * Adiciona uma impressão digital a uma proposta
     * @param proposalId String UUID da proposta
     * @param request Objeto da requisição que representa a impressão digital
     * @param builder Construtor do URI de retorno
     * @return Código de estado http 201(CREATED), uma body vazia e o local do recurso no header Location
     */
    @PostMapping("/{proposalId}")
    public ResponseEntity<?> add(@PathVariable String proposalId, @Valid @RequestBody FingerprintAddRequest request, UriComponentsBuilder builder){
        Span activeSpan = tracer.activeSpan();
        String userId = SecurityContextHolder.getContext().getAuthentication().getName();
        activeSpan.setTag("user.id", userId);
        Optional<Proposal> proposal = consultProposalUseCase.execute(proposalId);

        if(proposal.isEmpty() || !proposal.get().haveCard())
            return ResponseEntity.notFound().build();

        if(!userId.equals(proposal.get().getId()))
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();

        Fingerprint fingerprint = addFingerprintUseCase.execute(request.toEntity(proposal.get()));
        return ResponseEntity.created(
                builder
                        .path(path.concat("{id}"))
                        .buildAndExpand(fingerprint.getId())
                        .toUri()
        ).build();
    }
}
