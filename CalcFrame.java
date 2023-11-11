import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class CalcFrame implements ActionListener {
    JFrame frame;
    JTextField textField;
    JButton [] numberButtons = new JButton[10];
    JButton [] functionButton = new JButton[6];
    JButton addButton, mulButton, subButton, divButton;
    JButton delButton, clrButton, equButton,decButton;
    JPanel panel;

    Font font = new Font("Playfair Display", Font.PLAIN, 25);

    double num1 = 0, num2 = 0, result = 0;
    char operator;
    CalcFrame(){
        textField = new JTextField();
        textField.setBounds(50,25,375,50);
        textField.setFont(font);
        textField.setEditable(false);

        addButton = new JButton("+");
        subButton = new JButton("-");
        decButton = new JButton(".");
        equButton = new JButton("=");
        mulButton = new JButton("x");
        divButton = new JButton("/");
        functionButton[0] = addButton;
        functionButton[1] = subButton;
        functionButton[2] = decButton;
        functionButton[3] = equButton;
        functionButton[4] = mulButton;
        functionButton[5] = divButton;
        panel = new JPanel();
        panel.setBounds(50,90,375,275);
        panel.setLayout(new GridLayout(4,4,6,6));
        panel.setBackground(Color.lightGray);

        for(int i =0; i<6; i++){
            functionButton[i].setFont(font);
            functionButton[i].setFocusable(false);
            functionButton[i].addActionListener(this);
            functionButton[i].setForeground(Color.BLUE);
        }
        for(int i = 0; i<10; i++){
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFocusable(false);
            numberButtons[i].setFont(new Font("PlayFair Display", Font.PLAIN, 16));
        }
        divButton.setForeground(Color.BLUE);
        delButton = new JButton("Delete");
        delButton.setBounds(110,390,125,30);
        delButton.setFont(font);
        delButton.setFocusable(false);
        delButton.addActionListener(this);
        clrButton = new JButton("Clear");
        clrButton.setBounds(245,390,125,30);
        clrButton.setFont(font);
        clrButton.setFocusable(false);
        clrButton.addActionListener(this);

        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(equButton);
        panel.add(divButton);

        ImageIcon Icon = new ImageIcon("liverpoollogo.png");
        frame = new JFrame("Joel's Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(500,500);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.add(textField);
        frame.add(delButton);
        frame.add(clrButton);
        frame.add(panel);
        frame.getContentPane().setBackground(Color.BLUE);
        frame.setIconImage(new ImageIcon("liverpoollogo.png").getImage());
    }
    @Override
    public void actionPerformed(ActionEvent e){
        for(int i = 0; i<10; i++){
            if(e.getSource() == numberButtons[i]){
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }
        if(e.getSource() == decButton){
            textField.setText(textField.getText().concat("."));
        }
        if(e.getSource() == addButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText(" ");

        }
        if(e.getSource() == subButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText(" ");
        }
        if(e.getSource() == divButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText(" ");
        }
        if(e.getSource() == mulButton){
           num1 = Double.parseDouble(textField.getText());
           operator = '*';
           textField.setText(" ");
        }
        if(e.getSource() == clrButton){
           textField.setText(" ");
        }
        if(e.getSource() == delButton){
            String string = textField.getText();
            textField.setText("");
            for(int i =0; i<string.length()-1; i++){
                textField.setText(textField.getText() + string.charAt(i));
            }
        }
        if(e.getSource() == equButton)
        {
            num2 = Double.parseDouble(textField.getText());

            switch(operator){
                case  '+':
                    result = num1 + num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '/':
                    result = num1 / num2;
                    break;
            }
            textField.setText(String.valueOf(result));
        }
    }
}
