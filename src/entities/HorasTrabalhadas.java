package entities;

import java.util.Date;

public class HorasTrabalhadas {
	
	private Date data;
	private Double valorHora;
	private Integer horas;
	
	public HorasTrabalhadas() {
		
	}
	
	public HorasTrabalhadas(Date data, Double valorHora, Integer horas) {
		this.data = data;
		this.valorHora = valorHora;
		this.horas = horas;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Double getValorHora() {
		return valorHora;
	}

	public void setValorHora(Double valorHora) {
		this.valorHora = valorHora;
	}

	public Integer getHoras() {
		return horas;
	}

	public void setHoras(Integer horas) {
		this.horas = horas;
	}
	
	public Double valorTotal() {
		return valorHora * horas;
	}

	@Override
	public String toString() {
		return "Contrato:" + data + ", Valor hora" +String.format("%8.2f", valorHora) + ", Quantidade de horas:" + horas 
				+ String.format(" >>>> Total R$ %10.2f", valorHora*horas);
	}

	
}
