// Окошко для комментария

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame4Comment extends JFrame {
    private JPanel panelComment;
    private JScrollPane scroll;
    private JButton okComment;
    private JTextArea commenting;
    private String textComment = "";

    public Frame4Comment() {
        initScroll();
        initPanel();
        initButtonOk();
        adding();
        initFrame();
    }

    private void initButtonOk() {
        okComment = new JButton("OK");
        okComment.setFont(Panel4Plan.getGenericFont(20));
        okComment.setPreferredSize(new Dimension(100, 40));
        okComment.setToolTipText("Нажмите, для сохранения");

        okComment.addActionListener(new ButtonOkListener());
    }

    private void initScroll() {
        commenting = new JTextArea(5, 15);
        commenting.setLineWrap(true);
        commenting.setToolTipText("Введите Ваш коммментарий");
        commenting.setText(getTextComment());
        scroll = new JScrollPane(commenting);
    }

    private void initPanel() {
        panelComment = new JPanel();
        panelComment.setLayout(new FlowLayout());
    }

    private void adding() {
        add(panelComment);
        panelComment.add(scroll);
        panelComment.add(okComment);
    }

    private void initFrame() {
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        setTitle("Комментарий");
        setAlwaysOnTop(true);
        setSize(250, 190);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private class ButtonOkListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            textComment = commenting.getText();
            dispose();
        }
    }
    public String getTextComment() {
        return textComment;
    }

    public void setTextComment(String comment){
        commenting.setText(comment);
    }

    public void setEditing() {
        commenting.setEditable(false);
    }
}
