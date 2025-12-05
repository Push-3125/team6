package triangle;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import software_testing_project.Triangle;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Pairwise Combinatorial Testing cho Triangle
 * Sử dụng PICT (Pairwise Independent Combinatorial Testing)
 * 
 * Các tham số:
 * - Side_A: Small(1-10), Medium(11-100), Large(101-200)
 * - Side_B: Small(1-10), Medium(11-100), Large(101-200)
 * - Side_C: Small(1-10), Medium(11-100), Large(101-200)
 * 
 * PICT sẽ tạo ra tổ hợp tối ưu để test tất cả cặp giá trị
 */
@DisplayName("Triangle - Pairwise Combinatorial Tests")
public class TrianglePairwiseTest {
    private Triangle triangle;

    @BeforeEach
    void setUp() {
        triangle = new Triangle();
    }

    @Test
    @DisplayName("TRI_PW_23: Pairwise Small-Large-Large (1,100,100)")
    void testPairwiseSmallLargeLarge() {
        String result = triangle.classifyTriangle(1, 100, 100);
        assertEquals("Isosceles", result, 
            "Kết hợp: Side_A=Small, Side_B=Large, Side_C=Large -> Isosceles");
    }

    @Test
    @DisplayName("TRI_PW_24: Pairwise invalid mix (1,2,10)")
    void testPairwiseInvalidMix() {
        String result = triangle.classifyTriangle(1, 2, 10);
        assertEquals("Not a triangle", result, 
            "Kết hợp: Side_A=Small, Side_B=Small, Side_C=Small (không hợp lệ)");
    }

    @Test
    @DisplayName("TRI_PW_25: Pairwise valid mix (2,3,4)")
    void testPairwiseValidMix() {
        String result = triangle.classifyTriangle(2, 3, 4);
        assertEquals("Scalene", result, 
            "Kết hợp: Side_A=Small, Side_B=Small, Side_C=Small (hợp lệ) -> Scalene");
    }
}