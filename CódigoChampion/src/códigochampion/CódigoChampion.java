/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
        
package códigochampion;

import java.util.Scanner;

/**
 *
 * @author Lais Cardoso
 */
import java.util.Scanner;

class Champion {
    private String nome;
    private int vida;
    private int ataque;
    private int arma;

    public Champion(String nome, int vida, int ataque, int arma) {
        this.nome = nome;
        this.vida = vida;
        this.ataque = ataque;
        this.arma = arma;
    }

    public void takeDamage(Champion dois) {
        int dano = Math.max(dois.ataque - this.arma, 1); 
        this.vida = Math.max(this.vida - dano, 0);
    }

    public String status() {
        if (this.vida > 0) {
            return this.nome + ": " + this.vida + " de vida";
        } else {
            return this.nome+ ": morreu";
        }
    }

    public boolean isAlive() {
        return this.vida > 0;
    }
}

public class CódigoChampion {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("\nDigite os dados do primeiro campeao:");
        System.out.print("\nNome: ");
        String nome1 = sc.nextLine();
        
        System.out.print("\nVida inicial: ");
        int vida1 = sc.nextInt();
        
        System.out.print("\nAtaque: ");
        int ataque1 = sc.nextInt();
        
        System.out.print("\nArmadura: ");
        int arma1 = sc.nextInt();
        sc.nextLine();
        
        Champion champion1 = new Champion(nome1, vida1, ataque1, arma1);

        System.out.println("\nDigite os dados do segundo campeao:");
        System.out.print("\nNome: ");
        String nome2 = sc.nextLine();
        
        System.out.print("\nVida inicial: ");
        int vida2 = sc.nextInt();
        
        System.out.print("\nAtaque: ");
        int ataque2 = sc.nextInt();
        
        System.out.print("\nArmadura: ");
        int arma2 = sc.nextInt();
        
        Champion champion2 = new Champion( nome2, vida2, ataque2, arma2);

        System.out.print("\nQuantos turnos você deseja executar? \n");
        int turnos = sc.nextInt();

        for (int turno = 1; turno <= turnos; turno++) {
            System.out.println("Resultado do turno " + turno + ":");

            champion1.takeDamage(champion2);
            champion2.takeDamage(champion1);
            
            System.out.println(champion1.status());
            System.out.println(champion2.status());

            if (!champion1.isAlive() || !champion2.isAlive()) {
                break;
            }
        }

        System.out.println("\n### FIM DO COMBATE ###");
        sc.close();
    }
}   
    

