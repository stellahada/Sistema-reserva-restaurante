package Geral;

public class Menu {
private Prato[] pratos;
private Bebida[] bebidas;
private String dia;

public Menu() {
	
}

public Menu(Prato[] pratos, Bebida[] bebidas,String dia) {
	
}

public Prato[] getPratos() {
	return pratos;
}
public void setPratos(Prato[] pratos) {
	this.pratos = pratos;
}
public Bebida[] getBebidas() {
	return bebidas;
}
public void setBebidas(Bebida[] bebidas) {
	this.bebidas = bebidas;
}
public String getDia() {
	return dia;
}
public void setDia(String dia) {
	this.dia = dia;
}
}
