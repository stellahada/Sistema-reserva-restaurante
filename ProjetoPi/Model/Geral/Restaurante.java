package Geral;

import Servico.Experiencia;

public class Restaurante {
	private String nome;
	private String endereco;
	private int estrelas;
	private Experiencia experiencia;
	private String[] mesas;
	
	public Restaurante() {
		
	}
	
	public Restaurante(String nome, String endereco, int estrelas,Experiencia experiencia,String[] mesas) {
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public int getEstrelas() {
		return estrelas;
	}
	public void setEstrelas(int estrelas) {
		this.estrelas = estrelas;
	}
	public Experiencia getExperiencia() {
		return experiencia;
	}
	public void setExperiencia(Experiencia experiencia) {
		this.experiencia = experiencia;
	}

	public String[] getMesas() {
		return mesas;
	}

	public void setMesas(String[] mesas) {
		this.mesas = mesas;
	}
	
}
