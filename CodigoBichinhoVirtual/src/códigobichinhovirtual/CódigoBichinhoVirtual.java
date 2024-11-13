/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package códigobichinhovirtual;

import java.util.Scanner;

/**
 *
 * @author Lais Cardoso
 */

class Animal {
    private String nome;
    private String classe;
    private String familia;
    private int idade;
    private boolean vivo;
    private int caloria;
    private int forca;

    public Animal(String nome, String classe, String familia) {
        this.nome = nome;
        this.classe = classe;
        this.familia = familia;
        this.idade = 0;
        this.vivo = true;
        this.caloria = 10;
        this.forca = 10;
    }

    public void comer() {
        if (!vivo) {
            System.out.println("O animal esta morto e nao pode comer.\n");
            return;
        }
        if (caloria >= 100) {
            System.out.println("O animal esta cheio e nao pode comer mais.\n");
        } else {
            caloria += 10;
            forca -= 2;
            System.out.println("O animal comeu. Força: " + forca + ", Caloria: " + caloria + "\n");
        }
    }

    public void correr() {
        if (!vivo) {
            System.out.println("O animal esta morto e nao pode correr.\n");
            return;
        }
        if (caloria == 0) {
            System.out.println("O animal esta exausto e nao pode correr.\n");
        } else {
            forca -= 5;
            caloria -= 5;
            System.out.println("O animal correu. Força: " + forca + ", Caloria: " + caloria + "\n");
        }
    }

    public void dormir() {
        if (!vivo) {
            System.out.println("O animal esta morto e nao pode dormir.\n");
            return;
        }
        forca += 10;
        caloria -= 2;
        System.out.println("O animal dormiu. Força: " + forca + ", Caloria: " + caloria + "\n");
    }

    public void morrer() {
        vivo = false;
        forca = 0;
        System.out.println("O animal morreu.\n");
    }

    public boolean estaVivo() {
        return vivo;
    }

    public void exibirStatus() {
        System.out.println("Animal: " + nome + ", Classe: " + classe + ", Familia: " + familia + "\n");
        System.out.println("Forca: " + forca + ", Caloria: " + caloria + ", Idade: " + idade + ", Vivo: " + vivo + "\n");
    }
}

public class CódigoBichinhoVirtual {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            System.out.println("Deseja criar um novo bichinho virtual ou sair?");
            System.out.println("1 - Criar um novo bichinho");
            System.out.println("2 - Sair");
            System.out.print("Escolha uma opcao: ");
            int escolha = scanner.nextInt();
            scanner.nextLine();

            if (escolha == 1) {
                System.out.println("\nCrie seu novo animal");
                System.out.print("Insira o nome: ");
                String nome = scanner.nextLine();
                System.out.print("\nInsira a classe: ");
                String classe = scanner.nextLine();
                System.out.print("\nInsira a família: ");
                String familia = scanner.nextLine();

                Animal animal = new Animal(nome, classe, familia);
                System.out.println("O animal " + nome + " nasceu!\n");

                while (animal.estaVivo()) {
                    animal.exibirStatus();
                    System.out.println("O que o " + nome + " vai fazer agora? \n");
                    System.out.println("1 - Comer");
                    System.out.println("2 - Correr");
                    System.out.println("3 - Dormir");
                    System.out.println("4 - Morrer");
                    System.out.print("Escolha uma opcao: ");

                    int opcao = scanner.nextInt();
                    switch (opcao) {
                        case 1:
                            animal.comer();
                            break;
                        case 2:
                            animal.correr();
                            break;
                        case 3:
                            animal.dormir();
                            break;
                        case 4:
                            animal.morrer();
                            break;
                        default:
                            System.out.println("Opção inválida.");
                            break;
                    }
                }

                System.out.println("O programa terminou para o animal " + nome + ". Ele não está mais vivo. \n");
            } else if (escolha == 2) {
                continuar = false;
                System.out.println("Saindo do programa.\n");
            } else {
                System.out.println("Opção inválida. Tente novamente. \n");
            }
        }

        scanner.close();
    }
}