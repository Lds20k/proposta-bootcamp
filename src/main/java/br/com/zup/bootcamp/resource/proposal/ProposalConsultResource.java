package br.com.zup.bootcamp.resource.proposal;

import br.com.zup.bootcamp.entity.Proposal;
import br.com.zup.bootcamp.resource.dto.response.ProposalResponse;
import br.com.zup.bootcamp.usecase.ConsultProposalUseCase;
import io.opentracing.Span;
import io.opentracing.Tracer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

// Carga intrínseca = 6/7
@RestController
public class ProposalConsultResource extends ProposalResource {

    @Autowired
    private ConsultProposalUseCase consultProposalUseCase;

    @Autowired
    private Tracer tracer;

    /**
     * Endpoint que consulta uma proposta que esta persistida pelo id
     * @param id String do UUID da proposta
     * @return Código de estado http 200(OK), uma body com a elegibilidade da proposta
     */
    @GetMapping("/{id}")
    public ResponseEntity<?> consult(@PathVariable String id){
        Span activeSpan = tracer.activeSpan();
        String userId = SecurityContextHolder.getContext().getAuthentication().getName();
        activeSpan.setTag("user.id", userId);
        Optional<Proposal> proposal = consultProposalUseCase.execute(id);

        if(proposal.isEmpty()) return ResponseEntity.notFound().build();

        if(!userId.equals(id))
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();

        ProposalResponse response = new ProposalResponse(proposal.get().getEligibility());
        return ResponseEntity.ok(response);
    }
}
