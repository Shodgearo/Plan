// Панель для отображения текущих задач

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

public class Panel4OutTasks extends JPanel {
    private LinkedList<NewTask> listOfTasks;
    private int countTasks;

    public Panel4OutTasks(int w, int h) {
        setLayout(new GridLayout(0, 1, 0, 20));
        setPreferredSize(new Dimension(w, h));

        listOfTasks = new LinkedList<>();
        countTasks = 0;
    }

    public void addNewTask(String nameTask, String commentArea, String typeTask, String begin, String end) {
        NewTask task = new NewTask(nameTask, commentArea, typeTask, begin, end, countTasks);

        System.out.println("1-2");

        listOfTasks.add(task);
        countTasks++;

        adding(listOfTasks.getLast());
    }

    public void addNewTask(String nameTask, String commentArea, String typeTask, String begin) {
        NewTask task = new NewTask(nameTask, commentArea, typeTask, begin, countTasks);

        System.out.println("1");

        listOfTasks.add(task);
        countTasks++;

        adding(listOfTasks.getLast());
    }

    private void adding(NewTask last) {
        add(last);
    }
}
