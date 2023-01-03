package Pilha;

import java.util.Scanner;
import Estruturas.Pilha;

public class Q6 {
    public static void main(String[] args) {
        int max = 10; // 10 lugares no estacionamento
        
        Scanner scnr = new Scanner(System.in);
        String resp;
        String placa;

        Pilha<String> stack = new Pilha<>();
        Pilha<String> aux = new Pilha<>();

        int n = 0;
        while(stack.getTam() <= max){
            System.out.println("\nDigite se o carro vai entrar 'E' ou sair 'S' (digite 0 para encerrar o programa): ");
            resp = scnr.nextLine();

            if(verify(resp) == 0){
                System.out.println("Encerrando programa....");
                System.out.println("\nEstacionamento: ");
                System.out.println(stack.imprimePilha());

                System.exit(0);
            }
            
            if(stack.getTam() == 0 && verify(resp) == 2){
                System.out.println("Estacionamento vazio!");
                continue;
            }

            if(verify(resp) == 1){
                if(stack.getTam() <= max){
                   System.out.println("\nDigite a placa do carro:");
                    placa = scnr.nextLine();

                    stack.empilhar(placa); 
                }
                else{
                    System.out.println("\nNão há vaga no estacionamento!");
                    continue;
                }

            }

            if(verify(resp) == 2 && stack.getTam() > 0){
                System.out.println("\nDigite a placa do carro:");
                placa = scnr.nextLine();

                while(stack.getTopo().getInfo().equals(placa) != true){
                    aux.empilhar(stack.desempilhar());
                    n++;
                }
              
                stack.desempilhar();
                System.out.println("\nO carro saiu do estacionamento após ser manobrado "  + n + " vezes!");

                while(n != 0){
                    stack.empilhar(aux.desempilhar());
                    n--;
                }

            }

        }

        scnr.close();
    }

    public static int verify(String str){
        if(str.toLowerCase().equals("e"))
            return 1;

        if(str.toLowerCase().equals("s"))
            return 2;

        return 0;
    }
}
