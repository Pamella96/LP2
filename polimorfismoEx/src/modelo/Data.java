package modelo;

public class Data {
	public int dia;
	public int mes;
	private int ano;
	
	public Data(int d, int m, int a) {
		dia = d;
		mes = m;
		ano = a;
	}
	
	
	public String toString() {
		return (dia+ "/" +mes+ "/" +ano);
	}
	
	
	

}
