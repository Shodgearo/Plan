// Панель для всех панелей программы

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Panel4Plan extends JPanel {
    private JPanel panel;
    private PanelInfo panelInputInfo;
    private final int wButton = 90;
    private final int hButton = 90;
    private final int wPanel = 140;
    private final int hPanel = 140;
    private final int wPanelInputInfo = 380;
    private final int hPanelInputInfo = 300;
    private JButton buttonAdd;
    private JLabel adding;

    public Panel4Plan(int w, int h) {
        setLayout(null); // Установить деспетчер компановки
        setPreferredSize(new Dimension(w, h)); // Установить предпочтительные размеры окна

        initLabel();
        toolPanels(w, h);
        initButton();
        adding();
    }

    private void initLabel() {
        adding = new JLabel("Добавить");
        adding.setFont(new Font("Times New Roman", Font.BOLD, 20));
    }

    private void initButton() {
        buttonAdd = new JButton();
        buttonAdd.setPreferredSize(new Dimension(wButton, hButton));
        buttonAdd.addActionListener(new ButtonListener());
    }

    private void toolPanels(int w, int h) {
        int width = w / 2;
        int hieght = h / 2;

        panel = new JPanel(); // Настройки панели на которой размещены кнопка с меткой
        panel.setBounds((width) - wPanel / 2, (hieght) - hPanel / 2, wPanel, hPanel);
        panel.setBackground(Color.ORANGE);
        panel.setPreferredSize(new Dimension(wPanel, hPanel));

        // Настройки панели на которой будут указаны параметры
        panelInputInfo = new PanelInfo();
        panelInputInfo.setBounds((width) - wPanelInputInfo / 2, (hieght) - hPanelInputInfo / 2,
                                                                        wPanelInputInfo, hPanelInputInfo);
        panelInputInfo.setBackground(Color.GREEN);
        panelInputInfo.setPreferredSize(new Dimension(wPanelInputInfo, hPanelInputInfo));
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
}
