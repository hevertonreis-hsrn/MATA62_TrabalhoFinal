package br.ufba.src.app;

import java.util.HashMap;
import java.util.Scanner;

import br.ufba.src.app.command.*;
import br.ufba.src.constantes.Mensagem;

public class Console {
    public Scanner entrada = new Scanner(System.in);
    private HashMap<String, Comando> comandos = new HashMap<String, Comando>();

    public Console(){
        iniciarComandos();
    }

    public void iniciarComandos(){
        comandos.put("emp", new EmpComando(this));
        comandos.put("dev", new DevComando(this));
        comandos.put("res", new ResComando(this));
        comandos.put("obs", new ObsComando(this));
        comandos.put("liv", new LivComando(this));
        comandos.put("usu", new UsuComando(this));
        comandos.put("ntf", new NtfComando(this));
        comandos.put("sai", new SaiComando());
    }

    public boolean processarEntradaConsole(){
        String[] strEntrada = entrada.nextLine().split(" ");
        Parametros parametros = new Parametros(strEntrada);
        return servico(parametros);
    }

    public void iniciar() {
        print(Mensagem.iniciando);

        while (processarEntradaConsole());

        print(Mensagem.encerrando);
    }

    public boolean servico(Parametros parametros) {
        Comando c = comandos.get(parametros.getComando());
        if (c == null) {
            print(Mensagem.comandoInvalido);
            return true; // Continua executando
        }
        return c.executar(parametros);
    }

    public void print(String texto){
        System.out.println(texto);
    }

}
