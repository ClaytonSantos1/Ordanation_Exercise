package Etapa2;

public class OrdenarCandidatos {
    public static void ordenaCandidatosPorNome(Candidato[] candidatos) {
        // Ordenar por Nome (Inserção Direta)
        for (int i = 1; i < candidatos.length; i++) {
                Candidato c = candidatos[i];
                int j = i - 1;
                while (j >= 0 && candidatos[j].getNome().compareTo(c.getNome()) > 0) {
                    candidatos[j + 1] = candidatos[j];
                    j = j - 1;
                }
                candidatos[j + 1] = c;
            }
        }
    
        // Ordenar por Votos (Seleção Direta)
        public static void ordenaCandidatosPorVotos(Candidato[] candidatos) {
            for (int i = 0; i < candidatos.length - 1; i++) {
                int maxVotos = i;
                for (int j = i + 1; j < candidatos.length; j++) {
                    if (candidatos[j].getIntencoesVotos() > candidatos[maxVotos].getIntencoesVotos()) {
                        maxVotos = j;
                    }
                }
                Candidato temp = candidatos[maxVotos];
                candidatos[maxVotos] = candidatos[i];
                candidatos[i] = temp;
            }
        }
    
        // Ordenar por Partido (Inserção Direta)
        public static void ordenaCandidatosPorPartido(Candidato[] candidatos) {
            for (int i = 1; i < candidatos.length; i++) {
                Candidato p = candidatos[i];
                int j = i - 1;
                while (j >= 0 && candidatos[j].getPartido().compareTo(p.getPartido()) > 0) {
                    candidatos[j + 1] = candidatos[j];
                    j = j - 1;
                }
                candidatos[j + 1] = p;
            }
        }
    
        // Pesquisa Binária
        public static int pesquisaBinariaCandidatos(Candidato[] candidatos, String nome) {
            int inicio = 0;
            int fim = candidatos.length - 1;
            while (inicio <= fim) {
                int meio = (inicio + fim) / 2;
                int comparacao = candidatos[meio].getNome().compareToIgnoreCase(nome);
                if (comparacao == 0) {
                    return meio;
                } else if (comparacao < 0) {
                    inicio = meio + 1;
                } else {
                    fim = meio - 1;
                }
            }
            return -1;
        }
    }