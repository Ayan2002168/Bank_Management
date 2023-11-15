package com.Ayan;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;

public class MiniStatement extends JFrame {
    String pinNumber;
    MiniStatement(String pinNumber){
        this.pinNumber=pinNumber;
        setTitle("Mini Statement");
        setLayout(null);

        JLabel mini=new JLabel();
        add(mini);

        JLabel bank=new JLabel("State Bank of India");
        bank.setBounds(100,20,200,30);
        bank.setFont(new Font("Raleway",Font.BOLD,20));
        add(bank);

        JLabel card=new JLabel();
        card.setBounds(20,80,300,30);
        add(card);

        try {
            Conn c=new Conn();
            ResultSet rs =c.s.executeQuery("select * from login where Pinno='"+pinNumber+"'");
            System.out.println(rs.next());
            while (rs.next()){
                card.setText("Card Number:"+rs.getString("CardNo").substring(0,4) + "XXXXXXXX" + rs.getString("CardNo").substring(12));
            }
        }catch (Exception ae){
            ae.printStackTrace();
        }
        try {
            Conn c=new Conn();
            ResultSet rs =c.s.executeQuery("select * from bank where Pin='"+pinNumber+"'");
            while (rs.next()){
                mini.setText(mini.getText()+ "<html>" +rs.getString("Date"));
            }
        }catch (Exception ae){
            ae.printStackTrace();
        }

        getContentPane().setBackground(Color.WHITE);

        setSize(400,600);
        setLocation(20,20);
        setVisible(true);
    }
    public static void main(String[] args) {
        new MiniStatement("");
    }
}
