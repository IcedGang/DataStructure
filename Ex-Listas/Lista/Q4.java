package Lista;

import java.util.Scanner;

import Estruturas.Fila;
import Estruturas.No;

public class Q4 {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        String resp;
        int n;
        
        CircSimpleList<String> list = new CircSimpleList<>();
        Fila<String> removidos = new Fila<>();

        System.out.print("Entre com n (> 3): ");
        n = scnr.nextInt();

        System.out.println("Nome dos soldados (Digite 0 para encerrar): ");
        resp = scnr.nextLine();

        while(true){
            if(resp.equals("0"))
                break;
            else
                list.Inserir(resp);

            resp = scnr.nextLine();
        }
        
        No<String> node = list.getInicio();
        while(list.getTam() >= 1){    
            for(int i = 1; i <= n; i++)
                node = node.getProximo();

            removidos.enfileirar(list.Remover(node.getInfo())); 
        }
        
        System.out.println("--------------------");
        System.out.println("Ordem de Saida: " + removidos.imprimeFila());
        System.out.println("Soldado Sorteado: " + list.printList());

        scnr.close();
    }
}
