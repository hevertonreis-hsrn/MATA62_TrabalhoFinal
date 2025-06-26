package br.ufba.src.app;

import java.util.HashMap;
import java.util.Scanner;

import br.ufba.src.app.command.Comando;
import br.ufba.src.app.command.DevComando;
import br.ufba.src.app.command.EmpComando;
import br.ufba.src.app.command.LivComando;
import br.ufba.src.app.command.NtfComando;
import br.ufba.src.app.command.ObsComando;
import br.ufba.src.app.command.Parametros;
import br.ufba.src.app.command.ResComando;
import br.ufba.src.app.command.SaiComando;
import br.ufba.src.app.command.UsuComando;

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
        comandos.put("obs", new ObsComando());
        comandos.put("liv", new LivComando());
        comandos.put("usu", new UsuComando());
        comandos.put("ntf", new NtfComando());
        comandos.put("sai", new SaiComando());
    }

    public boolean processarEntradaConsole(){
        String[] strEntrada = entrada.nextLine().split(" ");
        Parametros parametros = new Parametros(strEntrada);
        return servico(parametros);
    }

    public void iniciar() {
        print("=== Sistema Biblioteca Iniciado ===");
        print("Digite um comando ou 'sai' para encerrar.");

        boolean continuar = true;
        while (continuar) {
            continuar = processarEntradaConsole();
        }

        print("=== Sistema Encerrado ===");
    }

    public boolean servico(Parametros parametros) {
        Comando c = comandos.get(parametros.getComando());
        if (c == null) {
            print("Comando invalido.");
            return true; // Continua executando
        }
        return c.executar(parametros);
    }

    //TODO: Giovane vai fazer alguma coisa 
    public void print(String texto){
        System.out.println(texto);
    }

}
