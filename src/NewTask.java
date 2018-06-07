// Для добавления новой панели и её настройки

import javax.swing.*;

public class NewTask extends JPanel {
    private String commentArea, typeTask, begin, end, nameTask;
    private int id;
//    private JTextField start, finish;
    private JLabel name, start, finish;

    public NewTask(String nameTask, String commentArea, String typeTask, String begin, String end, int countTasks) {
        this.commentArea = commentArea;
        this.typeTask = typeTask;
        this.begin = begin;
        this.end = end;
        this.nameTask = nameTask;

        id = countTasks;

        initLabel();
        adding();
    }

    public NewTask(String nameTask, String commentArea, String typeTask, String begin, int countTasks) {
        this.commentArea = commentArea;
        this.typeTask = typeTask;
        this.begin = begin;
        this.nameTask = nameTask;

        id = countTasks;
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
        revalidate();
    }

    public String getName() {
        return nameTask;
    }
}
