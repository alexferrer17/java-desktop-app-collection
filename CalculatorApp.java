import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BasicCalculator {
    private JTextField textField;
    private double firstNumber = 0;
    private double secondNumber = 0;
    private double result = 0;
    private String operation;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new BasicCalculator().createCalculatorGUI());
    }

    private void createCalculatorGUI() {
        JFrame frame = new JFrame("Basic Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 400);

        Container container = frame.getContentPane();
        container.setLayout(new BorderLayout());

        textField = new JTextField();
        container.add(textField, BorderLayout.NORTH);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4));
        container.add(panel, BorderLayout.CENTER);

        String[] buttonLabels = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", ".", "=", "+"
        };

        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.addActionListener(new ButtonClickListener());
            panel.add(button);
        }

        frame.setVisible(true);
    }

    private class ButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton source = (JButton) e.getSource();
            String text = source.getText();

            switch (text) {
                case "=":
                    if (operation != null) {
                        try {
                            secondNumber = Double.parseDouble(textField.getText());
                            switch (operation) {
                                case "+":
                                    result = firstNumber + secondNumber;
                                    break;
                                case "-":
                                    result = firstNumber - secondNumber;
                                    break;
                                case "*":
                                    result = firstNumber * secondNumber;
                                    break;
                                case "/":
                                    result = firstNumber / secondNumber;
                                    break;
                            }
                            textField.setText(Double.toString(result));
                            operation = null;
                        } catch (NumberFormatException ex) {
                            textField.setText("Error");
                        }
                    }
                    break;
                case "+":
                case "-":
                case "*":
                case "/":
                    operation = text;
                    try {
                        firstNumber = Double.parseDouble(textField.getText());
                        textField.setText("");
                    } catch (NumberFormatException ex) {
                        textField.setText("Error");
                    }
                    break;
                default:
                    textField.setText(textField.getText() + text);
                    break;
            }
        }
    }
}
