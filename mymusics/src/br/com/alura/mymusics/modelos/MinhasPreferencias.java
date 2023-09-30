package br.com.alura.mymusics.modelos;

public class MinhasPreferencias {
    public void inclui(Audio audio){
        if(audio.getClassificacao() >= 9){
            System.out.println(audio.getTitulo() + " é considerado um sucesso absoluto e preferido por todos!");
        }else {
            System.out.println(audio.getTitulo() + " também é um dos que tudo mundo está curtindo!");
        }
    }
}
