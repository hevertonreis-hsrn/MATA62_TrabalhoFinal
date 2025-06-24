package br.ufba.src.repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.ufba.src.model.AlunoGraduacao;
import br.ufba.src.model.AlunoPosGraduacao;
import br.ufba.src.model.Emprestimo;
import br.ufba.src.model.Livro;
import br.ufba.src.model.Professor;
import br.ufba.src.model.Reserva;
import br.ufba.src.model.Usuario;

public class Repositorio {
    
    private List<Usuario> usuarios;
    private List<Livro> livros;
    
    private static Repositorio instancia;

    private Repositorio() {
        this.usuarios = new ArrayList<>();
        this.livros = new ArrayList<>();
        carregarDadosDeTeste();
    }

    public static Repositorio getInstancia() {
        if(instancia == null){
            instancia = new Repositorio();
        }
        return instancia;
    }

    private void carregarDadosDeTeste(){
        usuarios.add(new AlunoGraduacao("123", "João da Silva"));
        usuarios.add(new AlunoPosGraduacao("456", "Luiz Fernando Rodrigues"));
        usuarios.add(new AlunoGraduacao("789", "Pedro Paulo"));
        usuarios.add(new Professor("100", "Carlos Lucena"));

        Livro livro01 = new Livro(
            "100", 
            "Engenharia de Software", 
            "Addison Wesley", 
            "Ian Sommervile", 
            "6ª", 
            2000);
        livros.add(livro01);
        livro01.adicionarExemplar("01");
        livro01.adicionarExemplar("02");

        Livro livro02 = new Livro(
            "101", 
            "UML - Guia do Usuário", 
            "Campus", 
            "Grady Booch, James Rumbaugh, Ivar Jacobson", 
            "7ª", 
            2000);
        livros.add(livro02);
        livro02.adicionarExemplar("03");

        Livro livro03 = new Livro(
            "200", 
            "Code Complete", 
            "Microsoft Press", 
            "Steve McConnell", 
            "2ª", 
            2014);
        livros.add(livro03);
        livro03.adicionarExemplar("04");

        Livro livro04 = new Livro(
            "201", 
            "Agile Software Development, Principles, Patterns and Practices", 
            "Prentice Hall", 
            "Robert Martin", 
            "1ª", 
            2002);
        livros.add(livro04);
        livro04.adicionarExemplar("05");

        Livro livro05 = new Livro(
            "300", 
            "Refactoring: Improving the Design of Existing Code", 
            "Addison Wesley Professional", 
            "Martin Fowler", 
            "1ª", 
            1999);
        livros.add(livro05);
        livro05.adicionarExemplar("06");
        livro05.adicionarExemplar("07");

        Livro livro06 = new Livro(
            "301", 
            "Software Metrics: A rigorous and Practical Approach", 
            "CRC Press", 
            "Norman Fenton, James Bieman", 
            "3ª", 
            2014);
        livros.add(livro06);

        Livro livro07 = new Livro(
            "400", 
            "Design Patterns: Element of Reusable Object-Oriented Software", 
            "Addison Wesley Professional", 
            "Erich Gamma, Richard Helm, Ralph Johnson, John Vlissides", 
            "1ª", 
            1994);
        livros.add(livro07);
        livro07.adicionarExemplar("08");
        livro07.adicionarExemplar("09");

        Livro livro08 = new Livro(
            "401", 
            "UML Distilled: A Brief Guide to the Standard Object Modeling Language", 
            "Addison Wesley Professional", 
            "Martin Fowler", 
            "3ª", 
            2003);
        livros.add(livro08);

        // Massa de testes de casos de erro (emprestimo)
        // Exemplar nao disponivel
        Usuario usuarioTeste01 = new AlunoGraduacao("001", "Felipe Lucena");
        usuarios.add(usuarioTeste01);
        Livro livro09 = new Livro(
            "003", 
            "Livro com Exemplar Indisponivel", 
            "Eng. Software I", 
            "Heverton Reis", 
            "0", 
            2025);
        livros.add(livro09);

        // Devolucao em atraso
        Emprestimo devolucaoAtrasada = new Emprestimo(
            usuarioTeste01,
            livro01.getExemplarDisponivel(), 
            LocalDate.parse("2025-06-17"), 
            LocalDate.parse("2025-06-21"));

        usuarioTeste01.adicionarEmprestimo(devolucaoAtrasada);

        // Emprestimos em aberto
        Usuario usuarioTeste02 = new AlunoGraduacao("002", "Larisse M");
        usuarios.add(usuarioTeste02);

        Emprestimo emprestimoAberto01 = new Emprestimo(
            usuarioTeste02,
            livro01.getExemplarDisponivel(), 
            LocalDate.parse("2025-06-21"), 
            LocalDate.parse("2025-06-25"));

        usuarioTeste02.adicionarEmprestimo(emprestimoAberto01);

        Emprestimo emprestimoAberto02 = new Emprestimo(
            usuarioTeste02,
            livro07.getExemplarDisponivel(), 
            LocalDate.parse("2025-06-21"), 
            LocalDate.parse("2025-06-25"));

        usuarioTeste02.adicionarEmprestimo(emprestimoAberto02);

        // Usuario nao tem reserva
        Usuario usuarioTeste03 = new AlunoGraduacao("003", "Jarbas Augusto");
        usuarios.add(usuarioTeste03);
        Livro livro10 = new Livro(
            "010", 
            "Livro com Todos os Exemplares Reservados", 
            "Eng. Software I", 
            "Heverton Reis", 
            "0", 
            2025);
        livros.add(livro10);
        livro10.adicionarExemplar("10");

        Reserva reservaA1 = new Reserva(
            usuarioTeste01,
            livro10,
            LocalDate.parse("2025-06-21")
        );
        livro10.adicionarReserva(reservaA1);

        Reserva reservaA2 = new Reserva(
            usuarioTeste02,
            livro10,
            LocalDate.parse("2025-06-21")
        );
        livro10.adicionarReserva(reservaA2);
    }

    public Usuario buscarUsuarioPorCodigo(String codigo){
        for (Usuario usuario : usuarios) {
            if (usuario.getCodigo().equals(codigo)) {
                return usuario;
            }
        }
        return null;
    }

    public Livro buscarLivroPorCodigo(String codigo){
        for (Livro livro : livros) {
            if (livro.getCodigo().equals(codigo)) {
                return livro;
            }
        }
        return null;
    }
}
