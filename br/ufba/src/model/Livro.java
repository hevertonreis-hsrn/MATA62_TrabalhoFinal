package br.ufba.src.model;

import br.ufba.src.services.Sujeito;

public class Livro extends Sujeito{

    private int codigo;
    private String titulo;
    private String editora;
    private String autores;
    private String edicao;
    private int anoPublicacao;

    public void criarLivro(int codigo,
                      String titulo,
                      String editora,
                      String autores,
                      String edicao,
                      int anoPublicacao){

        this.codigo = codigo;
        this.titulo = titulo;
        this.editora = editora;
        this.autores = autores;
        this. edicao = edicao;
        this.anoPublicacao = anoPublicacao;

        notificarObservadores();
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
        notificarObservadores();
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
        notificarObservadores();
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
        notificarObservadores();
    }

    public String getAutores() {
        return autores;
    }

    public void setAutores(String autores) {
        this.autores = autores;
        notificarObservadores();
    }

    public String getEdicao() {
        return edicao;
    }

    public void setEdicao(String edicao) {
        this.edicao = edicao;
        notificarObservadores();
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(int anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
        notificarObservadores();
    }

    public void consultarInformacoes() {
    }
}