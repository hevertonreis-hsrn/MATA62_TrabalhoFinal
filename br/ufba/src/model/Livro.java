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
    private List<Reserva> reservas;

    public Livro(String codigo, String titulo, String editora, String autores, String edicao, int anoPublicacao) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.editora = editora;
        this.autores = autores;
        this.edicao = edicao;
        this.anoPublicacao = anoPublicacao;
        this.exemplares = new ArrayList<Exemplar>();
        this.reservas = new ArrayList<Reserva>();
    }

    public String getCodigo() {
        return codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getEditora() {
        return editora;
    }

    public String getAutores() {
        return autores;
    }

    public String getEdicao() {
        return edicao;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public void adicionarExemplar(String codigo) {
        exemplares.add(new Exemplar(codigo, this, true));
    }

    public boolean temExemplarDisponivel() {
        for (Exemplar exemplar : exemplares) {
            if(exemplar.estaDisponivel()){
                return true;
            }
        }
        return false;
    }

    public int qtdReservas() {
        return reservas.size();
    }

    public String consultarInformacoes() {
        String strRetorno = "| " + titulo +" |\n";
        strRetorno += retornaUsuariosReserva();
        strRetorno += retornaStatusExemplares();

        return strRetorno;
    }

    public String retornaUsuariosReserva(){
        Reserva reserva;
        int quantidadeDeReservas = reservas.size();
        String strRetorno = "| "+ quantidadeDeReservas + " Reservas |\n";

        for(int i = 0; i < quantidadeDeReservas; i++){
            reserva = reservas.get(i);
            strRetorno += reserva.getUsuario();
            if(i != quantidadeDeReservas - 1){
                strRetorno += ", ";
            }
            else{
                strRetorno += ".\n";
            }
        }

        return strRetorno;
    }

    public String retornaStatusExemplares(){
        Exemplar exemplar;
        int quantidadeDeExemplares = exemplares.size();
        String strRetorno ="| Exemplares |\n";

        for(int i = 0; i < quantidadeDeExemplares; i++){
            exemplar = exemplares.get(i);
            strRetorno += "Código: " + exemplar.getCodigo() +
                          " | Status: ";
            if(exemplar.estaDisponivel()){
                strRetorno += "Disponível";
            }
            else {
                Emprestimo emprestimo = exemplar.getEmprestimo();
                strRetorno += "Emprestado" +
                              " | Usuário: " + emprestimo.getUsuario() +
                              " | Data de empréstimo: " + emprestimo.getDataEmprestimo() +
                              " | Data prevista para devolução: " + emprestimo.getDataDevolucaoEstimada();
            }
            strRetorno += "\n";
        }

        return strRetorno;
    }

    public int qtdExemplaresDisponiveis() {
        int qtd = 0;
        for (Exemplar exemplar : exemplares) {
            if(exemplar.estaDisponivel()){
                qtd++;
            }
        }
        return qtd;
    }

    public boolean reservaPertenceAoUsuario(Usuario usuario) {
        for (Reserva reserva : reservas) {
            if (reserva.getUsuario().equals(usuario)) {
                return true;
            }
        }
        return false;
    }

    public Exemplar getExemplarDisponivel() {
        for (Exemplar exemplar : exemplares) {
            if(exemplar.estaDisponivel()){
                return exemplar;
            }
        }
        return null;
    }

    public void removerReservaUsuario(Usuario usuario) {
        reservas.removeIf(reserva -> reserva.getUsuario().equals(usuario));
    }

    public void adicionarReserva(Reserva reserva) {
        this.reservas.add(reserva);

        if(this.reservas.size() > 2){
            this.notificarObservadores();
        }
    }
}