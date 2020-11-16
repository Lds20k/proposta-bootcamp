package br.com.zup.bootcamp.resource.wallet;

import br.com.zup.bootcamp.entity.Proposal;
import br.com.zup.bootcamp.entity.Wallet;
import br.com.zup.bootcamp.usecase.AssociateWalletUseCase;
import br.com.zup.bootcamp.usecase.ConsultProposalByCardUseCase;
import br.com.zup.bootcamp.usecase.HaveWalletUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Map;
import java.util.Optional;

// Carga intrínseca = 8/7
@RestController
@RequestMapping(AssociateWalletResource.path)
public class AssociateWalletResource {

    public static final String path = "/api/wallets";

    @Autowired
    private ConsultProposalByCardUseCase consultProposalByCardUseCase;

    @Autowired
    private AssociateWalletUseCase associateWalletUseCase;

    @Autowired
    private HaveWalletUseCase haveWalletUseCase;

    /**
     * Associa uma companhia/carteira a um cartão
     * @param company Companhia/Carteira que sera associada ao cartão
     * @param card String do identificador do cartão
     * @param builder Construtor do URI de retorno
     * @return Código de estado http 201(CREATED), uma body vazia e o local do recurso no header Location
     */
    @PostMapping("/{company}/{card}")
    public ResponseEntity<?> associate(@PathVariable("company") String company, @PathVariable("card") String card, UriComponentsBuilder builder){
        Map<String, Object> user = ((Jwt)SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal()
        ).getClaims();

        Optional<Proposal> proposalFromDB = consultProposalByCardUseCase.execute(card);

        if(proposalFromDB.isEmpty())
            return ResponseEntity.notFound().build();

        if(haveWalletUseCase.execute(proposalFromDB.get()))
            return ResponseEntity.unprocessableEntity().build();

        Proposal proposal = new Proposal(proposalFromDB.get(), user.get("email").toString());
        Wallet walletToProcess = new Wallet(company, card, proposal);

        if(
                !user.get("sub").toString().equals(proposalFromDB.get().getId()) ||
                proposalFromDB.get().isLocked() ||
                walletToProcess.companyIsNone()
        ) return ResponseEntity.badRequest().build();

        Wallet wallet = associateWalletUseCase.execute(walletToProcess);

        return ResponseEntity.created(
                builder
                        .path(path.concat("/{company}/{id}"))
                        .buildAndExpand(wallet.getCompanyString(), wallet.getId())
                        .toUri()
        ).build();
    }
}
