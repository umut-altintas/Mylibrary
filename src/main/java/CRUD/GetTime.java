package CRUD;

import org.jetbrains.annotations.NotNull;

import java.time.Duration;
import java.time.LocalDateTime;

public class GetTime {
    @NotNull
    public static String timeDiff(String url, int book_id){
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime book_added_date = ConnectToDb.getBookAddedDate(url, book_id);
        long df_hours = Duration.between(now, book_added_date).toHours();
        long df_days = Duration.between(now, book_added_date).toDays();
        return "Days:"+df_days+" "+"Hours"+df_hours;
    }
}
