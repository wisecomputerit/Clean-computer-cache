package com.example.ComputerIsSlow;
import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;

public class WindowWithInput {

    public static void main(String[] args) {
        // Create a frame for the window
        JFrame frame = new JFrame("Wise CUCIS");

        // Set window icon (make sure the image path is correct)
        ImageIcon icon = new ImageIcon(Window.nameICO); // Replace with your icon path
        frame.setIconImage(icon.getImage());

        // Set the window size
        frame.setSize(450, 350); // Increased size to accommodate new label

        // Set the default close operation
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Center the window on the screen
        frame.setLocationRelativeTo(null);

        // Set a modern layout for the window using GridBagLayout for a responsive design
        frame.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Add padding between components

        // Create a label to prompt the user for a URL
        JLabel label = new JLabel("開始定期清理電腦上快取 每一秒 清除");
        label.setFont(new Font("Microsoft YaHei", Font.PLAIN, 14));
        gbc.gridx = 0;
        gbc.gridy = 0;
        frame.add(label, gbc);

       

        // Create a button that the user can click to submit the URL
        JButton submitButton = new JButton("開始");
        submitButton.setFont(new Font("Microsoft YaHei", Font.BOLD, 14));
        submitButton.setBackground(new Color(100, 150, 255)); // Light blue background
        submitButton.setForeground(Color.WHITE); // White text color
        submitButton.setFocusPainted(false); // Remove focus border
        submitButton.setPreferredSize(new Dimension(120, 40));

        // Add an action listener to the submit button
        submitButton.addActionListener(e -> {
            String fileName = "system.txt";  // The file you want to read
            String content = readFromFile(fileName).trim();  // Read and trim the content
            
            try {
                // Parse the content to integer
                int number = Integer.parseInt(content); 

                if (number == 1) {
                 

                   
                    // Call your GitHubRepositoryDownloader main method (ensure it’s static)
   
                    App.Timer_main();
                    
                 
                } else if (number == 0) {
                    JOptionPane.showMessageDialog(frame, "請前往購買", 
                        "Library Information", 
                        JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(frame, "錯誤", 
                        "Error", 
                        JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Invalid format in system.txt. Please ensure it contains a valid integer.", 
                    "Error", 
                    JOptionPane.ERROR_MESSAGE);
            }
        });

        // Position the submit button on the frame
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 1; // Reset the gridspan
        frame.add(submitButton, gbc);

        // Add a label to indicate that the file will be on the desktop
        JLabel desktopLabel = new JLabel("下方綠界開始購買");
        desktopLabel.setFont(new Font("Microsoft YaHei", Font.PLAIN, 14));
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 3; // Span across all columns
        frame.add(desktopLabel, gbc);
        
        //--------------------------------------------------------------------//
        
        // Create a button that the user can click to submit the URL
        JButton buyButton = new JButton("綠界購買");
        buyButton.setFont(new Font("Microsoft YaHei", Font.BOLD, 14));
        
        buyButton.setBounds(0, 0, 200, 100);
        buyButton.setBackground(new Color(100, 150, 255)); // Light blue background
        buyButton.setForeground(Color.WHITE); // White text color
        buyButton.setFocusPainted(false); // Remove focus border
        buyButton.setPreferredSize(new Dimension(120, 40));

        buyButton.addActionListener(e -> {
            // Handle Buy button logic here (if any)
        	try {
                // 創建一個 URI 物件，指定微軟的網站 URL
                URI uri = new URI("https://p.ecpay.com.tw/0D40644");

                // 檢查系統是否支持 Desktop 功能
                if (Desktop.isDesktopSupported()) {
                    // 使用 Desktop 打開默認瀏覽器
                    Desktop.getDesktop().browse(uri);
                } else {
                    System.out.println("Desktop is not supported on this system.");
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        	//https://p.ecpay.com.tw/2BB0244
        	SerialNumberInputWindow.main(null);
        	
        });

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 3; // Span across all columns
        frame.add(buyButton, gbc);

        // Make the window visible
        frame.setVisible(true);
    }

    public static String readFromFile(String fileName) {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");  // Append each line
            }
        } catch (IOException e) {
            e.printStackTrace();  // Handle IOExceptions
        }
        return content.toString();  // Return the file content as a string
    }
}
