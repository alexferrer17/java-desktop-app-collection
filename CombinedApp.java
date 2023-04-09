import javax.swing.*;

public class UnifiedApplication {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createUnifiedGUI());
    }

    private static void createUnifiedGUI() {
        JFrame frame = new JFrame("Unified Application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        JTabbedPane tabbedPane = new JTabbedPane();

        // Add the calculator to the first tab
        BasicCalculator calculator = new BasicCalculator();
        calculator.createCalculatorGUI();
        tabbedPane.addTab("Calculator", calculator);

        // Add the text editor to the second tab
        SimpleTextEditor textEditor = new SimpleTextEditor();
        textEditor.createTextEditorGUI();
        tabbedPane.addTab("Text Editor", textEditor);

        frame.add(tabbedPane);
        frame.setVisible(true);
    }
}
