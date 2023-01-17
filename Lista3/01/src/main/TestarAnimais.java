package main;

import modelo.Animal;
import modelo.Mamifero;
import modelo.Peixe;

public class TestarAnimais {

    public static void main(String[] args) {
        Animal a1, a2;
        Peixe p1;
        Mamifero m1;

        a1 = new Animal("piranha", "cinza", "lagoa", 0.5f, 30, 0);
        a2 = new Animal ("capivara", "marrom", "Brasil", 1.5f, 10, 4);
        p1 = new Peixe(a1, "Barbatana");
        m1 = new Mamifero(a2, "vegetais");

        p1.ExibirDadosPeixe();
        m1.ExibirDadosMamifero();

    }

}
