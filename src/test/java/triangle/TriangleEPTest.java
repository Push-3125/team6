package triangle;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import software_testing_project.Triangle;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Equivalence Partitioning Tests cho Triangle
 * Phân vùng các trường hợp đầu vào thành các lớp tương đương
 */
@DisplayName("Triangle - Equivalence Partitioning Tests")
public class TriangleEPTest {
    private Triangle triangle;

    @BeforeEach
    void setUp() {
        triangle = new Triangle();
    }

    @Test
    @DisplayName("TRI_EP_01: Equilateral triangle (5,5,5)")
    void testEquilateralTriangle() {
        String result = triangle.classifyTriangle(5, 5, 5);
        assertEquals("Equilateral", result, "Tam giác đều với 3 cạnh bằng nhau");
    }

    @Test
    @DisplayName("TRI_EP_02: Isosceles triangle (5,5,3)")
    void testIsoscelesTriangle() {
        String result = triangle.classifyTriangle(5, 5, 3);
        assertEquals("Isosceles", result, "Tam giác cân với 2 cạnh bằng nhau");
    }

    @Test
    @DisplayName("TRI_EP_03: Scalene triangle (4,5,6)")
    void testScaleneTriangle() {
        String result = triangle.classifyTriangle(4, 5, 6);
        assertEquals("Scalene", result, "Tam giác thường với 3 cạnh khác nhau");
    }

    @Test
    @DisplayName("TRI_EP_04: One side zero (0,5,5)")
    void testOneSideZero() {
        String result = triangle.classifyTriangle(0, 5, 5);
        assertEquals("Not a triangle", result, "Cạnh = 0 không hợp lệ");
    }

    @Test
    @DisplayName("TRI_EP_05: Negative side (-1,5,5)")
    void testNegativeSide() {
        String result = triangle.classifyTriangle(-1, 5, 5);
        assertEquals("Not a triangle", result, "Cạnh âm không hợp lệ");
    }

    @Test
    @DisplayName("TRI_EP_06: Sum equal to third side (3,3,6)")
    void testSumEqualToThirdSide() {
        String result = triangle.classifyTriangle(3, 3, 6);
        assertEquals("Not a triangle", result, "Tổng 2 cạnh bằng cạnh thứ 3");
    }

    @Test
    @DisplayName("TRI_EP_07: Sum less than third side (2,3,6)")
    void testSumLessThanThirdSide() {
        String result = triangle.classifyTriangle(2, 3, 6);
        assertEquals("Not a triangle", result, "Tổng 2 cạnh nhỏ hơn cạnh thứ 3");
    }

    @Test
    @DisplayName("TRI_EP_08: Large valid scalene (100,120,130)")
    void testLargeValidScalene() {
        String result = triangle.classifyTriangle(100, 120, 130);
        assertEquals("Scalene", result, "Tam giác thường với cạnh lớn");
    }

    @Test
    @DisplayName("TRI_EP_09: Large equal sides (9999,9999,9999)")
    void testLargeEqualSides() {
        String result = triangle.classifyTriangle(9999, 9999, 9999);
        assertEquals("Not a triangle", result, "Cạnh vượt quá giới hạn MAX_SIDE=200");
    }

    @Test
    @DisplayName("TRI_EP_10: Mixed invalid sides (-1,0,5)")
    void testMixedInvalidSides() {
        String result = triangle.classifyTriangle(-1, 0, 5);
        assertEquals("Not a triangle", result, "Nhiều cạnh không hợp lệ");
    }
}