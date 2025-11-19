public class Conficional {
    public static void main(String[] args) {
        int anoLancamento = 1990;
        boolean inclusoNoPlano = false;
        String tipoPlano = "plus";


        if (anoLancamento >= 2022) {
            System.out.println("Lançamento que clientes estao curtindo!");
        } else {
            System.out.println("filmes retrô que valem apena assistir ");
        }

        if (inclusoNoPlano == true || tipoPlano.equals("plus")) {
            System.out.println("filme liberado");
        } else {
            System.out.println(" Deve pagar a locação");
        }
    }
    
}
