// Панель для получения информации от пользователя о задаче

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelInfo extends JPanel {
    private JTextField nameField;
    private ButtonGroup buttonGroup;
    private JRadioButton single, video, book, audio;
    private JPanel panelTextField, panelRadioButtons, panelButtonComment, panelButtonOk, panelComment;
    private MiniPanel4InputProgress panelInputProgress0, panelInputProgress1;
    private JButton ok, comment, okComment;
    private JTextArea commenting;
    private JScrollPane scroll;
    private JFrame frame;
    private String str = "Введите комментарий, если требуется";

    PanelInfo() {
        setLayout(new GridLayout(0, 1, 0, 25));
        toolsComponents();
        adding();

        setVisible(false);
    }

    private void toolsComponents() {
        initTextField();
        initRadioButtons();
        initButton();
        initTextArea();

        panelComment = new JPanel();
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
        single.setSelected(true);

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

        comment = new JButton("Комментарий");
        comment.setFont(Panel4Plan.getGenericFont(20));
        comment.addActionListener(new ButtonCommentListener());

        okComment = new JButton("OK");
        okComment.setFont(Panel4Plan.getGenericFont(20));
        okComment.setPreferredSize(new Dimension(100, 40));
    }

    private void initTextArea() {
        commenting = new JTextArea(5, 15);
        scroll = new JScrollPane(commenting);
    }

    private void adding() {
        add(panelTextField);
        panelTextField.add(nameField);
        add(panelRadioButtons);
        panelRadioButtons.add(single);
        panelRadioButtons.add(video);
        panelRadioButtons.add(book);
        panelRadioButtons.add(audio);
        add(comment);
        add(ok);
    }

    private class RadioButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("Одна задача") || e.getActionCommand().equals("Книга")) {
                remove(panelInputProgress0);
                panelInputProgress0 = new MiniPanel4InputProgress("Прогресс");
                add(panelInputProgress0);
                revalidate();
            } else {
                remove(panelInputProgress0);
                panelInputProgress0 = new MiniPanel4InputProgress();
                add(panelInputProgress0);
                revalidate();
            }
        }
    }

    // Добавление комментария к задаче
    private class ButtonCommentListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(frame != null) return;

            frame = new JFrame();
            frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            frame.setResizable(false);
            frame.setAlwaysOnTop(true);
            frame.setSize(250, 190);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);

            frame.add(panelComment);
            panelComment.setLayout(new FlowLayout());
            panelComment.add(scroll, BorderLayout.NORTH);
            panelComment.add(okComment, BorderLayout.SOUTH);
        }
    }
}
