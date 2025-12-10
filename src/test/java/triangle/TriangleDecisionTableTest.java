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
 * Điều kiện: C1(a==b) | C2(b==c) | C3(a==c) | C4(Valid) | Kết quả
 * R1:           Y          Y          Y          Y        Equilateral
 * R2:           Y          N          N          Y        Isosceles
 * R3:           N          Y          N          Y        Isosceles
 * R4:           N          N          Y          Y        Isosceles
 * R5:           N          N          N          Y        Scalene
 * R6:           *          *          *          N        Not a triangle
 */
@DisplayName("Triangle - Decision Table Tests")
public class TriangleDecisionTableTest {
    private Triangle triangle;

    @BeforeEach
    void setUp() {
        triangle = new Triangle();
    }

    @Test
    @DisplayName("TRI_DT_19: R1 - Equilateral (50,50,50)")
    void testRule1_Equilateral() {
        String result = triangle.classifyTriangle(50, 50, 50);
        assertEquals("Equilateral", result, 
            "Rule 1: a==b && b==c && a==c && valid -> Equilateral");
    }

    @Test
    @DisplayName("TRI_DT_20: R2 - Isosceles a=b (60,60,80)")
    void testRule2_Isosceles_AB() {
        String result = triangle.classifyTriangle(60, 60, 80);
        assertEquals("Isosceles", result, 
            "Rule 2: a==b && b!=c && a!=c && valid -> Isosceles");
    }

    @Test
    @DisplayName("TRI_DT_21: R3 - Isosceles b=c (70,90,90)")
    void testRule3_Isosceles_BC() {
        String result = triangle.classifyTriangle(70, 90, 90);
        assertEquals("Isosceles", result, 
            "Rule 3: a!=b && b==c && a!=c && valid -> Isosceles");
    }

    @Test
    @DisplayName("TRI_DT_22: R4 - Isosceles a=c (100,80,100)")
    void testRule4_Isosceles_AC() {
        String result = triangle.classifyTriangle(100, 80, 100);
        assertEquals("Isosceles", result, 
            "Rule 4: a!=b && b!=c && a==c && valid -> Isosceles");
    }

    @Test
    @DisplayName("TRI_DT_23: R5 - Scalene (30,40,50)")
    void testRule5_Scalene() {
        String result = triangle.classifyTriangle(30, 40, 50);
        assertEquals("Scalene", result, 
            "Rule 5: a!=b && b!=c && a!=c && valid -> Scalene");
    }

    @Test
    @DisplayName("TRI_DT_24: R6 - Not a triangle (3,4,7)")
    void testRule6_NotATriangle() {
        String result = triangle.classifyTriangle(3, 4, 7);
        assertEquals("Not a triangle", result, 
            "Rule 6: Vi phạm bất đẳng thức tam giác -> Not a triangle");
    }
}