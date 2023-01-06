package Ordenação;

public class AlgOrd {
    
    private static int swipe(String type){
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
            switch (swipe(type)) {
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
        
        int left, right = end;
        left = stt + 1;

        while(left <= right){
            switch (swipe(type)) {
                case 1:
                    while(left <= right && vet[left].getMatricula() < piv.getMatricula())    
                        left++;

                    while(right >= left && vet[right].getMatricula() >= piv.getMatricula())
                        right++;

                    if(left < right){
                        troca(vet, right, left);
                        left++;
                        right--;
                    }

                    troca(vet, stt, right);
                    break;

                case 2:
                    while(left <= right && vet[left].getNota() < piv.getNota())    
                        left++;

                    while(right >= left && vet[right].getNota() >= piv.getNota())
                        right++;

                    if(left < right){
                        troca(vet, right, left);
                        left++;
                        right--;
                    }

                    troca(vet, stt, right);
                    break;

                case 3:
                    while(left <= right && vet[left].getNome().compareToIgnoreCase(piv.getNome()) < 0)    
                        left++;

                    while(right >= left && vet[left].getNome().compareToIgnoreCase(piv.getNome()) >= 0)
                        right++;

                    if(left < right){
                        troca(vet, right, left);
                        left++;
                        right--;
                    }

                    troca(vet, stt, right);
                    break;
                    
                default:
                    System.out.println("Opção de ordenação inválida!!");
                    System.exit(0);    

                    break;
            }


        }
        
        return right;

    }

    private static void troca(Pessoa[] vet, int i, int j){
        Pessoa temp = vet[i];
        vet[i] = vet[j];
        vet[j] = temp;
    }
}
