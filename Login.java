package com.Ayan;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class Login extends JFrame implements ActionListener {
    JButton login,clear,register;
    JTextField card;
    JPasswordField pinField;
    Login(){
        setLayout(null);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2=i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel label=new JLabel(i3);
        label.setBounds(205,30,100,100);
        add(label);

        JLabel text=new JLabel("Welcome to SBI");
        add(text);
        text.setBounds(310,70,400,30);
        text.setFont(new Font("Onward",Font.BOLD,30));

        JLabel cardno=new JLabel("Card Number:");
        add(cardno);
        cardno.setBounds(120,150,150,30);
        cardno.setFont(new Font("Rale way",Font.BOLD,20));

        card=new JTextField();
        card.setBounds(300,150,250,30);
        add(card);


        JLabel pin=new JLabel("PIN:");
        add(pin);
        pin.setBounds(120,220,200,30);
        pin.setFont(new Font("Rale way",Font.BOLD,20));

        pinField=new JPasswordField();
        pinField.setBounds(300,220,250,30);
        add(pinField);

        login=new JButton("Sign in");
        login.setBounds(200,300,100,30);
        login.addActionListener(this);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        add(login);

        clear=new JButton("Clear");
        clear.setBounds(330,300,100,30);
        clear.addActionListener(this);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        add(clear);

        register=new JButton("Register");
        register.setBounds(265,350,100,30);
        register.addActionListener(this);
        register.setBackground(Color.BLACK);
        register.setForeground(Color.WHITE);
        add(register);

        getContentPane().setBackground(Color.white);

        setTitle("Automated Teller Machine");
        setSize(800,480);
        setVisible(true);
        setLocation(350,200);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
       try {
           if(e.getSource()==login){
               Conn c=new Conn();
               String cardNo=card.getText();
               String pinNumber=pinField.getText();
               String q="select * from login where CardNo='"+cardNo+"' and Pinno='"+pinNumber+"' ";
               System.out.println(q);
               ResultSet resultSet=c.s.executeQuery(q);
               System.out.println("Record Exist: "+resultSet.next());
//               if(resultSet.next()){
//                 if(!pinNumber.equals(pinNumber)){
                   setVisible(false);
                   new Transactions(pinNumber).setVisible(true);

//               else {JOptionPane.showMessageDialog(null,"Invalid PIN");}
           } else if (e.getSource()==register) {
               setVisible(false);
               new Register().setVisible(true);
           }

       }
       catch (Exception ae){
           System.out.println(ae);
       }
    }
    public static void main(String[] args) {
        new Login();

    }

}
