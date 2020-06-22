package spring.a03;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;

public class IoC {

    public static void main(String[] args) {

        JFrame jFrame = new JFrame("Best application");
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setSize(300, 200);
        jFrame.setLocationByPlatform(true);

        JPanel jPanel = new JPanel();
        jPanel.setLayout(new FlowLayout());
        JButton button = new JButton("What's time?");

        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JDialog jDialog = new JDialog();
                jDialog.setTitle("Dialog");
                jDialog.setSize(250, 100);
                jDialog.add(new Label("Now is: " + LocalDateTime.now().toString()));
                jDialog.setLocationRelativeTo(jFrame);
                jDialog.setVisible(true);
            }
        };

        button.addActionListener(actionListener);

        jPanel.add(button);
        jFrame.setContentPane(jPanel);

        jFrame.setVisible(true);
    }
}
