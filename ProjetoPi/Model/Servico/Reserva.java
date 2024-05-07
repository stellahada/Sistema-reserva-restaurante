package Servico;
import Geral.Restaurante;
import Usuario.Cliente;

public class Reserva {
private Cliente cliente;
private String mesa;
private Restaurante restaurante;
private Experiencia experiencia;

public Cliente getCliente() {
	return cliente;
}
public void setCliente(Cliente cliente) {
	this.cliente = cliente;
}
public String getMesa() {
	return mesa;
}
public void setMesa(String mesa) {
	this.mesa = mesa;
}
public Restaurante getRestaurante() {
	return restaurante;
}
public void setRestaurante(Restaurante restaurante) {
	this.restaurante = restaurante;
}
public Experiencia getExperiencia() {
	return experiencia;
}
public void setExperiencia(Experiencia experiencia) {
	this.experiencia = experiencia;
}

}
