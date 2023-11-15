package com.Ayan;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Transactions extends JFrame implements ActionListener {
    JButton deposit,withdrawal,fastcash,ministatement,pin,enquiry,exit;
    String pinNumber;
    Transactions(String pinNumber){
        this.pinNumber=pinNumber;
        setLayout(null);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(800,800,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,800,800);
        add(image);

        JLabel text=new JLabel("Please select your Transaction");
        text.setBounds(185,280,300,30);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Releway",Font.BOLD,16));
        image.add(text);

        deposit=new JButton("Deposit");
        deposit.setBounds(150,370,100,26);
        deposit.addActionListener(this);
        image.add(deposit);

        withdrawal=new JButton("Cash Withdrawal");
        withdrawal.setBounds(300,370,150,26);
        withdrawal.addActionListener(this);
        image.add(withdrawal);

        fastcash=new JButton("Fast Cash");
        fastcash.setBounds(150,400,100,26);
        fastcash.addActionListener(this);
        image.add(fastcash);

        ministatement=new JButton("Mini Statement");
        ministatement.setBounds(300,400,150,26);
        image.add(ministatement);

        pin=new JButton("PIN change");
        pin.setBounds(150,430,100,26);
        pin.addActionListener(this);
        image.add(pin);

        enquiry=new JButton("Balance Enquiry");
        enquiry.setBounds(300,430,150,26);
        enquiry.addActionListener(this);
        image.add(enquiry);

        exit=new JButton("Exit");
        exit.setBounds(150,460,100,26);
        exit.addActionListener(this);

        image.add(exit);

        setSize(800,800);
        setLocation(300,0);
//        setUndecorated(true);
        setVisible(true);
    }
    public static void main(String[] args) {
        new Transactions("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==exit){
            setVisible(false);
        } else if (e.getSource()==deposit) {
            setVisible(false);
            new deposit(pinNumber).setVisible(true);

        } else if (e.getSource()==withdrawal) {
            setVisible(false);
            new withdrawal(pinNumber).setVisible(true);

        } else if (e.getSource()==fastcash) {
            setVisible(false);
            new FastCash(pinNumber).setVisible(true);

        } else if (e.getSource()==pin) {
            setVisible(false);
            new PinChange(pinNumber).setVisible(true);
        }
        else if (e.getSource()==enquiry) {
            setVisible(false);
            new BalanceEnquiry(pinNumber).setVisible(true);
        }




    }
}
