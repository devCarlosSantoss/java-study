import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        List<String> list = new ArrayList<>();

        System.out.println("Insira Elementos na lista: ");
        for (int i = 0; i < 3; i++) {
            System.out.print("Adicionar: ");
            String value = sc.nextLine();
            list.add(value);
        }

        for (String x : list) {
            System.out.println(x);
        }
    }
}