package desafiodiobanco;

public class ContaPoupança extends Conta {
    
    public ContaPoupança(Cliente cliente) {
        super(cliente);
    }
    
    public ContaPoupança() {        
    }
    
    @Override
    public void imprimirDadosContaCliente() {
        System.out.println("\n--- Extrato Conta Poupança ---");
        super.exibirDadosComuns();
    }
}
