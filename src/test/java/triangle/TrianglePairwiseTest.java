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
    @DisplayName("TRI_PW_01: Small-Medium boundary (8,50,50)")
    void testPairwiseSmallMediumBoundary() {
        String result = triangle.classifyTriangle(8, 50, 50);
        assertEquals("Isosceles", result, 
            "Kết hợp: Small-Medium-Medium, test boundary giữa 2 vùng");
    }

    @Test
    @DisplayName("TRI_PW_02: Medium-Large boundary (50,150,180)")
    void testPairwiseMediumLargeBoundary() {
        String result = triangle.classifyTriangle(50, 150, 180);
        assertEquals("Scalene", result, 
            "Kết hợp: Medium-Large-Large, test boundary giữa 2 vùng");
    }

    @Test
    @DisplayName("TRI_PW_03: Small-Large gap (5,80,150)")
    void testPairwiseSmallLargeGap() {
        String result = triangle.classifyTriangle(5, 80, 150);
        assertEquals("Not a triangle", result, 
            "Kết hợp: Small-Medium-Large với khoảng cách lớn → Invalid");
    }

    @Test
    @DisplayName("TRI_PW_04: Medium-Medium-Medium (60,70,80)")
    void testPairwiseMediumRange() {
        String result = triangle.classifyTriangle(60, 70, 80);
        assertEquals("Scalene", result, 
            "Kết hợp: Medium-Medium-Medium, test tam giác trong vùng Medium");
    }
}