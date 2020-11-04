package br.com.zup.bootcamp.client.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Collection;

// Carga intrínseca = 5/7
public class CardResponse {
    private final String id;

    private final LocalDateTime emitidoEm;

    private final String titular;

    private final Collection<BlockResponse> bloqueios;

    private final Collection<WarningResponse> avisos;

    private final Collection<WalletResponse> carteiras;

    private final Collection<PortionResponse> parcelas;

    private final BigDecimal limite;

    private final Collection<RenegotiationResponse> renegociacao;

    private final DueDateResponse vencimento;

    private final String idProposta;

    public CardResponse(String id, LocalDateTime emitidoEm, String titular, Collection<BlockResponse> bloqueios, Collection<WarningResponse> avisos, Collection<WalletResponse> carteiras, Collection<PortionResponse> parcelas, BigDecimal limite, Collection<RenegotiationResponse> renegociacao, DueDateResponse vencimento, String idProposta) {
        this.id = id;
        this.emitidoEm = emitidoEm;
        this.titular = titular;
        this.bloqueios = bloqueios;
        this.avisos = avisos;
        this.carteiras = carteiras;
        this.parcelas = parcelas;
        this.limite = limite;
        this.renegociacao = renegociacao;
        this.vencimento = vencimento;
        this.idProposta = idProposta;
    }

    @Override
    public String toString() {
        return "CardResponse{" +
                "id='" + id + '\'' +
                ", emitidoEm=" + emitidoEm +
                ", titular='" + titular + '\'' +
                ", bloqueios=" + bloqueios +
                ", avisos=" + avisos +
                ", carteiras=" + carteiras +
                ", parcelas=" + parcelas +
                ", limite=" + limite +
                ", renegociacao=" + renegociacao +
                ", vencimento=" + vencimento +
                ", idProposta='" + idProposta + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }
}
