// Панель для всех панелей программы

import javax.swing.*;
import java.awt.*;

public class Panel4Plan extends JPanel {
    private JPanel panel;
    private final int wButton = 90;
    private final int hButton = 90;

    public Panel4Plan(FlowLayout lm, int w, int h) {
        setLayout(lm); // Установить деспетчер компановки
        setPreferredSize(new Dimension(w, h)); // Установить предпочтительные размеры окна

        toolPanel();
        adding();
    }

    public Panel4Plan(GridLayout gm, int w, int h) {
        setLayout(gm); // Установить деспетчер компановки
        setPreferredSize(new Dimension(w, h)); // Установить предпочтительные размеры окна
    }

    private void adding() {
        add(panel);
    }

    private void toolPanel() {
        panel = new JPanel();
        panel.setBackground(Color.BLUE);
        panel.setPreferredSize(new Dimension(100, 110));
    }
}
