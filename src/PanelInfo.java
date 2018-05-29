// Панель для получения информации от пользователя о задаче

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelInfo extends JPanel {
    private JTextField nameField;
    private ButtonGroup buttonGroup;
    private JRadioButton single, video, book, audio;
    private JLabel tSingle, tVideo, tBook, tAudio;
    private JPanel panelTextField, panelRadioButtons, panelOK, panelComment;
    private MiniPanel4InputProgress panelInputProgress;
    private JButton ok;

    PanelInfo() {
        setLayout(new GridLayout(5, 1, 0, 25));
        toolsComponents();
        adding();

        setVisible(false);
    }

    private void toolsComponents() {
        initTextField();
        initRadioButtons();
//        initLabels();
        initButton();
    }

    private void initLabels() {
        tSingle = new JLabel("Одна задача");
        tVideo = new JLabel("Видео");
        tBook = new JLabel("Книга");
        tAudio = new JLabel("Аудио");

        tSingle.setFont(Panel4Plan.getGenericFont(15));
        tVideo.setFont(Panel4Plan.getGenericFont(15));
        tBook.setFont(Panel4Plan.getGenericFont(15));
        tAudio.setFont(Panel4Plan.getGenericFont(15));
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
        buttonGroup.setSelected(single.getModel(), true);

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
        panelOK = new JPanel();
    }

    private void adding() {
        add(panelTextField);
        panelTextField.add(nameField);
        add(panelRadioButtons);
//        panelRadioButtons.add(tSingle);
        panelRadioButtons.add(single);
//        panelRadioButtons.add(tVideo);
        panelRadioButtons.add(video);
//        panelRadioButtons.add(tBook);
        panelRadioButtons.add(book);
//        panelRadioButtons.add(tAudio);
        panelRadioButtons.add(audio);
        add(panelInputProgress);
        add(panelOK);
        panelOK.add(ok);
    }

    private class RadioButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println(e.getActionCommand());
            if(e.getActionCommand().equals("Одна задача") || e.getActionCommand().equals("Книга"))
                add(new MiniPanel4InputProgress("Закладка"));
            else add(new MiniPanel4InputProgress());
        }
    }
}
