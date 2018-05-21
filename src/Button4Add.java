// Класс для редактирования кнопки

import javax.swing.*;
import java.awt.*;

public class Button4Add extends JButton {
    public Button4Add(String s, int w, int h) {
        super(s);
        
        setPreferredSize(new Dimension(w, h));
    }
}
