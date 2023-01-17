package modelo;

public class Peixe extends Animal {
    private String caracte;

    public Peixe() {

    }

    public Peixe(String nome, String cor, String ambiente, float comp, float vm, int numPatas, String caracte) {
        super(nome, cor, ambiente, comp, vm, numPatas);
        this.caracte = caracte;

    }

    public Peixe(Animal p, String caracte) {
        super(p.getNome(), p.getCor(), p.getAmbiente(), p.getComp(), p.getVm(), p.getNumPatas());
        this.caracte = caracte;
    }

    public String getCaracte() {
        return caracte;
    }

    public void setCaracte(String caracte) {
        this.caracte = caracte;
    }

    public void ExibirDadosPeixe(){
        super.ExibirDados();
        System.out.println("Caracteristica:" +caracte);
    }

}