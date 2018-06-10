// Небольшой класс который при выборе радио кнопки будет создавать панельку с одним или двумя полями

import javax.swing.*;

public class MiniPanel4InputProgress extends JPanel {
    private JTextField startField, endField;

    public MiniPanel4InputProgress(String msg) {
        initTextFields();

        if(msg.equals("Одна задача") || msg.equals("Книга")) add(startField);
        else {
            add(startField);
            add(endField);
        }

        setVisible(true);
    }

    private void initTextFields() {
        startField = new JTextField(5);
        startField.setToolTipText("Начало");
        endField = new JTextField(8);
        endField.setToolTipText("Конец");
        startField.setFont(Panel4Plan.getGenericFont(18));
        endField.setFont(Panel4Plan.getGenericFont(18));
    }

    public String getBegin() {
        return startField.getText();
    }

    public String getEnd() {
        return endField.getText();
    }
}
