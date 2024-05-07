package Servico;
import Usuario.Cliente;

public class RelatorioVendas {
private double receita;
private int numReservas;
private Cliente[] clientes;

public RelatorioVendas(){
	
}
public RelatorioVendas(double receita,int numReservas,Cliente[] clientes){
	
}

public double getReceita() {
	return receita;
}
public void setReceita(double receita) {
	this.receita = receita;
}
public int getNumReservas() {
	return numReservas;
}
public void setNumReservas(int numReservas) {
	this.numReservas = numReservas;
}
public Cliente[] getClientes() {
	return clientes;
}
public void setClientes(Cliente[] clientes) {
	this.clientes = clientes;
}

}
