package br.ufba.src.model;

import java.time.LocalDate;

public class Reserva {
    
    private Usuario usuario;
    private Livro livro;
    private LocalDate dataReserva;

    public Reserva(Usuario usuario, Livro livro, LocalDate dataReserva) {
        this.usuario = usuario;
        this.livro = livro;
        this.dataReserva = dataReserva;
    }

    public String getTituloLivro(){
        return livro.getTitulo();
    }

    public Livro getLivro() {
        return livro;
    }

    public LocalDate getDataReserva() {
        return dataReserva;
    }

    public Usuario getUsuario() {
        return usuario;
    }

}
