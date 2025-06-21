package br.ufba.src.model;

import br.ufba.src.services.Observador;
import br.ufba.src.services.Sujeito;

public class Professor extends Usuario implements Observador {

    public Professor(int codigo, String nome) {
        super(codigo, nome);
    }

    @Override
    public void realizarEmprestimo(Livro livro) {
    }

    @Override
    public void realizarDevolucao(Livro livro) {

    }

    @Override
    public void realizarReserva(Livro livro) {

    }

    @Override
    public void observarLivro(Livro livro) {

    }

    @Override
    public void notificar(Sujeito sujeito) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'notificar'");
    }


}
