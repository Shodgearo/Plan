// Панель для получения информации от пользователя о задаче

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelInfo extends JPanel {
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

    PanelInfo(JPanel panel) {
        this.panel = panel;
        setLayout(new GridLayout(5, 1, 0, 25));
        toolsComponents();
        adding();

        setVisible(false);
    }

    private void toolsComponents() {
        initTextField();
        initRadioButtons();
        initButton();

        panelInputProgress = new MiniPanel4InputProgress();
        panelButtonComment = new JPanel();
        panelOK = new JPanel();
    }

    private void initRadioButtons() {
        single = new JRadioButton("Одна задача");
        video = new JRadioButton("Видео");
        book = new JRadioButton("Книга");
        audio = new JRadioButton("Аудио");
        buttonGroup = new ButtonGroup();

        buttonGroup.add(single);
        buttonGroup.add(video);
        buttonGroup.add(book);
        buttonGroup.add(audio);

        panelRadioButtons = new JPanel();

        single.addActionListener(new RadioButtonListener());
        video.addActionListener(new RadioButtonListener());
        book.addActionListener(new RadioButtonListener());
        audio.addActionListener(new RadioButtonListener());

        single.setFont(Panel4Plan.getGenericFont(15));
        video.setFont(Panel4Plan.getGenericFont(15));
        book.setFont(Panel4Plan.getGenericFont(15));
        audio.setFont(Panel4Plan.getGenericFont(15));
    }

    private void initTextField() {
        nameField = new JTextField("Введите название задачи", 20);
        nameField.setFont(Panel4Plan.getGenericFont(20));

        panelTextField = new JPanel();
    }

    private void initButton() {
        ok = new JButton("OK");
        ok.setFont(Panel4Plan.getGenericFont(20));
        ok.setPreferredSize(new Dimension(65, 32));

        ok.addActionListener(new ButtonOKListener());

        comment = new JButton("Комментарий");
        comment.setFont(Panel4Plan.getGenericFont(20));
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
            String command = e.getActionCommand(); // Для удобства

            if (command.equals("Одна задача") || command.equals("Книга")) {
                startCount("Прогресс");
                typeTask = command;
            } else {
                startCount();

                typeTask = command;
            }
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
            if(frame != null) commentArea = frame.getTextComment();
            begin = panelInputProgress.getBegin();
            end = panelInputProgress.getEnd();
            setVisible(false);
            panel.setVisible(true);
            frame = null;
            // сброс всех полей
            single.setSelected(true);
            startCount();
        }
    }
    private void startCount() {
        remove(panelInputProgress);
        panelInputProgress = new MiniPanel4InputProgress();
        add(panelInputProgress);
        revalidate();
        addSecondStep();
    }

    private void startCount(String msg) {
        remove(panelInputProgress);
        panelInputProgress = new MiniPanel4InputProgress(msg);
        add(panelInputProgress);
        revalidate();
        addSecondStep();
    }

    public String getCommentArea() {
        return commentArea;
    }

    public String getTypeTask() {
        return typeTask;
    }

    public String getBegin() {
        return begin;
    }

    public String getEnd() {
        return end;
    }
}
