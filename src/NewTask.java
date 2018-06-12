// Для добавления новой панели и её настройки

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewTask extends JPanel {
    private String commentArea, typeTask, begin, end, nameTask;
    private int id;
    private JTextField startField, finishField;
    private JLabel name, start, finish;
    private Frame4Comment frame4Comment;
    private JButton commentButton;
    private GridBagConstraints c; // Для менеджера компановки

    public NewTask(String nameTask, String commentArea, String typeTask, String begin, String end, int countTasks) {
        setLayout(new GridBagLayout());
        c = new GridBagConstraints();
        this.commentArea = commentArea;
        this.typeTask = typeTask;
        this.begin = begin;
        this.end = end;
        this.nameTask = nameTask;

        id = countTasks;

        setPreferredSize(new Dimension(140, 100));
        initLabel();
        initTextFields();
        initButton();
        toolsTable();
    }

    public NewTask(String nameTask, String commentArea, String typeTask, String begin, int countTasks) {
        setLayout(new GridBagLayout());
        c = new GridBagConstraints();
        this.commentArea = commentArea;
        this.typeTask = typeTask;
        this.begin = begin;
        this.end = null;
        this.nameTask = nameTask;

        id = countTasks;

        setPreferredSize(new Dimension(140, 100));
        initLabel();
        initTextFields();
        initButton();
        toolsTable();
    }


    private void initLabel() {
        name = new JLabel(nameTask);
        name.setHorizontalAlignment(SwingConstants.CENTER);
    }

    private void initTextFields() {
        startField = new JTextField(begin);
        finishField = new JTextField(end);

        startField.setHorizontalAlignment(SwingConstants.CENTER);
        finishField.setHorizontalAlignment(SwingConstants.CENTER);
    }

    private void initButton() {
        commentButton = new JButton("Комментарий");
        commentButton.setFont(Panel4Plan.getGenericFont(13));

        commentButton.addActionListener(new ButtonListener());
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

    // Настроки для табличного менеджера копановки.
    private void toolsTable() {
        // Настрока для имени задачи
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        add(name, c);

        // Настройка для поля "от"
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 1;
        add(startField, c);

        // Настройка для поля "до"
        if(end != null) { // Только если это не одна задача или кнгиа
            c.fill = GridBagConstraints.HORIZONTAL;
            c.gridx = 0;
            c.gridy = 2;
            add(finishField, c);
        }

        // Настройка для кнопки комментария
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 3;
        add(commentButton, c);
    }
}
