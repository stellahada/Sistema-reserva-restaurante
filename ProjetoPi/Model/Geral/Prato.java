package Geral;
import Supers.Consumivel;

public class Prato extends Consumivel {
private String chef;
private boolean restricao;

public Prato(){
	
}

public Prato(String nome,double preco,String regiao,String descricao,String chef,boolean restricao){
	
}


public String getChef() {
	return chef;
}
public void setChef(String chef) {
	this.chef = chef;
}
public boolean isRestricao() {
	return restricao;
}
public void setRestricao(boolean restricao) {
	this.restricao = restricao;
}
}
