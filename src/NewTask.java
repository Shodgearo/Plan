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
    private JButton commentButton, deleteButton;
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

        toolOutingTask();
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

        toolOutingTask();
    }

    private void toolOutingTask() {
        setPreferredSize(new Dimension(170, 130));
        initLabel();
        initTextFields();
        initButtons();
        toolsTable();
        setOpaque(false); // Изменить по востребованию
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

    private void initButtons() {
        commentButton = new JButton("Комментарий");
        commentButton.setFont(Panel4Plan.getGenericFont(15));
        commentButton.setBorderPainted(false);

        commentButton.addActionListener(new ButtonListener());

        deleteButton = new JButton("Удалить задачу");
        deleteButton.setFont(Panel4Plan.getGenericFont(13));
        deleteButton.setBorderPainted(false);

        deleteButton.addActionListener(new DeleteButtonListener());
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
        c.insets = new Insets(5, 0, 0, 0); // Отступы
        add(name, c);

        // Настройка для поля "от"
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 1;
        c.insets = new Insets(5, 10, 0, 10);
        add(startField, c);

        // Настройка для поля "до"
        if(end != null) { // Только если это не одна задача или кнгиа
            c.fill = GridBagConstraints.HORIZONTAL;
            c.gridx = 0;
            c.gridy = 2;
            c.insets = new Insets(5, 10, 0, 10);
            add(finishField, c);
        }

        // Настройка для кнопки комментария
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 3;
        c.insets = new Insets(5, 0, 0, 0);
        add(commentButton, c);

        // Настройка кнопки для удаления элемента с панели
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 4;
        c.insets = new Insets(5, 25, 0, 25);
        add(deleteButton, c);
    }

    private class DeleteButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            setVisible(false);
            id = -1;
        }
    }
}
