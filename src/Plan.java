// ������� ����� ��� ��������-������������
// Главный класс планировщика.

import javax.swing.*;
import java.awt.*;

public class Plan extends JFrame {
    public static void main(String[] args) {
        new Plan();
    }

    final static int WIDTH_FRAME = 550;
    final static int HIEGHT_FRAME = 400;

    private Plan() {
        initFrame();
    }

    private void initFrame() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(WIDTH_FRAME, HIEGHT_FRAME));
        setTitle("Планировщик задач.");
        pack();
        setLocation(this.WIDTH + WIDTH_FRAME, this.HEIGHT + HIEGHT_FRAME);
        setVisible(true);
    }
}
