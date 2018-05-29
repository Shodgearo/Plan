// Панель для получения информации от пользователя о задаче

import javax.swing.*;
import java.awt.*;

public class PanelInfo extends JPanel {
    private JTextField nameField, startField, endField;
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
        initLabels();
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
        nameField.setFont(Panel4Plan.getGenericFont(20));

        startField = new JTextField("От", 5);
        startField.setToolTipText("Начало");
        endField = new JTextField("До", 8);
        endField.setToolTipText("Конец");

        panelTextField = new JPanel();
        panelInputProgress = new MiniPanel4InputProgress();
        panelInputProgress.setVisible(false);
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
        panelRadioButtons.add(tSingle);
        panelRadioButtons.add(single);
        panelRadioButtons.add(tVideo);
        panelRadioButtons.add(video);
        panelRadioButtons.add(tBook);
        panelRadioButtons.add(book);
        panelRadioButtons.add(tAudio);
        panelRadioButtons.add(audio);
        add(panelInputProgress);
        panelInputProgress.add(startField);
        panelInputProgress.add(endField);
        add(panelOK);
        panelOK.add(ok);
    }
}
