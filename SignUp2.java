package com.Ayan;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class SignUp2 extends JFrame implements ActionListener {
    JRadioButton r1,r2,r3,r4;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton submit,cancel;
    String formNo;
    SignUp2(String formNo){
        this.formNo=formNo;
        setLayout(null);
        JLabel l1=new JLabel("Page 3:Account Details");
        l1.setBounds(280,40,400,40);
        l1.setFont(new Font("Raleway",Font.BOLD,22));
        add(l1);

        JLabel type=new JLabel("Account Type");
        type.setFont(new Font("Raleway", Font.BOLD, 22));
        type.setBounds(100,140,200,40);
        add(type);

        r1=new JRadioButton("Savings Account");
        r1.setBounds(100,200,200,20);
        r1.setFont(new Font("Raleway", Font.BOLD,16));
        r1.setBackground(Color.WHITE);
        add(r1);

        r2=new JRadioButton("Current Account");
        r2.setBounds(350,200,200,20);
        r2.setFont(new Font("Raleway", Font.BOLD,16));
        r2.setBackground(Color.WHITE);
        add(r2);

        r3=new JRadioButton("Fixed Deposit Account");
        r3.setBounds(100,250,200,20);
        r3.setFont(new Font("Raleway", Font.BOLD,16));
        r3.setBackground(Color.WHITE);
        add(r3);

        r4=new JRadioButton("Recurring Account");
        r4.setBounds(350,250,200,20);
        r4.setFont(new Font("Raleway", Font.BOLD,16));
        r4.setBackground(Color.WHITE);
        add(r4);

        ButtonGroup B=new ButtonGroup();
        B.add(r1);
        B.add(r2);
        B.add(r3);
        B.add(r4);

        JLabel card=new JLabel("Card Number:");
        card.setFont(new Font("Raleway", Font.BOLD, 22));
        card.setBounds(100,300,200,40);
        add(card);

        JLabel number=new JLabel("XXXX-XXXX-XXXX-4296");
        number.setFont(new Font("Raleway", Font.ITALIC, 18));
        number.setBounds(310,300,300,40);
        add(number);

        JLabel pin=new JLabel("PIN:");
        pin.setFont(new Font("Raleway", Font.BOLD, 22));
        pin.setBounds(100,350,200,40);
        add(pin);

        JLabel pinNo=new JLabel("XXXX");
        pinNo.setFont(new Font("Raleway", Font.ITALIC, 18));
        pinNo.setBounds(310,350,300,40);
        add(pinNo);

        JLabel services=new JLabel("Services required");
        services.setFont(new Font("Raleway", Font.BOLD, 22));
        services.setBounds(100,410,300,40);
        add(services);

        c1=new JCheckBox("ATM Card");
        c1.setBounds(100,460,200,20);
        c1.setBackground(Color.WHITE);
        c1.setFont(new Font("Raleway",Font.BOLD,16));
        add(c1);

        c2=new JCheckBox("Internet Banking");
        c2.setBounds(350,460,200,20);
        c2.setBackground(Color.WHITE);
        c2.setFont(new Font("Raleway",Font.BOLD,16));
        add(c2);

        c3=new JCheckBox("Mobile Banking");
        c3.setBounds(100,510,200,20);
        c3.setBackground(Color.WHITE);
        c3.setFont(new Font("Raleway",Font.BOLD,16));
        add(c3);

        c4=new JCheckBox("Email and SMS alerts");
        c4.setBounds(350,510,200,20);
        c4.setBackground(Color.WHITE);
        c4.setFont(new Font("Raleway",Font.BOLD,16));
        add(c4);

        c5=new JCheckBox("Cheque Book");
        c5.setBounds(100,560,200,20);
        c5.setBackground(Color.WHITE);
        c5.setFont(new Font("Raleway",Font.BOLD,16));
        add(c5);

        c6=new JCheckBox("E-Statement");
        c6.setBounds(350,560,200,20);
        c6.setBackground(Color.WHITE);
        c6.setFont(new Font("Raleway",Font.BOLD,16));
        add(c6);

        c7=new JCheckBox("I hereby declare that the above entered details are correct to the best of my knowledge");
        c7.setBounds(50,620,800,20);
        c7.setBackground(Color.WHITE);
        c7.setFont(new Font("Raleway",Font.BOLD,16));
        add(c7);

        submit=new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setBounds(250, 720, 100, 30);
        add(submit);

        cancel=new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setBounds(420, 720, 100, 30);
        cancel.addActionListener(this);
        add(cancel);

        getContentPane().setBackground(Color.WHITE);

        setSize(850, 800);
        setVisible(true);
        setLocation(350,10);
    }
    public static void main(String[] args) {
        new SignUp2("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
//        if(e.getSource()==submit){
            String Account=null;
            if(r1.isSelected()){
                Account="Savings Account";
            } else if (r2.isSelected()) {
                Account="Current Account";
            } else if (r3.isSelected()) {
                Account="Fixed Deposit Account";
            } else if (r4.isSelected()) {
                Account="Recurring Account";
            }

            Random random=new Random();
            String cardno= " " + Math.abs(random.nextLong() % 900000000L+ 504093600000000L);
            String pinno=" "+ Math.abs((random.nextLong() % 9000L)+1000L);

            String Facility="";
            if(c1.isSelected()){
                Facility +="ATM card, ";
            }
            if (c2.isSelected()) {
                Facility +=" Internet Banking, ";
            }
            if (c3.isSelected()) {
                Facility += " Mobile Banking, ";
            }
            if (c4.isSelected()) {
                Facility += " Email and SMS alerts, ";
            }
            if (c5.isSelected()) {
                Facility +=" Cheque Book, ";
            }
            if (c6.isSelected()) {
                Facility +=" E-Statement, ";
            }
            try {
                if(e.getSource()==submit) {
                    if (Account.equals("")) {
                        JOptionPane.showMessageDialog(null, "Account type required");
                    } else {
                        Conn conn = new Conn();
                        String query1 = "insert into signup3 values('" + formNo + "','" + Account + "', '" + cardno + "', '" + pinno + "','" + Facility + "')";
                        String query2 = "insert into login values('" + formNo + "', '" + cardno + "', '" + pinno + "')";
                        JOptionPane.showMessageDialog(null, "Card Number: " + cardno + "\n  Pin:" + pinno);
                        conn.s.executeUpdate(query1);
                        conn.s.executeUpdate(query2);
                        setVisible(false);
//                        new deposit(pinno).setVisible(true);
                        new Transactions(pinno).setVisible(true);
                    }
                } else if(e.getSource()==cancel){
                             setVisible(false);
                             new Login().setVisible(true);
            }
            }
            catch (Exception ae){
                System.out.println(e);
            }



    }
}
