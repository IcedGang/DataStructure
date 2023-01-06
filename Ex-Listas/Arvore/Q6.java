package Arvore;

import Estruturas.Arvore;
import Estruturas.No;

public class Q6 {

    // Para ser um heap precisa ser uma arvore completa ou quase-completa
    // da esquerda para direita. 
    
    // Se os valores dos Filhos são menores ou iguais ao do Pai: MaxHeap.
    // Se os valores dos Filhos sáo maiores ou iguais ao do Pai: MinHeap.

    public static void main(String[] args) {
        Arvore<Integer> tree = new Arvore<>();
        
        if(isHeap(tree, tree.getRaiz()) == 0)
            System.out.println("Não é heap");
        else if(isHeap(tree, tree.getRaiz()) == 1)
            System.out.println("MaxHeap");
        else if(isHeap(tree, tree.getRaiz()) == -1)
            System.out.println("MinHeap");

    }

    // Retorna true se for completo
    public static boolean isComp(No<Integer> node, int index, int numberNodes){
        if(node == null)
            return true;
        
        if(index > numberNodes)
            return false;
        
        return isComp(node.getAnterior(), (2 * index) + 1, numberNodes) && 
               isComp(node.getProximo(), (2 * index) + 2, numberNodes);

    }

    // Retorna true se for MaxHeap
    public static boolean isMax(No<Integer> node){
        if(node.getAnterior() == null && node.getProximo() == null)
            return true;
        
        if(node.getProximo() == null)
            return node.getInfo().compareTo(node.getAnterior().getInfo()) == 1; // Retorna true se for maior
        else{
            if(node.getInfo().compareTo(node.getAnterior().getInfo()) == 1 && node.getInfo().compareTo(node.getProximo().getInfo()) == 1)
                return isMax(node.getAnterior()) && isMax(node.getProximo());
            else
                return false;
        }

    }

    // Retorna true se for MinHeap
    public static boolean isMin(No<Integer> node){
        if(node.getAnterior() == null && node.getProximo() == null)
            return true;
        
        if(node.getProximo() == null)
            return node.getInfo().compareTo(node.getAnterior().getInfo()) == -1; // Retorna true se for menor
        else{
            if(node.getInfo().compareTo(node.getAnterior().getInfo()) == -1 && node.getInfo().compareTo(node.getProximo().getInfo()) == -1)
                return isMin(node.getAnterior()) && isMin(node.getProximo());
            else
                return false;
        }

    }

    // Retorna 0 se n for heap, -1 se for MinHeap e 1 se for MaxHeap
    public static int isHeap(Arvore<Integer> Heap, No<Integer> node){
        int sizeHeap = Heap.getTam();
        if(node == null)
            return 1; // Retorna como MaxHeap

        if(isComp(node, 0, sizeHeap) && isMax(node))
            return 1;
        else if(isComp(node, 0, sizeHeap) && isMin(node))
            return -1;
        else
            return 0;
    
    }   
}
