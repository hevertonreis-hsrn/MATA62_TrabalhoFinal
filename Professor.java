public class Professor extends Usuario implements Observer {

    public Professor(String codigo, String nome) {
        super(codigo, nome);
        //TODO Auto-generated constructor stub
    }

    @Override
    public void realizarEmprestimo(Livro livro) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'realizarEmprestimo'");
    }

    @Override
    public void notificar(Livro livro) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'notificar'");
    }
    
}
