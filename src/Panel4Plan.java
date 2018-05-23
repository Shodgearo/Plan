// Панель для всех панелей программы

import javax.swing.*;
import java.awt.*;

public class Panel4Plan extends JPanel {
    private JPanel panel;
    private final int wButton = 90;
    private final int hButton = 90;
    private Button4Add buttonAdd;
    private JLabel adding;

    public Panel4Plan(FlowLayout lm, int w, int h) {
        setLayout(lm); // Установить деспетчер компановки
        setPreferredSize(new Dimension(w, h)); // Установить предпочтительные размеры окна

        initLabel();
        toolPanel();
        initButton();
        adding();
    }

    private void initLabel() {
        adding = new JLabel("Добавить");
        adding.setFont(new Font("Times New Roman", Font.BOLD, 20));
    }

    private void initButton() {
        buttonAdd = new Button4Add(wButton, hButton);
    }

    private void toolPanel() {
        panel = new JPanel();
        panel.setBackground(Color.ORANGE);
        panel.setPreferredSize(new Dimension(140, 140));
    }

    private void adding() {
        add(panel);
        panel.add(adding);
        panel.add(buttonAdd);
    }
}
