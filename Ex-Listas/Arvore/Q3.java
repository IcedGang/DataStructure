package Arvore;

import Estruturas.Arvore;
import Estruturas.No;

public class Q3 {
    public static void main(String[] args) {
        
        Arvore<Integer> tree = new Arvore<>();
    
        tree.inserir(20);
        tree.inserir(5);
        tree.inserir(15);
        tree.inserir(30);
        tree.inserir(22);
        tree.inserir(32);
        tree.inserir(25);
        tree.inserir(2);
        tree.inserir(7);
        tree.inserir(1);
        tree.inserir(6);

        tree.emOrdem(tree.getRaiz());
        System.out.println();
        System.out.println("Altura da Arvore: " + heightTree(tree.getRaiz()));


    }
    
    public static int heightTree(No<Integer> node){
        if(node == null)
            return 0;
        else{
            int left = heightTree(node.getAnterior());
            int right = heightTree(node.getProximo());
            
            if(left > right)
                return left + 1;
            else
                return right + 1;

        }
            

    }
}
