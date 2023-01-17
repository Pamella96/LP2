package modelo;

public class Mamifero extends Animal {
	private String alimento;

	public Mamifero() {
		
	}

	public Mamifero(String nome, String cor, String ambiente, float comp, float vm, int numPatas, String alimento) {
		super(nome, cor, ambiente, comp, vm, numPatas);
		this.alimento = alimento;
	}
	
	public Mamifero (Animal a, String alimento) {
		super(a.getNome(), a.getCor(), a.getAmbiente(), a.getComp(), a.getVm(), a.getNumPatas());
        this.alimento = alimento;
	}
    public String getAlimento() {
		return alimento;
	}

	public void setAlimento(String alimento) {
		this.alimento = alimento;
	}
	
	public void ExibirDadosMamifero() {
		super.ExibirDados();
		System.out.println("Alimento:" +alimento);
	}
	
	

	
	
	

}
