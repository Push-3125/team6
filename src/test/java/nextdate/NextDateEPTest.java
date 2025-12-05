package nextdate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import software_testing_project.NextDate;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Equivalence Partitioning Tests cho NextDate
 * Phân vùng các trường hợp: ngày thường, cuối tháng 30, cuối tháng 31, 
 * tháng 2 năm nhuận/không nhuận, ngày không hợp lệ
 */
@DisplayName("NextDate - Equivalence Partitioning Tests")
public class NextDateEPTest {
    private NextDate nextDate;

    @BeforeEach
    void setUp() {
        nextDate = new NextDate();
    }

    @Test
    @DisplayName("ND_EP_01: Normal day (10/3/2023)")
    void testNormalDay() {
        String result = nextDate.getNextDate(10, 3, 2023);
        assertEquals("11/3/2023", result, "Ngày thường trong tháng");
    }

    @Test
    @DisplayName("ND_EP_02: End of 30-day month (30/4/2023)")
    void testEndOf30DayMonth() {
        String result = nextDate.getNextDate(30, 4, 2023);
        assertEquals("1/5/2023", result, "Ngày cuối tháng có 30 ngày");
    }

    @Test
    @DisplayName("ND_EP_03: End of 31-day month (31/1/2023)")
    void testEndOf31DayMonth() {
        String result = nextDate.getNextDate(31, 1, 2023);
        assertEquals("1/2/2023", result, "Ngày cuối tháng có 31 ngày");
    }

    @Test
    @DisplayName("ND_EP_04: End of February non-leap year (28/2/2023)")
    void testEndOfFebruaryNonLeap() {
        String result = nextDate.getNextDate(28, 2, 2023);
        assertEquals("1/3/2023", result, "Ngày cuối tháng 2 năm không nhuận");
    }

    @Test
    @DisplayName("ND_EP_05: End of February leap year (29/2/2024)")
    void testEndOfFebruaryLeap() {
        String result = nextDate.getNextDate(29, 2, 2024);
        assertEquals("1/3/2024", result, "Ngày cuối tháng 2 năm nhuận");
    }

    @Test
    @DisplayName("ND_EP_06: Leap year check (28/2/2024)")
    void testLeapYearCheck() {
        String result = nextDate.getNextDate(28, 2, 2024);
        assertEquals("29/2/2024", result, "Năm nhuận có 29/2");
    }

    @Test
    @DisplayName("ND_EP_07: Invalid day (32/1/2023)")
    void testInvalidDay() {
        String result = nextDate.getNextDate(32, 1, 2023);
        assertEquals("Invalid date", result, "Ngày vượt quá số ngày trong tháng");
    }

    @Test
    @DisplayName("ND_EP_08: Invalid month (10/13/2023)")
    void testInvalidMonth() {
        String result = nextDate.getNextDate(10, 13, 2023);
        assertEquals("Invalid date", result, "Tháng không hợp lệ");
    }

    @Test
    @DisplayName("ND_EP_09: Invalid February day (30/2/2023)")
    void testInvalidFebruaryDay() {
        String result = nextDate.getNextDate(30, 2, 2023);
        assertEquals("Invalid date", result, "Tháng 2 không có ngày 30");
    }

    @Test
    @DisplayName("ND_EP_10: Invalid lower bound (0/1/2023)")
    void testInvalidLowerBound() {
        String result = nextDate.getNextDate(0, 1, 2023);
        assertEquals("Invalid date", result, "Ngày = 0 không hợp lệ");
    }
}