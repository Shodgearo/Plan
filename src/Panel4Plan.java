// Панель для всех панелей программы

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Panel4Plan extends JPanel {
    private JPanel panel;
    private final int wButton = 90;
    private final int hButton = 90;
    private final int wPanel = 140;
    private final int hPanel = 140;
    private Button4Add buttonAdd;
    private JLabel adding;

    public Panel4Plan(FlowLayout lm, int w, int h) {
        setLayout(null); // Установить деспетчер компановки
        setPreferredSize(new Dimension(w, h)); // Установить предпочтительные размеры окна

        initLabel();
        toolPanel(w, h);
        initButton();
        adding();
    }

    private void initLabel() {
        adding = new JLabel("Добавить");
        adding.setFont(new Font("Times New Roman", Font.BOLD, 20));
    }

    private void initButton() {
        buttonAdd = new Button4Add(wButton, hButton);
        buttonAdd.addActionListener(new ButtonListener());
    }

    private void toolPanel(int w, int h) {
        panel = new JPanel();
        panel.setBounds((w / 2) - wPanel / 2, (h / 2) - hPanel / 2, wPanel, hPanel);
        panel.setBackground(Color.ORANGE);
        panel.setPreferredSize(new Dimension(wPanel, hPanel));
    }

    private void adding() {
        add(panel);
        panel.add(adding);
        panel.add(buttonAdd);
    }

    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            panel.setVisible(false);
        }
    }
}
