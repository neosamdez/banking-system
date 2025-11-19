import java.util.Scanner;

public class SistemaBancario {
    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);

        // 1. Instanciação: Criando o objeto conta baseado na classe Conta
        Conta minhaConta = new Conta("Neo", "Corrente", 2500.00);

        int opcao = 0;

        // Mostra os dados iniciais usando o método da própria conta
        System.out.println(minhaConta.getResumo());

        while (opcao != 4) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Consultar Saldo");
            System.out.println("2. Receber Valor");
            System.out.println("3. Transferir Valor");
            System.out.println("4. Sair");
            System.out.print("Opção: ");
            
            opcao = leitura.nextInt();

            if (opcao == 1) {
                // O Main pergunta para o objeto quanto ele tem
                System.out.println("Seu saldo atual é: " + minhaConta.saldo);
            
            } else if (opcao == 2) {
                System.out.print("Valor a receber: ");
                double valor = leitura.nextDouble();
                
                // O Main MANDA a conta receber. O Main não faz a conta de '+'
                minhaConta.receberValor(valor);
                System.out.println("Saldo atualizado: " + minhaConta.saldo);
            
            } else if (opcao == 3) {
                System.out.print("Valor a transferir: ");
                double valor = leitura.nextDouble();

                // O Main pede para transferir e verifica a resposta (true/false)
                boolean sucesso = minhaConta.transferirValor(valor);

                if (sucesso) {
                    System.out.println("Transferência realizada!");
                    System.out.println("Saldo atual: " + minhaConta.saldo);
                } else {
                    System.out.println("ERRO: Saldo insuficiente.");
                }
            
            } else if (opcao == 4) {
                System.out.println("Saindo...");
            } else {
                System.out.println("Opção inválida.");
            }
        }
        
        leitura.close();
    }
}