package nextdate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import software_testing_project.NextDate;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Decision Table Tests cho NextDate
 * Kiểm tra các tổ hợp điều kiện và kết quả tương ứng
 * 
 * Bảng quyết định:
 * Điều kiện: C1(Valid) | C2(End Month) | C3(End Year) | C4(Leap) | Action
 * R1:           Y              N               N            -       day + 1
 * R2:           Y              Y               N            -       1/(month+1)/year
 * R3:           Y              Y               Y            -       1/1/(year+1)
 * R4:           N              *               *            *       Invalid date
 */
@DisplayName("NextDate - Decision Table Tests")
public class NextDateDecisionTableTest {
    private NextDate nextDate;

    @BeforeEach
    void setUp() {
        nextDate = new NextDate();
    }

    @Test
    @DisplayName("ND_DT_01: R1 - Normal day (15/8/2023)")
    void testRule1_NormalDay() {
        String result = nextDate.getNextDate(15, 8, 2023);
        assertEquals("16/8/2023", result, 
            "Rule 1: Valid && !End Month && !End Year -> day+1");
    }

    @Test
    @DisplayName("ND_DT_02: R2 - End of month (30/9/2023)")
    void testRule2_EndOfMonth() {
        String result = nextDate.getNextDate(30, 9, 2023);
        assertEquals("1/10/2023", result, 
            "Rule 2: Valid && End Month && !End Year -> 1/(month+1)/year");
    }

    @Test
    @DisplayName("ND_DT_03: R3 - End of year (31/12/2023)")
    void testRule3_EndOfYear() {
        String result = nextDate.getNextDate(31, 12, 2023);
        assertEquals("1/1/2024", result, 
            "Rule 3: Valid && End Month && End Year -> 1/1/(year+1)");
    }

    @Test
    @DisplayName("ND_DT_04: R4 - Invalid date (31/9/2023)")
    void testRule4_InvalidDate() {
        String result = nextDate.getNextDate(31, 9, 2023);
        assertEquals("Invalid date", result, 
            "Rule 4: !Valid -> Invalid date");
    }
}