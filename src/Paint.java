import javax.swing.*;
import java.awt.*;

public class Paint extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            BallBounce.ballBounce.repaint(g);
        }
    }

