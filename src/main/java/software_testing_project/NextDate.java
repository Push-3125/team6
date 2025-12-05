package software_testing_project;

public class NextDate {
    private static final int MIN_YEAR = 1900;
    private static final int MAX_YEAR = 2100;

    /**
     * Tính ngày tiếp theo
     * @param day ngày (1-31)
     * @param month tháng (1-12)
     * @param year năm (1900-2100)
     * @return Ngày tiếp theo dạng "dd/mm/yyyy" hoặc "Invalid date"
     */
    public String getNextDate(int day, int month, int year) {
        // Kiểm tra input hợp lệ
        if (!isValidDate(day, month, year)) {
            return "Invalid date";
        }

        int nextDay = day;
        int nextMonth = month;
        int nextYear = year;

        // Lấy số ngày trong tháng hiện tại
        int daysInMonth = getDaysInMonth(month, year);

        // Nếu chưa phải ngày cuối tháng
        if (day < daysInMonth) {
            nextDay = day + 1;
        } else {
            // Ngày cuối tháng
            nextDay = 1;
            if (month < 12) {
                nextMonth = month + 1;
            } else {
                // Cuối năm
                nextMonth = 1;
                nextYear = year + 1;
            }
        }

        return String.format("%d/%d/%d", nextDay, nextMonth, nextYear);
    }

    /**
     * Kiểm tra ngày có hợp lệ không
     */
    private boolean isValidDate(int day, int month, int year) {
        // Kiểm tra năm
        if (year < MIN_YEAR || year > MAX_YEAR) {
            return false;
        }

        // Kiểm tra tháng
        if (month < 1 || month > 12) {
            return false;
        }

        // Kiểm tra ngày
        if (day < 1) {
            return false;
        }

        int daysInMonth = getDaysInMonth(month, year);
        if (day > daysInMonth) {
            return false;
        }

        return true;
    }

    /**
     * Lấy số ngày trong tháng
     */
    private int getDaysInMonth(int month, int year) {
        switch (month) {
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                return 31;
            case 4: case 6: case 9: case 11:
                return 30;
            case 2:
                return isLeapYear(year) ? 29 : 28;
            default:
                return 0;
        }
    }

    /**
     * Kiểm tra năm nhuận
     * Năm nhuận: chia hết cho 4 NHƯNG không chia hết cho 100, 
     * HOẶC chia hết cho 400
     */
    public boolean isLeapYear(int year) {
        if (year % 400 == 0) {
            return true;
        }
        if (year % 100 == 0) {
            return false;
        }
        return year % 4 == 0;
    }

    /**
     * Methods hỗ trợ white-box testing
     */
    public boolean checkValidDate(int day, int month, int year) {
        return isValidDate(day, month, year);
    }

    public int checkDaysInMonth(int month, int year) {
        return getDaysInMonth(month, year);
    }

    // Main method để test thủ công
    public static void main(String[] args) {
        NextDate nd = new NextDate();
        
        // Test cases mẫu
        System.out.println("Test 1 (10/3/2023): " + nd.getNextDate(10, 3, 2023));
        System.out.println("Test 2 (30/4/2023): " + nd.getNextDate(30, 4, 2023));
        System.out.println("Test 3 (31/12/2023): " + nd.getNextDate(31, 12, 2023));
        System.out.println("Test 4 (28/2/2023): " + nd.getNextDate(28, 2, 2023));
        System.out.println("Test 5 (29/2/2024): " + nd.getNextDate(29, 2, 2024));
        System.out.println("Test 6 (32/1/2023): " + nd.getNextDate(32, 1, 2023));
    }
}
