package Usuario;
import Supers.Pessoa;

public class Cliente extends Pessoa {
private boolean reserva;
private int idade;

public Cliente() {
	
}
public Cliente(String nome,String cpf,String endereco,boolean reserva) {
	
}
public boolean isReserva() {
	return reserva;
}
public void setReserva(boolean reserva) {
	this.reserva = reserva;
}

public int getIdade() {
	return idade;
}
public void setIdade(int idade) {
	this.idade = idade;
}

public boolean realizaPagamento() {
	return true;
}

public boolean realizaReserva() {
	return true;
}


}
