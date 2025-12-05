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
    @DisplayName("ND_PW_23: Pairwise small day (1/12/2023)")
    void testPairwiseSmallDay() {
        String result = nextDate.getNextDate(1, 12, 2023);
        assertEquals("2/12/2023", result, 
            "Kết hợp: Day=Start, Month=Dec, Year=NonLeap");
    }

    @Test
    @DisplayName("ND_PW_24: Pairwise month change (31/3/2023)")
    void testPairwiseMonthChange() {
        String result = nextDate.getNextDate(31, 3, 2023);
        assertEquals("1/4/2023", result, 
            "Kết hợp: Day=End31, Month=Mar, chuyển sang tháng 4");
    }

    @Test
    @DisplayName("ND_PW_25: Pairwise leap boundary (28/2/2020)")
    void testPairwiseLeapBoundary() {
        String result = nextDate.getNextDate(28, 2, 2020);
        assertEquals("29/2/2020", result, 
            "Kết hợp: Day=End28, Month=Feb, Year=Leap -> có ngày 29");
    }

    @Test
    @DisplayName("ND_PW_26: Pairwise year end (31/12/2024)")
    void testPairwiseYearEnd() {
        String result = nextDate.getNextDate(31, 12, 2024);
        assertEquals("1/1/2025", result, 
            "Kết hợp: Day=End31, Month=Dec, chuyển sang năm mới");
    }
}