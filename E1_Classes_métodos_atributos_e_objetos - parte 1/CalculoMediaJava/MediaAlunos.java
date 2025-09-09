package CalculoMedia;

import java.util.Scanner;

public class MediaAlunos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite P1: ");
        double P1 = sc.nextDouble();

        System.out.print("Digite E1: ");
        double E1 = sc.nextDouble();

        System.out.print("Digite E2: ");
        double E2 = sc.nextDouble();

        System.out.print("Digite X (Ponto Extra): ");
        double X = sc.nextDouble();

        System.out.print("Digite SUB: ");
        double SUB = sc.nextDouble();

        System.out.print("Digite API: ");
        double API = sc.nextDouble();

        double notaBase = P1*0.5 + E1*0.2 + E2*0.3 + X + SUB*0.15;

        double parte1 = notaBase * 0.5;

        double parte2;
        if (notaBase > 5.9) {
         
            parte2 = API * 0.5;
        } else {
            
            parte2 = 0;
        }

    
        double media = parte1 + parte2;

        System.out.println("A média calculada é: " + media);

        sc.close();
    }
}
