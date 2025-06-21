package br.ufba.src.app.command;

import java.util.ArrayList;
import java.util.List;

public class Parametros {
    private List<String> parametros = new ArrayList<>();
    private String comando;

    public Parametros(String[] strEntrada) {
        comando = strEntrada[0];
        for (int i = 1; i < strEntrada.length; i++) {
            parametros.add(strEntrada[i]);
        }
    }

    public String getComando() {
        return this.comando;
    }

    public String getP(int i) {
        return parametros.get(i - 1);
    }
}
