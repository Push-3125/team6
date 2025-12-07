package triangle;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import software_testing_project.Triangle;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Helper Methods và Missing Coverage Tests cho Triangle
 */
@DisplayName("Triangle - Helper & Coverage Tests")
public class TriangleHelperTest {
    private Triangle triangle;

    @BeforeEach
    void setUp() {
        triangle = new Triangle();
    }

    // ============ TEST HELPER METHODS ============

    @Test
    @DisplayName("Helper_01: checkValidInput - all valid")
    void testCheckValidInputAllValid() {
        assertTrue(triangle.checkValidInput(1, 1, 1), "MIN boundary");
        assertTrue(triangle.checkValidInput(5, 5, 5), "Normal valid");
        assertTrue(triangle.checkValidInput(100, 100, 100), "Medium valid");
        assertTrue(triangle.checkValidInput(200, 200, 200), "MAX boundary");
        assertTrue(triangle.checkValidInput(50, 100, 150), "Mixed valid");
    }

    @Test
    @DisplayName("Helper_02: checkValidInput - invalid a")
    void testCheckValidInputInvalidA() {
        assertFalse(triangle.checkValidInput(0, 5, 5), "a = 0");
        assertFalse(triangle.checkValidInput(-1, 5, 5), "a negative");
        assertFalse(triangle.checkValidInput(-10, 5, 5), "a very negative");
        assertFalse(triangle.checkValidInput(201, 5, 5), "a > MAX");
        assertFalse(triangle.checkValidInput(300, 5, 5), "a far > MAX");
    }

    @Test
    @DisplayName("Helper_03: checkValidInput - invalid b")
    void testCheckValidInputInvalidB() {
        assertFalse(triangle.checkValidInput(5, 0, 5), "b = 0");
        assertFalse(triangle.checkValidInput(5, -1, 5), "b negative");
        assertFalse(triangle.checkValidInput(5, -10, 5), "b very negative");
        assertFalse(triangle.checkValidInput(5, 201, 5), "b > MAX");
        assertFalse(triangle.checkValidInput(5, 300, 5), "b far > MAX");
    }

    @Test
    @DisplayName("Helper_04: checkValidInput - invalid c")
    void testCheckValidInputInvalidC() {
        assertFalse(triangle.checkValidInput(5, 5, 0), "c = 0");
        assertFalse(triangle.checkValidInput(5, 5, -1), "c negative");
        assertFalse(triangle.checkValidInput(5, 5, -10), "c very negative");
        assertFalse(triangle.checkValidInput(5, 5, 201), "c > MAX");
        assertFalse(triangle.checkValidInput(5, 5, 300), "c far > MAX");
    }

    @Test
    @DisplayName("Helper_05: checkValidInput - multiple invalid")
    void testCheckValidInputMultipleInvalid() {
        assertFalse(triangle.checkValidInput(0, 0, 5), "a and b = 0");
        assertFalse(triangle.checkValidInput(0, 5, 0), "a and c = 0");
        assertFalse(triangle.checkValidInput(5, 0, 0), "b and c = 0");
        assertFalse(triangle.checkValidInput(0, 0, 0), "all = 0");
        assertFalse(triangle.checkValidInput(-1, -1, -1), "all negative");
        assertFalse(triangle.checkValidInput(201, 201, 201), "all > MAX");
    }

    @Test
    @DisplayName("Helper_06: checkTriangleInequality - valid triangles")
    void testCheckTriangleInequalityValid() {
        assertTrue(triangle.checkTriangleInequality(5, 5, 5), "Equilateral");
        assertTrue(triangle.checkTriangleInequality(5, 5, 3), "Isosceles");
        assertTrue(triangle.checkTriangleInequality(3, 4, 5), "Right triangle");
        assertTrue(triangle.checkTriangleInequality(4, 5, 6), "Scalene");
        assertTrue(triangle.checkTriangleInequality(100, 100, 150), "Large valid");
    }

    @Test
    @DisplayName("Helper_07: checkTriangleInequality - sum equals third")
    void testCheckTriangleInequalitySumEquals() {
        assertFalse(triangle.checkTriangleInequality(1, 1, 2), "1+1=2");
        assertFalse(triangle.checkTriangleInequality(2, 3, 5), "2+3=5");
        assertFalse(triangle.checkTriangleInequality(3, 3, 6), "3+3=6");
        assertFalse(triangle.checkTriangleInequality(10, 5, 15), "10+5=15");
        assertFalse(triangle.checkTriangleInequality(100, 50, 150), "100+50=150");
    }

