package nextdate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import software_testing_project.NextDate;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Decision Table Tests cho NextDate
 * 
 * Bảng quyết định:
 * Điều kiện              | R1  | R2  | R3  | R4
 * ----------------------|-----|-----|-----|-----
 * Ngày hợp lệ           | T   | T   | T   | F
 * Cuối tháng            | F   | T   | T   | -
 * Cuối năm              | -   | F   | T   | -
 * Tháng 2 năm nhuận     | -   | T   | -   | -
 * ----------------------|-----|-----|-----|-----
 * Kết quả: day+1        | X   | -   | -   | Invalid
 * Kết quả: day=1,month+1| -   | X   | -   | -
 * Kết quả: 1/1/year+1   | -   | -   | X   | -
 */
@DisplayName("NextDate - Decision Table Tests")
public class NextDateDecisionTableTest {
    private NextDate nextDate;

    @BeforeEach
    void setUp() {
        nextDate = new NextDate();
    }

    @Test
    @DisplayName("ND_DT_19: Decision normal day (15/8/2023)")
    void testDecisionNormalDay() {
        String result = nextDate.getNextDate(15, 8, 2023);
        assertEquals("16/8/2023", result, 
            "Rule 1: Ngày hợp lệ && !cuối tháng -> day+1");
    }

    @Test
    @DisplayName("ND_DT_20: Decision 30-day month end (30/9/2023)")
    void testDecision30DayMonthEnd() {
        String result = nextDate.getNextDate(30, 9, 2023);
        assertEquals("1/10/2023", result, 
            "Rule 2: Ngày hợp lệ && cuối tháng && !cuối năm -> 1/(month+1)/year");
    }

    @Test
    @DisplayName("ND_DT_21: Decision February leap year (29/2/2024)")
    void testDecisionFebruaryLeapYear() {
        String result = nextDate.getNextDate(29, 2, 2024);
        assertEquals("1/3/2024", result, 
            "Rule 2: Tháng 2 năm nhuận, ngày 29 là cuối tháng");
    }

    @Test
    @DisplayName("ND_DT_22: Decision invalid date (31/9/2023)")
    void testDecisionInvalidDate() {
        String result = nextDate.getNextDate(31, 9, 2023);
        assertEquals("Invalid date", result, 
            "Rule 4: Ngày không hợp lệ -> Invalid date");
    }
}