package br.ufba.src.model;

import java.time.LocalDate;

public class Reserva {
    
    private Usuario usuario;
    private Livro livro;
    private LocalDate dataReserva;

    public Usuario getUsuario() {
        return usuario;
    }

}
