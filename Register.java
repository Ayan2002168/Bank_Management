package com.Ayan;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import com.toedter.calendar.JDateChooser;
public class Register extends JFrame implements ActionListener {
    long random;
    JTextField nameField, fnameField, mailField, addField, cityField, pinField, stateField;
    JButton next;
    JRadioButton student, male, female, married, Unmarried;
    JDateChooser dateChooser;

    Register() {
        setLayout(null);

        Random ran = new Random();
        random = Math.abs(ran.nextLong() % 9000) + 1000L;

        JLabel formNo = new JLabel("Application No.: " + random);
        formNo.setBounds(260, 20, 600, 40);
        formNo.setFont(new Font("Osward", Font.BOLD, 30));
        add(formNo);

        JLabel personal = new JLabel("Page1: Personal Details");
        personal.setBounds(300, 80, 400, 30);
        personal.setFont(new Font("Osward", Font.BOLD, 20));
        add(personal);

        JLabel name = new JLabel("Name:");
        name.setBounds(100, 150, 400, 20);
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        add(name);

        nameField = new JTextField();
        nameField.setBounds(300, 150, 300, 25);
        add(nameField);

        JLabel fname = new JLabel("Fathers Name:");
        fname.setBounds(100, 200, 200, 20);
        fname.setFont(new Font("Raleway", Font.BOLD, 20));
        add(fname);

        fnameField = new JTextField();
        fnameField.setBounds(300, 200, 300, 25);
        add(fnameField);

        JLabel dob = new JLabel("Date of Birth:");
        dob.setBounds(100, 250, 200, 20);
        dob.setFont(new Font("Raleway", Font.BOLD, 20));
        add(dob);

        dateChooser = new JDateChooser();
        dateChooser.setBounds(300, 250, 300, 25);
        add(dateChooser);

        JLabel gender = new JLabel("Gender:");
        gender.setBounds(100, 300, 200, 20);
        gender.setFont(new Font("Raleway", Font.BOLD, 20));
        add(gender);

        male = new JRadioButton("Male");
        male.setBounds(300, 300, 70, 30);
        male.setBackground(Color.white);
        add(male);

        female = new JRadioButton("Female");
        female.setBounds(400, 300, 70, 30);
        female.setBackground(Color.white);
        add(female);

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);

        JLabel email = new JLabel("Email Address:");
        email.setBounds(100, 350, 200, 20);
        email.setFont(new Font("Raleway", Font.BOLD, 20));
        add(email);

        mailField = new JTextField();
        mailField.setBounds(300, 350, 300, 25);
        add(mailField);

        JLabel marital = new JLabel("Marital Status:");
        marital.setBounds(100, 400, 200, 20);
        marital.setFont(new Font("Raleway", Font.BOLD, 20));
        add(marital);

        married = new JRadioButton("Married");
        married.setBounds(300, 400, 100, 30);
        married.setBackground(Color.white);
        add(married);

        Unmarried = new JRadioButton("Unmarried");
        Unmarried.setBounds(450, 400, 100, 30);
        Unmarried.setBackground(Color.white);
        add(Unmarried);

        student = new JRadioButton("Student");
        student.setBounds(600, 400, 100, 30);
        student.setBackground(Color.white);
        add(student);

        ButtonGroup status = new ButtonGroup();
        status.add(married);
        status.add(Unmarried);
        status.add(student);

        JLabel address = new JLabel("Address:");
        address.setBounds(100, 450, 200, 20);
        address.setFont(new Font("Raleway", Font.BOLD, 20));
        add(address);

        addField = new JTextField();
        addField.setBounds(300, 450, 300, 25);
        add(addField);

        JLabel city = new JLabel("City:");
        city.setBounds(100, 500, 200, 23);
        city.setFont(new Font("Raleway", Font.BOLD, 20));
        add(city);

        cityField = new JTextField();
        cityField.setBounds(300, 500, 300, 25);
        add(cityField);

        JLabel pin = new JLabel("Pin Code:");
        pin.setBounds(100, 550, 200, 20);
        pin.setFont(new Font("Raleway", Font.BOLD, 20));
        add(pin);

        pinField = new JTextField();
        pinField.setBounds(300, 550, 300, 25);
        add(pinField);

        JLabel state = new JLabel("State:");
        state.setBounds(100, 600, 200, 20);
        state.setFont(new Font("Raleway", Font.BOLD, 20));
        add(state);

        stateField = new JTextField();
        stateField.setBounds(300, 600, 300, 25);
        add(stateField);

        next = new JButton("Next");
        next.setBounds(620, 660, 70, 30);
        next.setBackground(Color.BLACK);
        next.setForeground(Color.blue);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.WHITE);

        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String formNo = " " + random;
        String name = nameField.getText();
        String fname = fnameField.getText();
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if (male.isSelected()) {
            gender = "Male";
        } else if (female.isSelected()) {
            gender = "Female";
        }
        String email = mailField.getText();
        String status = null;
        if (married.isSelected()) {
            status = "Married";
        } else if (Unmarried.isSelected()) {
            status = "Unmarried";
        } else if (student.isSelected()) {
            status = "Student";
        }
        String add = addField.getText();
        String city = cityField.getText();
        String pin = pinField.getText();
        String state = stateField.getText();

        try {
            if (name.equals("")) {
                JOptionPane.showMessageDialog(null, "Name required");
            } else if (fname.equals("")) {
                JOptionPane.showMessageDialog(null, "Name required");
            } else if (dob.equals("")) {
                JOptionPane.showMessageDialog(null, "Date Required");
            }
            else {
                Conn c=new Conn();
                String query ="insert into signup values('"+formNo+"', '"+name+"', '"+fname+"', '"+dob+"', '"+gender+"', '"+email+"', '"+status+"', '"+add+"', '"+city+"', '"+pin+"', '"+state+"')";
                c.s.executeUpdate(query);
                setVisible(false);
               new SignUp(formNo).setVisible(true);
            }
        }
        catch (Exception ae) {
            System.out.println(ae);
        }
    }
        public static void main (String[]args){
            new Register();
        }

}


