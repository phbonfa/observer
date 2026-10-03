package observer;

import java.util.Observable;
import java.util.Observer;

public class Funcionario implements Observer {

    private String nome;
    private String ultimaNotificacao;

    public Funcionario(String nome) {
        this.nome = nome;
    }

    public String getUltimaNotificacao() {
        return this.ultimaNotificacao;
    }

    public void registraDepto(Departamento depto) {
        depto.addObserver(this);
    }

    public void update(Observable depto, Object arg1) {
        this.ultimaNotificacao = this.nome + ", salário lançado no " + depto.toString();
        // System.out.println(this.ultimaNotificacao);
    }
}
