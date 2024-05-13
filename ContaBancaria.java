import java.util.Scanner;
import java.util.Random;

public class ContaBancaria {
    private static Scanner scanner = new Scanner(System.in);
    private static Random random = new Random();
    private static String nome;
    private static String agencia;
    private static double saldo;

    public static void main(String[] args) {
        saldo = 0;
        agencia = (random.nextInt(900) + 100) + " - " + (random.nextInt(10));
        int conta = random.nextInt(9000) + 1000;
        System.out.print("Digite seu nome: ");
        nome = scanner.next();

        System.out.print("Digite seu saldo: ");
        saldo = scanner.nextDouble();

        atualizar();

        String resp = "";
        while (!resp.equals("N")) {
            if (resp.equals("S")) {
                System.out.print("Qual valor deseja sacar? R$");
                double valorSaque = scanner.nextDouble();
                sacar(valorSaque);
            } else if (resp.equals("D")) {
                System.out.print("Qual valor deseja depositar? R$");
                double valorDeposito = scanner.nextDouble();
                depositar(valorDeposito);
            } else {
                System.out.println("Resposta inválida, tente de novo!");
            }
            System.out.print("=======================\nDigite 'S' para sacar, 'D' para depositar ou 'N' para sair: ");
            resp = scanner.next().toUpperCase();
        }

        System.out.println("===========================\nAté a próxima!");

        scanner.close();
    }

    public static void atualizar() {
        System.out.println("=======================");
        System.out.println("Nome: " + nome + " | " + "Agência: " + agencia);
        System.out.println("----------------------------");
        System.out.println("Seu saldo: R$" + saldo);
        System.out.println("=======================");
    }

    public static void sacar(double valor) {
        if (valor > saldo) {
            System.out.println("Saldo insuficiente!");
        } else {
            saldo -= valor;
            System.out.println("Saque de R$" + valor + " realizado com sucesso!");
            atualizar();
        }
    }

    public static void depositar(double valor) {
        saldo += valor;
        System.out.println("Depósito de R$" + valor + " realizado com sucesso!");
        atualizar();
    }
}
