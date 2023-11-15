package com.Ayan;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class withdrawal extends JFrame implements ActionListener {
    JTextField t1;
    JButton withdraw,back;
    String pinNumber;
    withdrawal(String pinNumber){
        this.pinNumber=pinNumber;

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(800,800,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,800,800);
        add(image);

        JLabel l1=new JLabel("Enter the amount to Withdraw: ");
        l1.setBounds(185,250,300,30);
        l1.setFont(new Font("Raleway",Font.BOLD,16));
        l1.setForeground(Color.WHITE);
        image.add(l1);

        t1=new JTextField();
        t1.setBounds(185,290,220,30);
        image.add(t1);

        withdraw=new JButton("Withdraw");
        withdraw.setBounds(340,415,100,26);
        withdraw.addActionListener(this);
        image.add(withdraw);

        back = new JButton("Back");
        back.setBounds(140,415,100,26);
        back.addActionListener(this);
        image.add(back);

        setSize(800,800);
        setLocation(300,0);
        setVisible(true);
    }
    public static void main(String[] args) {
        new withdrawal("");
    }
    public void actionPerformed(ActionEvent e) {
        try {

            String amount=t1.getText();
            Date date=new Date();
            if(e.getSource()==withdraw) {
                if (t1.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Please enter the amount you want to Withdraw");
                }else {
                    Conn c=new Conn();
                    c.s.executeUpdate("insert into bank values('"+pinNumber+"','"+date+"','Withdraw','"+amount+"')");
                    JOptionPane.showMessageDialog(null,"Rs. "+amount+" Withdrawal Successfully");
                    setVisible(false);
                    new Transactions(pinNumber).setVisible(true);
                }

            } else if (e.getSource()==back) {
                setVisible(false);
                new Transactions(pinNumber).setVisible(true);
            }
        }catch (Exception ae){
            ae.printStackTrace();
        }

    }
}
