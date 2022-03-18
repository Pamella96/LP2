public class ElipApp {
    public static void main(String[] args) {
        Elip e1 = new Elip(3, 3, 9, 10);
        e1.print();

    }

}

class Elip {
    int x, y;
    int w, h;

    Elip(int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }

    void print() {
        System.out.format(
                "Elipse iniando na cordenada (%d, %d) de tamanho Largura:(%d) e Altura:(%d) de altura e terminando na posicao (%d, %d).\n",
                this.x, this.y, this.w, this.h, this.w + this.x, this.h + this.y);
    }

}