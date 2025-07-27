import java.util.Scanner;

public class ContaBancaria {
    private double saldo;
    private double chequeEspecial;
    private double limiteChequeEspecial;

    public ContaBancaria(double saldoInicial, double limiteChequeEspecial) {
        this.saldo = saldoInicial;
        this.limiteChequeEspecial = limiteChequeEspecial;
        this.chequeEspecial = limiteChequeEspecial;
    }

    public void consultarSaldo() {
        System.out.printf("Saldo atual: R$ %.2f%n", saldo);
    }

    public void consultarChequeEspecial() {
        System.out.printf("Limite do cheque especial: R$ %.2f%n", limiteChequeEspecial);
        System.out.printf("Cheque especial disponível: R$ %.2f%n", chequeEspecial);
    }

    public void depositar(double valor) {
        saldo += valor;
        System.out.printf("Depósito de R$ %.2f realizado.%n", valor);
        consultarSaldo();
    }

    public void sacar(double valor) {
        if (valor <= saldo) {
            saldo -= valor;
            System.out.printf("Saque de R$ %.2f realizado.%n", valor);
        } else if (valor <= saldo + chequeEspecial) {
            double restante = valor - saldo;
            saldo = 0;
            chequeEspecial -= restante;
            System.out.printf("Saque de R$ %.2f realizado usando cheque especial.%n", valor);
        } else {
            System.out.println("Saldo insuficiente.");
            return;
        }
        consultarSaldo();
        verificarUsoChequeEspecial();
    }

    public void pagarBoleto(double valor) {
        System.out.printf("Pagamento de boleto no valor de R$ %.2f.%n", valor);
        sacar(valor);
    }

    public void verificarUsoChequeEspecial() {
        if (saldo < 0 || chequeEspecial < limiteChequeEspecial) {
            System.out.println("A conta está usando o cheque especial.");
        } else {
            System.out.println("A conta não está usando o cheque especial.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ContaBancaria conta = new ContaBancaria(1000.0, 500.0);

        while (true) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1 - Consultar saldo");
            System.out.println("2 - Consultar cheque especial");
            System.out.println("3 - Depositar dinheiro");
            System.out.println("4 - Sacar dinheiro");
            System.out.println("5 - Pagar um boleto");
            System.out.println("6 - Verificar se está usando cheque especial");
            System.out.println("0 - Sair");
            int opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    conta.consultarSaldo();
                    break;
                case 2:
                    conta.consultarChequeEspecial();
                    break;
                case 3:
                    System.out.print("Valor para depositar: ");
                    double valorDeposito = sc.nextDouble();
                    conta.depositar(valorDeposito);
                    break;
                case 4:
                    System.out.print("Valor para sacar: ");
                    double valorSaque = sc.nextDouble();
                    conta.sacar(valorSaque);
                    break;
                case 5:
                    System.out.print("Valor do boleto: ");
                    double valorBoleto = sc.nextDouble();
                    conta.pagarBoleto(valorBoleto);
                    break;
                case 6:
                    conta.verificarUsoChequeEspecial();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    sc.close();
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}