
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Lesson10 {

    public String formatDate() {
        String firstDate = "15.08.1995 18:30:15";
        DateFormat df = new SimpleDateFormat("dd.MM.yyyy kk:mm:ss", Locale.US);
        DateFormat destinationFormat = new SimpleDateFormat("dd MMM h:mm a",
                Locale.US);
        Date date;

        String newDate;

        try {
            date = df.parse(firstDate);
            newDate = destinationFormat.format(date);
            System.out.println(newDate);

            return newDate;
        } catch (ParseException e) {
            System.out.println("Can't parse");
        }
        return "";
    }

    public void writtenFile(String newDate) {

        try {
            FileWriter writer = new FileWriter(System.getProperty("user.dir") + File.separator + "lesson.txt");
            writer.write(newDate);

            writer.flush(); // как я понял метод flush() позволит производить перезапись файла дальше в программе
                            // а если написать метод close() то перезаписывать файл будет нельзя
        } catch (IOException e) {
            System.out.println("IOException");
        }

    }

}
