public class Conta {
    // Atributos (O estado da conta)
    String nome;
    String tipoConta;
    double saldo;

    // Construtor: Como a conta "nasce"
    public Conta(String nomeInicial, String tipoInicial, double saldoInicial) {
        this.nome = nomeInicial;
        this.tipoConta = tipoInicial;
        this.saldo = saldoInicial;
    }

    // Método: Depositar
    public void receberValor(double valor) {
        this.saldo += valor;
    }

    // Método: Sacar/Transferir
    // verifica se tem saldo antes de tirar
    // Retorna true se deu certo, false se deu errado
    public boolean transferirValor(double valor) {
        if (valor > this.saldo) {
            return false; // Operação negada
        } else {
            this.saldo -= valor;
            return true; // Operação aprovada
        }
    }

    // Método para apenas mostrar os dados formatados
    public String getResumo() {
        return """
               ***********************
               Titular: %s
               Tipo: %s
               Saldo: R$ %.2f
               ***********************
               """.formatted(this.nome, this.tipoConta, this.saldo);
    }
}