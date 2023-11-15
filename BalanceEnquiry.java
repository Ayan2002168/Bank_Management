package com.Ayan;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class BalanceEnquiry extends JFrame implements ActionListener {
    JButton back;
    String pinNumber;
    BalanceEnquiry(String pinNumber){
        this.pinNumber=pinNumber;

        setLayout(null);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(800,800,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,800,800);
        add(image);

        back=new JButton("Back");
        back.setBounds(340,450,100,26);
        back.addActionListener(this);
        image.add(back);

        Conn c=new Conn();
        int balance = 0;
        try {
            ResultSet rs = c.s.executeQuery("select * from bank where Pin='" + pinNumber + "'");
            System.out.println("Record Exist: "+rs.next());
            while (rs.next()) {
                if (rs.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
        }catch (Exception ae){
            ae.printStackTrace();
        }
        JLabel text=new JLabel("Your current Account balance is Rs: "+balance);
        text.setBounds(145,300,250,30);
        text.setForeground(Color.WHITE);
        image.add(text);

        getContentPane().setBackground(Color.WHITE);

        setSize(600,600);
        setLocation(310,50);
        setVisible(true);
    }
    public static void main(String[] args) {
        new BalanceEnquiry("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==back){
            setVisible(false);
            new Transactions(pinNumber).setVisible(true);
        }
    }
}
