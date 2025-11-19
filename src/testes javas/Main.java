public class Main {
    public static void main(String[] args) {
        System.out.println("Esse é o Screen Match");
        System.out.println("Filme: Top Gun Maverick");

        int ano = 2022;
        System.out.println("ano de lançamento\n" + ano);

        boolean incluidoNoPlano = true;
        System.out.println(incluidoNoPlano);

        double notaDoFilme = 9.9;
        System.out.println("Nota do Filme" +  notaDoFilme);

        double mediaNota = (9.9 + 9 + 10) / 3;
        System.out.println(mediaNota);

        String sinopse;
        sinopse = """
                Filme Top Gun
                Filme de ação no ares
                muito bom
                """;
        System.out.println(sinopse);

        int classificacao = (int) (mediaNota / 2);
        System.out.println(classificacao);

    }
}       

