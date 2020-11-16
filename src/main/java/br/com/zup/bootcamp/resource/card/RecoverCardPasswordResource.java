package br.com.zup.bootcamp.resource.card;

import br.com.zup.bootcamp.entity.PasswordRecover;
import br.com.zup.bootcamp.entity.Proposal;
import br.com.zup.bootcamp.usecase.ConsultLockCardUseCase;
import br.com.zup.bootcamp.usecase.ConsultProposalByCardUseCase;
import br.com.zup.bootcamp.usecase.RecoverCardPasswordUseCase;
import io.opentracing.Span;
import io.opentracing.Tracer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

// Carga intrínseca = 6/7
@RestController
public class RecoverCardPasswordResource extends CardResource {

    @Autowired
    private RecoverCardPasswordUseCase recoverCardPasswordUseCase;

    @Autowired
    private ConsultProposalByCardUseCase consultProposalByCardUseCase;

    @Autowired
    private Tracer tracer;

    /**
     * Requisição para recuperar senha do cartão
     * @param card String identificadora do cartão
     * @param request Objeto que cotem dados sobre a requisição
     * @param builder Construtor do URI de retorno
     * @return Código de estado http 201(CREATED), uma body vazia e o local do recurso no header Location
     */
    @PostMapping("/{card}/passwords")
    public ResponseEntity<?> recover(@PathVariable String card, HttpServletRequest request, UriComponentsBuilder builder){
        Span activeSpan = tracer.activeSpan();
        String userId = SecurityContextHolder.getContext().getAuthentication().getName();
        activeSpan.setTag("user.id", userId);
        Optional<Proposal> proposal = consultProposalByCardUseCase.execute(card);

        if(proposal.isEmpty())
            return ResponseEntity.notFound().build();

        if(!userId.equals(proposal.get().getId()) || proposal.get().isLocked())
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

        PasswordRecover passwordRecoverToProcess = new PasswordRecover(
                request.getRemoteAddr(),
                request.getHeader("User-Agent"),
                proposal.get()
        );
        PasswordRecover passwordRecover = recoverCardPasswordUseCase.execute(passwordRecoverToProcess);

        return ResponseEntity.created(
                builder
                        .path(CardResource.path.concat("{id}/passwords"))
                        .buildAndExpand(passwordRecover.getId())
                        .toUri()
        ).build();
    }
}
