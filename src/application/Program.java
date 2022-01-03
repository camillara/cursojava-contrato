package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entities.Departamento;
import entities.Funcionario;
import entities.HorasTrabalhadas;
import entities.enums.Nivel;

public class Program {

	public static void main(String[] args) throws ParseException {

		Scanner leia = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");// necessário para data

		Double valorHora = 0.0;
		int horas = 0;
		HorasTrabalhadas contrato = null;
		double valorTotalContratos=0.0;

		System.out.print("Informe o nome do departamento: ");
		String aux = leia.nextLine();
		Departamento depart = new Departamento(aux);
		System.out.print("Nome: ");
		String nome = leia.nextLine();
		System.out.print("Nível: ");
		aux = leia.nextLine();
		Nivel nivel = Nivel.valueOf(aux.toUpperCase());
		System.out.print("Salário base: ");
		Double salarioBase = leia.nextDouble();
		Funcionario colaborador = new Funcionario(nome, nivel, salarioBase, depart);

		System.out.print("Informe a quantidade de contratos: ");
		int x = leia.nextInt();

		for (int i = 1; i <= x; i++) {
			System.out.printf("%dº CONTRATO\n", i);
			System.out.print("Data (dd/mm/aaaa): ");
			Date dtContrato = sdf.parse(leia.next()); // ler o valor que for digitado
			System.out.print("Valor hora trabalhada: R$ ");
			valorHora = leia.nextDouble();
			System.out.print("Quantidade de horas: ");
			horas = leia.nextInt();
			contrato = new HorasTrabalhadas(dtContrato, valorHora, horas);
			colaborador.addContrato(contrato);
			valorTotalContratos+=contrato.valorTotal();// adicionar contratos na lista do trabalhador
		}

		System.out.println();
		System.out.printf("Quantidade total de contratos do funcionário %s: %d \n",colaborador.getNome().toUpperCase() ,colaborador.getContratos().size());// tamanho da lista
		System.out.printf("Soma de todos os contratos R$ %.2f\n", valorTotalContratos);
		
		System.out.println();
		System.out.print("Digite o mês e o ano (mm/yyyy): ");
		aux = leia.next();
		int mes = Integer.parseInt(aux.substring(0, 2));
		int ano = Integer.parseInt(aux.substring(3));

		System.out.println();
		System.out.println("Nome: " + colaborador.getNome().toUpperCase() + " - Nível: " + colaborador.getClasse());
		System.out.println("Departamento: " + colaborador.getDepartamento().getDepartamento().toUpperCase());
		System.out.println("Período: " + mes + "/" + ano);
		System.out.println("Salário Base: \tR$ " + String.format("%.2f", colaborador.getSalarioBase()));
		System.out.println("Salário Bruto: \tR$ " + String.format("%.2f", colaborador.salarioBruto(ano, mes)));

		
		leia.close();
	}

}
