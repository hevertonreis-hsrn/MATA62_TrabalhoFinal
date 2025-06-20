package MATA62_TrabalhoFinal.br.ufba.src.app;

import java.util.HashMap;
import java.util.Scanner;

public class Console {
    public Scanner entrada = new Scanner(System.in);
    private HashMap<String, Comando> comandos = new HashMap<String, Comando>();

    public Console(){
        iniciarComandos();
    }

    public void iniciarComandos(){
        comandos.put("emp", new EmpComando());
        comandos.put("dev", new DevComando());
        comandos.put("res", new ResComando());
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

    public boolean servico(Parametros parametros) {
        Comando c = (Comando) comandos.get(parametros.getComando());
        return c.executar(parametros);
    }

    public void print(String texto){
        System.out.println(texto);
    }

}
