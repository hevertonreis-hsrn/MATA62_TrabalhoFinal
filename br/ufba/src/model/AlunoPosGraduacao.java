package br.ufba.src.model;
public class AlunoPosGraduacao extends Usuario {

    public AlunoPosGraduacao(String codigo, String nome) {
        super(codigo, nome);
    }

    @Override
    public void realizarEmprestimo(Livro livro) {
    }

    @Override
    public void realizarDevolucao(Livro livro) {

    }


    public void realizarReserva(Livro livro) {

    }

    @Override
    public void observarLivro(Livro livro) {

    }

    @Override
    public int getPrazoEmprestimo() {
        return 5;
    }

}
