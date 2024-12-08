package Etapa2;

import java.io.*;
import java.util.*;

public class PrincipalCandidatos {
    public static void main(String[] args) {

        try {
            
        //Lê Arquivos
        BufferedReader brNomes = new BufferedReader(new FileReader("Etapa2/nomes.txt"));
        BufferedReader brPartidos = new BufferedReader(new FileReader("Etapa2/partidos.txt"));

        //Número de Candidatos aleatório
        Random random = new Random(); 
        int numCandidatos = random.nextInt(100) + 1; 
        Candidato[] candidatos = new Candidato[numCandidatos];

        //Preencher array Candidatos
        for (int i = 0; i < numCandidatos; i++) {
            String nome = brNomes.readLine();
            String partido = brPartidos.readLine();
            int votos = random.nextInt(1000);
            candidatos[i] = new Candidato(nome, partido, votos);
        }
        brNomes.close();
        brPartidos.close();

        //Ordernar Candidatos
        OrdenarCandidatos.ordenaCandidatosPorNome(candidatos);
        System.out.println("Candidatos ordenados por nome:");
        for (Object c : candidatos) {
            System.out.println(c);
        }

        OrdenarCandidatos.ordenaCandidatosPorVotos(candidatos);
        System.out.println("Candidatos ordenados por votos:");
        for (Object c : candidatos) {
            System.out.println(c);
        }

        OrdenarCandidatos.ordenaCandidatosPorPartido(candidatos);
        System.out.println("Candidatos ordenados por partido:");
        for (Object c : candidatos) {
            System.out.println(c);

        }

        //Pesquisa
        Scanner s = new Scanner(System.in);
        System.out.println("\nDigite o nome do candidato para pesquisar:");
        String canditadoPesquisa = s.nextLine();

        OrdenarCandidatos.pesquisaBinariaCandidatos(candidatos, canditadoPesquisa); //Confirma ordenação para pesquisar
        int resultadoPesquisa = OrdenarCandidatos.pesquisaBinariaCandidatos(candidatos, canditadoPesquisa);
        if (resultadoPesquisa != -1) {
            System.out.println("Candidato encontrado na posição: " + resultadoPesquisa);
            System.out.println(candidatos[resultadoPesquisa]);
        } else {
            System.out.println("Candidato não encontrado");
        }
        s.close();
    }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
