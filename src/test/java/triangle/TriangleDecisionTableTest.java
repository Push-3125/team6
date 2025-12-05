package triangle;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import software_testing_project.Triangle;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Decision Table Tests cho Triangle
 * Kiểm tra các tổ hợp điều kiện và kết quả tương ứng
 * 
 * Bảng quyết định:
 * Điều kiện: a==b | b==c | a==c | a+b>c | a+c>b | b+c>a | Kết quả
 * R1:          T      T      T      T        T        T     Equilateral
 * R2:          T      F      F      T        T        T     Isosceles
 * R3:          F      F      F      T        T        T     Scalene
 * R4:          F      F      F      F        -        -     Not a triangle
 */
@DisplayName("Triangle - Decision Table Tests")
public class TriangleDecisionTableTest {
    private Triangle triangle;

    @BeforeEach
    void setUp() {
        triangle = new Triangle();
    }

    @Test
    @DisplayName("TRI_DT_19: Decision table - Equilateral (7,7,7)")
    void testDecisionTableEquilateral() {
        String result = triangle.classifyTriangle(7, 7, 7);
        assertEquals("Equilateral", result, 
            "Rule 1: a==b && b==c && a==c && tam giác hợp lệ -> Equilateral");
    }

    @Test
    @DisplayName("TRI_DT_20: Decision table - Isosceles (8,8,5)")
    void testDecisionTableIsosceles() {
        String result = triangle.classifyTriangle(8, 8, 5);
        assertEquals("Isosceles", result, 
            "Rule 2: a==b && b!=c && tam giác hợp lệ -> Isosceles");
    }

    @Test
    @DisplayName("TRI_DT_21: Decision table - Scalene (4,5,7)")
    void testDecisionTableScalene() {
        String result = triangle.classifyTriangle(4, 5, 7);
        assertEquals("Scalene", result, 
            "Rule 3: a!=b && b!=c && a!=c && tam giác hợp lệ -> Scalene");
    }

    @Test
    @DisplayName("TRI_DT_22: Decision table - Invalid (4,-1,7)")
    void testDecisionTableInvalid() {
        String result = triangle.classifyTriangle(4, -1, 7);
        assertEquals("Not a triangle", result, 
            "Rule 4: Input không hợp lệ -> Not a triangle");
    }
}