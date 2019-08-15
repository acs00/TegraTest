package com.example.flight.api.model;

import java.util.ArrayList;

public class Flight {
	String origem;
	String destino;
	String chegada;
	String saida;
	ArrayList<Scale> trechos;
	
	public String getOrigem() {
		return origem;
	}
	public void setOrigem(String origem) {
		this.origem = origem;
	}
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	public String getChegada() {
		return chegada;
	}
	public void setChegada(String chegada) {
		this.chegada = chegada;
	}
	public String getSaida() {
		return saida;
	}
	public void setSaida(String saida) {
		this.saida = saida;
	}
	public ArrayList<Scale> getTrechos() {
		return trechos;
	}
	public void setTrechos(ArrayList<Scale> trechos) {
		this.trechos = trechos;
	}
}
