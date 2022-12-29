package Estruturas;

import java.io.Serializable;

// Pilha de tipo genérico
public class Pilha<Type> implements Serializable{
    
    private Lista<Type> pilha; // Usando lista para representar uma pilha
    private No<Type> topo; // O topo da pilha

    // Inicializa a pilha
    public Pilha(){
        this.pilha = new Lista<>();
        this.topo = null;
    }

    // Insere elementos na pilha
    public void empilhar(Type info){
        No<Type> x = new No<>(info);

        pilha.inserirInicio(x);
        this.topo = pilha.getInicio();
    }

    // Remove elementos da pilha
    public Type desempilhar(){
        No<Type> node = new No<>();
        node = pilha.removerInicio();
        this.topo = topo.getProximo();

        return node.getInfo();
    }

    // Imprime a pilha interia
    public String imprimePilha(){
        return pilha.imprimeLista();
    }
    
    // Retorna o topo da pilha
    public No<Type> getTopo() {
        return topo;
    }

    // Retorna o tam da pilha
    public int getTam(){
        return pilha.getTam();
    }

    // Mostra o topo e o tamanho da pilha
    @Override
    public String toString() {
        String str = "Pilha: " + getTopo();
        str += "Tam: " + pilha.getTam();

        return str;
    }

}
