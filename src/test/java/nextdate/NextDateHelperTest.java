package nextdate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import software_testing_project.NextDate;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Helper Methods và Missing Coverage Tests cho NextDate
 */
@DisplayName("NextDate - Helper & Coverage Tests")
public class NextDateHelperTest {
    private NextDate nextDate;

    @BeforeEach
    void setUp() {
        nextDate = new NextDate();
    }

    // ============ TEST HELPER METHODS ============
    
    @Test
    @DisplayName("Helper_01: checkValidDate - valid dates")
    void testCheckValidDateValid() {
        assertTrue(nextDate.checkValidDate(10, 3, 2023), "Valid normal date");
        assertTrue(nextDate.checkValidDate(1, 1, 1900), "Valid at MIN_YEAR");
        assertTrue(nextDate.checkValidDate(31, 12, 2100), "Valid at MAX_YEAR");
        assertTrue(nextDate.checkValidDate(29, 2, 2024), "Valid leap day");
    }

    @Test
    @DisplayName("Helper_02: checkValidDate - invalid day")
    void testCheckValidDateInvalidDay() {
        assertFalse(nextDate.checkValidDate(0, 1, 2023), "Day = 0");
        assertFalse(nextDate.checkValidDate(-1, 1, 2023), "Day negative");
        assertFalse(nextDate.checkValidDate(32, 1, 2023), "Day > max for Jan");
        assertFalse(nextDate.checkValidDate(31, 4, 2023), "Day 31 in 30-day month");
        assertFalse(nextDate.checkValidDate(30, 2, 2023), "Day 30 in Feb");
        assertFalse(nextDate.checkValidDate(29, 2, 2023), "Day 29 in non-leap Feb");
    }

    @Test
    @DisplayName("Helper_03: checkValidDate - invalid month")
    void testCheckValidDateInvalidMonth() {
        assertFalse(nextDate.checkValidDate(10, 0, 2023), "Month = 0");
        assertFalse(nextDate.checkValidDate(10, -1, 2023), "Month negative");
        assertFalse(nextDate.checkValidDate(10, 13, 2023), "Month = 13");
        assertFalse(nextDate.checkValidDate(10, 15, 2023), "Month > 12");
    }

    @Test
    @DisplayName("Helper_04: checkValidDate - invalid year")
    void testCheckValidDateInvalidYear() {
        assertFalse(nextDate.checkValidDate(1, 1, 1899), "Year < MIN_YEAR");
        assertFalse(nextDate.checkValidDate(1, 1, 1800), "Year far below MIN");
        assertFalse(nextDate.checkValidDate(1, 1, 2101), "Year > MAX_YEAR");
        assertFalse(nextDate.checkValidDate(1, 1, 2200), "Year far above MAX");
    }

    @Test
    @DisplayName("Helper_05: checkDaysInMonth - 31-day months")
    void testCheckDaysInMonth31Days() {
        assertEquals(31, nextDate.checkDaysInMonth(1, 2023), "January");
        assertEquals(31, nextDate.checkDaysInMonth(3, 2023), "March");
        assertEquals(31, nextDate.checkDaysInMonth(5, 2023), "May");
        assertEquals(31, nextDate.checkDaysInMonth(7, 2023), "July");
        assertEquals(31, nextDate.checkDaysInMonth(8, 2023), "August");
        assertEquals(31, nextDate.checkDaysInMonth(10, 2023), "October");
        assertEquals(31, nextDate.checkDaysInMonth(12, 2023), "December");
    }

    @Test
    @DisplayName("Helper_06: checkDaysInMonth - 30-day months")
    void testCheckDaysInMonth30Days() {
        assertEquals(30, nextDate.checkDaysInMonth(4, 2023), "April");
        assertEquals(30, nextDate.checkDaysInMonth(6, 2023), "June");
        assertEquals(30, nextDate.checkDaysInMonth(9, 2023), "September");
        assertEquals(30, nextDate.checkDaysInMonth(11, 2023), "November");
    }

    @Test
    @DisplayName("Helper_07: checkDaysInMonth - February")
    void testCheckDaysInMonthFebruary() {
        assertEquals(28, nextDate.checkDaysInMonth(2, 2023), "Feb non-leap");
        assertEquals(29, nextDate.checkDaysInMonth(2, 2024), "Feb leap");
        assertEquals(28, nextDate.checkDaysInMonth(2, 2100), "Feb 2100 non-leap");
        assertEquals(29, nextDate.checkDaysInMonth(2, 2000), "Feb 2000 leap");
    }

