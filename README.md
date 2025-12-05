<<<<<<< HEAD
<<<<<<< HEAD
# 🧪 Software Testing Project - Triangle & NextDate

## 📋 Tổng quan

Dự án áp dụng các kỹ thuật kiểm thử phần mềm cho 2 bài toán

- Triangle Xác định loại tam giác dựa trên độ dài 3 cạnh
- NextDate Tính toán ngày tiếp theo

## 🎯 Mục tiêu

Áp dụng và so sánh hiệu quả của 4 kỹ thuật kiểm thử Black-box

1. Equivalence Partitioning (EP) - Phân vùng tương đương
2. Boundary Value Analysis (BVA) - Phân tích giá trị biên
3. Decision Table (DT) - Bảng quyết định
4. Combinatorial Testing - Kiểm thử tổ hợp (sử dụng PICT)

## 🏗️ Cấu trúc dự án

```
software-testing-project
├── pom.xml                          # Maven configuration
├── README.md                        # Documentation
├── src
│   ├── mainjava
│   │   ├── Triangle.java           # Triangle classifier
│   │   └── NextDate.java           # NextDate calculator
│   └── testjava
│       ├── triangle
│       │   ├── TriangleEPTest.java          # 10 tests - EP
│       │   ├── TriangleBVATest.java         # 8 tests - BVA
│       │   ├── TriangleDecisionTableTest.java # 4 tests - DT
│       │   └── TrianglePairwiseTest.java    # 3 tests - Pairwise
│       ├── nextdate
│       │   ├── NextDateEPTest.java          # 10 tests - EP
│       │   ├── NextDateBVATest.java         # 8 tests - BVA
│       │   ├── NextDateDecisionTableTest.java # 4 tests - DT
│       │   └── NextDatePairwiseTest.java    # 4 tests - Pairwise
│       └── TestSuite.java          # Complete test suite
└── pict
    ├── triangle.txt                # PICT config for Triangle
    └── nextdate.txt                # PICT config for NextDate
```

## 🚀 Hướng dẫn cài đặt

### 1. Prerequisites

- Java JDK 11 hoặc cao hơn
- Maven 3.6+
- IDE IntelliJ IDEA Eclipse VS Code
- PICT tool (optional, cho Combinatorial Testing)

### 2. Clone và setup

```bash
# Clone repository
git clone your-repo-url
cd software-testing-project

# Build project
mvn clean compile
```

## 🧪 Chạy Tests

### Chạy tất cả tests

```bash
mvn test
```

### Chạy tests với code coverage (JaCoCo)

```bash
mvn clean test jacocoreport
```

Report sẽ được tạo tại `targetsitejacocoindex.html`

### Chạy tests theo class cụ thể

```bash
# Triangle EP tests
mvn test -Dtest=TriangleEPTest

# NextDate BVA tests
mvn test -Dtest=NextDateBVATest

# Chạy tất cả Triangle tests
mvn test -Dtest=triangle.
```

### Chạy tests trong IDE

1. Right-click vào class test hoặc method test
2. Chọn Run 'ClassName' hoặc Run 'testMethodName()'
3. Xem kết quả trong Test Runner panel

## 📊 Kỹ thuật kiểm thử đã áp dụng

### 1. Equivalence Partitioning (EP)

Mục đích Phân chia input thành các vùng tương đương, mỗi vùng đại diện cho một nhóm dữ liệu có hành vi giống nhau.

Triangle - 10 test cases

- Valid triangles Equilateral, Isosceles, Scalene
- Invalid inputs zero, negative, out of bounds
- Invalid triangles không thỏa bất đẳng thức tam giác

NextDate - 10 test cases

- Normal days, end of months (3031 days)
- February (leapnon-leap years)
- Invalid dates (daymonthyear)

### 2. Boundary Value Analysis (BVA)

Mục đích Tập trung test các giá trị biên vì lỗi thường xảy ra ở đây.

Triangle - 8 test cases

- MIN boundary 1
- MAX boundary 200
- Triangle inequality boundaries

NextDate - 8 test cases

- Day boundaries 1, 28, 29, 30, 31
- Month boundaries 1, 12
- Year boundaries 1900, 2100

### 3. Decision Table (DT)

Mục đích Test các tổ hợp điều kiện và kết quả tương ứng.

Triangle - 4 test cases

- All sides equal → Equilateral
- Two sides equal → Isosceles
- No sides equal → Scalene
- Invalid conditions → Not a triangle

NextDate - 4 test cases

