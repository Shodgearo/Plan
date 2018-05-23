// Панель для всех панелей программы

import javax.swing.*;
import java.awt.*;

public class Panel4Plan extends JPanel {
    private JPanel panel;
    private final int wButton = 90;
    private final int hButton = 90;
    private Button4Add buttonAdd;

    public Panel4Plan(FlowLayout lm, int w, int h) {
        setLayout(lm); // Установить деспетчер компановки
        setPreferredSize(new Dimension(w, h)); // Установить предпочтительные размеры окна

        toolPanel();
        initButton();
        adding();
    }

    public Panel4Plan(GridLayout gm, int w, int h) {
        setLayout(gm); // Установить деспетчер компановки
        setPreferredSize(new Dimension(w, h)); // Установить предпочтительные размеры окна
    }

    private void initButton() {
        buttonAdd = new Button4Add(wButton, hButton);
    }

    private void toolPanel() {
        panel = new JPanel();
        panel.setBackground(Color.BLUE);
        panel.setPreferredSize(new Dimension(140, 120));
    }

    private void adding() {
        add(panel);
        panel.add(buttonAdd);
    }
}
