package JavaPrimer.Project;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class GraphicalTest extends JFrame {
    static final int WIDTH = 1200;
    static final int HEIGHT = 800;
    JTextField accountFromField, amountField;
    JLabel label1, label2;
    JTextArea result;
    JButton pay;

    public GraphicalTest(){
        super("Graphical Test");

        //code UI here
        label1 = new JLabel("Account From:");
        label1.setBounds(100,150,300,40);

        accountFromField = new JTextField("account from");
        accountFromField.setBounds(100,200,300,40);

        label2 = new JLabel("Amount:");
        label2.setBounds(700,150,300,40);

        amountField = new JTextField("amount");
        amountField.setBounds(700,200,300,40);

        pay = new JButton("Payment Go");
        pay.setBounds(500,400,120,40);

        //action
        pay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CreditCard card = new CreditCard("666666",5000, 800.0);
                String fromAccount = accountFromField.getText();
                double amount = Integer.parseInt(amountField.getText());
                if(Objects.equals(fromAccount, card.getAccount())){
                    card.makePayment(amount);
                }
                result.setText(String.valueOf(card.getBalance()));

            }
        });

        result = new JTextArea();
        result.setBounds(400,600,300,100);


        //add objects
        add(accountFromField);
        add(amountField);
        add(label1);
        add(label2);
        add(pay);
        add(result);
        setLayout(null);
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);



    }


}
