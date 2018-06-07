// Панель для отображения текущих задач

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

public class Panel4OutTasks extends JPanel {
    private LinkedList<NewTask> listOfTasks;

    public Panel4OutTasks(int w, int h) {
        setLayout(new GridLayout());
        setPreferredSize(new Dimension(w, h));

        listOfTasks = new LinkedList<>();
    }

    public void addNewTask(String commentArea, String typeTask, String begin, String end) {
        listOfTasks.add(new NewTask(commentArea, typeTask, begin, end));
    }
}
