package modelo;

public class Paciente {

    private int codigo, cpf, tel;
    private String nome;

    public Paciente(int codigo, int cpf, int tel, String nome) {
        this.codigo = codigo;
        this.cpf = cpf;
        this.tel = tel;
        this.nome = nome;
    }

    public Paciente() {

    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isEqual(int code) {
        if (getCodigo() == code) {
            return true;

        } else {
            return false;
        }
    }

    public String toString() {
        return "\nCodigo:" + codigo + "\nCpf" + cpf + "\nTel:" + tel + "\nNome:" + nome;
    }

}
