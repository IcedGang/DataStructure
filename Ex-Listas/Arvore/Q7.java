package Arvore;

public class Q7 {
    public static void main(String[] args) {
        int[] vet = {10, 45, 23, 12, 5, 34};    
        
        System.out.print("Vetor: ");
        for (int i = 0; i < vet.length; i++) {
            System.out.print(vet[i] + " ");
        }

        System.out.print("\n\nMaxHeap: ");
        Heapify(vet, vet.length, 2);
        for (int i = 0; i < vet.length; i++) {
            System.out.print(vet[i] + " ");
        }

        System.out.print("\nMinHeap: ");
        Heapify(vet, vet.length, 1);
        for (int i = 0; i < vet.length; i++) {
            System.out.print(vet[i] + " ");
        }

    }


    public static void Heapify(int[] vet, int tam, int type){
        if(type == 1)
            MinHeap(vet, tam, 0);
        else if(type == 2)
            MaxHeap(vet, tam, 0);
        else
            System.out.println("Erro ao 'Heapficar' o vetor");
    }

    public static void MaxHeap(int[] vet, int tam, int index){
        int aux = index;
        
        int left = (2 * index) + 1;
        int right = (2 * index) + 2;

        if(left < tam && vet[left] > vet[aux])
            aux = left;

        if(right < tam && vet[right] > vet[aux])
            aux = right;

        if(aux != index){
            swap(vet, index, aux);
            MaxHeap(vet, tam, aux);
        }

    }   

    public static void MinHeap(int[] vet, int tam, int index){
        int aux = index;
        
        int left = (2 * index) + 1;
        int right = (2 * index) + 2;

        if(left < tam && vet[left] < vet[aux])
            aux = left;

        if(right < tam && vet[right] < vet[aux])
            aux = right;

        if(aux != index){
            swap(vet, index, aux);
            MinHeap(vet, tam, aux);
        }
    }

    public static int[] swap(int[] vet, int i, int j){
        int aux = vet[i];

        vet[i] = vet[j];
        vet[j] = aux;
        return vet;
    }

}
