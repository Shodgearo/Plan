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

    public void addNewTask(String commentArea, String typeTask, String begin, String end) {
        NewTask task;

        if (!end.equals("0")) task = new NewTask(commentArea, typeTask, begin, end, countTasks);
        else task = new NewTask(commentArea, typeTask, begin, countTasks);

        listOfTasks.add(task);
        countTasks++;
    }
}
