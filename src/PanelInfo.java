// Панель для получения информации от пользователя о задаче

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelInfo extends JPanel {
    private Panel4OutTasks outTasks;
    private JTextField nameField;
    private ButtonGroup buttonGroup;
    private JRadioButton single, video, book, audio;
    private JPanel panelTextField, panelRadioButtons, panelButtonComment, panelOK;
    private MiniPanel4InputProgress panelInputProgress;
    private JButton ok, comment;
    private Frame4Comment frame;
    private JPanel panel; // Панель для того чтобы отобразить видимость панели с кнопкой добавления

    private String commentArea; // Строка для сохранения комментария
    private String typeTask; // Строка для сохранения типа задачи
    private String begin, end; // Для созранения начала и конца текущей задачи
    private String nameTask = ""; // Строка для сохранения названия задачи

    PanelInfo(JPanel panel, Panel4OutTasks tasks) {
        this.panel = panel;
        setLayout(new GridLayout(5, 1));
        toolsComponents();
        adding();

        setVisible(false);
        outTasks = tasks;
    }

    private void toolsComponents() {
        initTextField();
        initRadioButtons();
        initButton();

        panelInputProgress = new MiniPanel4InputProgress("Одна задача");
        panelInputProgress.setOpaque(false);
        panelButtonComment = new JPanel();
        panelButtonComment.setOpaque(false);
        panelOK = new JPanel();
        panelOK.setOpaque(false);
    }

    private void initRadioButtons() {
        single = new JRadioButton("Одна задача");
        video = new JRadioButton("Видео");
        book = new JRadioButton("Книга");
        audio = new JRadioButton("Аудио");
        buttonGroup = new ButtonGroup();

        single.setOpaque(false);
        video.setOpaque(false);
        book.setOpaque(false);
        audio.setOpaque(false);

        buttonGroup.add(single);
        buttonGroup.add(video);
        buttonGroup.add(book);
        buttonGroup.add(audio);

        panelRadioButtons = new JPanel();
        panelRadioButtons.setOpaque(false);

        single.addActionListener(new RadioButtonListener());
        video.addActionListener(new RadioButtonListener());
        book.addActionListener(new RadioButtonListener());
        audio.addActionListener(new RadioButtonListener());

        single.setFont(Panel4Plan.getGenericFont(17));
        video.setFont(Panel4Plan.getGenericFont(17));
        book.setFont(Panel4Plan.getGenericFont(17));
        audio.setFont(Panel4Plan.getGenericFont(17));
    }

    private void initTextField() {
        nameField = new JTextField(20);
        nameField.setFont(Panel4Plan.getGenericFont(17));
        nameField.setToolTipText("Введите название задачи");

        panelTextField = new JPanel();
        panelTextField.setOpaque(false);
    }

    private void initButton() {
        ok = new JButton("OK");
        ok.setFont(Panel4Plan.getGenericFont(17));
        ok.setPreferredSize(new Dimension(65, 32));

        ok.addActionListener(new ButtonOKListener());

        comment = new JButton("Комментарий");
        comment.setFont(Panel4Plan.getGenericFont(17));
        comment.addActionListener(new ButtonCommentListener());
    }

    private void adding() {
        add(panelTextField);
        panelTextField.add(nameField);
        add(panelRadioButtons);
        panelRadioButtons.add(single);
        panelRadioButtons.add(video);
        panelRadioButtons.add(book);
        panelRadioButtons.add(audio);
    }

    private void addSecondStep() {
        add(panelButtonComment);
        panelButtonComment.add(comment);
        add(panelOK);
        panelOK.add(ok);
    }

    private class RadioButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            typeTask = e.getActionCommand();
            startCount(typeTask);
        }
    }
    // Добавление комментария к задаче
    private class ButtonCommentListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(frame == null) frame = new Frame4Comment();
            else frame.setVisible(true);
        }
    }
    private class ButtonOKListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // передадим всю инфу на панель отображения задач
            saveInfo();
            setVisible(false);
            panel.setVisible(true);
            frame = null;
            // Создадим панель отображения задачи
            if (typeTask.equals("Одна задача") || typeTask.equals("Книга")) {
                outTasks.addNewTask(nameTask, commentArea, typeTask, begin);
            }
            else outTasks.addNewTask(nameTask, commentArea, typeTask, begin, end);

            // сброс всех полей
            startCount(typeTask);
            nameTask = "";
            nameField.setText("");

        }
    }

    private void saveInfo() {
        if(frame != null) commentArea = frame.getTextComment();
        begin = panelInputProgress.getBegin();
        end = panelInputProgress.getEnd();
        nameTask = nameField.getText();
    }

    private void startCount(String msg) {
        remove(panelInputProgress);
        panelInputProgress = new MiniPanel4InputProgress(msg);
        panelInputProgress.setOpaque(false);
        add(panelInputProgress);
        revalidate();
        addSecondStep();
    }
}