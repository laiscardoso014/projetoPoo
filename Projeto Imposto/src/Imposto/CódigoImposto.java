package Imposto;

import java.util.Scanner;

public class CódigoImposto {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean desejaContinuar = true;

        while (desejaContinuar) {
            double salario;
            double capital = 0;
            double medico = 0;
            double educacao = 0;
            double servicos = 0;
            int opcao;
            boolean continuar = true;

            System.out.print("SISTEMA PARA CALCULAR IMPOSTO DE RENDA \n\n");
            System.out.print("Digite a soma anual do seu salario: ");
            salario = scanner.nextDouble();

            while (continuar) {
                System.out.print("\nMENU DE OPCOES\n");
                System.out.print("Digite 1 - Renda com prestacoes de serviços \n");
                System.out.print("Digite 2 - Renda com ganho de capital \n");
                System.out.print("Digite 3 - Gastos Medicos \n");
                System.out.print("Digite 4 - Gastos Educacionais \n");
                System.out.print("Digite 5 - Calcular Imposto e Sair\n\n");
                opcao = scanner.nextInt();

                switch (opcao) {

                    case 1:
                        System.out.print("\nDigite a renda anual com prestacao de servicos: ");
                        servicos = scanner.nextDouble();
                        break;

                    case 2:
                        System.out.print("\nDigite a renda anual com o ganho de capital: ");
                        capital = scanner.nextDouble();
                        break;

                    case 3:
                        System.out.print("\nDigite o valor dos seus gastos medicos: ");
                        medico = scanner.nextDouble();
                        break;

                    case 4:
                        System.out.print("\nDigite o valor dos seus gastos educacionais: ");
                        educacao = scanner.nextDouble();
                        break;

                    case 5:
                        System.out.print("\n Realizando Calculo de Impostos...\n");
                        continuar = false;

                        double salarioMensal = salario / 12;
                        double impostoSalario = 0;

                        if (salarioMensal < 3000) {
                            impostoSalario = 0;
                        } else if (salarioMensal < 5000) {
                            impostoSalario = salario * 0.10;
                        } else {
                            impostoSalario = salario * 0.20;
                        }

                        double impostoServico = servicos * 0.15;
                        double impostoCapital = capital * 0.20;
                        double impostoTotal = impostoSalario + impostoServico + impostoCapital;

                        double Total = impostoTotal;

                        double maximoDedutivel = Total * 0.30;
                        double gastosDedutivel = medico + educacao;

                        double abatimento = Math.min(maximoDedutivel, gastosDedutivel);

                        double impostoDevido = Total - abatimento;

                        System.out.println("\n RELATORIO DE IMPOSTO DE RENDA \n");
                        System.out.println("\n* CONSOLIDADO DE RENDA:\n");
                        System.out.printf("Imposto sobre salario: %.2f\n", impostoSalario);
                        System.out.printf("Imposto sobre servicos: %.2f\n", impostoServico);
                        System.out.printf("Imposto sobre ganho de capital: %.2f\n", impostoCapital);

                        System.out.println("\n* DEDUCOES:\n");
                        System.out.printf("Maximo dedutivel: %.2f\n", maximoDedutivel);
                        System.out.printf("Gastos dedutiveis: %.2f\n", gastosDedutivel);

                        System.out.println("\n* RESUMO: \n");
                        System.out.printf("Imposto bruto total: %.2f\n", Total);
                        System.out.printf("Abatimento: %.2f\n", abatimento);
                        System.out.printf("Imposto devido: %.2f\n", impostoDevido);

                        break;

                    default:
                        System.out.print("Opcao Invalida! Tente Novamente.\n");
                        break;
                }
            }

            System.out.print("\nDeseja realizar outro calculo de imposto? (S para Sim / N para Nao): ");
            String resposta = scanner.next();

            if (!resposta.equalsIgnoreCase("S")) {
                desejaContinuar = false;
            }
        }

        System.out.println("Obrigado por usar o sistema de calculo de imposto!");
        scanner.close();
    }
}
