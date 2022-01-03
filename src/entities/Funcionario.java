package entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entities.enums.Nivel;

public class Funcionario {

	private String nome;
	private Nivel classe;
	private Double salarioBase;

	private Departamento departamento;
	private List<HorasTrabalhadas> contratos = new ArrayList<HorasTrabalhadas>(); // não deve ser incluido nos construtores.

	public Funcionario() {

	}

	public Funcionario(String nome, Nivel classe, Double salarioBase, Departamento departamento) { //  observe que a lista não foi inserida no contrutor.
		this.nome = nome;
		this.classe = classe;
		this.salarioBase = salarioBase;
		this.departamento = departamento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Nivel getClasse() {
		return classe;
	}

	public void setClasse(Nivel classe) {
		this.classe = classe;
	}

	public Double getSalarioBase() {
		return salarioBase;
	}

	public void setSalarioBase(Double salarioBase) {
		this.salarioBase = salarioBase;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public List<HorasTrabalhadas> getContratos() {
		return contratos;
	}
	
	public void addContrato(HorasTrabalhadas contrato) {
		contratos.add(contrato);		
	}
	
	public void removerContrato(HorasTrabalhadas contrato) {
		contratos.remove(contrato);
	}
	
	public Double salarioBruto(int ano, int mes) {// argumento / parametro.
		Double soma=salarioBase;
		Calendar cal = Calendar.getInstance();
		for (HorasTrabalhadas c : contratos) {
			cal.setTime(c.getData()); // faz com que a data de cal seja a mesma data que está no contrato da variável c.
			int anoContrato = cal.get(Calendar.YEAR);
			int mesContrato = 1+ cal.get(Calendar.MONTH); // necessário acrescentar +1 pq o mês do Calendar inicia em zero.
			if(ano ==anoContrato && mes ==mesContrato) { // compara se o ano e mês do argumento são o mesmo do contrato.
			soma+=c.valorTotal();
			}
		}
		
		return soma;
	}
	
	
}
