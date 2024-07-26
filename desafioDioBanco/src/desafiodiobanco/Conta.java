package desafiodiobanco;

public class Conta implements IConta {

    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;

    protected int agencia;
    protected int id;
    protected double saldo = 0.0;
    protected Cliente cliente;

    public Conta() {
    }

    public Conta(Cliente cliente) {
        this.agencia = Conta.AGENCIA_PADRAO;
        this.id = SEQUENCIAL++;
        this.cliente = cliente;
    }

    public int getAgencia() {
        return agencia;
    }

    public int getId() {
        return id;
    }

    public double getSaldo() {
        return saldo;
    }

    public Cliente getCliente() {
        return cliente;
    }
    
    protected void exibirDadosComuns() {
        System.out.println(String.format("Titular: %s", cliente.getNome()));
        System.out.println(String.format("Agência: %d", agencia));
        System.out.println(String.format("ID: %d", id));
        System.out.println(String.format("Saldo: %.2f", saldo));
        imprimirDadosContaCliente();
    }
    
    @Override
    public String toString() {
        return agencia + " - " + id + " - " + saldo;
    }
        
    @Override
    public void imprimirDadosContaCliente() {
    }
    
    @Override
    public void sacar(double valor) {
        saldo -= valor;
    }

    @Override
    public void depositar(double valor) {
        saldo += valor;
    }

    @Override
    public void transferir(Conta contaDestino, double valor) {
        sacar(valor);
        contaDestino.depositar(valor);
    }
}
