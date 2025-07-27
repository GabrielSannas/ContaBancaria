import java.util.Scanner;

public class App {
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



