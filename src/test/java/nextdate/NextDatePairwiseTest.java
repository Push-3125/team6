package nextdate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import software_testing_project.NextDate;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Pairwise Combinatorial Testing cho NextDate
 * 
 * Các tham số:
 * - Day: Start(1), Middle(15), End28(28), End29(29), End30(30), End31(31)
 * - Month: Jan(1), Feb(2), Apr(4), Dec(12)
 * - Year: NonLeap(2023), Leap(2020), Boundary(2024)
 * 
 * PICT sẽ tạo tổ hợp tối ưu để test tất cả cặp giá trị
 */
@DisplayName("NextDate - Pairwise Combinatorial Tests")
public class NextDatePairwiseTest {
    private NextDate nextDate;

    @BeforeEach
    void setUp() {
        nextDate = new NextDate();
    }

    @Test
    @DisplayName("ND_PW_01: Middle day in leap Feb (15/2/2024)")
    void testPairwiseMiddleDayLeapFeb() {
        String result = nextDate.getNextDate(15, 2, 2024);
        assertEquals("16/2/2024", result, 
            "Kết hợp: Middle-Feb-Leap, test ngày giữa tháng 2 năm nhuận");
    }

    @Test
    @DisplayName("ND_PW_02: End29 in 31-day month (29/1/2024)")
    void testPairwiseEnd29In31DayMonth() {
        String result = nextDate.getNextDate(29, 1, 2024);
        assertEquals("30/1/2024", result, 
            "Kết hợp: End29-Jan-Leap, test ngày 29 trong tháng 31 ngày");
    }

    @Test
    @DisplayName("ND_PW_03: End30 in December (30/12/2024)")
    void testPairwiseEnd30InDecember() {
        String result = nextDate.getNextDate(30, 12, 2024);
        assertEquals("31/12/2024", result, 
            "Kết hợp: End30-Dec-Leap, test ngày 30 trong tháng cuối năm");
    }

    @Test
    @DisplayName("ND_PW_04: End29 in 30-day month (29/4/2024)")
    void testPairwiseEnd29In30DayMonth() {
        String result = nextDate.getNextDate(29, 4, 2024);
        assertEquals("30/4/2024", result, 
            "Kết hợp: End29-Apr-Leap, test ngày 29 trong tháng 30 ngày");
    }
}