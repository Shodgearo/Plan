// Класс, в котором будут сохраняться и загружаться файлы для физического размещения задач в папке программы

import java.io.*;

public class SerialClass implements Serializable {
    private int i = 100;

    public SerialClass() throws IOException {

    }

    public int getI() {
        return i;
    }
}
