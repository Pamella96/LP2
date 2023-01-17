package modelo;

public class Funcionario extends Pessoa {
	private Data dtAdm;
	private double salario;
	
	public Funcionario(String nome, String cpf, Data dtNasc, Data dtAdm, double salario) {
		super(nome, cpf, dtNasc);
		this.dtAdm = dtAdm;
		this.salario = salario;
	}
	public Funcionario(Pessoa p, Data dtAdm, double salario) {
		super(p.getNome(), p.getCpf(), p.getDtNasc());
		this.dtAdm = dtAdm;
		this.salario = salario;
		
	}
	public Data getDtAdm() {
		return dtAdm;
	}
	public void setDtAdm(Data dtAdm) {
		this.dtAdm = dtAdm;
	}
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	
	public String toString() {
		return(super.toString()+ "\nData de adm:" +dtAdm+ "\nSalario:" +salario);
	}
	
	

}