    @Test
    @DisplayName("Helper_08: checkDaysInMonth - invalid month")
    void testCheckDaysInMonthInvalid() {
        assertEquals(0, nextDate.checkDaysInMonth(0, 2023), "Month 0");
        assertEquals(0, nextDate.checkDaysInMonth(13, 2023), "Month 13");
        assertEquals(0, nextDate.checkDaysInMonth(-1, 2023), "Month negative");
        assertEquals(0, nextDate.checkDaysInMonth(20, 2023), "Month 20");
    }

    @Test
    @DisplayName("Helper_09: isLeapYear - divisible by 400")
    void testIsLeapYearBy400() {
        assertTrue(nextDate.isLeapYear(2000), "2000 divisible by 400");
        assertTrue(nextDate.isLeapYear(2400), "2400 divisible by 400");
        assertTrue(nextDate.isLeapYear(1600), "1600 divisible by 400");
    }

    @Test
    @DisplayName("Helper_10: isLeapYear - divisible by 100 not 400")
    void testIsLeapYearBy100Not400() {
        assertFalse(nextDate.isLeapYear(1900), "1900 not leap");
        assertFalse(nextDate.isLeapYear(2100), "2100 not leap");
        assertFalse(nextDate.isLeapYear(2200), "2200 not leap");
    }

    @Test
    @DisplayName("Helper_11: isLeapYear - divisible by 4 not 100")
    void testIsLeapYearBy4Not100() {
        assertTrue(nextDate.isLeapYear(2024), "2024 is leap");
        assertTrue(nextDate.isLeapYear(2020), "2020 is leap");
        assertTrue(nextDate.isLeapYear(2016), "2016 is leap");
    }

    @Test
    @DisplayName("Helper_12: isLeapYear - not divisible by 4")
    void testIsLeapYearNotBy4() {
        assertFalse(nextDate.isLeapYear(2023), "2023 not leap");
        assertFalse(nextDate.isLeapYear(2021), "2021 not leap");
        assertFalse(nextDate.isLeapYear(2019), "2019 not leap");
    }

    // ============ MISSING COVERAGE TESTS ============

    @Test
    @DisplayName("Coverage_01: Year above MAX_YEAR")
    void testYearAboveMaxYear() {
        String result = nextDate.getNextDate(1, 1, 2101);
        assertEquals("Invalid date", result, "Year 2101 > MAX_YEAR");
    }

    @Test
    @DisplayName("Coverage_02: Year 2100 (non-leap)")
    void testYear2100() {
        String result = nextDate.getNextDate(28, 2, 2100);
        assertEquals("1/3/2100", result, "Feb 28 in 2100 (non-leap)");
    }

    @Test
    @DisplayName("Coverage_03: All 31-day months at boundary")
    void testAll31DayMonthsBoundary() {
        assertEquals("1/4/2023", nextDate.getNextDate(31, 3, 2023), "Mar 31");
        assertEquals("1/6/2023", nextDate.getNextDate(31, 5, 2023), "May 31");
        assertEquals("1/8/2023", nextDate.getNextDate(31, 7, 2023), "Jul 31");
        assertEquals("1/9/2023", nextDate.getNextDate(31, 8, 2023), "Aug 31");
        assertEquals("1/11/2023", nextDate.getNextDate(31, 10, 2023), "Oct 31");
    }

    @Test
    @DisplayName("Coverage_04: All 30-day months at boundary")
    void testAll30DayMonthsBoundary() {
        assertEquals("1/7/2023", nextDate.getNextDate(30, 6, 2023), "Jun 30");
        assertEquals("1/10/2023", nextDate.getNextDate(30, 9, 2023), "Sep 30");
        assertEquals("1/12/2023", nextDate.getNextDate(30, 11, 2023), "Nov 30");
    }

    @Test
    @DisplayName("Coverage_05: Feb 29 in non-leap year")
    void testFeb29NonLeap() {
        String result = nextDate.getNextDate(29, 2, 2023);
        assertEquals("Invalid date", result, "Feb 29 doesn't exist in 2023");
    }

    @Test
    @DisplayName("Coverage_06: Year at MIN_YEAR boundary")
    void testYearAtMinBoundary() {
        String result = nextDate.getNextDate(1, 1, 1900);
        assertEquals("2/1/1900", result, "Valid at MIN_YEAR");
    }

    @Test
    @DisplayName("Coverage_07: Year at MAX_YEAR boundary")
    void testYearAtMaxBoundary() {
        String result = nextDate.getNextDate(30, 12, 2100);
        assertEquals("31/12/2100", result, "Valid at MAX_YEAR");
    }
}