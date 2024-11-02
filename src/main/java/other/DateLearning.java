package other;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateLearning {

    public static void main(String[] args) {
        String format = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
        System.out.println(format);
    }
}
