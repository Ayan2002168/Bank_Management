package com.Ayan;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.sql.ResultSet;

public class FastCash extends JFrame implements ActionListener {
    JButton deposit,withdrawal,fastcash,ministatement,pin,enquiry,back;
    String pinNumber;
    FastCash(String pinNumber){
        this.pinNumber=pinNumber;
        setLayout(null);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(800,800,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,800,800);
        add(image);

        JLabel text=new JLabel("Select Withdrawal amount:");
        text.setBounds(185,280,300,30);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Releway",Font.BOLD,16));
        image.add(text);

        deposit=new JButton("Rs 100");
        deposit.setBounds(150,370,100,26);
        deposit.addActionListener(this);
        image.add(deposit);

        withdrawal=new JButton("Rs 500");
        withdrawal.setBounds(300,370,150,26);
        withdrawal.addActionListener(this);
        image.add(withdrawal);

        fastcash=new JButton("Rs 1000");
        fastcash.setBounds(150,400,100,26);
        fastcash.addActionListener(this);
        image.add(fastcash);

        ministatement=new JButton("Rs 2000");
        ministatement.setBounds(300,400,150,26);
        ministatement.addActionListener(this);
        image.add(ministatement);

        pin=new JButton("Rs 5000");
        pin.setBounds(150,430,100,26);
        pin.addActionListener(this);
        image.add(pin);

        enquiry=new JButton("Rs 10000");
        enquiry.setBounds(300,430,150,26);
        enquiry.addActionListener(this);
        image.add(enquiry);

        back=new JButton("Back");
        back.setBounds(150,460,100,26);
        back.addActionListener(this);
        image.add(back);

        setSize(800,800);
        setLocation(300,0);
//        setUndecorated(true);
        setVisible(true);
    }

    public static void main(String[] args) {
        new FastCash("");
    }
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==back){
            setVisible(false);
            new Transactions(pinNumber).setVisible(true);
        } else{
           String amount=((JButton)e.getSource()).getText().substring(3);
           Conn c=new Conn();
           try {
               ResultSet rs=c.s.executeQuery("select * from bank where Pin='"+pinNumber+"'");
               int balance=0;
               while (rs.next()){
                   if(rs.getString("type").equals("Deposit")){
                       balance +=Integer.parseInt(rs.getString("amount"));
                   }else{
                       balance -=Integer.parseInt(rs.getString("amount"));
                   }
               }
               if(e.getSource()!=back && balance<Integer.parseInt(amount)){
                   JOptionPane.showMessageDialog(null,"Insufficient balance");
                   return;
               }
               Date date=new Date();
               String query="insert into bank values('"+pinNumber+"', '"+date+"', 'Withdraw','"+amount+"')";
               c.s.executeUpdate(query);
               JOptionPane.showMessageDialog(null,"Amount Debited Successfully");
               setVisible(false);
               new Transactions(pinNumber).setVisible(true);
           }catch (Exception ae){
               ae.printStackTrace();
           }


//        } else if (e.getSource()==withdrawal) {
//            setVisible(false);
//            new withdrawal(pinNumber).setVisible(true);

        }


    }
}
