package Pilha;

import java.util.Scanner;
import Estruturas.Pilha;

public class Q5 {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);

        Pilha<Character> stack1 = new Pilha<>(); // '()'
        Pilha<Character> stack2 = new Pilha<>(); // '[]'
        Pilha<Character> stack3 = new Pilha<>(); // '{}'

        System.out.println("Digite a Expressão: ");
        String str = scnr.nextLine();

        for(int i = 0; i < str.length(); i++){
            verify(stack1, str, '(', ')', i);
            verify(stack2, str, '[', ']', i);
            verify(stack3, str, '{', '}', i);
        }

        if(isEmpty(stack1, stack2, stack3))
            System.out.println("Expressão Válida!!");
        else
            System.out.println("Expressão Inválida!!");

    }

    public static boolean isEmpty(Pilha<Character> stack1, Pilha<Character> stack2, Pilha<Character> stack3){
        if(stack1.getTam() == 0 && stack2.getTam() == 0 && stack3.getTam() == 0)
            return true;
        
        return false;
    }

    public static void verify(Pilha<Character> stack, String str, Character open, Character close, int i){
        if(str.charAt(i) == open)
            stack.empilhar(str.charAt(i));
        if(str.charAt(i) == close)
            if(stack.getTam() == 0){
                System.out.println("Expressão Inválida!!");
                System.exit(i);
            }
            else    
                stack.desempilhar();

    } 
}
