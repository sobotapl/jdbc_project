import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Utils {

    public static void saveTofile(Path path, List<Contact> contactList) {
        String[] elementsArray = new String[5];
        StringBuilder builder;
        ArrayList<String> lines = new ArrayList<>();

        for (Contact contact : contactList) {
            builder = new StringBuilder();
            elementsArray[0] = contact.getId() + ":";
            elementsArray[1] = contact.getName() + ":";
            elementsArray[2] = contact.getAge() + ":";
            elementsArray[3] = contact.getCity() + ":";
            elementsArray[4] = contact.getNumber() + "";
            for (String s : elementsArray) {
                builder.append(s);
            }
            builder.append("\n");
            lines.add(builder.toString());
        }
        try {
            Files.write(path, lines, StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String saveToFileList(List<Contact> contactList) {
        try {
            FileWriter file = new FileWriter("/Volumes/dev/dev/java podstawy/JDBCproject/tekst.txt");
            StringBuilder sb = new StringBuilder();
            for (Contact lists : contactList) {
                sb.append(lists.toString());
                sb.append(Utils.dateGeneration().toString());
                sb.append("\n");
            }
            String lines = String.valueOf(sb);
            file.write(lines);
            file.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public static LocalDateTime dateGeneration (){
        LocalDateTime localDate = LocalDateTime.now();
        return localDate;
    }
}