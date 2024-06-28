package br.edu.up;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GerenciadorDeArquivos {
    private String header = "";
    private String arquivoAlunos = "C:\\Users\\autologon\\Documents\\GitHub\\A1-33905380\\Alunos\\src\\br\\edu\\up\\alunos.csv";
    private String arquivoResumo = "C:\\Users\\autologon\\Documents\\GitHub\\A1-33905380\\Alunos\\src\\br\\edu\\up\\resumo.csv";

    public List<Aluno> getAlunos() {
        List<Aluno> listaDeAlunos = new ArrayList<>();

        try (Scanner leitor = new Scanner(new File(arquivoAlunos))) {

            if (leitor.hasNextLine()) {
                leitor.nextLine();
            }
            while (leitor.hasNextLine()) {
                String linha = leitor.nextLine();
                String dados[] = linha.split(";");

                String matricula = dados[0];
                String nome = dados[1];
                String nota = dados[2];

                Aluno aluno = new Aluno(matricula, nome, nota);
                listaDeAlunos.add(aluno);

            }
        } catch (Exception e) {
            System.out.println("Arquivo de alunos não encontrado! " + e.getMessage());
        }

        return listaDeAlunos;
    }

    
    private int calcularQuantidadeAlunos(List<Aluno> alunos) {
        return alunos.size();
    }

    private int calcularQuantidadeAprovados(List<Aluno> alunos) {
        int count = 0;
        for (Aluno aluno : alunos) {
            if (Double.parseDouble(aluno.getNota().replace(",", ".")) >= 6.0) {
                count++;
            }
        }
        return count;
    }

    private int calcularQuantidadeReprovados(List<Aluno> alunos) {
        int count = 0;
        for (Aluno aluno : alunos) {
            if (Double.parseDouble(aluno.getNota().replace(",", ".")) < 6.0) {
                count++;
            }
        }
        return count;
    }

    public boolean gravarAlunoLista(List<Aluno> alunos) {
        try {
            FileWriter arquivoGravar = new FileWriter(arquivoResumo);
            PrintWriter gravador = new PrintWriter(arquivoGravar);

            gravador.println("matricula;nome;nota");
            for (Aluno aluno : alunos) {
                gravador.println(aluno.toCSV());
            }

            gravador.close();
            return true;
        } catch (Exception e) {
            System.out.println("Não foi possível gravar o arquivo!");
        }
        return false;
    }

}