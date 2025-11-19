import java.util.Scanner;

public class Leitura {
    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);

        System.out.println("digite seu filme favorito");
        String filme = leitura.nextLine();
        System.out.println("digite o ano de lançamento");
        int ano = leitura.nextInt();
        System.out.println("qual a nota desse filme");
        double avalicao = leitura.nextDouble();



        System.out.println(filme);
        System.out.println(ano);
        System.out.println(avalicao);


        leitura.close();

    }
}
