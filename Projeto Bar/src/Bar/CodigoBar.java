/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bar;

import java.util.Scanner;

/**
 * @author Lais Cardoso
 */

public class CodigoBar {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        final double ingresso_homem = 10.0;
        final double ingresso_mulher = 8.0;
        final double Pcerveja = 5.0;
        final double Prefrigerante = 3.0;
        final double Pespetinho = 7.0;
        final double show = 4.0;
        final double isento_show = 30.0;

        System.out.println("\n SISTEMA CAIXA DE BAR \n");

        while (continuar) {
            System.out.println("PREENCHA AS INFORMACOES CONFORME A COMANDA \n");

            System.out.print("Informe o tipo do ingresso (M OU F): ");
            char ingresso = scanner.next().toUpperCase().charAt(0);

            System.out.print("\nQuantidade de Refrigerantes Consumidos: ");
            int refrigerante = scanner.nextInt();

            System.out.print("\nQuantidade de Cervejas Consumidas: ");
            int cerveja = scanner.nextInt();

            System.out.print("\nQuantidade de Espetinhos Consumidos: ");
            int espetinho = scanner.nextInt();

            double valorIngresso = (ingresso == 'M') ? ingresso_homem : ingresso_mulher;
            double valorConsumo = (cerveja * Pcerveja) + (refrigerante * Prefrigerante) + (espetinho * Pespetinho);
            double valorShow = (valorConsumo > isento_show) ? 0 : show;
            double valorTotal = valorConsumo + valorIngresso + valorShow;

            System.out.printf("\nRELATORIO DA COMANDA\n");
            System.out.printf("Soma dos Itens Consumidos: R$%.2f\n", valorConsumo);
            System.out.printf("Valor do Couvert: R$%.2f\n", valorShow);
            System.out.printf("Valor do Ingresso: R$%.2f\n", valorIngresso);
            System.out.printf("TOTAL A PAGAR: R$%.2f\n", valorTotal);

            System.out.print("\nDeseja realizar outra comanda? (S para sim / N para nao): ");
            String resposta = scanner.next();

            if (!resposta.equalsIgnoreCase("S")) {
                continuar = false;
            }
        }

        System.out.println("Sistema encerrado. Obrigado por utilizar nosso servico!");
        scanner.close();
    }
}