- Normal day → day+1
- End of month → 1(month+1)
- End of year → 11(year+1)
- Invalid date → Invalid date

### 4. Combinatorial Testing (Pairwise)

Mục đích Test tất cả cặp giá trị có thể của các tham số (sử dụng PICT tool).

Triangle - 3 test cases

- Side combinations SmallMediumLarge

NextDate - 4 test cases

- DayMonthYear combinations

## 🔧 Sử dụng PICT Tool

### Cài đặt PICT

```bash
# Windows
choco install pict

# Linux
# Download từ httpsgithub.comMicrosoftpict
# Build và install theo hướng dẫn

# macOS
brew install pict
```

### Tạo test cases với PICT

```bash
# Triangle
cd pict
pict triangle.txt  triangle_testcases.txt

# NextDate
pict nextdate.txt  nextdate_testcases.txt
```

PICT sẽ tự động tạo ra tổ hợp test cases tối ưu dựa trên các constraints đã định nghĩa.

## 📈 Code Coverage với JaCoCo

### Xem report

Sau khi chạy `mvn clean test jacocoreport`, mở file

```
targetsitejacocoindex.html
```

### Các metrics quan trọng

- Line Coverage Tỷ lệ dòng code được test
- Branch Coverage Tỷ lệ nhánh điều kiện được test
- Method Coverage Tỷ lệ methods được test
- Class Coverage Tỷ lệ classes được test

### Mục tiêu Coverage

- Target ≥ 80% line coverage
- Ideal ≥ 90% line coverage + ≥ 85% branch coverage

## 📊 Kết quả thống kê

### Tổng số test cases

## Component EP BVA DT Pairwise Total

Triangle 10 8 4 3 25
NextDate 10 8 4 4 26
Total 20 16 8 7 51

### So sánh hiệu quả các kỹ thuật

## Kỹ thuật Ưu điểm Nhược điểm Số lượng tests

EP Bao phủ rộng, dễ thiết kế Có thể bỏ sót edge cases 20
BVA Phát hiện lỗi biên hiệu quả Không test logic phức tạp 16
DT Bao phủ tổ hợp điều kiện Phức tạp với nhiều điều kiện 8
Pairwise Tối ưu số lượng tests Cần công cụ, thiết lập phức tạp 7

## 🎓 Đánh giá và Kết luận

### Hiệu quả từng kỹ thuật

1. Equivalence Partitioning

   ✅ Tốt cho việc phân loại input thành các nhóm

   ✅ Dễ thiết kế và maintain

   ⚠️ Cần kết hợp với BVA để bao phủ edge cases

2. Boundary Value Analysis

   ✅ Rất hiệu quả cho việc phát hiện lỗi biên

   ✅ Bổ sung tốt cho EP

   ⚠️ Không test được các tổ hợp logic phức tạp

3. Decision Table

   ✅ Tuyệt vời cho việc test business logic

   ✅ Đảm bảo coverage tổ hợp điều kiện

   ⚠️ Có thể phức tạp với nhiều điều kiện

4. Pairwise Testing

   ✅ Giảm số lượng test cases mà vẫn đảm bảo coverage

   ✅ Phát hiện lỗi tương tác giữa các parameters

   ⚠️ Cần công cụ và kinh nghiệm để thiết kế

### Kết luận

- Kết hợp các kỹ thuật cho kết quả tốt nhất
- EP + BVA Nền tảng cơ bản cho mọi dự án
- Decision Table Bắt buộc cho business logic phức tạp
- Pairwise Tối ưu khi có nhiều parameters

## 👥 Phân công công việc

- Thành viên 1 Phân tích yêu cầu, thiết kế test cases (EP, BVA)
- Thành viên 2 Triển khai test automation (JUnit), BVA, Decision Table
- Thành viên 3 Combinatorial testing (PICT), Test reporting, Đánh giá hiệu quả

## 🔗 Tài liệu tham khảo

- [JUnit 5 Documentation](httpsjunit.orgjunit5docscurrentuser-guide)
- [JaCoCo Documentation](httpswww.jacoco.orgjacocotrunkdoc)
- [PICT Tool](httpsgithub.comMicrosoftpict)
- [Software Testing Techniques](httpswww.guru99.comsoftware-testing.html)

## 📝 License

Educational project for Software Testing course.

---

Prepared by Team 6  
Date December 2025  
Course Software Testing
=======
# team6
>>>>>>> branch 'main' of https://github.com/Push-3125/team6.git
=======
# team6
>>>>>>> ddb3b949a786d03c0232493648c9efd27bda65a1
