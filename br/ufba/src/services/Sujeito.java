package MATA62_TrabalhoFinal.br.ufba.src.services;

import java.util.ArrayList;

public abstract class Sujeito{

    private ArrayList<Observador> observadores = new ArrayList<Observador>();

    public void adicionarObservador(Observador observador){
        observadores.add(observador);
    };
    public void removerObservador(Observador observador){
        observadores.remove(observador);
    }

    public void notificarObservadores(){
        for(Observador observador : observadores){
            observador.notificar(this);
        }
    }
}