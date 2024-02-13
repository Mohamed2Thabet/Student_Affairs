import javax.swing.*;
import java.awt.*;

public class Image extends JPanel {
    private ImageIcon imageIcon;

    public Image() {
        this.setLayout(null);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponents(g);

        imageIcon = new ImageIcon(getClass().getResource("Staff.png"));
        imageIcon.paintIcon(this,g,0,0);
    }
}
