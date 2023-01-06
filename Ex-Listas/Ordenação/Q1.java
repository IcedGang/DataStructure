package Ordenação;

public class Q1 {
    public static void main(String[] args) {
        Pessoa p1 = new Pessoa(10, "Vítor", 8.5f);
        Pessoa p2 = new Pessoa(35, "Yago", 7.6f);
        Pessoa p3 = new Pessoa(15, "Rafael ", 9.2f);
        Pessoa p4 = new Pessoa(21, "Antônio", 8f);
        Pessoa p5 = new Pessoa(5, "Caroline", 6.8f);
        Pessoa[] vet = new Pessoa[]{p1, p2, p3, p4, p5};

        System.out.println("Sem Ordenar: ");
        Print(vet);

        // MergeSort
        // System.out.println("Ordenado por Nome");
        // AlgOrd.MergeSort(0, vet.length, vet, "nome");
        // Print(vet);

        // System.out.println("Ordenado por Matricula");
        // AlgOrd.MergeSort(0, vet.length, vet, "matricula");
        // Print(vet);

        // System.out.println("Ordenado por Nota");
        // AlgOrd.MergeSort(0, vet.length, vet, "nota");
        // Print(vet);

        // QuickSort
        // System.out.println("Ordenado por Nome");
        // AlgOrd.QuickSort(vet, vet.length, 0, "nome");
        // Print(vet);

        // System.out.println("Ordenado por Matricula");
        // AlgOrd.QuickSort(vet, vet.length, 0, "matricula");
        // Print(vet);

        // System.out.println("Ordenado por Nota");
        // AlgOrd.QuickSort(vet, vet.length, 0, "nota");
        // Print(vet);

    }

    public static void Print(Pessoa[] vet){
        for(int i = 0; i < vet.length; i++)
            System.out.println(vet[i]);
    }
    
}
