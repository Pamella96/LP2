package application;

import modelo.Paciente;

import java.util.Scanner;

public class Main {

    public static void main(String[] args, String string) {

        Scanner sc = new Scanner(System.in);
        int menu = 0;
        int i = 0;
        int code;

        Paciente[] pacientes;
        pacientes = new Paciente[50];

        System.out.println("\n1- cadastrar paciente\n2- buscar por codigo\n3- exibir dados do paciente\n4- sair");
        menu = sc.nextInt();

        while (menu > 0 && menu != 4 && menu < 5) {
            if (menu == 1) {
                pacientes[i] = new Paciente();

                System.out.println("digite o codigo do paciente:");
                pacientes[i].setCodigo(sc.nextInt());
                sc.nextLine();

                System.out.println("digite o cpf do paciente:");
                pacientes[i].setCpf(sc.nextInt());
                sc.nextLine();

                System.out.println("digite o tel do paciente:");
                pacientes[i].setTel(sc.nextInt());
                sc.nextLine();

                System.out.println("digite o nome do paciente:");
                pacientes[i].setNome(sc.nextLine());

                i++;

                System.out.println(
                        "\n1- Cadastrar paciente\n2- Buscar cliente pelo código\n3- Exibir dados dos pacientes\n4- Sair");
                menu = sc.nextInt();

            } else if (menu == 2) {
                System.out.println("Digite o código do paciente: ");
                code = sc.nextInt();
                for (int j = 0; j < i; j++) {
                    if (pacientes[j].isEqual(code)) {
                        System.out.println(pacientes[j].toString());
                    }
                }

                System.out.println(
                        "\n1- Cadastrar paciente\n2- Buscar cliente pelo código\n3- Exibir dados dos pacientes\n4- Sair");
                menu = sc.nextInt();

            } else {
                for (int j = 0; j < i; j++) {
                    System.out.println(pacientes[j].toString());
                }

                System.out.println(
                        "\n1- Cadastrar paciente\n2- Buscar cliente pelo código\n3- Exibir dados dos pacientes\n4- Sair");
                menu = sc.nextInt();
            }
        }

        System.out.println("fim");

        sc.close();

    }

}