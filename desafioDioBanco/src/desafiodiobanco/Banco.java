package desafiodiobanco;

import java.util.Scanner;

public class Banco {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Cliente cliente1 = new Cliente(); 
        Cliente cliente2 = new Cliente(); 
        String nome, email;
        long cpf;
        int sacar, depositar, transferir, opcao;
        double valor;
        
        System.out.println("--- Cliente Conta Corrente ---");
        System.out.print("Nome: ");
        nome = scanner.next();
        System.out.print("Email: ");
        email = scanner.next();
        System.out.print("CFP: ");
        cpf = scanner.nextLong();
        cliente1.setNome(nome);
        cliente1.setEmail(email);
        cliente1.setCpf(cpf);
        Conta corrente = new ContaCorrente(cliente1);
        
        System.out.println("--- Cliente Conta Poupança ---");
        System.out.print("Nome: ");
        nome = scanner.next();
        System.out.print("Email: ");
        email = scanner.next();
        System.out.print("CFP: ");
        cpf = scanner.nextLong();
        cliente2.setNome(nome);
        cliente2.setEmail(email);
        cliente2.setCpf(cpf);
        Conta poupanca = new ContaPoupança(cliente2);
        
        do {
            opcao = 0;
            
            System.out.print("[1] Sacar [2] Depositar [3] Transferir [4] Consultar Saldo [5] Consultar Contas [6] Sair: ");
            opcao = scanner.nextInt();
            
            switch(opcao) {
                case 1:
                    System.out.print("[1] Sacar para conta corrente [2] Sacar para conta poupança: ");
                    sacar = scanner.nextInt();

                    switch (sacar) {
                        case 1:
                            System.out.println("Saldo disponível: R$" + corrente.saldo);
                            System.out.print("Informe o valor do saque: ");
                            valor = scanner.nextDouble();

                            if (valor < corrente.getSaldo()) {
                                corrente.sacar(valor);
                            } else {
                                System.out.println("Saldo insuficiente!");
                            }
                            break;
                        case 2:
                            System.out.println("Saldo disponível: R$" + poupanca.saldo);
                            System.out.print("Informe o valor do saque: ");
                            valor = scanner.nextDouble();

                            if (valor < poupanca.getSaldo()) {
                                poupanca.sacar(valor);
                            } else {
                                System.out.println("Saldo insuficiente!");
                            }
                            break;
                        default:
                            System.out.println("Não foi possível realizar o saque");
                            break;
                    }
                    break;
                case 2:
                    System.out.print("[1] Depositar para conta corrente [2] Depositar para conta poupança: ");
                    depositar = scanner.nextInt();
                    
                    switch (depositar) {
                        case 1:
                            System.out.print("Informe o valor do depósito: ");
                            valor = scanner.nextDouble();
                            corrente.depositar(valor);
                            System.out.println("Saldo atual: R$" + corrente.saldo);
                            break;
                        case 2:
                            System.out.print("Informe o valor do depósito: ");
                            valor = scanner.nextDouble();
                            poupanca.depositar(valor);
                            System.out.println("Saldo atual: R$" + poupanca.saldo);
                            break;
                        default:
                            System.out.println("Não foi possível realizar o depósito!");
                            break;
                    }
                    break;
                case 3:
                    System.out.print("[1] Transferir para conta poupança [2] Transferir para conta corrente: ");
                    transferir = scanner.nextInt();
                    
                    switch (transferir) {
                        case 1:
                            System.out.println("Saldo disponível: R$" + corrente.saldo);
                            System.out.print("Informe o valor do transferência: ");
                            valor = scanner.nextDouble();
                            corrente.transferir(poupanca, valor);
                            break;
                        case 2:
                            System.out.println("Saldo disponível: R$" + poupanca.saldo);
                            System.out.print("Informe o valor do transferência: ");
                            valor = scanner.nextDouble();
                            poupanca.transferir(corrente, valor);
                        default:
                            System.out.println("Não foi possível realizar a transferência!");
                            break;
                    }
                    break;
                case 4:
                    System.out.println("[1] Saldo Conta Corrente [2] Saldo Conta Poupança: ");
                    int obterSaldo = scanner.nextInt();
                    
                    switch (obterSaldo) {
                        case 1:
                            System.out.println("Saldo disponível: " + corrente.saldo);
                            break;
                        case 2:
                            System.out.println("Saldo disponível: " + poupanca.saldo);
                            break;
                        default:
                            System.out.println("Opcao inválida!");
                            break;
                    }
                    break;
                case 5:                    
                    corrente.imprimirDadosContaCliente();
                    poupanca.imprimirDadosContaCliente();
                    break;
                case 6:
                    break;
                default:
                    System.out.println("Opcão inválida!");
                    break;
            }
        } while (opcao != 6);
    }
}