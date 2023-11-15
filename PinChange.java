package com.Ayan;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PinChange extends JFrame implements ActionListener {
    JPasswordField ptext,rptextField;
    JButton change,back;
    String pinNumber;
    PinChange(String pinNumber){
        this.pinNumber=pinNumber;
        setLayout(null);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(800,800,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,800,800);
        add(image);

        JLabel text=new JLabel("Change your PIN");
        text.setBounds(230,280,300,30);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Releway",Font.BOLD,16));
        image.add(text);

        JLabel pintext=new JLabel("New PIN");
        pintext.setBounds(145,330,120,20);
        pintext.setForeground(Color.WHITE);
        pintext.setFont(new Font("Releway",Font.BOLD,16));
        image.add(pintext);

        ptext=new JPasswordField();
        ptext.setBounds(280,330,100,20);
        add(ptext);

        JLabel rptext=new JLabel("Re-Enter PIN");
        rptext.setBounds(145,370,120,20);
        rptext.setForeground(Color.WHITE);
        rptext.setFont(new Font("Releway",Font.BOLD,16));
        image.add(rptext);

        rptextField=new JPasswordField();
        rptextField.setBounds(280,370,100,20);
        add(rptextField);

        change=new JButton("Change");
        change.setBounds(340,450,100,26);
        change.addActionListener(this);
        image.add(change);

        back=new JButton("Back");
        back.setBounds(160,450,100,26);
        back.addActionListener(this);
        image.add(back);

        setSize(800,800);
        setLocation(300,0);
        setVisible(true);

    }
    public static void main(String[] args) {
        new PinChange("").setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==change) {
            try {
                String nPin = ptext.getText();
                String rPin = rptextField.getText();
                if (!nPin.equals(rPin)) {
                    JOptionPane.showMessageDialog(null, "Entered PIN does not match");
                }
                if(nPin.equals("")){
                    JOptionPane.showMessageDialog(null,"Enter new PIN");
                }
                if(rPin.equals("")){
                    JOptionPane.showMessageDialog(null,"Enter Re-enter PIN");
                }
                Conn c=new Conn();
                c.s.executeUpdate("update bank set Pin='"+rPin+"' where Pin='"+pinNumber+"'");
                c.s.executeUpdate("update login set Pinno='"+rPin+"' where Pinno='"+pinNumber+"'");
                c.s.executeUpdate("update signup3 set Pinno='"+rPin+"' where Pinno='"+pinNumber+"'");

                JOptionPane.showMessageDialog(null,"PIN changed Successfully");
                setVisible(false);
                new Transactions(pinNumber).setVisible(true);
            } catch (Exception ae) {
                ae.printStackTrace();
            }
        }
        else {
            setVisible(false);
            new Transactions(pinNumber).setVisible(true);
        }

    }
}
