import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {
    private final JComboBox<String> fromUnitComboBox;
    private final JComboBox<String> toUnitComboBox;
    private final JTextField temperatureTextField;
    private final JLabel resultLabel;

    public Main() {
        // Configurações básicas do JFrame
        setTitle("Conversor de Temperatura");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);

        // Criação dos componentes
        fromUnitComboBox = new JComboBox<>(new String[]{"Celsius", "Fahrenheit"});
        toUnitComboBox = new JComboBox<>(new String[]{"Celsius", "Fahrenheit"});
        temperatureTextField = new JTextField(10);
        resultLabel = new JLabel();
        JButton convertButton = new JButton("Converter");

        // Configuração do ActionListener para o botão
        convertButton.addActionListener(e -> {
            // Obtém os valores selecionados nos JComboBoxes
            String fromUnit = (String) fromUnitComboBox.getSelectedItem();
            String toUnit = (String) toUnitComboBox.getSelectedItem();

            // Obtém a temperatura digitada no campo de texto
            String temperatureStr = temperatureTextField.getText();

            try {
                // Converte a temperatura para o tipo double
                double temperature = Double.parseDouble(temperatureStr);

                // Realiza a conversão de temperatura
                assert fromUnit != null;
                double convertedTemperature = convertTemperature(temperature, fromUnit, toUnit);

                // Exibe o resultado na JLabel
                resultLabel.setText(String.format("%.2f %s", convertedTemperature, toUnit));
            } catch (NumberFormatException ex) {
                // Exibe uma mensagem de erro se a temperatura não for um número válido
                resultLabel.setText("Temperatura inválida");
            }
        });

        // Adiciona os componentes ao JFrame
        setLayout(new FlowLayout());
        add(fromUnitComboBox);
        add(new JLabel("para"));
        add(toUnitComboBox);
        add(temperatureTextField);
        add(convertButton);
        add(resultLabel);
    }

    // Método para converter a temperatura
    private double convertTemperature(double temperature, String fromUnit, String toUnit) {
        if (fromUnit.equals("Celsius") && toUnit.equals("Fahrenheit")) {
            return (temperature * 9 / 5) + 32;
        } else if (fromUnit.equals("Fahrenheit") && toUnit.equals("Celsius")) {
            return (temperature - 32) * 5 / 9;
        } else {
            return temperature; // Retorna a temperatura sem conversão se as unidades forem iguais
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Main().setVisible(true));
    }
}
