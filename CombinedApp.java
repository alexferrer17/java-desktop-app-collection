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

        // Add the to-do list to the third tab
        ToDoList toDoList = new ToDoList();
        toDoList.createToDoListGUI();
        tabbedPane.addTab("To-Do List", toDoList);

        frame.add(tabbedPane);
        frame.setVisible(true);
    }
}
