package com.example.ComputerIsSlow;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

public class SerialNumberInputWindow {

    public static void main(String[] args) {
        // Create a JFrame (window)
        JFrame frame = new JFrame("Serial Number Input");
        // Set window icon (make sure the image path is correct)
        ImageIcon icon = new ImageIcon(Window.nameICO); // Replace with your icon path
        frame.setIconImage(icon.getImage());
        // Set the window size and close operation
        frame.setSize(400, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Center the window on the screen
        frame.setLocationRelativeTo(null);
        // Create a panel to hold components
        JPanel panel = new JPanel();
        frame.add(panel);
        panel.setLayout(new FlowLayout());

        // Add a label to prompt for serial number
        JLabel label = new JLabel("輸入序號 :");
        panel.add(label);

        // Add a text field for serial number input
        JTextField serialNumberField = new JTextField(20);
        panel.add(serialNumberField);

        // Add a button to submit the serial number
        JButton submitButton = new JButton("確認序號");
        panel.add(submitButton);

        // Action listener for the submit button
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String serialNumber = serialNumberField.getText();
                if (!serialNumber.isEmpty()) {
                  
                    
                    if(serialNumber.equals("26884529"))
                    {
                    	  JOptionPane.showMessageDialog(frame, "Complete Purchase : " + serialNumber+" OK");
                    	  
                    	  
                    	  String fileName = "system.txt";  // The file you want to read
                          String content = "1";

                          try {
                              // Create a FileWriter with append set to false (to overwrite the file)
                              FileWriter writer = new FileWriter(fileName, false);
                              writer.write(content);  // Write the content to the file
                              writer.close();  // Close the writer to ensure data is saved

                              System.out.println("資料已成功寫入並覆蓋！");
                          } catch (IOException e2) {
                              e2.printStackTrace();  // Print the exception stack trace for debugging
                              JOptionPane.showMessageDialog(frame, "Error writing to file: " + e2.getMessage());
                          }
                          frame.dispose();
                    	  
                    	
                    }
                    else
                    {
                    	
                    	JOptionPane.showMessageDialog(frame, "Error Code :" + serialNumber+"");
                    	
                    }
                    
                    
                } else {
                    JOptionPane.showMessageDialog(frame, "請輸入序號!");
                }
            }
        });
        
        // Add a label to prompt for serial number
        JLabel Email = new JLabel("購買完成後 序號將寄信到您的信箱 請輸入信箱內的序號");
        panel.add(Email);
        

        // Make the window visible
        frame.setVisible(true);
    }
}
