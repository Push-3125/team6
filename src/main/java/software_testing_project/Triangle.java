package software_testing_project;

public class Triangle {
    private static final int MIN_SIDE = 1;
    private static final int MAX_SIDE = 200;

    /**
     * Xác định loại tam giác dựa trên độ dài 3 cạnh
     * @param a độ dài cạnh a
     * @param b độ dài cạnh b
     * @param c độ dài cạnh c
     * @return Loại tam giác: "Equilateral", "Isosceles", "Scalene", hoặc "Not a triangle"
     */
    public String classifyTriangle(int a, int b, int c) {
        // Kiểm tra giá trị hợp lệ
        if (!isValidInput(a, b, c)) {
            return "Not a triangle";
        }

        // Kiểm tra bất đẳng thức tam giác
        if (!isTriangle(a, b, c)) {
            return "Not a triangle";
        }

        // Xác định loại tam giác
        if (a == b && b == c) {
            return "Equilateral";
        } else if (a == b || b == c || a == c) {
            return "Isosceles";
        } else {
            return "Scalene";
        }
    }

    /**
     * Kiểm tra input có hợp lệ không
     */
    private boolean isValidInput(int a, int b, int c) {
        // Kiểm tra các giá trị phải nằm trong khoảng MIN_SIDE đến MAX_SIDE
        if (a < MIN_SIDE || a > MAX_SIDE) {
            return false;
        }
        if (b < MIN_SIDE || b > MAX_SIDE) {
            return false;
        }
        if (c < MIN_SIDE || c > MAX_SIDE) {
            return false;
        }
        return true;
    }

    /**
     * Kiểm tra bất đẳng thức tam giác
     * Tổng 2 cạnh bất kỳ phải lớn hơn cạnh còn lại
     */
    private boolean isTriangle(int a, int b, int c) {
        return (a + b > c) && (a + c > b) && (b + c > a);
    }

    /**
     * Method để test từng điều kiện riêng lẻ (hỗ trợ white-box testing)
     */
    public boolean checkValidInput(int a, int b, int c) {
        return isValidInput(a, b, c);
    }

    public boolean checkTriangleInequality(int a, int b, int c) {
        return isTriangle(a, b, c);
    }
}
