package Ordenação;

public class Pessoa {
    
    private int matricula;
    private String nome;
    private float nota;
    
    public Pessoa(int matricula, String nome, float nota) {
        this.matricula = matricula;
        this.nome = nome;
        this.nota = nota;
    }

    public int getMatricula() {
        return matricula;
    }

    public String getNome() {
        return nome;
    }

    public float getNota() {
        return nota;
    }

    @Override
    public String toString() {
        String str = "Nome: " + getNome() + "\n";
        str += "Matricula: " + getMatricula() + "\n";
        str += "Nota: " + getNota() + "\n";

        return str;
    }
}
