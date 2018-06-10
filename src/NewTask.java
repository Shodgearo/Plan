// Для добавления новой панели и её настройки

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewTask extends JPanel {
    private String commentArea, typeTask, begin, end, nameTask;
    private int id;
//    private JTextField start, finish;
    private JLabel name, start, finish;
    private Frame4Comment frame4Comment;
    private JButton commentButton;

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
        initButton();
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
        initButton();
        adding();
    }

    private void initLabel() {
        name = new JLabel(nameTask);
        start = new JLabel(begin);
        finish = new JLabel(end);

        name.setHorizontalAlignment(SwingConstants.CENTER);
        start.setHorizontalAlignment(SwingConstants.CENTER);
        finish.setHorizontalAlignment(SwingConstants.CENTER);
    }

    private void initButton() {
        commentButton = new JButton("Комментарий");
        commentButton.setFont(Panel4Plan.getGenericFont(13));

        commentButton.addActionListener(new ButtonListener());
    }

    private void adding() {
        add(name);
        add(start);
        add(finish);
        add(commentButton);
    }

    public String getName() {
        return nameTask;
    }

    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            frame4Comment = new Frame4Comment();
            frame4Comment.setTextComment(commentArea);
            frame4Comment.setEditing();
        }
    }
}
