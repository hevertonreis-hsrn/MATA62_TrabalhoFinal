package br.ufba.src.services;

public class ResultadoOperacao {
    
    private boolean sucesso;
    private String mensagem;

    public ResultadoOperacao(boolean sucesso, String mensagem) {
        this.sucesso = sucesso;
        this.mensagem = mensagem;
    }

    public boolean isSucesso() {
        return sucesso;
    }

    public String getMensagem() {
        return mensagem;
    }

}
