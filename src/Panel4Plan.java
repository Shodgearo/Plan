// Панель для всех панелей программы

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class Panel4Plan extends JPanel {
    private JPanel panel;
    private PanelInfo panelInputInfo;
    private Panel4OutTasks tasks;
    private final int wButton = 90;
    private final int hButton = 90;
    private final int wPanel = 140;
    private final int hPanel = 140;
    private final int wPanelInputInfo = 480;
    private final int hPanelInputInfo = 300;
    private JButton buttonAdd;
    private JLabel adding;
    private static Font genericFont;

    public Panel4Plan(int w, int h, Panel4OutTasks tasks) {
        this.tasks = tasks;
        genericFont = getGenericFont(20);
        setLayout(null); // Установить деспетчер компановки
        setPreferredSize(new Dimension(w, h)); // Установить предпочтительные размеры окна

        initLabel();
        toolPanels(w, h);
        initButton();
        adding();
    }

    private void initLabel() {
        adding = new JLabel("Добавить");
        adding.setFont(genericFont);
    }

    private void initButton() {
        buttonAdd = new JButton(new ImageIcon("assets/buttonOk.png"));
        buttonAdd.setBorderPainted(false);
        buttonAdd.setPreferredSize(new Dimension(wButton, hButton));
        buttonAdd.addActionListener(new ButtonListener());
    }

    private void toolPanels(int w, int h) {
        int width = w / 2;
        int height = h / 2;

        panel = new JPanel(); // Настройки панели на которой размещены кнопка с меткой
        panel.setBounds((width) - wPanel / 2, (height) - hPanel / 2, wPanel, hPanel);
        panel.setPreferredSize(new Dimension(wPanel, hPanel));
        panel.setOpaque(false);

        // Настройки панели на которой будут указаны параметры
        panelInputInfo = new PanelInfo(panel, tasks);
        panelInputInfo.setBounds((width) - wPanelInputInfo / 2, (height) - hPanelInputInfo / 2,
                wPanelInputInfo, hPanelInputInfo);
        panelInputInfo.setPreferredSize(new Dimension(wPanelInputInfo, hPanelInputInfo));
        panelInputInfo.setOpaque(false);
    }

    private void adding() {
        add(panelInputInfo);
        add(panel);
        panel.add(adding);
        panel.add(buttonAdd);
    }

    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            panel.setVisible(false);
            panelInputInfo.setVisible(true);
        }
    }

    public static Font getGenericFont(int size) {
        return new Font("Times New Roman", Font.BOLD, size);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        ImageIcon icon = new ImageIcon("assets/bg_main.png");

        g.drawImage(icon.getImage(), -5, 0, this);
    }
}

