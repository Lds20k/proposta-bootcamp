package br.com.zup.bootcamp.client.response;

public class AssociateWalletResponse {

    private final String resultado;
    private final String id;

    public AssociateWalletResponse(String resultado, String id) {
        this.resultado = resultado;
        this.id = id;
    }

    public String getResultado() {
        return resultado;
    }

    public String getId() {
        return id;
    }
}
