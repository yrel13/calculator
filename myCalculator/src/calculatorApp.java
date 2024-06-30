import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class calculatorApp extends JFrame implements ActionListener {
    private JTextField screen;
    private JButton[] numPad;
    private JButton[] functionPad;
    private JButton addButton, subButton, mulButton, divButton;
    private JButton decButton, equButton, delButton, clrButton;
    private JPanel panel;

    //operands and result
    private double num1 = 0, num2 = 0, result = 0;
    private char operator;

    public calculatorApp() {
        setTitle("Calculator");
        setSize(420, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        //display
        screen = new JTextField();
        screen.setBounds(50, 25, 300, 50);
        screen.setEditable(false);
        add(screen);

        //functions
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("Del");
        clrButton = new JButton("Clear");

        functionPad = new JButton[8];
        functionPad[0] = addButton;
        functionPad[1] = subButton;
        functionPad[2] = mulButton;
        functionPad[3] = divButton;
        functionPad[4] = decButton;
        functionPad[5] = equButton;
        functionPad[6] = delButton;
        functionPad[7] = clrButton;

        for (int i = 0; i < 8; i++) {
            functionPad[i].addActionListener(this);
            functionPad[i].setFont(new Font("Helvetica", Font.PLAIN, 30));
            functionPad[i].setFocusable(false);
        }

        // numpad
        numPad = new JButton[10];
        for (int i = 0; i < 10; i++) {
            numPad[i] = new JButton(String.valueOf(i));
            numPad[i].addActionListener(this);
            numPad[i].setFont(new Font("Helvetica", Font.PLAIN, 30));
            numPad[i].setFocusable(false);
        }

        //Panel
        panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(4, 4, 10, 10));

        //panel buttons
        panel.add(numPad[7]);
        panel.add(numPad[8]);
        panel.add(numPad[9]);
        panel.add(addButton);
        panel.add(numPad[4]);
        panel.add(numPad[5]);
        panel.add(numPad[6]);
        panel.add(subButton);
        panel.add(numPad[1]);
        panel.add(numPad[2]);
        panel.add(numPad[3]);
        panel.add(mulButton);
        panel.add(numPad[0]);
        panel.add(decButton);
        panel.add(equButton);
        panel.add(divButton);

        add(panel);

        //delete and clear buttons
        delButton.setBounds(50, 430, 145, 50);
        clrButton.setBounds(205, 430, 145, 50);
        add(delButton);
        add(clrButton);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numPad[i]) {
                screen.setText(screen.getText().concat(String.valueOf(i)));
            }
        }

        if (e.getSource() == decButton) {
            screen.setText(screen.getText().concat("."));
        }
        if (e.getSource() == addButton) {
            num1 = Double.parseDouble(screen.getText());
            operator = '+';
            screen.setText("");
        }
        if (e.getSource() == subButton) {
            num1 = Double.parseDouble(screen.getText());
            operator = '-';
            screen.setText("");
        }
        if (e.getSource() == mulButton) {
            num1 = Double.parseDouble(screen.getText());
            operator = '*';
            screen.setText("");
        }
        if (e.getSource() == divButton) {
            num1 = Double.parseDouble(screen.getText());
            operator = '/';
            screen.setText("");
        }
        if (e.getSource() == equButton) {
            num2 = Double.parseDouble(screen.getText());

            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    result = num1 / num2;
                    break;
            }
            screen.setText(String.valueOf(result));
            num1 = result;
        }
        if (e.getSource() == clrButton) {
            screen.setText("");
        }
        if (e.getSource() == delButton) {
            String string = screen.getText();
            screen.setText("");
            for (int i = 0; i < string.length() - 1; i++) {
                screen.setText(screen.getText() + string.charAt(i));
            }
        }
    }

    public static void main(String[] args) {
        new calculatorApp();
    }


}
