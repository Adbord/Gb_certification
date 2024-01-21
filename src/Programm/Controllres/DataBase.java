package Programm.Controllres;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataBase {
    public void fileRecording(String nameFile, Boolean recording, String data) {
        try (FileWriter fileWriter = new FileWriter(nameFile + ".csv", recording)) {
            fileWriter.write(data + "\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<String[]> fileReading(String name, String title) {
        List<String[]> entry = new ArrayList<>();
        if (!thereIsFile(name)) {
            String[] txt = new String[]{"Файл не существует"};
            entry.add(txt);
            return entry;
        }
        try (FileReader fileReader = new FileReader(name + ".csv")) {
            StringBuilder sb = new StringBuilder();
            int c;
            int i = 1;
            while ((c = fileReader.read()) != -1) {
                if (c == 10) {
                    if (name.contains("Commands")) {
                        sb.append("," + title);
                    } else {
                        sb.append("," + title + "," + i);
                        i++;
                    }
                    entry.add(sb.toString().split(","));
                    sb.delete(0, sb.length());
                } else {
                    sb.append((char) c);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return entry;
    }

    public boolean thereIsFile(String name) {
        File file = new File(name + ".csv");
        return file.isFile() && file.canRead();
    }
}