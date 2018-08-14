// ������� ����� ��� ��������-������������
// Главный класс планировщика.

import javax.swing.*;
import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Plan extends JFrame {
    public static void main(String[] args) {
        new Plan();
    }

    // Размеры окна
    private final static int WIDTH_FRAME = 650;
    private final static int HEIGHT_FRAME = 450;
    // Ширина панелей
    private final static int WIDTH_FRAME_ADDTASKS = WIDTH_FRAME - 180;
    private final static int WIDTH_FRAME_TASKS = WIDTH_FRAME - WIDTH_FRAME_ADDTASKS;

    //Поля
    private Panel4OutTasks tasks;
    private Panel4Plan addTasks;

    private Plan() {
        initPanel();
        adding();
        initFrame();
        try {
            readingSerial();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void readingSerial() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("temp.out");
        ObjectInputStream ois = new ObjectInputStream(fis);
        SerialClass serial = (SerialClass)ois.readObject();
        System.out.println(serial.getI());
    }

    private void adding() {
        add(tasks, BorderLayout.EAST);
        add(addTasks, BorderLayout.WEST);
    }

    private void initPanel() {
        tasks = new Panel4OutTasks(WIDTH_FRAME_TASKS, HEIGHT_FRAME);
        tasks.setBackground(Color.BLACK);

        addTasks = new Panel4Plan(WIDTH_FRAME_ADDTASKS, HEIGHT_FRAME, tasks);
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
}
