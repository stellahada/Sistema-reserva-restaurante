package Servico;

import Geral.Menu;

public class Experiencia {
private String nome;
private String chef;
private double preco;
private Menu menu;
private String descricao;
private String tipo;


public Experiencia() {
	
}

public Experiencia(String nome,String chef,double preco,Menu menu,String tipo,String descricao) {
	
}

public String getNome() {
	return nome;
}
public void setNome(String nome) {
	this.nome = nome;
}
public String getChef() {
	return chef;
}
public void setChef(String chef) {
	this.chef = chef;
}
public double getPreco() {
	return preco;
}
public void setPreco(double preco) {
	this.preco = preco;
}
public Menu getMenu() {
	return menu;
}
public void setMenu(Menu menu) {
	this.menu = menu;
}
public String getTipo() {
	return tipo;
}

public void setTipo(String tipo) {
	this.tipo = tipo;
}
public String getDescricao() {
	return descricao;
}
public void setDescricao(String descricao) {
	this.descricao = descricao;
}
}
