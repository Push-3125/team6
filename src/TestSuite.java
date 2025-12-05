import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

/**
 * Test Suite để chạy tất cả test cases
 * 
 * Để chạy:
 * - Maven: mvn test
 * - Maven với JaCoCo: mvn clean test jacoco:report
 * - IDE: Run this class as JUnit Test
 */
@Suite
@SuiteDisplayName("Software Testing Project - Complete Test Suite")
@SelectPackages({"triangle", "nextdate"})
public class TestSuite {
    // Test suite sẽ tự động chạy tất cả tests trong packages được chỉ định
    
    /**
     * Tổng số test cases:
     * 
     * Triangle Tests:
     * - TriangleEPTest: 10 tests
     * - TriangleBVATest: 8 tests
     * - TriangleDecisionTableTest: 4 tests
     * - TrianglePairwiseTest: 3 tests
     * Total: 25 tests
     * 
     * NextDate Tests:
     * - NextDateEPTest: 10 tests
     * - NextDateBVATest: 8 tests
     * - NextDateDecisionTableTest: 4 tests
     * - NextDatePairwiseTest: 4 tests
     * Total: 26 tests
     * 
     * GRAND TOTAL: 51 tests
     */
}