package br.com.zup.bootcamp.client.response;

import br.com.zup.bootcamp.enumerate.Eligibility;

// Carga intrínseca = 0/7
public class AnalyzeResponse {
    private final String documento;

    private final String nome;

    private final String resultadoSolicitacao;

    private final String idProposta;

    public AnalyzeResponse(String documento, String nome, String resultadoSolicitacao, String idProposta) {
        this.documento = documento;
        this.nome = nome;
        this.resultadoSolicitacao = resultadoSolicitacao;
        this.idProposta = idProposta;
    }

    public static AnalyzeResponse convertFromString(String content) {
        String aux[] = content.split("\"");
        return new AnalyzeResponse(aux[3], aux[7], aux[11], aux[15]);
    }

    public String getDocumento() {
        return documento;
    }

    public String getNome() {
        return nome;
    }

    public String getResultadoSolicitacao() {
        return resultadoSolicitacao;
    }

    public String getIdProposta() {
        return idProposta;
    }

    @Override
    public String toString() {
        return "AnalyzeResponse{" +
                ", resultadoSolicitacao='" + resultadoSolicitacao + '\'' +
                ", idProposta='" + idProposta + '\'' +
                '}';
    }

    public Eligibility getResultadoSolicitacaoConverted() {
        if (this.resultadoSolicitacao.equals("SEM_RESTRICAO"))
            return Eligibility.ELEGIVEL;
        return Eligibility.NAO_ELEGIVEL;
    }
}
