package observer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FuncionarioTest {

    @Test
    void deveNotificarUmFuncionario() {
        Departamento depto = new Departamento(2021, 1,1000.0f, "Vendas", "A");
        Funcionario funcionario = new Funcionario("Funcionario 1");
        funcionario.registraDepto(depto);
        depto.lancarSalario();
        assertEquals("Funcionario 1, salário lançado no Departamento{ano=2021, mes=1, salario=1000.0, nomeSetor='Vendas', nomeDepartamento='A'}", funcionario.getUltimaNotificacao());
    }

    @Test
    void deveNotificarFuncionarios() {
        Departamento depto = new Departamento(2021, 1, 1000.0f,"Vendas", "A");
        Funcionario funcionario1 = new Funcionario("Funcionario 1");
        Funcionario funcionario2 = new Funcionario("Funcionario 2");
        funcionario1.registraDepto(depto);
        funcionario2.registraDepto(depto);
        depto.lancarSalario();
        assertEquals("Funcionario 1, salário lançado no Departamento{ano=2021, mes=1, salario=1000.0, nomeSetor='Vendas', nomeDepartamento='A'}", funcionario1.getUltimaNotificacao());
        assertEquals("Funcionario 2, salário lançado no Departamento{ano=2021, mes=1, salario=1000.0, nomeSetor='Vendas', nomeDepartamento='A'}", funcionario2.getUltimaNotificacao());
    }

    @Test
    void naoDeveNotificarFuncionario() {
        Departamento depto = new Departamento(2021, 1, 1000.0f,"Vendas", "A");
        Funcionario funcionario = new Funcionario("Funcionario 1");
        depto.lancarSalario();
        assertEquals(null, funcionario.getUltimaNotificacao());
    }

    @Test
    void deveNotificarFuncionarioDepartamentoA() {
        Departamento deptoA = new Departamento(2021, 1, 1000.0f,"Vendas", "A");
        Departamento deptoB = new Departamento(2021, 1,1000.0f, "Vendas", "B");
        Funcionario funcionario1 = new Funcionario("Funcionario 1");
        Funcionario funcionario2 = new Funcionario("Funcionario 2");
        funcionario1.registraDepto(deptoA);
        funcionario2.registraDepto(deptoB);
        deptoA.lancarSalario();
        assertEquals("Funcionario 1, salário lançado no Departamento{ano=2021, mes=1, salario=1000.0, nomeSetor='Vendas', nomeDepartamento='A'}", funcionario1.getUltimaNotificacao());
        assertEquals(null, funcionario2.getUltimaNotificacao());
    }
}