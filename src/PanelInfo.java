// Панель для получения информации от пользователя о задаче

import javax.swing.*;
import java.awt.*;

public class PanelInfo extends JPanel {
    private JTextField nameField;
    private JRadioButton single, video, book, audio;
    private JLabel tSingle, tVideo, tBook, tAudio;
    private ButtonGroup buttonGroup;

    PanelInfo() {
        toolsComponents();
        adding();

        setVisible(false);
    }

    private void toolsComponents() {
        initTextField();
        initRadioButtons();
        initLabels();
    }

    private void initLabels() {
        tSingle = new JLabel("Одна задача");
        tVideo = new JLabel("Видео");
        tBook = new JLabel("Книга");
        tAudio = new JLabel("Аудио");
    }

    private void initRadioButtons() {
        single = new JRadioButton();
        video = new JRadioButton();
        book = new JRadioButton();
        audio = new JRadioButton();
        buttonGroup = new ButtonGroup();

        buttonGroup.add(single);
        buttonGroup.add(video);
        buttonGroup.add(book);
        buttonGroup.add(audio);
        buttonGroup.setSelected(single.getModel(), true);
    }

    private void initTextField() {
        nameField = new JTextField("Введите название задачи", 20);
    }

    private void adding() {
        add(nameField);
        add(tSingle);
        add(single);
        add(tVideo);
        add(video);
        add(tBook);
        add(book);
        add(tAudio);
        add(audio);
    }
}
