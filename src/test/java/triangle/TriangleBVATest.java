package triangle;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import software_testing_project.Triangle;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Boundary Value Analysis Tests cho Triangle
 * Kiểm tra các giá trị biên: MIN=1, MAX=200
 */
@DisplayName("Triangle - Boundary Value Analysis Tests")
public class TriangleBVATest {
    private Triangle triangle;

    @BeforeEach
    void setUp() {
        triangle = new Triangle();
    }

    @Test
    @DisplayName("TRI_BVA_11: Minimum boundary (1,1,1)")
    void testMinimumBoundary() {
        String result = triangle.classifyTriangle(1, 1, 1);
        assertEquals("Equilateral", result, "Tam giác đều tại giá trị MIN=1");
    }

    @Test
    @DisplayName("TRI_BVA_12: Min+1 boundary (1,1,2)")
    void testMinPlusOneBoundary() {
        String result = triangle.classifyTriangle(1, 1, 2);
        assertEquals("Not a triangle", result, "1+1=2, không thỏa bất đẳng thức tam giác");
    }

    @Test
    @DisplayName("TRI_BVA_13: Maximum boundary equal (200,200,200)")
    void testMaximumBoundaryEqual() {
        String result = triangle.classifyTriangle(200, 200, 200);
        assertEquals("Equilateral", result, "Tam giác đều tại giá trị MAX=200");
    }

    @Test
    @DisplayName("TRI_BVA_14: Maximum boundary mixed (199,200,200)")
    void testMaximumBoundaryMixed() {
        String result = triangle.classifyTriangle(199, 200, 200);
        assertEquals("Isosceles", result, "Tam giác cân gần giá trị MAX");
    }

    @Test
    @DisplayName("TRI_BVA_15: Above maximum boundary (201,200,200)")
    void testAboveMaximumBoundary() {
        String result = triangle.classifyTriangle(201, 200, 200);
        assertEquals("Not a triangle", result, "Một cạnh vượt quá MAX=200");
    }

    @Test
    @DisplayName("TRI_BVA_16: Sum boundary equal (100,50,150)")
    void testSumBoundaryEqual() {
        String result = triangle.classifyTriangle(100, 50, 150);
        assertEquals("Not a triangle", result, "100+50=150, tổng bằng cạnh thứ 3");
    }

    @Test
    @DisplayName("TRI_BVA_17: Sum boundary valid (100,51,150)")
    void testSumBoundaryValid() {
        String result = triangle.classifyTriangle(100, 51, 150);
        assertEquals("Scalene", result, "100+51>150, thỏa bất đẳng thức");
    }

    @Test
    @DisplayName("TRI_BVA_18: Sum boundary invalid (100,49,150)")
    void testSumBoundaryInvalid() {
        String result = triangle.classifyTriangle(100, 49, 150);
        assertEquals("Not a triangle", result, "100+49<150, không thỏa bất đẳng thức");
    }
}