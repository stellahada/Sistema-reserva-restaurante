package Usuario;
import Supers.Pessoa;

public class Administrador extends Pessoa{
private int chave;

public Administrador() {
	
}

public Administrador(String nome,String cpf,String endereco,int chave) {
	
}

public int getChave() {
	return chave;
}

public void setChave(int chave) {
	this.chave = chave;
}

}
