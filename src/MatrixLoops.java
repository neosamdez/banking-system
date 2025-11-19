import java.util.Scanner;

public class MatrixLoops {
    public static void main(String[] args) throws InterruptedException { // throws... é só para o atraso funcionar
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- INICIANDO TREINAMENTO DO NEO ---");
        System.out.println();

        // ============================================================
        // 1. O LOOP 'FOR' (O Contador Determinado)
        // Use quando você SABE quantas vezes quer repetir.
        // ============================================================
        System.out.println(">>> EXERCÍCIO 1: Download de Habilidades (FOR Loop)");
        System.out.println("Baixando 5 módulos de Kung Fu...");

        // Estrutura: (onde começa; até onde vai; de quanto em quanto pula)
        for (int i = 1; i <= 5; i++) {
            System.out.println("Carregando módulo " + i + " de 5... [OK]");
            
            // Um pequeno atraso só para dar emoção (500 milissegundos)
            Thread.sleep(500); 
        }

        System.out.println("Download Completo. Eu sei Kung Fu.");
        System.out.println("-------------------------------------------------");

        // ============================================================
        // 2. O LOOP 'WHILE' (O Sentinela)
        // Use quando você NÃO SABE quando vai parar (depende do usuário).
        // ============================================================
        System.out.println(">>> EXERCÍCIO 2: Hackeando a Senha (WHILE Loop)");
        
        String senhaCorreta = "zion";
        String tentativa = "";
        int erros = 0;

        // Tradução: "Enquanto a tentativa NÃO FOR IGUAL à senhaCorreta..."
        // O '!' significa NÃO (negação).
        while (!tentativa.equals(senhaCorreta)) {
            
            System.out.print("Digite a senha de acesso a Zion: ");
            tentativa = scanner.nextLine(); // O loop para aqui esperando você digitar

            if (!tentativa.equals(senhaCorreta)) {
                System.out.println("⛔ Acesso Negado. Tente novamente.");
                erros++; // Conta os erros (erros = erros + 1)
            }
        }

        System.out.println("🔓 Acesso Permitido! Bem-vindo, Neo.");
        System.out.println("Você errou " + erros + " vezes antes de acertar.");
        
        scanner.close();
    }
}