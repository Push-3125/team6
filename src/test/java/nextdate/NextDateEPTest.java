package nextdate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import software_testing_project.NextDate;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Equivalence Partitioning Tests cho NextDate
 * 
 * Vùng hợp lệ:
 * EP1: Ngày thường trong tháng
 * EP2: Cuối tháng 30 ngày
 * EP3: Cuối tháng 31 ngày
 * EP4: Tháng 2 năm thường
 * EP5: Tháng 2 năm nhuận
 * EP6: Đầu tháng
 * EP7: Đầu năm
 * EP8: Cuối năm (31/12)
 * 
 * Vùng không hợp lệ:
 * EP9: Day < 1
 * EP10: Day > 31
 * EP11: Month < 1
 * EP12: Month > 12
 * EP13: Year < 1900
 * EP14: Year > 2100
 * EP15: Ngày không tồn tại
 */
@DisplayName("NextDate - Equivalence Partitioning Tests")
public class NextDateEPTest {
    private NextDate nextDate;

    @BeforeEach
    void setUp() {
        nextDate = new NextDate();
    }

    // ============ VÙNG HỢP LỆ ============

    @Test
    @DisplayName("ND_EP_01: EP1 - Ngày thường (15,6,2024)")
    void testEP1_NormalDay() {
        String result = nextDate.getNextDate(15, 6, 2024);
        assertEquals("16/6/2024", result, "EP1: Ngày thường trong tháng");
    }

    @Test
    @DisplayName("ND_EP_02: EP2 - Cuối tháng 30 ngày (30,6,2024)")
    void testEP2_EndOf30DayMonth() {
        String result = nextDate.getNextDate(30, 6, 2024);
        assertEquals("1/7/2024", result, "EP2: Cuối tháng 30 ngày");
    }

    @Test
    @DisplayName("ND_EP_03: EP3 - Cuối tháng 31 ngày (31,7,2024)")
    void testEP3_EndOf31DayMonth() {
        String result = nextDate.getNextDate(31, 7, 2024);
        assertEquals("1/8/2024", result, "EP3: Cuối tháng 31 ngày");
    }

    @Test
    @DisplayName("ND_EP_04: EP4 - Tháng 2 năm thường (28,2,2023)")
    void testEP4_FebruaryNonLeap() {
        String result = nextDate.getNextDate(28, 2, 2023);
        assertEquals("1/3/2023", result, "EP4: Cuối tháng 2 năm thường");
    }

    @Test
    @DisplayName("ND_EP_05: EP5 - Tháng 2 năm nhuận (29,2,2024)")
    void testEP5_FebruaryLeap() {
        String result = nextDate.getNextDate(29, 2, 2024);
        assertEquals("1/3/2024", result, "EP5: Cuối tháng 2 năm nhuận");
    }

    @Test
    @DisplayName("ND_EP_06: EP6 - Đầu tháng (1,5,2024)")
    void testEP6_StartOfMonth() {
        String result = nextDate.getNextDate(1, 5, 2024);
        assertEquals("2/5/2024", result, "EP6: Đầu tháng");
    }

    @Test
    @DisplayName("ND_EP_07: EP7 - Đầu năm (1,1,2024)")
    void testEP7_StartOfYear() {
        String result = nextDate.getNextDate(1, 1, 2024);
        assertEquals("2/1/2024", result, "EP7: Đầu năm");
    }

    @Test
    @DisplayName("ND_EP_08: EP8 - Cuối năm (31,12,2024)")
    void testEP8_EndOfYear() {
        String result = nextDate.getNextDate(31, 12, 2024);
        assertEquals("1/1/2025", result, "EP8: Cuối năm");
    }

    // ============ VÙNG KHÔNG HỢP LỆ ============

    @Test
    @DisplayName("ND_EP_09: EP9 - Day < 1 (0,6,2024)")
    void testEP9_DayLessThan1() {
        String result = nextDate.getNextDate(0, 6, 2024);
        assertEquals("Invalid date", result, "EP9: Day < 1 không hợp lệ");
    }

    @Test
    @DisplayName("ND_EP_10: EP10 - Day > 31 (32,1,2024)")
    void testEP10_DayGreaterThan31() {
        String result = nextDate.getNextDate(32, 1, 2024);
        assertEquals("Invalid date", result, "EP10: Day > 31 không hợp lệ");
    }

    @Test
    @DisplayName("ND_EP_11: EP11 - Month < 1 (15,0,2024)")
    void testEP11_MonthLessThan1() {
        String result = nextDate.getNextDate(15, 0, 2024);
        assertEquals("Invalid date", result, "EP11: Month < 1 không hợp lệ");
    }

    @Test
    @DisplayName("ND_EP_12: EP12 - Month > 12 (15,13,2024)")
    void testEP12_MonthGreaterThan12() {
        String result = nextDate.getNextDate(15, 13, 2024);
        assertEquals("Invalid date", result, "EP12: Month > 12 không hợp lệ");
    }

    @Test
    @DisplayName("ND_EP_13: EP13 - Year < 1900 (1,1,1899)")
    void testEP13_YearLessThan1900() {
        String result = nextDate.getNextDate(1, 1, 1899);
        assertEquals("Invalid date", result, "EP13: Year < 1900 không hợp lệ");
    }

    @Test
    @DisplayName("ND_EP_14: EP14 - Year > 2100 (1,1,2101)")
    void testEP14_YearGreaterThan2100() {
        String result = nextDate.getNextDate(1, 1, 2101);
        assertEquals("Invalid date", result, "EP14: Year > 2100 không hợp lệ");
    }

    @Test
    @DisplayName("ND_EP_15: EP15 - Ngày không tồn tại (31,4,2024)")
    void testEP15_InvalidDay() {
        String result = nextDate.getNextDate(31, 4, 2024);
        assertEquals("Invalid date", result, "EP15: Tháng 4 không có 31 ngày");
    }

    @Test
    @DisplayName("ND_EP_16: EP15 - Tháng 2 không tồn tại (30,2,2024)")
    void testEP15_FebruaryInvalidDay() {
        String result = nextDate.getNextDate(30, 2, 2024);
        assertEquals("Invalid date", result, "EP15: Tháng 2 không có 30 ngày");
    }
}