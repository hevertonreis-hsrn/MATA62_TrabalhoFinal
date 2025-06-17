import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Servidor {
    private List<Object> db = new ArrayList<Object>();
    private HashMap comandos = new HashMap();

    public Servidor(){
        iniciarComandos();
    }

    public Object iniciarComandos(){
        return null;
    }

    public void servico(String comando,
                        Object informacao){
        Command c =(Command) comandos.get(comando);
        Object resultado = c.executar(informacao);
    }
}
