import br.com.alura.screenmatch.calculos.CalculadoraDeTempo;
import br.com.alura.screenmatch.modelos.Movie;
import br.com.alura.screenmatch.modelos.Serie;


public class Main {
    public static void main(String[] args) {
        Movie favorito = new Movie();

        favorito.setNome("The Matrix");
        favorito.setAnoDeLancamento(1999);
        favorito.setDuracaoEmMinutos(135);
        favorito.setIncluidoNoPlano(true);

        favorito.exibeFichaTecnica();
        favorito.avalia(9);
        favorito.avalia(8);
        favorito.avalia(9);

        System.out.printf("Média das avaliações: %.2f%n",  favorito.pegaMedia() );

        Serie lost = new Serie();
        lost.setNome("Lost");
        lost.setDuracaoEmMinutos(50);
        lost.setAnoDeLancamento(2015);
        lost.setTemporadas(5);
        lost.setEpisodiosPorTemporada(10);
        lost.setMinutosPorEpisodio(25);
        lost.exibeFichaTecnica();

        CalculadoraDeTempo calculadoraDeTempo = new CalculadoraDeTempo();
        calculadoraDeTempo.inclui(favorito);
        System.out.println(calculadoraDeTempo.getTempoTotal());

//        Outro filme
        Movie forrestGump = new Movie();
        forrestGump.setNome("Forrest Gump: O contador de histórias");
        forrestGump.setDuracaoEmMinutos(150);
        calculadoraDeTempo.inclui(forrestGump);
        System.out.println(calculadoraDeTempo.getTempoTotal());

    }
}