package com.Ayan;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUp extends JFrame implements ActionListener {

    JButton next;
    JTextField panField,aadhaarField;
    JRadioButton yes,no,yes1,no1;
    JComboBox<String > rel,cat,income1,education,occupation;
    String formNo;

    SignUp(String formNo){
        this.formNo=formNo;
        setLayout(null);
        JLabel additional=new JLabel("Page 2:Additional Details");
        additional.setBounds(270, 70, 600, 40);
        additional.setFont(new Font("Osward", Font.BOLD, 27));
        add(additional);

        JLabel religion=new JLabel("Religion:");
        religion.setBounds(100, 150, 400, 25);
        religion.setFont(new Font("Raleway", Font.BOLD, 20));
        add(religion);

        String[] valReligion ={"Hindu","Muslim","Sikh","Christian"};
        rel=new JComboBox<>(valReligion);
        rel.setBounds(300, 150, 300, 25);
        rel.setBackground(Color.WHITE);
        add(rel);

        JLabel category=new JLabel("Category:");
        category.setBounds(100, 200, 400, 25);
        category.setFont(new Font("Raleway", Font.BOLD, 20));
        add(category);

        String[] valCategory ={"General","SC","ST","OBC","Others"};
        cat=new JComboBox<>(valCategory);
        cat.setBounds(300, 200, 300, 25);
        cat.setBackground(Color.WHITE);
        add(cat);

        JLabel income=new JLabel("Income:");
        income.setBounds(100, 250, 400, 25);
        income.setFont(new Font("Raleway", Font.BOLD, 20));
        add(income);

        String[] incomeCategory ={"Null","<150000","<250000","<500000","Upto 1000000"};
        income1=new JComboBox<>(incomeCategory);
        income1.setBounds(300, 250, 300, 25);
        income1.setBackground(Color.WHITE);
        add(income1);

        JLabel edu=new JLabel("Educational:");
        edu.setBounds(100, 300, 400, 25);
        edu.setFont(new Font("Raleway", Font.BOLD, 20));
        add(edu);
        JLabel qual=new JLabel("Qualification");
        qual.setBounds(100, 320, 400, 25);
        qual.setFont(new Font("Raleway", Font.BOLD, 20));
        add(qual);

        String[] eduValues ={"HighSchool","Graduate","PostGraduation","Phd"};
        education=new JComboBox<>(eduValues);
        education.setBounds(300, 300, 300, 25);
        education.setBackground(Color.WHITE);
        add(education);

        JLabel ocup=new JLabel("Occupation:");
        ocup.setBounds(100, 370, 400, 25);
        ocup.setFont(new Font("Raleway", Font.BOLD, 20));
        add(ocup);

        String[] ocupationValues ={"Self-Employed","Business","Government Job","Student"};
        occupation=new JComboBox<>(ocupationValues);
        occupation.setBounds(300, 370, 300, 25);
        occupation.setBackground(Color.WHITE);
        add(occupation);

        JLabel pan=new JLabel("PAN Number:");
        pan.setBounds(100, 420, 400, 25);
        pan.setFont(new Font("Raleway", Font.BOLD, 20));
        add(pan);

        panField=new JTextField();
        panField.setBounds(300,420,300,25);
        panField.setBackground(Color.WHITE);
        add(panField);

        JLabel aadhaar=new JLabel("Aadhaar Number:");
        aadhaar.setBounds(100, 470, 400, 25);
        aadhaar.setFont(new Font("Raleway", Font.BOLD, 20));
        add(aadhaar);

        aadhaarField=new JTextField();
        aadhaarField.setBounds(300,470,300,25);
        aadhaarField.setBackground(Color.WHITE);
        add(aadhaarField);

        JLabel citizen=new JLabel("Senior Citizen");
        citizen.setBounds(100, 520, 400, 25);
        citizen.setFont(new Font("Raleway", Font.BOLD, 20));
        add(citizen);

        yes =new JRadioButton("Yes");
        yes.setBounds(300,520,70,25);
        yes.setBackground(Color.WHITE);
        add(yes);

        no =new JRadioButton("No");
        no.setBounds(450,520,70,25);
        no.setBackground(Color.WHITE);
        add(no);

        ButtonGroup citizenField=new ButtonGroup();
        citizenField.add(yes);
        citizenField.add(no);

        JLabel act=new JLabel("Existing Account:");
        act.setBounds(100, 570, 400, 25);
        act.setFont(new Font("Raleway", Font.BOLD, 20));
        add(act);

        yes1 =new JRadioButton("Yes");
        yes1.setBounds(300,570,70,25);
        yes1.setBackground(Color.WHITE);
        add(yes1);

        no1 =new JRadioButton("No");
        no1.setBounds(450,570,70,25);
        no1.setBackground(Color.WHITE);
        add(no1);

        ButtonGroup existingField=new ButtonGroup();
        existingField.add(no1);
        existingField.add(yes1);

        next = new JButton("Next");
        next.setBounds(620, 660, 70, 30);
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        add(next);


        getContentPane().setBackground(Color.WHITE);

        setSize(850,800);
        setVisible(true);
        setLocation(350,10);

    }
    public static void main(String[] args) {
        new SignUp("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String sreligion = (String) rel.getSelectedItem();
        String scategory = (String) cat.getSelectedItem();
        String sincome = (String)income1.getSelectedItem();
        String seducation = (String)education.getSelectedItem();
        String soccupation = (String)occupation.getSelectedItem();
        String citizen=null;
        String exist=null;
        if (yes.isSelected()) {
            citizen = "Yes";
        } else if (no.isSelected()) {
            citizen = "NO";
        }
        if (yes1.isSelected()){
            exist="Yes";
        } else if (no1.isSelected()) {
            exist="No";
        }
        String epan = panField.getText();
        String eaadhaar=aadhaarField.getText();
        try {
            Conn c=new Conn();
            String query ="insert into signup2 values('"+formNo+"', '"+sreligion+"', '"+scategory+"', '"+sincome+"', '"+seducation+"', '"+soccupation+"','"+epan+"', '"+eaadhaar+"' ,'"+citizen+"', '"+exist+"' )";
            c.s.executeUpdate(query);
            setVisible(false);
            new SignUp2(formNo).setVisible(true);

        }catch (Exception ae){
            System.out.println(ae);
        }
    }
}
