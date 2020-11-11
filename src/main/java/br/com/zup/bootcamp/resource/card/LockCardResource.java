package br.com.zup.bootcamp.resource.card;

import br.com.zup.bootcamp.entity.LockedCard;
import br.com.zup.bootcamp.entity.Proposal;
import br.com.zup.bootcamp.usecase.ConsultLockCardUseCase;
import br.com.zup.bootcamp.usecase.ConsultProposalByCardUseCase;
import br.com.zup.bootcamp.usecase.LockCardUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

// Carga intrínseca = 7/7
@RestController
@RequestMapping(LockCardResource.path)
public class LockCardResource {

    public static final String path = "/api/cards";

    @Autowired
    private ConsultProposalByCardUseCase consultProposalByCardUseCase;

    @Autowired
    private LockCardUseCase lockCardUseCase;

    @Autowired
    private ConsultLockCardUseCase consultLockCardUseCase;

    /**
     * Bloqueia um cartão
     * @param card String do identificador do cartão
     * @param request objeto que cotem dados sobre a requisição
     * @param builder Construtor do URI de retorno
     * @return Código de estado http 201(CREATED), uma body vazia e o local do recurso no header Location
     */
    @PatchMapping("/{card}")
    public ResponseEntity<?> lock(@PathVariable String card, HttpServletRequest request, UriComponentsBuilder builder){
        String userId = SecurityContextHolder.getContext().getAuthentication().getName();
        Optional<Proposal> proposal = consultProposalByCardUseCase.execute(card);

        if(proposal.isEmpty())
            return ResponseEntity.notFound().build();

        if(!userId.equals(proposal.get().getId()) || consultLockCardUseCase.execute(card).isPresent())
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

        LockedCard lockedCardToProcess = new LockedCard(
                card,
                request.getRemoteAddr(),
                request.getHeader("User-Agent"),
                proposal.get()
        );
        LockedCard lockedCard = lockCardUseCase.execute(lockedCardToProcess);

        return ResponseEntity.created(
                builder
                        .path(path.concat("/{id}"))
                        .buildAndExpand(lockedCard.getId())
                        .toUri()
        ).build();
    }
}
