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
    @DisplayName("ND_BVA_01: MIN Year (1/1/1900 → 2/1/1900)")
    void testBVA_01() {
        String result = nextDate.getNextDate(1, 1, 1900);
        assertEquals("2/1/1900", result);
    }

    @Test
    @DisplayName("ND_BVA_02: MAX Year (31/12/2100 → 1/1/2101)")
    void testBVA_02() {
        String result = nextDate.getNextDate(31, 12, 2100);
        assertEquals("1/1/2101", result);
    }

    @Test
    @DisplayName("ND_BVA_03: MIN-1 Year (31/12/1899 → Invalid)")
    void testBVA_03() {
        String result = nextDate.getNextDate(31, 12, 1899);
        assertEquals("Invalid date", result);
    }

    @Test
    @DisplayName("ND_BVA_04: MAX+1 Year (1/1/2101 → Invalid)")
    void testBVA_04() {
        String result = nextDate.getNextDate(1, 1, 2101);
        assertEquals("Invalid date", result);
    }

    @Test
    @DisplayName("ND_BVA_05: Biên tháng 2 không nhuận (28/2/2023 → 1/3/2023)")
    void testBVA_05() {
        String result = nextDate.getNextDate(28, 2, 2023);
        assertEquals("1/3/2023", result);
    }

    @Test
    @DisplayName("ND_BVA_06: Biên tháng 2 nhuận (29/2/2024 → 1/3/2024)")
    void testBVA_06() {
        String result = nextDate.getNextDate(29, 2, 2024);
        assertEquals("1/3/2024", result);
    }

    @Test
    @DisplayName("ND_BVA_07: Biên tháng 30 ngày (30/6/2024 → 1/7/2024)")
    void testBVA_07() {
        String result = nextDate.getNextDate(30, 6, 2024);
        assertEquals("1/7/2024", result);
    }

    @Test
    @DisplayName("ND_BVA_08: Biên tháng 31 ngày (31/7/2024 → 1/8/2024)")
    void testBVA_08() {
        String result = nextDate.getNextDate(31, 7, 2024);
        assertEquals("1/8/2024", result);
    }
}