// ������� ����� ��� ��������-������������
// Главный класс планировщика.

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Plan extends JFrame {
    public static void main(String[] args) {
        new Plan();
    }

    // Размеры окна
    private final static int WIDTH_FRAME = 600;
    private final static int HEIGHT_FRAME = 450;
    // Ширина панелей
    private final static int WIDTH_FRAME_ADDTASKS = WIDTH_FRAME - 180;
    private final static int WIDTH_FRAME_TASKS = WIDTH_FRAME - WIDTH_FRAME_ADDTASKS;

    //Поля
    private Panel4Plan tasks;
    private Panel4Plan addTasks;
    private Button4Add bAdd;

    private Plan() {
        initPanel();
        initButton();
        adding();
        initFrame();
    }

    private void initButton() {
        bAdd = new Button4Add("Добавить", 90, 20);
        bAdd.addActionListener(new ButtonListener());
    }

    private void adding() {
        add(tasks, BorderLayout.EAST);
        add(addTasks, BorderLayout.WEST);
        addTasks.add(bAdd);
    }

    private void initPanel() {
        tasks = new Panel4Plan(WIDTH_FRAME_TASKS, HEIGHT_FRAME);
        tasks.setBackground(Color.BLACK);

        addTasks = new Panel4Plan(WIDTH_FRAME_ADDTASKS, HEIGHT_FRAME);
        addTasks.setBackground(Color.RED);
    }

    private void initFrame() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(WIDTH_FRAME, HEIGHT_FRAME));
        setTitle("Планировщик задач");
        setResizable(false);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            bAdd.setVisible(false);
        }
    }
}
