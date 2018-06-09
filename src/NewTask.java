// Для добавления новой панели и её настройки

import javax.swing.*;
import java.awt.*;

public class NewTask extends JPanel {
    private String commentArea, typeTask, begin, end, nameTask;
    private int id;
//    private JTextField start, finish;
    private JLabel name, start, finish;

    public NewTask(String nameTask, String commentArea, String typeTask, String begin, String end, int countTasks) {
        setLayout(new GridLayout(5, 1));
        this.commentArea = commentArea;
        this.typeTask = typeTask;
        this.begin = begin;
        this.end = end;
        this.nameTask = nameTask;

        id = countTasks;

        setPreferredSize(new Dimension(120, 80));
        initLabel();
        adding();
    }

    public NewTask(String nameTask, String commentArea, String typeTask, String begin, int countTasks) {
        setLayout(new GridLayout(5, 1));
        this.commentArea = commentArea;
        this.typeTask = typeTask;
        this.begin = begin;
        this.nameTask = nameTask;

        id = countTasks;

        setPreferredSize(new Dimension(120, 80));
        initLabel();
        adding();
    }

    private void initLabel() {
        name = new JLabel(nameTask);
        start = new JLabel(begin);
        finish = new JLabel(end);
    }

    private void adding() {
        add(name);
        add(start);
        add(finish);
    }

    public String getName() {
        return nameTask;
    }
}
