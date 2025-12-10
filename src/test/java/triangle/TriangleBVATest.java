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
    @DisplayName("TRI_BVA_01: (1,1,1) → Equilateral")
    void testBVA_T01() {
        assertEquals("Equilateral",
                triangle.classifyTriangle(1, 1, 1));
    }    
    
    @Test
    @DisplayName("TRI_BVA_02: (2,2,2) → Equilateral")
    void testBVA_T02() {
        assertEquals("Equilateral",
                triangle.classifyTriangle(2, 2, 2));
    }

    @Test
    @DisplayName("TRI_BVA_03: (199,199,199) → Equilateral")
    void testBVA_T03() {
        assertEquals("Equilateral",
                triangle.classifyTriangle(199, 199, 199));
    }

    @Test
    @DisplayName("TRI_BVA_04: (200,200,200) → Equilateral")
    void testBVA_T04() {
        assertEquals("Equilateral",
                triangle.classifyTriangle(200, 200, 200));
    }

    @Test
    @DisplayName("TRI_BVA_05: (0,5,5) → Not a triangle")
    void testBVA_T05() {
        assertEquals("Not a triangle",
                triangle.classifyTriangle(0, 5, 5));
    }

    @Test
    @DisplayName("TRI_BVA_6: (201,100,100) → Not a triangle")
    void testBVA_T06() {
        assertEquals("Not a triangle",
                triangle.classifyTriangle(201, 100, 100));
    }

    @Test
    @DisplayName("TRI_BVA_07: (3,4,7) → Not a triangle (a+b=c)")
    void testBVA_T07() {
        assertEquals("Not a triangle",
                triangle.classifyTriangle(3, 4, 7));
    }

    @Test
    @DisplayName("TRI_BVA_08: (3,4,6) → Scalene (a+b=c+1)")
    void testBVA_T08() {
        assertEquals("Scalene",
                triangle.classifyTriangle(3, 4, 6));
    }
}