// ������� ����� ��� ��������-������������
// Главный класс планировщика.

import javax.swing.*;
import java.awt.*;

public class Plan extends JFrame {
    public static void main(String[] args) {
        new Plan();
    }

    final static int WIDTH_FRAME = 550;
    final static int HEIGHT_FRAME = 400;

    private Plan() {
        initFrame();
    }

    private void initFrame() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(WIDTH_FRAME, HEIGHT_FRAME));
        setTitle("Планировщик задач.");
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
