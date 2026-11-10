import javax.swing.*;
import java.awt.event.*;

public class MyWindow {
    public static void main(String[] args) {
        JWindow window = new JWindow();
        JPanel panel = new JPanel();
        JButton closeButton = new JButton("X");
        //closeButton.setBounds(200,200,200,200);
        closeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                window.dispose();
            }
        });
        
        panel.add(closeButton);
        window.add(panel);
        window.setBounds(100,100,600,600);
        window.setVisible(true);
    }
}






