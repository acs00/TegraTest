package com.example.flight.api.model;

import java.util.Date;

public class UberAir {
	String numero_voo;
	String aeroporto_origem;
	String aeroporto_destino;
	String data;
	String horario_saida;
	String horario_chegada;
	Double preco;
	
	public UberAir() {
		super();
	}
	public UberAir(String numero_voo, String aeroporto_origem, String aeroporto_destino, String data,
			String horario_saida, String horario_chegada, Double preco) {
		super();
		this.numero_voo = numero_voo;
		this.aeroporto_origem = aeroporto_origem;
		this.aeroporto_destino = aeroporto_destino;
		this.data = data;
		this.horario_saida = horario_saida;
		this.horario_chegada = horario_chegada;
		this.preco = preco;
	}
	public String getNumero_voo() {
		return numero_voo;
	}
	public void setNumero_voo(String numero_voo) {
		this.numero_voo = numero_voo;
	}
	public String getAeroporto_origem() {
		return aeroporto_origem;
	}
	public void setAeroporto_origem(String aeroporto_origem) {
		this.aeroporto_origem = aeroporto_origem;
	}
	public String getAeroporto_destino() {
		return aeroporto_destino;
	}
	public void setAeroporto_destino(String aeroporto_destino) {
		this.aeroporto_destino = aeroporto_destino;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getHorario_saida() {
		return horario_saida;
	}
	public void setHorario_saida(String horario_saida) {
		this.horario_saida = horario_saida;
	}
	public String getHorario_chegada() {
		return horario_chegada;
	}
	public void setHorario_chegada(String horario_chegada) {
		this.horario_chegada = horario_chegada;
	}
	public Double getPreco() {
		return preco;
	}
	public void setPreco(Double preco) {
		this.preco = preco;
	}
}
