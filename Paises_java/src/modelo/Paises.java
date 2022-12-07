package modelo;

public class Paises {
    private String sigla, nome;
    private int populacao;
    private double dimensao;

    public Paises(String sigla, String nome, int populacao, double dimensao) {
        this.sigla = sigla;
        this.nome = nome;
        this.populacao = populacao;
        this.dimensao = dimensao;
    }

    public Paises() {

    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPopulacao() {
        return populacao;
    }

    public void setPopulacao(int populacao) {
        this.populacao = populacao;
    }

    public double getDimensao() {
        return dimensao;
    }

    public void setDimensao(double dimensao) {
        this.dimensao = dimensao;
    }

    public double densiPop() {
        System.out.print("\n a densidade demografica do pais" + nome + "\n é de:");
        return populacao / dimensao;
    }

    public String toString() {
        return "\nSigla: " + sigla + "\nNome:" + nome + "\nPopulacao:" + populacao + "\nDimensao:" + dimensao + "\n";
    }

}
