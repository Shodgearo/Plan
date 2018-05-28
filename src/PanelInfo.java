// Панель для получения информации от пользователя о задаче

import javax.swing.*;
import java.awt.*;

public class PanelInfo extends JPanel {
    private JTextField nameField;
    private JRadioButton single, video, book, audio;
    private JLabel tSingle, tVideo, tBook, tAudio;
    private ButtonGroup buttonGroup;
    private JPanel panelTextField, panelRadioButtons, panelInputProgress, panelOK;

    PanelInfo() {
        setLayout(new GridLayout(4, 1, 0, 35));
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

        panelRadioButtons = new JPanel();
    }

    private void initTextField() {
        nameField = new JTextField("Введите название задачи", 20);

        panelTextField = new JPanel();
    }

    private void adding() {
        add(panelTextField);
        panelTextField.add(nameField);
        add(panelRadioButtons);
        panelRadioButtons.add(tSingle);
        panelRadioButtons.add(single);
        panelRadioButtons.add(tVideo);
        panelRadioButtons.add(video);
        panelRadioButtons.add(tBook);
        panelRadioButtons.add(book);
        panelRadioButtons.add(tAudio);
        panelRadioButtons.add(audio);
    }
}
