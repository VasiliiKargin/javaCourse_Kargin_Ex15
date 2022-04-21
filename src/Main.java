import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String txt = "";
        List<String> bigWords = new ArrayList<>();
        try (FileReader fr = new FileReader("C://Users//user//Desktop//Стих.txt");
             FileWriter fw = new FileWriter("fileNew.txt")) {
            int i;
            while ((i = fr.read()) != -1) {
                txt += (char) i;
            }
            // Удаление знаков препинания
            String txtUp = txt.toLowerCase().replaceAll("(?U)[\\pP]", "").replaceAll("\\r\\n", " ");
            List<String> listtxt = Arrays.asList(txtUp.split(" "));
            for (String s : listtxt) {
                if (s.length() > 6) {
                    bigWords.add(s);
                }
            }
            System.out.println(bigWords);
            fw.write("Текст: \n" + txt + "\n\nСписок bigWords: " + bigWords.toString().replaceAll("^\\[|\\]$", ""));
        } catch (IOException ioe) {
            System.out.println(ioe);
        }
    }
}
