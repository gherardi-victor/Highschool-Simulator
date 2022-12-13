import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Button {
    public static int y = 20;
    public static Container container;

    public static JButton crea(String text){
        JButton button = new JButton(text);
        button.setBounds(20, Button.y, Display.PANEL_WIDTH - 40, 50);
        button.setFont(new Font("Helvetica Neue", Font.BOLD, 20));
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setEnabled(false);
        Button.y += 70;
        return button;
    }
}
