import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorApp extends JFrame {
    private JTextField firstNumberField, secondNumberField, resultField;
    private double num1, num2, result;
    private String operator;

    public CalculatorApp() {
        setTitle("Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setSize(300, 400);

        // Input Fields
        firstNumberField = createTextField();
        secondNumberField = createTextField();

        // Result Field (read-only)
        resultField = createTextField();
        resultField.setEditable(false);

        // Button Panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 2, 5, 5)); // 4 rows, 2 columns, gaps
        addButtons(buttonPanel);

        // Layout Components
        add(new JPanel(new FlowLayout(FlowLayout.LEFT)).add(new JLabel("First Number:")), BorderLayout.NORTH);
        add(firstNumberField, BorderLayout.NORTH);
        add(new JPanel(new FlowLayout(FlowLayout.LEFT)).add(new JLabel("Second Number:")), BorderLayout.CENTER);
        add(secondNumberField, BorderLayout.CENTER);
        add(new JPanel(new FlowLayout(FlowLayout.LEFT)).add(new JLabel("Result:")), BorderLayout.SOUTH);
        add(resultField, BorderLayout.SOUTH);
        add(buttonPanel, BorderLayout.EAST);

        setVisible(true);
    }

    private JTextField createTextField() {
        JTextField textField = new JTextField(10);
        textField.setHorizontalAlignment(JTextField.RIGHT);
        return textField;
    }

    private void addButtons(JPanel panel) {
        String[] buttonLabels = {"+", "-", "*", "/", "%", "Clear"};
        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.addActionListener(new ButtonClickListener());
            panel.add(button);
        }
    }

    private class ButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            if (command.matches("[0-9.]")) {
                // ... (handle digit input)
            } else if (command.matches("[+\\-*/%]")) {
                operator = command;
                num1 = Double.parseDouble(firstNumberField.getText());
            } else if (command.equals("=")) {
                // ... (perform calculation)
            } else if (command.equals("Clear")) {
                // ... (clear input fields and result)
            }
        }
    }

    public static void main(String[] args) {
        new CalculatorApp();
    }
}