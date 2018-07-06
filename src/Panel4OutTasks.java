// Панель для отображения текущих задач

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

public class Panel4OutTasks extends JPanel {
    private LinkedList<NewTask> listOfTasks;
    private int countTasks;

    public Panel4OutTasks(int w, int h) {
        setLayout(new FlowLayout());
        setPreferredSize(new Dimension(w, h));

        listOfTasks = new LinkedList<>();
        countTasks = 0;
    }

    public void addNewTask(String nameTask, String commentArea, String typeTask, String begin, String end) {
        NewTask task = new NewTask(nameTask, commentArea, typeTask, begin, end, countTasks);

        listOfTasks.add(task);
        countTasks++;

        adding(listOfTasks.getLast());
    }

    public void addNewTask(String nameTask, String commentArea, String typeTask, String begin) {
        NewTask task = new NewTask(nameTask, commentArea, typeTask, begin, countTasks);

        listOfTasks.add(task);
        countTasks++;

        adding(listOfTasks.getLast());
    }

    private void adding(NewTask last) {
        add(last);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        ImageIcon icon = new ImageIcon("assets/bg_main.png");

        g.drawImage(icon.getImage(), -490, -0, this);
    }
}
