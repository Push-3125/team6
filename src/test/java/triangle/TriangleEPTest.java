package triangle;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import software_testing_project.Triangle;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Equivalence Partitioning Tests cho Triangle
 * Phân vùng các trường hợp đầu vào thành các lớp tương đương
 * 
 * Vùng hợp lệ:
 * EP1: Tam giác đều (a=b=c)
 * EP2: Tam giác cân (a=b≠c)
 * EP3: Tam giác cân (b=c≠a)
 * EP4: Tam giác cân (a=c≠b)
 * EP5: Tam giác thường (a≠b≠c)
 * 
 * Vùng không hợp lệ:
 * EP6: Cạnh ≤ 0
 * EP7: Cạnh > 200
 * EP8: Vi phạm BĐT (a+b≤c)
 * EP9: Vi phạm BĐT (a+c≤b)
 * EP10: Vi phạm BĐT (b+c≤a)
 */
@DisplayName("Triangle - Equivalence Partitioning Tests")
public class TriangleEPTest {
    private Triangle triangle;

    @BeforeEach
    void setUp() {
        triangle = new Triangle();
    }

    @Test
    @DisplayName("TRI_EP_01: EP1 - Tam giác đều (50,50,50)")
    void testEP1_Equilateral() {
        String result = triangle.classifyTriangle(50, 50, 50);
        assertEquals("Equilateral", result, "EP1: a=b=c -> Tam giác đều");
    }

    @Test
    @DisplayName("TRI_EP_02: EP2 - Tam giác cân a=b (60,60,80)")
    void testEP2_Isosceles_AB() {
        String result = triangle.classifyTriangle(60, 60, 80);
        assertEquals("Isosceles", result, "EP2: a=b≠c -> Tam giác cân");
    }

    @Test
    @DisplayName("TRI_EP_03: EP3 - Tam giác cân b=c (70,90,90)")
    void testEP3_Isosceles_BC() {
        String result = triangle.classifyTriangle(70, 90, 90);
        assertEquals("Isosceles", result, "EP3: b=c≠a -> Tam giác cân");
    }

    @Test
    @DisplayName("TRI_EP_04: EP4 - Tam giác cân a=c (100,80,100)")
    void testEP4_Isosceles_AC() {
        String result = triangle.classifyTriangle(100, 80, 100);
        assertEquals("Isosceles", result, "EP4: a=c≠b -> Tam giác cân");
    }

    @Test
    @DisplayName("TRI_EP_05: EP5 - Tam giác thường (30,40,50)")
    void testEP5_Scalene() {
        String result = triangle.classifyTriangle(30, 40, 50);
        assertEquals("Scalene", result, "EP5: a≠b≠c -> Tam giác thường");
    }

    @Test
    @DisplayName("TRI_EP_06: EP6 - Cạnh = 0 (0,5,5)")
    void testEP6_SideZero() {
        String result = triangle.classifyTriangle(0, 5, 5);
        assertEquals("Not a triangle", result, "EP6: Cạnh = 0 không hợp lệ");
    }

    @Test
    @DisplayName("TRI_EP_07: EP6 - Cạnh âm (-5,10,10)")
    void testEP6_SideNegative() {
        String result = triangle.classifyTriangle(-5, 10, 10);
        assertEquals("Not a triangle", result, "EP6: Cạnh âm không hợp lệ");
    }

    @Test
    @DisplayName("TRI_EP_08: EP7 - Cạnh > 200 (201,100,100)")
    void testEP7_SideOver200() {
        String result = triangle.classifyTriangle(201, 100, 100);
        assertEquals("Not a triangle", result, "EP7: Cạnh > 200 không hợp lệ");
    }

    @Test
    @DisplayName("TRI_EP_09: EP8 - Vi phạm BĐT a+b≤c (3,4,10)")
    void testEP8_ViolateAB() {
        String result = triangle.classifyTriangle(3, 4, 10);
        assertEquals("Not a triangle", result, "EP8: a+b < c -> Vi phạm BĐT");
    }

    @Test
    @DisplayName("TRI_EP_10: EP9 - Vi phạm BĐT a+c≤b (10,4,3)")
    void testEP9_ViolateAC() {
        String result = triangle.classifyTriangle(10, 4, 3);
        assertEquals("Not a triangle", result, "EP9: a+c < b -> Vi phạm BĐT");
    }

    @Test
    @DisplayName("TRI_EP_11: EP10 - Vi phạm BĐT b+c≤a (3,10,4)")
    void testEP10_ViolateBC() {
        String result = triangle.classifyTriangle(3, 10, 4);
        assertEquals("Not a triangle", result, "EP10: b+c < a -> Vi phạm BĐT");
    }

    @Test
    @DisplayName("TRI_EP_12: EP8 - Tổng = cạnh thứ 3 (3,4,7)")
    void testEP8_SumEqual() {
        String result = triangle.classifyTriangle(3, 4, 7);
        assertEquals("Not a triangle", result, "EP8: a+b = c -> Tam giác suy biến");
    }
}