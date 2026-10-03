package observer;

import java.util.Observable;

public class Departamento extends Observable {

    private Integer ano;
    private Integer mes;
    private Float valorSalario;
    private String nomeSetor;
    private String nomeDepartamento;

    public Departamento(Integer ano, Integer mes, Float valorSalario, String nomeSetor, String nomeDepartamento) {
        this.ano = ano;
        this.mes = mes;
        this.valorSalario = valorSalario;
        this.nomeSetor = nomeSetor;
        this.nomeDepartamento = nomeDepartamento;
    }

    public void lancarSalario() {
        setChanged();
        notifyObservers();
    }

    @Override
    public String toString() {
        return "Departamento{" +
                "ano=" + ano +
                ", mes=" + mes +
                ", salario=" + valorSalario +
                ", nomeSetor='" + nomeSetor + '\'' +
                ", nomeDepartamento='" + nomeDepartamento + '\'' +
                '}';
    }
}
