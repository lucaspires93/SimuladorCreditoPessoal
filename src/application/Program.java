package application;

import entities.Cliente;
import entities.CreditoPessoal;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        char resp;


        System.out.println("==== SISTEMA DE SIMULAÇÃO DE CRÉDITO ====");
        System.out.println();

        do {
            System.out.print("Digite o nome do cliente: ");
            String nome = sc.nextLine();

            String cpf;
            while (true) {
                System.out.print("Digite o CPF: ");
                cpf = sc.nextLine();
                if (cpf != null && cpf.matches("\\d{11}")) break;
                System.out.println("CPF inválido. Digite novamente.");
            }
            System.out.print("Digite a idade: ");
            int idade = sc.nextInt();
            System.out.print("Digite o salário mensal: ");
            double salarioMensal = sc.nextDouble();
            System.out.print("Digite o score de crédito (0 a 1000): ");
            int scoreCredito = sc.nextInt();
            sc.nextLine();
            System.out.println();

            double limiteCreditoDisponivel = 0;
            Cliente c = new Cliente(nome,cpf, idade, salarioMensal,scoreCredito,limiteCreditoDisponivel);

            double limite = c.calcularLimiteCredito();
            c.setLimiteCreditoDisponivel(limite);


            System.out.printf("Limite de crédito disponível: R$ %.2f\n",c.getLimiteCreditoDisponivel());

            System.out.println();
            System.out.println("--- SIMULAÇÃO DE EMPRÉSTIMO ---");
            System.out.println();

            System.out.print("Digite o valor desejado para o empréstimo: ");
            double valorSolicitado = sc.nextDouble();
            System.out.print("Digite o número de parcelas: ");
            int numeroParcelas = sc.nextInt();
            System.out.print("Taxa de juros anual aplicada: ");
            int jurosAnual = sc.nextInt();
            CreditoPessoal cp = new CreditoPessoal(valorSolicitado,numeroParcelas,jurosAnual,c);
            sc.nextLine();

            System.out.println();
            System.out.println("[SIMULAÇÃO EM ANDAMENTO...]");

            double parcela = cp.calcularParcelas();
            System.out.printf("Valor da parcela: %.2f\n", parcela);

            double total = cp.totalPagar();
            System.out.printf("Total a pagar: %.2f\n", total);
            double juroTotal = cp.juroTotal();
            System.out.printf("Juros totais : %.2f\n", juroTotal);
            System.out.println();

            String apv = cp.aprovacao();
            System.out.println(apv);
            System.out.println();

            System.out.println("--- RESUMO DO CLIENTE ---");
            String info = c.exibirInfo();
            System.out.println(info);

            String resumo = cp.exibirResumo();
            System.out.println(resumo);


            System.out.print("Deseja simular outros cenários? (s/n): ");
            resp = sc.next().charAt(0);
            sc.nextLine();
            System.out.println();
        }
        while(resp == 's');





     sc.close();
    }
}