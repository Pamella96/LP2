package modelo;

public class Animal {
    private String nome, cor, ambiente;
    private float comp, vm;
    private int numPatas;

    public Animal() {

    }

    public Animal(String nome, String cor, String ambiente, float comp, float vm, int numPatas) {
        this.nome = nome;
        this.cor = cor;
        this.ambiente = ambiente;
        this.comp = comp;
        this.vm = vm;
        this.numPatas = numPatas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getAmbiente() {
        return ambiente;
    }

    public void setAmbiente(String ambiente) {
        this.ambiente = ambiente;
    }

    public float getComp() {
        return comp;
    }

    public void setComp(float comp) {
        this.comp = comp;
    }

    public float getVm() {
        return vm;
    }

    public void setVm(float vm) {
        this.vm = vm;
    }

    public int getNumPatas() {
        return numPatas;
    }

    public void setNumPatas(int numPatas) {
        this.numPatas = numPatas;
    }

    public void ExibirDados() {
        System.out.println("\nNome:" + nome + "\nCor:" + cor + "\nAmbiente:" + ambiente + "\nComprimento:" + comp
                + "\nVelocidade Media:" + vm + "\nNumero Patas:" + numPatas);
    }

}