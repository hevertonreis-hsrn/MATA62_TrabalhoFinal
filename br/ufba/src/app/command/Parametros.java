package br.ufba.src.app.command;

import java.util.ArrayList;

public class Parametros {
    private ArrayList<Integer> parametros = new ArrayList<Integer>();
    private String comando;

    public Parametros(String[] strEntrada){
        comando = strEntrada[0];
        for(int i = 1; i < strEntrada.length; i++){
            parametros.add(Integer.parseInt(strEntrada[i]));
        }
    }

    public String getComando(){
        return this.comando;
    }

    public int getP(int i){
        return parametros.get(i - 1);
    }

}
