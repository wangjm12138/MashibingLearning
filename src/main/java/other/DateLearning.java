package other;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateLearning {

    public static void main(String[] args) {
//        String format = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
//        System.out.println(format);
        // 获取当前时间的 Date 对象
        Date date = new Date();
        Long time = date.getTime();
        // 创建 Timestamp 对象
        System.out.println(time);
        Timestamp timestamp = new Timestamp(time);
        System.out.println(timestamp);
    }
}
