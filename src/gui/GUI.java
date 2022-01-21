/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.System.exit;
import java.nio.charset.Charset;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author Luxin
 */
public class GUI implements ActionListener {

        private int count = 0;
        private JLabel label;
        private JFrame frame;
        private JPanel panel;
    
    public GUI() {
        
        JButton button = new JButton("generate Password");
        button.addActionListener(this);
       
        frame = new JFrame();
        
        panel = new JPanel();
        
        label = new JLabel("output", SwingConstants.CENTER);
        
        
        panel.setBorder(BorderFactory.createEmptyBorder(100, 100, 25, 100));
        panel.setLayout(new GridLayout(0, 1));
        panel.add(button);
        panel.add(label);
        
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.RED);
        frame.setTitle("Counter");
        frame.pack();
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        
        new GUI();
        
    }
        public void actionPerformed(ActionEvent e) {
        count++;
        //label.setText("Number of clicks: " + count);
        if(count == 1) {
            String s = passowrdGenerator();
            label.setText("Your password is " + s );
        }
        if(count == 2) 
            exit(0);
        
    }
    
    
    public static String passwordGenerator() {
        //StringBuffer passowrd = new StringBuffer();
        byte[] array = new byte[16]; // length is bounded by 16
    new Random().nextBytes(array);
    String generatedString = new String(array, Charset.forName("ASCII"));
        return generatedString;
    }

    private String passowrdGenerator() {
     int n = 16;
     byte[] array = new byte[256];
        new Random().nextBytes(array);
  
        String randomString
            = new String(array, Charset.forName("UTF-8"));
  
        // Create a StringBuffer to store the result
        StringBuffer r = new StringBuffer();
  
        // Append first 20 alphanumeric characters
        // from the generated random String into the result
        for (int k = 0; k < randomString.length(); k++) {
  
            char ch = randomString.charAt(k);
  
            if (((ch >= 'a' && ch <= 'z')
                 || (ch >= 'A' && ch <= 'Z')
                 || (ch >= '0' && ch <= '9'))
                && (n > 0)) {
  
                r.append(ch);
                n--;
            }
        }
  
        // return the resultant string
        return r.toString();
    }
}