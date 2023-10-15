import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TemperatureConverterApp {
    private JFrame frame;
    private JPanel panel;
    private JTextField inputField;
    private JLabel resultLabel;
    private JButton convertButton;

    public TemperatureConverterApp() {
        frame = new JFrame("Temperature Converter");
        panel = new JPanel();
        inputField = new JTextField(10);
        resultLabel = new JLabel("");
        convertButton = new JButton("Convert");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 150);
        frame.setResizable(false);
        frame.getContentPane().setLayout(new BorderLayout());

        panel.setLayout(new FlowLayout());
        panel.add(inputField);
        panel.add(convertButton);

        frame.add(panel, BorderLayout.CENTER);
        frame.add(resultLabel, BorderLayout.SOUTH);

        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                convertTemperature();
            }
        });

        frame.setVisible(true);
    }

    private void convertTemperature() {
        try {
            double inputValue = Double.parseDouble(inputField.getText());
            double result;
            String fromUnit, toUnit;

            if (inputField.getText().contains("C") || inputField.getText().contains("c")) {
                // Convert from Celsius to Fahrenheit
                result = (inputValue * 9 / 5) + 32;
                fromUnit = "Celsius";
                toUnit = "Fahrenheit";
            } else if (inputField.getText().contains("F") || inputField.getText().contains("f")) {
                // Convert from Fahrenheit to Celsius
                result = (inputValue - 32) * 5 / 9;
                fromUnit = "Fahrenheit";
                toUnit = "Celsius";
            } else {
                resultLabel.setText("Invalid input. Use 'C' for Celsius or 'F' for Fahrenheit.");
                return;
            }

            resultLabel.setText(inputValue + " " + fromUnit + " = " + result + " " + toUnit);
        } catch (NumberFormatException ex) {
            resultLabel.setText("Invalid input. Enter a valid numeric temperature.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TemperatureConverterApp();
            }
        });
    }
}
