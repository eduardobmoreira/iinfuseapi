package br.com.infuse.entity;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Pedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer numeroControle;
	private String dataCadastro;
	private String nome;
	private Double valor;
	private Integer quantidade;
	private String codigoCliente;
	private Double valorTotal;
	
	public Pedido(Integer numeroControle, String dataCadastro, String nome, Double valor, Integer quantidade,
			String codigoCliente, Double valorTotal) {
		super();
		this.numeroControle = numeroControle;
		if(dataCadastro == null) {
			String datePattern = "dd-MM-yyyy HH:mm:ss";
			DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(datePattern);
			this.dataCadastro = dateFormatter.format(ZonedDateTime.now());
		}else {
			this.dataCadastro = dataCadastro;
		}
		this.nome = nome;
		this.valor = valor;
		if(quantidade == null) {
			this.quantidade = 1;
		}else {
			this.quantidade = quantidade;
		}
		this.valorTotal = this.valor*this.quantidade;
		if(quantidade >= 10) {
			this.valorTotal = this.valorTotal - this.valorTotal*0.1;
		} else if(quantidade > 5) {
			this.valorTotal = this.valorTotal - this.valorTotal*0.05;
		}
		this.codigoCliente = codigoCliente;
	}

	public Integer getNumeroControle() {
		return numeroControle;
	}

	public void setNumeroControle(Integer numeroControle) {
		this.numeroControle = numeroControle;
	}

	public String getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(String dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public String getCodigoCliente() {
		return codigoCliente;
	}

	public void setCodigoCliente(String codigoCliente) {
		this.codigoCliente = codigoCliente;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}
}
