package services;
import model.Livro;

public interface Observer {
    void notificar(Livro livro);
}
