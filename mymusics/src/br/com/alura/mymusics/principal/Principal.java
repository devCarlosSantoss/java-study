package br.com.alura.mymusics.principal;

import br.com.alura.mymusics.modelos.MinhasPreferencias;
import br.com.alura.mymusics.modelos.Musica;
import br.com.alura.mymusics.modelos.Podcast;

public class Principal {
    public static void main(String[] args) {
        Musica myMusic = new Musica();

        myMusic.setTitulo("Forever");
        myMusic.setCantor("Kiss");

        for (int i = 0; i < 1000; i++){
            myMusic.reproduz();
        }
        for (int i = 0; i < 50; i++){
            myMusic.curte();
        }

        Podcast myPodcast = new Podcast();
        myPodcast.setTitulo("BolhaDev");
        myPodcast.setApresentador("Marcos Mendes");

        for(int i = 0; i < 5000; i++){
            myPodcast.reproduz();
        }

        for (int i = 0; i < 1000; i++){
            myPodcast.curte();
        }

        MinhasPreferencias preferencias = new MinhasPreferencias();
        preferencias.inclui(myPodcast);
        preferencias.inclui(myMusic);
    }
}
