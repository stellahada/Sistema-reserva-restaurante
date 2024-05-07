package Servico;

public class CadastroMesa{
private String dia;
private String hora;
private String[] mesas;

public CadastroMesa() {
	
}
public CadastroMesa(String dia,String hora,String[] mesas) {
	
}


public String getDia() {
	return dia;
}
public void setDia(String dia) {
	this.dia = dia;
}
public String getHora() {
	return hora;
}
public void setHora(String hora) {
	this.hora = hora;
}
public String[] getMesas() {
	return mesas;
}
public void setMesas(String[] mesas) {
	this.mesas = mesas;
}

}
