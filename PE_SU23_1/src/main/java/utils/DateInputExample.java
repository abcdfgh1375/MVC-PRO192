package utils;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateInputExample {
    public static void main(String[] args) {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dateStr = "20/11/2023"; // Thay thế bằng chuỗi ngày tháng bạn muốn nhập

        try {
            LocalDate date = LocalDate.parse(dateStr, dateFormatter);
            System.out.println("Ngày đã nhập: " + date);
        } catch (DateTimeParseException e) {
            System.out.println("Định dạng ngày không hợp lệ.");
        }
    }
}
