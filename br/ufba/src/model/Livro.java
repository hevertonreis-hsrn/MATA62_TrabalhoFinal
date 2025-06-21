package br.ufba.src.model;

import java.util.ArrayList;
import java.util.List;

import br.ufba.src.services.Sujeito;

public class Livro extends Sujeito {

    private String codigo;
    private String titulo;
    private String editora;
    private String autores;
    private String edicao;
    private int anoPublicacao;
    private List<Exemplar> exemplares;

    public Livro(String codigo, String titulo, String editora, String autores, String edicao, int anoPublicacao) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.editora = editora;
        this.autores = autores;
        this.edicao = edicao;
        this.anoPublicacao = anoPublicacao;
        this.exemplares = new ArrayList<Exemplar>();
    }

    /*public void criarLivro(String codigo,
            String titulo,
            String editora,
            String autores,
            String edicao,
            int anoPublicacao) {

        this.codigo = codigo;
        this.titulo = titulo;
        this.editora = editora;
        this.autores = autores;
        this.edicao = edicao;
        this.anoPublicacao = anoPublicacao;

        notificarObservadores();
    }*/

    

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
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

    public void adicionarExemplar(String codigo) {
        exemplares.add(new Exemplar(codigo, this, true));
    }
}