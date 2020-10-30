package br.com.zup.bootcamp.gateway.dto;

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
                "documento='" + documento + '\'' +
                ", nome='" + nome + '\'' +
                ", resultadoSolicitacao='" + resultadoSolicitacao + '\'' +
                ", idProposta='" + idProposta + '\'' +
                '}';
    }
}
