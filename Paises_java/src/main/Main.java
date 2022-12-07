package main;

import java.util.Scanner;
import modelo.Paises;

public class Main {
    public static void main(String[] args) {
        int i = 0, check = 0;
        Scanner scan = new Scanner(System.in);
        Paises[] pais;
        pais = new Paises[200];

        while (check != -1) {

            pais[i] = new Paises();

            System.out.println("digite a sigla do país:");
            pais[i].setSigla(scan.nextLine());

            System.out.println("digite o nome do pais:");
            pais[i].setNome(scan.nextLine());

            System.out.println("digite a populacao do pais:");
            pais[i].setPopulacao(scan.nextInt());

            System.out.println("digite a dimensao do pais:");
            pais[i].setDimensao(scan.nextDouble());

            i++;
            scan.nextLine();

            System.out.println("país cadastrado digite -1 para parar e 1 para continuar");
            check = scan.nextInt();
            scan.nextLine();
        }

        for (int j = 0; j < i; j++) {
            System.out.println(pais[j].toString());
            System.out.println(pais[j].densiPop());
        }
    }
}