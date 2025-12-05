package nextdate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import software_testing_project.NextDate;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Boundary Value Analysis Tests cho NextDate
 * Kiểm tra các giá trị biên:
 * - Day: 1, 28, 29, 30, 31
 * - Month: 1, 2, 12
 * - Year: 1900, 2100
 */
@DisplayName("NextDate - Boundary Value Analysis Tests")
public class NextDateBVATest {
    private NextDate nextDate;

    @BeforeEach
    void setUp() {
        nextDate = new NextDate();
    }

    @Test
    @DisplayName("ND_BVA_11: Start of year (1/1/2023)")
    void testStartOfYear() {
        String result = nextDate.getNextDate(1, 1, 2023);
        assertEquals("2/1/2023", result, "Ngày đầu năm");
    }

    @Test
    @DisplayName("ND_BVA_12: End of year (31/12/2023)")
    void testEndOfYear() {
        String result = nextDate.getNextDate(31, 12, 2023);
        assertEquals("1/1/2024", result, "Ngày cuối năm, chuyển sang năm mới");
    }

    @Test
    @DisplayName("ND_BVA_13: 30-day boundary (30/6/2023)")
    void test30DayBoundary() {
        String result = nextDate.getNextDate(30, 6, 2023);
        assertEquals("1/7/2023", result, "Ngày cuối tháng 30 ngày");
    }

    @Test
    @DisplayName("ND_BVA_14: 30-day valid (29/4/2023)")
    void test30DayValid() {
        String result = nextDate.getNextDate(29, 4, 2023);
        assertEquals("30/4/2023", result, "Ngày 29 trong tháng có 30 ngày");
    }

    @Test
    @DisplayName("ND_BVA_15: February non-leap boundary (27/2/2023)")
    void testFebruaryNonLeapBoundary() {
        String result = nextDate.getNextDate(27, 2, 2023);
        assertEquals("28/2/2023", result, "Ngày 27/2 năm không nhuận");
    }

    @Test
    @DisplayName("ND_BVA_16: February leap boundary (27/2/2024)")
    void testFebruaryLeapBoundary() {
        String result = nextDate.getNextDate(27, 2, 2024);
        assertEquals("28/2/2024", result, "Ngày 27/2 năm nhuận");
    }

    @Test
    @DisplayName("ND_BVA_17: Max day invalid in 30-day month (31/4/2023)")
    void testMaxDayInvalidIn30DayMonth() {
        String result = nextDate.getNextDate(31, 4, 2023);
        assertEquals("Invalid date", result, "Tháng 4 không có ngày 31");
    }

    @Test
    @DisplayName("ND_BVA_18: Min year invalid (31/12/1899)")
    void testMinYearInvalid() {
        String result = nextDate.getNextDate(31, 12, 1899);
        assertEquals("Invalid date", result, "Năm < MIN_YEAR=1900");
    }
}