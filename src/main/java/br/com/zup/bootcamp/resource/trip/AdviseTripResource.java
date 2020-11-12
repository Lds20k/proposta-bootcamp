package br.com.zup.bootcamp.resource.trip;

import br.com.zup.bootcamp.entity.AdviseTrip;
import br.com.zup.bootcamp.entity.Proposal;
import br.com.zup.bootcamp.resource.dto.request.AdviseTripRequest;
import br.com.zup.bootcamp.usecase.AdviceTripUseCase;
import br.com.zup.bootcamp.usecase.ConsultProposalByCardUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Optional;

// Carga intrínseca = 7/7
@RestController
@RequestMapping(AdviseTripResource.path)
public class AdviseTripResource {

    public static final String path = "/api/trips";

    @Autowired
    private ConsultProposalByCardUseCase proposalByCardUseCase;

    @Autowired
    private AdviceTripUseCase adviceTripUseCase;

    /**
     * Cria um aviso de viagem
     * @param card String identificadora do cartão
     * @param request Objeto que representa a body da requisição
     * @param requestInfo Objeto que cotem dados sobre a requisição
     * @param builder Construtor do URI de retorno
     * @return Código de estado http 201(CREATED), uma body vazia e o local do recurso no header Location
     */
    @PostMapping("/{card}")
    public ResponseEntity<?> advice(@PathVariable String card, @Valid @RequestBody AdviseTripRequest request, HttpServletRequest requestInfo, UriComponentsBuilder builder){
        String userId = SecurityContextHolder.getContext().getAuthentication().getName();
        Optional<Proposal> proposal = proposalByCardUseCase.execute(card);

        if(proposal.isEmpty())
            return ResponseEntity.notFound().build();

        if(!userId.equals(proposal.get().getId()))
            return ResponseEntity.badRequest().build();

        AdviseTrip adviseTripToProcess = new AdviseTrip(
                card,
                request.getDestiny(),
                request.getEnding(),
                requestInfo.getRemoteAddr(),
                requestInfo.getHeader("User-Agent"),
                proposal.get()
        );
        AdviseTrip adviseTrip = adviceTripUseCase.execute(adviseTripToProcess);

        return ResponseEntity.created(
                builder
                        .path(path.concat("/{id}"))
                        .buildAndExpand(adviseTrip.getId())
                        .toUri()
        ).build();
    }
}
