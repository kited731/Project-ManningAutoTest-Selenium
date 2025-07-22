package Util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimestampGenerator {
    public String getTimestamp() {
        // Datetime format for path creation
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
        String timestamp = now.format(formatter);
        return timestamp;
    }
}
