import java.util.Scanner;

public class SistemaBancario {
    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);
        String nome = "Neo";
        String tipo = "Corrente";
        double saldo = 2500;
        int opcao = 0;

        System.out.println("****************************");
        System.out.println("\nDados iniciais do cliente:");
        System.out.println("\nnome:" + nome);
        System.out.println("Tipo da Conta:" + tipo);
        System.out.println("Saldo inicial:" + saldo);
        System.out.println("\n****************************");   
        
        String menu = """
                *** Operações ***

                1- Consultar saldo
                2- Receber pix
                3- Enviar pix
                4- sair
                
            ## Escolha uma opção ##

                """;
        // o menu deve aparecer enquanto a opcao for != 4
        while(opcao != 4) {
            System.out.println(menu);
            opcao = leitura.nextInt(); // ler a opcao

            if (opcao == 1) {
                System.out.println("O seu saldo atual é R$" + saldo);

            } else if (opcao == 2) {
                System.out.println("Informe o valor a receber:");
                double valorRecebido = leitura.nextDouble(); // leitura é quem ler
                saldo += valorRecebido; // atualiza saldo
                System.out.println("Saldo atualizado: R$" + saldo);

            } else if (opcao == 3) {
                System.out.println("Informe o valor do pix:");
                double valorPix = leitura.nextDouble();

                if (valorPix > saldo) {
                    System.out.println("Saldo insuficiente");
                } else {
                    saldo -= valorPix; // atualiza saldo
                    System.out.println("Saldo atualizado: R$" + saldo);
                }
            } else if (opcao == 4) {
                System.out.println("Voçê saiu da sua conta");
            } else {
                System.out.println("Opção invalida");
            }
        } // fim do loop
        leitura.close();
    }
 }   
