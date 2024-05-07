package Geral;

public class Evento {
private String nome;
private String estilo;
private String data;
private String artista;

public Evento() {
	
}

public Evento(String nome,String estilo,String data,String artista) {
	
}

public String getNome() {
	return nome;
}

public void setNome(String nome) {
	this.nome = nome;
}

public String getEstilo() {
	return estilo;
}
public void setEstilo(String estilo) {
	this.estilo = estilo;
}
public String getData() {
	return data;
}
public void setData(String data) {
	this.data = data;
}
public String getArtista() {
	return artista;
}
public void setArtista(String artista) {
	this.artista = artista;
}
}
