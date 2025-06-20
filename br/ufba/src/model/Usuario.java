package MATA62_TrabalhoFinal.br.ufba.src.model;
import java.util.ArrayList;
import java.util.List;

public abstract class Usuario {
    
    protected int codigo;
    protected String nome;
    protected List<Emprestimo> emprestimos;

    public Usuario(int codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
        this.emprestimos = new ArrayList<>();
    }

    public int getCodigo() {
        return this.codigo;
    }

    public void consultarInformacoes() {
    }
    
    public abstract void realizarEmprestimo(Livro livro);

    public abstract void realizarDevolucao(Livro livro);

    public abstract void realizarReserva(Livro livro);

    public abstract void observarLivro(Livro livro);

}
