package desafiodiobanco;

public class ContaCorrente extends Conta {
    
    public ContaCorrente(Cliente cliente) {
        super(cliente);
    }
    
    public ContaCorrente() {        
    }
    
    @Override
    public void imprimirDadosContaCliente() {
        System.out.println("\n--- Extrato Conta Corrente ---");
        super.exibirDadosComuns();
    }
}
