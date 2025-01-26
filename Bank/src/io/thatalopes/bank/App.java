package io.thatalopes.bank;

import java.util.Scanner;
import java.util.List;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Bank santander = new Bank("001");
        // C = Criar conta
        // E = Sair (exit)
        while(true) {
            System.out.println("O que deseja fazer? C = Criar conta, E = Sair");
            String op = scanner.nextLine();

            if (op.equals("C")) {
                System.out.println("Digite o seu nome:");
                String name = scanner.nextLine();
                Account account = santander.generateAccount(name);
                santander.insertAccount(account);
                operateAccount(account);
            } else if (op.equals("E")) {
                break;
            } else {
                System.out.println("Comando inválido, tente novamente.");
            }
        }

        List<Account> accountList = santander.getAccounts();
        for(Account cc: accountList) {
            System.out.println(cc);
        }
        santander.outputTotal();
    }


    static void operateAccount(Account account) {
        Scanner scanner = new Scanner(System.in);
        // D - Depoisito
        // S - Saque
        // E - Sair (exit)
        while(true) {
            System.out.println("O que deseja fazer? D = Deposito, S = Saque, E = Sair da conta");
            String op = scanner.nextLine();

            if (op.equals("D")) {
                System.out.println("Qual valor deseja depositar?");
                double value = scanner.nextDouble();
                account.deposit(value);
            } else if (op.equals("S")) {
                System.out.println("Qual valor deseja sacar?");
                double value = scanner.nextDouble();
                if (!account.withDraw(value)) {
                    System.out.println("Não foi possível sacar o valor R$" + value);
                }
            } else if (op.equals("E")) {
                break;
            } else {
                System.out.println("Comando inválido, tente novamente.");
            }

            scanner = new Scanner(System.in);
        }
    }
}
