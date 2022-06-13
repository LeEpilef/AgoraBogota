/**
 *
 */
package GUI;

import businessLogic.EventManager;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * @author Felipe Páez González
 *
 */
public class LogIn {
    JFrame frame;
    JPanel contentOanel;
    JButton userButton;
    JLabel label;
    JButton adminBoutton;
    JButton exitButton;
    JLabel tittleLabel;
    public boolean admin;

    public LogIn(EventManager manager) {
        frame = new JFrame();
        frame.setUndecorated(true);
        frame.getContentPane().setBackground(new Color(0, 100, 0));
        frame.getContentPane().setForeground(new Color(0, 100, 0));
        //frame.setType(Window.Type.UTILITY);
        frame.setBackground(new Color(0, 100, 0));
        frame.setTitle("Agora_LogIn");
        frame.setResizable(false);
        frame.setBounds(100, 100, 250, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout(0, 0));

        this.contentOanel = new JPanel();
        frame.getContentPane().add(contentOanel, BorderLayout.CENTER);
        contentOanel.setLayout(null);

        this.label = new JLabel("INGRESAR");
        label.setForeground(new Color(255, 255, 255));
        label.setFont(new Font("Roboto Black", Font.BOLD, 18));
        label.setBounds(75, 65, 100, 14);
        label.setHorizontalAlignment(SwingConstants.CENTER);

        this.userButton = new JButton("Usuario");
        userButton.setBorderPainted(false);
        userButton.setBorder(null);
        userButton.setBackground(new Color(154, 205, 50));
        userButton.setForeground(new Color(255, 255, 255));
        userButton.setFont(new Font("Roboto", Font.PLAIN, 16));
        userButton.setBounds(75, 95, 100, 30);
        userButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame mainFrame = new MainFrame(manager, false);
                frame.setVisible(false);
            }
        });

        this.adminBoutton = new JButton("Administrador");
        adminBoutton.setBackground(new Color(255, 255, 255));
        adminBoutton.setBorderPainted(false);
        adminBoutton.setFont(new Font("Roboto", Font.PLAIN, 16));
        adminBoutton.setForeground(new Color(154, 205, 50));
        adminBoutton.setBorder(null);
        adminBoutton.setBounds(61, 135, 114, 30);
        adminBoutton.setAlignmentX(Component.CENTER_ALIGNMENT);
        adminBoutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame mainFrame = new MainFrame(manager, true);
                frame.setVisible(false);
            }
        });

        this.exitButton = new JButton("Salir");
        exitButton.setBackground(new Color(154, 205, 50));
        exitButton.setForeground(new Color(255, 255, 255));
        exitButton.setBorder(null);
        exitButton.setBorderPainted(false);
        exitButton.setFont(new Font("Roboto", Font.PLAIN, 16));
        exitButton.setBounds(75, 175, 100, 30);
        contentOanel.setLayout(null);
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }});

        this.tittleLabel = new JLabel("Agora_LogIn");
        tittleLabel.setFont(new Font("Roboto", Font.BOLD, 11));
        tittleLabel.setForeground(UIManager.getColor("Button.light"));
        tittleLabel.setBounds(10, 0, 70, 22);

        JLabel backgroundLabel = new JLabel("");
        backgroundLabel.setIcon(new ImageIcon("image/backgrond.png"));
        backgroundLabel.setBounds(0, 0, 250, 250);

        contentOanel.add(tittleLabel);
        contentOanel.add(userButton);
        contentOanel.add(adminBoutton);
        contentOanel.add(label);
        contentOanel.add(exitButton);
        contentOanel.add(backgroundLabel);

        frame.setVisible(true);
    }

    private boolean getAdmin(){return admin;}
}
