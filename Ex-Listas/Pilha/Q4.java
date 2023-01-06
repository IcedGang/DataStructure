package Pilha;

import java.util.Random;

import Estruturas.No;
import Estruturas.Pilha;

public class Q4 {
    public static void main(String[] args) {
        
        String[] baralho = new String[]{"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K",
                                        "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K",
                                        "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K",
                                        "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"}; // 52 cartas

        Pilha<String> stack1 = new Pilha<>(); // 18 cartas
        Pilha<String> stack2 = new Pilha<>(); // 17 cartas
        Pilha<String> stack3 = new Pilha<>(); // 17 cartas
        
        Pilha<String> stack4 = new Pilha<>(); // 52 cartas

        System.out.println("Baralho Inicial: ");
        for(int i = 0; i < baralho.length; i++){
            System.out.print(baralho[i] + ", ");
            if((i + 1) % 13 == 0)
                System.out.println();
        }

        Enqueue(stack1, baralho, 18);
        Enqueue(stack2, baralho, 17);
        Enqueue(stack3, baralho, 17);

        Merge(stack1, stack2, stack3, stack4);
        printBaralho(stack4);

    }

    // Printa o baralho resultante após embaralhar
    public static void printBaralho(Pilha<String> stack4){
        No<String> node = stack4.getTopo();
        int count = 0;
        
        System.out.println("\nBaralho Final: ");
        while(node != null){
            System.out.print(node.getInfo() + ", ");
            count++;
                if(count % 13 == 0)
                    System.out.println();

            node = node.getProximo();
        }
        System.out.println();

    }

    // Embaralha nas 3 pilhas
    public static void Enqueue(Pilha<String> stack, String[] baralho, int tam){
        Random number = new Random();
        int x, i = 0;
        
        x = number.nextInt(52);
        while(i < tam){
            if(baralho[x] != "X"){
                stack.empilhar(baralho[x]);
                baralho[x] = "X";
                i++;
            }
            else
                x = number.nextInt(52);

        }

    }

    // Junta o conteudo da três pilhas em outra pilha
    public static void Merge(Pilha<String> stack1, Pilha<String> stack2, Pilha<String> stack3, Pilha<String> stack4){
        Random number = new Random();
        int x; 

        while(stack4.getTam() != 52){
            x = number.nextInt(3);

            switch (x) {
                case 0:
                    if(stack1.getTam() != 0)    
                        stack4.empilhar(stack1.desempilhar());
                    else
                        x = 1;

                    break;
                
                case 1:
                    if(stack2.getTam() != 0)    
                        stack4.empilhar(stack2.desempilhar());
                    else
                        x = 2;

                    break;

                case 2:
                    if(stack3.getTam() != 0)    
                        stack4.empilhar(stack3.desempilhar());
                    else
                        x = 0;

                    break;
                
                default:
                    System.out.println("Error!!");
                    break;
            
            
            }

        }

    }
}