    @Test
    @DisplayName("Helper_08: checkTriangleInequality - sum less than third")
    void testCheckTriangleInequalitySumLess() {
        assertFalse(triangle.checkTriangleInequality(1, 1, 3), "1+1<3");
        assertFalse(triangle.checkTriangleInequality(1, 2, 10), "1+2<10");
        assertFalse(triangle.checkTriangleInequality(2, 3, 6), "2+3<6");
        assertFalse(triangle.checkTriangleInequality(5, 10, 20), "5+10<20");
        assertFalse(triangle.checkTriangleInequality(10, 20, 50), "10+20<50");
    }

    @Test
    @DisplayName("Helper_09: checkTriangleInequality - different permutations")
    void testCheckTriangleInequalityPermutations() {
        // a+b <= c
        assertFalse(triangle.checkTriangleInequality(1, 2, 10), "a+b < c");
        // a+c <= b
        assertFalse(triangle.checkTriangleInequality(1, 10, 2), "a+c < b");
        // b+c <= a
        assertFalse(triangle.checkTriangleInequality(10, 1, 2), "b+c < a");
    }

    // ============ MISSING COVERAGE TESTS ============

    @Test
    @DisplayName("Coverage_01: Boundary combinations")
    void testBoundaryCombinations() {        // Equilateral at boundaries
        assertEquals("Equilateral", triangle.classifyTriangle(1, 1, 1), "MIN all equal");
        assertEquals("Equilateral", triangle.classifyTriangle(200, 200, 200), "MAX all equal");        
        assertEquals("Isosceles", triangle.classifyTriangle(2, 2, 3), "Small isosceles");
        assertEquals("Isosceles", triangle.classifyTriangle(1, 100, 100), "MIN-MID isosceles");
        assertEquals("Isosceles", triangle.classifyTriangle(199, 200, 200), "MAX-1 isosceles");               
        assertEquals("Scalene", triangle.classifyTriangle(2, 3, 4), "Small scalene");
        assertEquals("Scalene", triangle.classifyTriangle(100, 120, 130), "Mid scalene");
    }

    @Test
    @DisplayName("Coverage_02: Large scalene triangles")
    void testLargeScaleneTriangles() {
        assertEquals("Scalene", triangle.classifyTriangle(100, 120, 130), "Large scalene 1");
        assertEquals("Scalene", triangle.classifyTriangle(150, 160, 170), "Large scalene 2");
        assertEquals("Scalene", triangle.classifyTriangle(180, 190, 195), "Large scalene 3");
    }

    @Test
    @DisplayName("Coverage_03: Isosceles variations")
    void testIsoscelesVariations() {
        assertEquals("Isosceles", triangle.classifyTriangle(5, 5, 8), "a==b");
        assertEquals("Isosceles", triangle.classifyTriangle(5, 8, 5), "a==c");
        assertEquals("Isosceles", triangle.classifyTriangle(8, 5, 5), "b==c");
    }

    @Test
    @DisplayName("Coverage_04: Edge of validity")
    void testEdgeOfValidity() {
        assertEquals("Scalene", triangle.classifyTriangle(100, 51, 150), "Just valid");
        assertEquals("Not a triangle", triangle.classifyTriangle(100, 50, 150), "Just invalid (sum=)");
        assertEquals("Not a triangle", triangle.classifyTriangle(100, 49, 150), "Just invalid (sum<)");
    }

    @Test
    @DisplayName("Coverage_05: Various invalid inputs")
    void testVariousInvalidInputs() {
        assertEquals("Not a triangle", triangle.classifyTriangle(0, 0, 0), "All zero");
        assertEquals("Not a triangle", triangle.classifyTriangle(-5, -5, -5), "All negative");
        assertEquals("Not a triangle", triangle.classifyTriangle(500, 500, 500), "All > MAX");
        assertEquals("Not a triangle", triangle.classifyTriangle(-1, 201, 5), "Mixed invalid");
    }
}