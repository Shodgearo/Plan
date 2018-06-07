// Для добавления новой панели и её настройки

import javax.swing.*;

public class NewTask extends JPanel {
    private String commentArea, typeTask, begin, end;
    private int id;
    private JTextField start, finish;
    private JLabel nameTask;

    public NewTask(String nameTask, String commentArea, String typeTask, String begin, String end, int countTasks) {
        this.commentArea = commentArea;
        this.typeTask = typeTask;
        this.begin = begin;
        this.end = end;

        id = countTasks;


    }

    public NewTask(String nameTask, String commentArea, String typeTask, String begin, int countTasks) {
        this.commentArea = commentArea;
        this.typeTask = typeTask;
        this.begin = begin;

        id = countTasks;
    }
}
