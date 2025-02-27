package com.example.ComputerIsSlow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Window extends JPanel {

    static String name = "image.wise.🗂️/DLSclose.jpg"; // For the application icon path
    public static String nameICO = "image.wise.🗂️/14.png"; // For the application icon path (use simpler path)
    static String WindowwICO = "image.wise.🗂️/14.png"; // For the application icon path (use simpler path)

    public static void main(String[] args) {
        // Run GUI in the Event Dispatch Thread for thread safety
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // Step 1: Create the JFrame and set basic properties
                JFrame frame = new JFrame("View Model");
                frame.setLayout(new BorderLayout());

                // Set window size and position
                frame.setSize(1000, 800);
                frame.setLocationRelativeTo(null); // Center the window
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                // Log to confirm frame setup
                System.out.println("Frame properties set...");

                // Fix: Load the icon image
                try {
                    BufferedImage transparentImage = ImageIO.read(new File(WindowwICO)); // Correct way to load the image
                    ImageIcon transparentIcon = new ImageIcon(transparentImage);
                    frame.setIconImage(transparentIcon.getImage());  // Set the window icon image
                } catch (IOException e) {
                    System.out.println("Error loading icon image: " + e.getMessage());
                }

                // Step 2: Set the background color to black
                frame.getContentPane().setBackground(Color.BLACK); // Set background color

                // Step 3: Create a panel with gradient background (optional)
                JPanel panel = new JPanel() {
                    @Override
                    protected void paintComponent(Graphics g) {
                        super.paintComponent(g);
                        Graphics2D g2d = (Graphics2D) g;
                        GradientPaint gradient = new GradientPaint(0, 0, new Color(50, 50, 50), getWidth(), getHeight(), new Color(80, 80, 80));
                        g2d.setPaint(gradient);
                        g2d.fillRect(0, 0, getWidth(), getHeight());
                    }
                };
                panel.setLayout(new BorderLayout());

                // Step 4: Create a label for typing effect
                JLabel typingLabel = new JLabel("", JLabel.LEFT);
                typingLabel.setFont(new Font("Segoe UI", Font.PLAIN, 18));
                typingLabel.setForeground(Color.WHITE); // White text for dark background
                typingLabel.setVerticalAlignment(SwingConstants.TOP);
                typingLabel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
                typingLabel.setText("<html></html>");

                // Step 5: Add the label inside a scroll pane
                JScrollPane scrollPane = new JScrollPane(typingLabel);
                scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
                scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
                scrollPane.getVerticalScrollBar().setPreferredSize(new Dimension(0, 0)); // Hide scrollbars
                scrollPane.getHorizontalScrollBar().setPreferredSize(new Dimension(0, 0)); // Hide scrollbars
                scrollPane.setBackground(new Color(50, 50, 50)); // Set scrollPane background
                typingLabel.setBackground(new Color(50, 50, 50)); // Set label background
                typingLabel.setOpaque(true); // Make label opaque to show background color

                // Step 6: Add scroll pane to the panel
                panel.add(scrollPane, BorderLayout.CENTER);

                // Step 7: Create a "closure" button to close the window
                JButton closureButton = new JButton("Closure");

                // Load and resize the ICO file as the icon
                ImageIcon icon = new ImageIcon(nameICO); // Load the ICO file
                Image img = icon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH); // Resize the icon
                closureButton.setIcon(new ImageIcon(img)); // Set the resized icon on the button

                closureButton.setFont(new Font("Courier New", Font.BOLD, 20));
                closureButton.setBackground(new Color(34, 139, 34)); // Green color for the button
                closureButton.setForeground(Color.WHITE);
                closureButton.setFocusPainted(false);
                closureButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
                closureButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
                closureButton.setPreferredSize(new Dimension(200, 40));

                // Button hover effect
                closureButton.addMouseListener(new java.awt.event.MouseAdapter() {
                    @Override
                    public void mouseEntered(java.awt.event.MouseEvent evt) {
                        closureButton.setBackground(new Color(50, 205, 50)); // Lighter green on hover
                    }

                    @Override
                    public void mouseExited(java.awt.event.MouseEvent evt) {
                        closureButton.setBackground(new Color(34, 139, 34)); // Reset to original green
                    }
                });

                // Action listener for the button (close the window)
                closureButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        frame.dispose(); // Close the window
                    }
                });

                // Step 8: Add the closure button to the bottom of the panel
                panel.add(closureButton, BorderLayout.SOUTH);
                panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Padding around the panel

                // Step 9: Add the panel to the frame
                frame.add(panel, BorderLayout.CENTER);

                // Log to confirm everything is set up
                System.out.println("Panel and components added to frame...");

                // Step 10: Display the frame
                frame.setVisible(true); // This is where the window should become visible
                System.out.println("Frame visible...");

                // Ensure command-line arguments are passed
                if (args.length == 0) {
                    System.out.println("No input provided. Please provide text as command-line arguments.");
                    return;
                }

                // Use command-line arguments as the message lines
                String[] messageLines = args;

                // Add extra empty lines for spacing
                String[] newLines = {"\n", "\n"};
                String[] updatedMessageLines = new String[messageLines.length + newLines.length];
                System.arraycopy(messageLines, 0, updatedMessageLines, 0, messageLines.length);
                System.arraycopy(newLines, 0, updatedMessageLines, messageLines.length, newLines.length);
                messageLines = updatedMessageLines;

                // Step 11: Set up a timer to simulate typing effect
                Timer timer = new Timer(100, new ActionListener() {
                    int lineIndex = 0;
                    String displayedText = "<html>";

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (lineIndex < updatedMessageLines.length) {
                            String currentLine = updatedMessageLines[lineIndex];
                            displayedText += currentLine + "<br>";
                            typingLabel.setText(displayedText + "</html>");

                            // Scroll to the bottom of the scroll pane
                            JScrollBar verticalBar = scrollPane.getVerticalScrollBar();
                            verticalBar.setValue(verticalBar.getMaximum()); // Scroll to the bottom

                            lineIndex++;
                        } else {
                            // Stop the timer once all lines are displayed
                            ((Timer) e.getSource()).stop();
                        }
                    }
                });

                // Start the timer
                timer.start();
            }
        });
    }
}
