package br.edu.up;
import java.util.ArrayList;
import java.util.List;

public class Program {
    public static void main(String[] args) throws Exception {

        System.out.println("\n--- Prova A1 ---");

        GerenciadorDeArquivos gArquivos = new GerenciadorDeArquivos();

        List<Aluno> listaAlunos;
        listaAlunos = gArquivos.getAlunos();

        System.out.println("\nLista de Alunos: ");

        if (listaAlunos.size() == 0) {
            System.out.println("Não há Alunos cadastrados");
        } else {
            System.out.println(listaAlunos.toString());
        }

        if (gArquivos.gravarAlunoLista(listaAlunos) == true) {
            System.out.println("Arquivo Gravado com sucesso!");
        }else{
            System.out.println("Falha ao gravar arquivo");
        }
        
    }
}