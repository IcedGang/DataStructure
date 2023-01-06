package Lista;

import Estruturas.No;

public class CircSimpleList<Type>{

    private No<Type> inicio;
    private No<Type> fim;
    private int tam;
    
    public CircSimpleList() {
        this.inicio = null;
        this.fim = null;
        this.tam = 0;
    }

    public No<Type> getInicio() {
        return inicio;
    }
    
    public No<Type> getFim() {
        return fim;
    }

    public int getTam() {
        return tam;
    }

    private boolean isEmpty(){
        if(this.tam == 0)
            return true;
        
        return false;
    }
    
    // Inserir
    public void Inserir(Type info){
        No<Type> aux = new No<>();
        aux.setInfo(info);

        if(isEmpty()){
            this.inicio = aux;
            this.fim = aux;
            
            this.fim.setProximo(aux);
        }
        else{
            this.fim.setProximo(aux);
            this.fim = aux;

            aux.setProximo(this.inicio);
        }

        this.tam++;
    }
    
    // Remover
    public Type Remover(Type info){
        No<Type> aux = new No<>();
        No<Type> node = new No<>();
        
        if(isEmpty()){
            System.out.println("Lista Vazia!Impossível remover!");
            System.exit(0);
        }
        else{
            if(this.inicio == this.fim && this.getInicio().getInfo() == info){
                node = this.inicio;
                this.inicio = null;
                this.fim =null;
            }
            else if(this.inicio.getInfo() == info){
                node = this.inicio;
                this.inicio = node.getProximo();
                this.fim.setProximo(this.inicio);
            }
            else{
                aux = this.inicio;
                while(aux.getProximo() != this.inicio && aux.getProximo().getInfo() != info)
                    aux = aux.getProximo();
                
                if(aux.getProximo().getInfo() == info){
                    if(this.fim == aux.getProximo()){
                        node = aux.getProximo();
                        aux.setProximo(node.getProximo());
                        this.fim = aux;
                    }
                    else{
                        node = aux.getProximo();
                        aux.setProximo(node.getProximo());
                    }
                }

            }

        }

        this.tam--;
        return node.getInfo();
    }

    public String printList(){
        No<Type> node = this.inicio;
        String str = "[" + node.getInfo() + ", ";
        
        do{
            node = node.getProximo();
            if(node != this.fim)
                str += node.getInfo() + ", ";
            else
                str += node.getInfo() + "]";

        }while(node != this.fim);

        return str;
    }

}