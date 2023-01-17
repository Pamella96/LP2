package main;

import modelo.Data;
import modelo.Pessoa;
import modelo.Funcionario;

public class MainPessoa {

	public static void main(String[] args) {
		
		Pessoa p1 = new Pessoa("Maria", "12365498778", new Data(3,6,1982));
		Funcionario f1 = new Funcionario("Joao","78965432111", new Data(04,12,1990), new Data(15,10,2022),4000f);
		
		
		
		System.out.println(p1+"\n");
		System.out.println(f1+"\n");
		
		

	}

}