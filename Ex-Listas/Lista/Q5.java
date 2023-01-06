package Lista;

import Estruturas.Lista;
import Estruturas.No;

public class Q5 {
    public static boolean isPaliRec(Lista<Character> lista, No<Character> ini, No<Character> fim){
        if(lista.getTam() == 0 || lista.getTam() == 1)
            return false;
        else
            if(ini.getInfo().equals(fim.getInfo()))
                return isPaliRec(lista, ini.getProximo(), fim.getAnterior());
            else
                return false;
    }


    public static boolean isPaliIte(Lista<Character> lista){
        int half;
        int count = 0;

        if(lista.getTam() == 0 || lista.getTam() == 1)
            return false;

        else{
            if(lista.getTam() == 2){
                if(lista.removerInicio().equals(lista.removerFinal()))
                    return true;
                else
                    return false;
            }

            if(lista.getTam() > 2 && lista.getTam() % 2 == 0){
                half = lista.getTam() / 2;

                for(int i = 0; i < half - 1; i++){
                    if(lista.removerInicio().equals(lista.removerFinal()))
                        count++;
                    else
                        return false;
                }

                if(count == half)
                    return true;
                else
                    return false;
            }
            else{
                half = (lista.getTam() / 2) - 1;

                for(int i = 0; i < half - 1; i++){
                    if(lista.removerInicio().equals(lista.removerFinal()))
                        count++;
                    else
                        return false;
                }

                if(count == half - 1)
                    return true;
                else
                    return false;
            }

        }

    }
}
