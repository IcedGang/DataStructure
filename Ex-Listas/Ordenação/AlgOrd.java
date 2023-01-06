package Ordenação;

public class AlgOrd {
    
    private static int swap(String type){
        if(type.toLowerCase().compareTo("matricula") == 0)
            return 1;
        
        if(type.toLowerCase().compareTo("nota") == 0)
            return 2;
        
        if(type.toLowerCase().compareTo("nome") == 0)
            return 3;

        return 0;
    }

    // MergeSort
    public static void MergeSort(int stt, int end, Pessoa[] vet, String type){
        if(stt < end - 1){
            int half = (stt + end) / 2;
            
            MergeSort(stt, half, vet, type);
            MergeSort(half, end, vet, type);
            Merge(vet, stt, half, end, type);
        }
    }

    private static void Merge(Pessoa[] vet, int stt, int half, int end, String type){
        Pessoa[] newVet = new Pessoa[end - stt];

        int aux1 = stt;
        int aux2 = half;
        int pos = 0;

        while(aux1 < half && aux2 < end){
            switch (swap(type)) {
                case 1:
                    if(vet[aux1].getMatricula() == vet[aux2].getMatricula()){
                        newVet[pos] = vet[aux1];
                        pos += 1;
                        aux1 += 1;
                    } 
                    else{
                        newVet[pos] = vet[aux2];
                        pos += 1;
                        aux2 += 1;
                    }

                    break;
                
                case 2:
                    if(vet[aux1].getNota() <= vet[aux2].getNota()){
                        newVet[pos] = vet[aux1];
                        pos += 1;
                        aux1 += 1;
                    } 
                    else{
                        newVet[pos] = vet[aux2];
                        pos += 1;
                        aux2 += 1;
                    }

                    break;

                case 3:
                    if(vet[aux1].getNome().compareToIgnoreCase(vet[aux2].getNome()) <= 0){
                        newVet[pos] = vet[aux1];
                        pos += 1;
                        aux1 += 1;
                    } 
                    else{
                        newVet[pos] = vet[aux2];
                        pos += 1;
                        aux2 += 1;
                    }

                    break;

                default:
                    System.out.println("Opção de ordenação inválida!!");
                    System.exit(0);

                    break;
            }


        }

        while(aux1 < half){
            newVet[pos] = vet[aux1];
            pos += 1;
            aux1 += 1;   
        }

        while(aux2 < end){
            newVet[pos] = vet[aux2];
            pos += 1;
            aux2 += 1;
        }

        for(pos = 0, aux1 = stt; aux1 < end; pos++, aux1++)
            vet[aux1] = newVet[pos];
        
    }

    // QuickSort
    public static void QuickSort(Pessoa[] vet, int stt, int end, String type){
        if(end > stt){
            int posPiv = vetBreak(vet, stt, end, type);

            QuickSort(vet, stt, posPiv - 1, type);
            QuickSort(vet, posPiv + 1, end, type);
        }
    }

    private static int vetBreak(Pessoa[] vet, int stt, int end, String type){
        Pessoa piv = vet[stt];
        int i = end - 1;
        int aux = swap(type);

        for(int j = stt; j < end; j++){
            if(aux == 0){
                System.out.println("Impossivel ordenar o vetor!");
                System.exit(0);
            }
            
            if(aux == 1){
                if (vet[j].getMatricula() <= piv.getMatricula()){
                    i++;
                    troca(vet, i, j);
                }         
            }

            if(aux == 2){
                if (vet[j].getNota() <= piv.getNota()){
                    i++;
                    troca(vet, i, j);
                }         
            }

            if(aux == 3){
                if (vet[j].getNome().compareTo(piv.getNome()) <= 0){
                    i++;
                    troca(vet, i, j);
                }         
            }
        }

        troca(vet, i, end);
        return i;
    }

    private static void troca(Pessoa[] vet, int i, int j){
        Pessoa temp = vet[i];
        vet[i] = vet[j];
        vet[j] = temp;
    }

    // HeapSort -- MaxHeap
    private static void Heapify(Pessoa[] vet, int tam, int index, String type){
        int aux = index;
        int left = (2 * index) + 1, right = (2 * index) + 2;

        switch (swap(type)) {
            case 1:
                if(left < tam && vet[left].getMatricula() > vet[aux].getMatricula())
                    aux = left;
                
                if(right < tam && vet[right].getMatricula() > vet[aux].getMatricula())
                    aux = right;

                break;

            case 2:
                if(left < tam && vet[left].getNota() > vet[aux].getNota())
                    aux = left;
                
                if(right < tam && vet[right].getNota() > vet[aux].getNota())
                    aux = right;

                break;

            case 3:
                if(left < tam && vet[left].getNome().compareTo(vet[aux].getNome()) > 0)
                    aux = left;
                
                if(right < tam && vet[right].getNome().compareTo(vet[aux].getNome()) > 0)
                    aux = right;

                break;
        
        }

        if(aux != index){
            troca(vet, index, aux);
            Heapify(vet, tam, aux, type);
        }

    }

    public static void HeapSort(Pessoa[] vet, String type){
        for(int i = vet.length / 2 - 1; i >= 0; i--)
            Heapify(vet, vet.length, i, type);
        
        for(int i = vet.length - 1; i > 0; i--){
            troca(vet, i, 0);
            Heapify(vet, i, 0, type);
        }

    }

    // InsertionSort
    public static void InsertionSort(Pessoa[] vet, String type){
        Pessoa key;
        int i, aux;

        for(i = 1; i < vet.length; i++){
            key = vet[i];
            aux = i - 1;

            switch (swap(type)) {
                case 1:
                    while((aux >= 0) && vet[aux].getMatricula() > key.getMatricula()){
                        vet[aux + 1] = vet[aux];
                        aux--;
                    }
                
                    break;
                
                case 2:
                    while((aux >= 0) && vet[aux].getNota() > key.getNota()){
                        vet[aux + 1] = vet[aux];
                        aux--;
                    }

                    break;

                case 3:
                    while((aux >= 0) && vet[aux].getNome().compareTo(key.getNome()) > 0){
                        vet[aux + 1] = vet[aux];
                        aux--;
                    }

                    break;

            }

            vet[aux + 1] = key;
        }

    }

    // SelectionSort
    public static void SelectionSort(Pessoa[] vet, String type){
        int swap = swap(type);
        
        for(int fix = 0; fix < vet.length; fix++){
            int aux = fix;

            for(int i = aux + 1; i < vet.length; i++){
                if(swap == 1){
                    if(vet[i].getMatricula() < vet[aux].getMatricula())
                        aux = i;
                }

                if(swap == 2){
                    if(vet[i].getNota() < vet[aux].getNota())
                        aux = i;
                }

                if(swap == 3){
                    if(vet[i].getNome().compareTo(vet[aux].getNome()) < 0)
                        aux = i;
                }

            }

            if(aux != fix)
                troca(vet, fix, aux);
        }

    }


}
