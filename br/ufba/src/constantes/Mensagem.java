package br.ufba.src.constantes;

public class Mensagem {
    public static final String iniciando = (
            "=== Sistema Biblioteca Iniciado ===\n" +
            "Digite um comando ou 'sai' para encerrar."
    );

    public static final String encerrando = (
            "=== Sistema Encerrado ==="
    );

    public static final String comandoInvalido = (
            "Comando invalido."
    );

    public static final String emprestimo = (
            "Empréstimo realizado com sucesso!"
    );

    public static final String semEmprestimo= (
            "Nao é possível fazer um novo empréstimo! "
    );

    public static final String semExemplares = (
             semEmprestimo + "Não existem exemplares disponíveis na biblioteca."
    );

    public static final String devolucoesEmAtraso = (
            semEmprestimo + "Existem devoluções em atraso para este usuário."
    );

    public static final String limiteAtingido = (
            semEmprestimo + "Limite atingido."
    );

    public static final String livroReservado = (
            semEmprestimo + "O livro está reservado para outros alunos."
    );

    public static final String emprestimoEmAberto = (
            semEmprestimo + "O usuário possui um empréstimo em aberto deste livro."
    );

    public static final String devolucao = (
            "Devolucao realizada com sucesso!"
    );

    public static final String semDevolucao = (
            "Não foi possível efetuar a devolução. Não existe empréstimos em aberto para este livro."
    );

    public static final String reserva = (
            "Reserva realizada com sucesso!"
    );

    public static final String semReserva = (
            "Não foi possível efetuar a reserva. O usuário possui uma reserva para este livro."
    );

    public static final String observadorRegistrado = (
            "Usuário registrado como observador do livro."
    );

    public static final String totalNotificacoes = (
            " notficações foram recebidas pelo usuário sobre livros observados."
    );

}
