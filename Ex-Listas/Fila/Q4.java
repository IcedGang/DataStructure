package Fila;

import java.util.Scanner;
import Estruturas.No;

// Utilizando fila os fatores saem em ordem crescente
import Estruturas.Fila;

// Utilizando Pilha os fatores saem em ordem decrescente
import Estruturas.Pilha;

public class Q4 {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        System.out.print("Digite um numero: ");
        int n = scnr.nextInt();

        Pilha<Integer> pilha = new Pilha<>();
        pilha = divisaoFatorial(n);

        System.out.println("\nFatores do numero: ");
        imprimeFatores(pilha);

        scnr.close();
    }

    // Imprime para Pilha
    public static void imprimeFatores(Pilha<Integer> stack){
        No<Integer> node = stack.getTopo();

        while(node != null){
            if(node.getProximo() != null)
                System.out.print(node.getInfo() + " * ");
            else
                System.out.print(node.getInfo());
            
            node = node.getProximo();
        }

        System.out.println();
    }

    // Retorna uma Pilha com os divisores do numero
    public static Pilha<Integer> divisaoFatorial(int n){
        Pilha<Integer> stack = new Pilha<>();

        // Divide sempre por 2
        while(n % 2 == 0){
            stack.empilhar(2);
            n /= 2;
        }

        // Divide por outros primos
        int div = 3;
        while((div * div) <= n){
            if(n % div == 0){
                stack.empilhar(div);
                n /= div;
            }
            else
                div += 2;

        }

        // Quando o n for primo
        if(n > 1)
            stack.empilhar(n);

        return stack;
    }
}
