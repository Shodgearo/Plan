// Небольшой класс который при выборе радио кнопки будет создавать панельку с одним или двумя полями

import javax.swing.*;

public class MiniPanel4InputProgress extends JPanel {
    private JTextField startField, endField;
    private String begin, end;

    public MiniPanel4InputProgress() {
        initTextFields();

        begin = end = "";

        add(startField);
        add(endField);

        setVisible(true);
    }

    public MiniPanel4InputProgress(String msg) {
        initTextFields(msg);

        add(startField);

        setVisible(true);
    }

    private void initTextFields(String msg) {
        startField = new JTextField(msg, 10);
        startField.setToolTipText("Прогресс");
    }

    private void initTextFields() {
        startField = new JTextField("От", 5);
        startField.setToolTipText("Начало");
        endField = new JTextField("До", 8);
        endField.setToolTipText("Конец");
    }

    public String getBegin() {
        return begin;
    }

    public String getEnd() {
        return end;
    }
}
