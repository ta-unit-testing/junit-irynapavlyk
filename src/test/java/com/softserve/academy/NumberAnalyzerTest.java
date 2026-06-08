package com.softserve.academy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class NumberAnalyzerTest {

    // AAA: Arrange-Act-Assert pattern
    // Arrange - підготовка даних (BeforeEach створює базову колекцію)
    // Act - виконання дії
    // Assert - перевірка результату

    private NumberAnalyzer analyzer;
    private List<Integer> testNumbers;

    @BeforeEach
    void setUp() {
        // Arrange - створюємо фіксовану колекцію для тестування
        testNumbers = new ArrayList<>(Arrays.asList(
                45, 12, 78, 23, 56, 89, 34, 67, 90, 15,
                42, 8, 73, 29, 61, 5, 38, 82, 50, 19
        ));
        analyzer = new NumberAnalyzer(testNumbers);
    }

    // ===== Constructor tests =====

    @Test
    void shouldCreateAnalyzerWithValidNumbers() {
        // Arrange
        List<Integer> numbers = Arrays.asList(1, 2, 3);

        // Act
        NumberAnalyzer newAnalyzer = new NumberAnalyzer(numbers);

        // Assert
        assertEquals(3, newAnalyzer.size());
    }

    @Test
        //Реалізувати тест - має кинути виключення якщо список null
    void shouldThrowExceptionWhenNumbersListIsNull() {
        List<Integer> numbers = null;

        assertThrows(IllegalArgumentException.class, () -> {
            new NumberAnalyzer(numbers);
        });
    }

    // ===== findMinimum() tests =====

    @Test
        //Реалізувати тест - має знайти мінімальне число в колекції
    void shouldFindMinimumNumber() {
        int minimum = analyzer.findMinimum();

        assertEquals(5, minimum, "The minimum value is " + minimum);
    }

    @Test
        //Реалізувати тест - має кинути виключення для порожньої колекції")
    void shouldThrowExceptionWhenFindingMinimumInEmptyCollection() {
        NumberAnalyzer analyzerEmpty = new NumberAnalyzer(new ArrayList<>());

        assertThrows(IllegalStateException.class, analyzerEmpty::findMinimum);
    }

    // ===== findMaximum() tests =====

    @Test
        //Реалізувати тест - має знайти максимальне число в колекції")
    void shouldFindMaximumNumber() {
        int maximum = analyzer.findMaximum();
        int expectedMaximum = findMaximumInTest();

        assertEquals(expectedMaximum, maximum, "Expected maximum: " + expectedMaximum + ", but actual is: " + maximum);

    }

    public Integer findMaximumInTest() {
        List<Integer> sorted = testNumbers.stream()
                .sorted()
                .toList();

        return sorted.getLast();
    }

    @Test
        //Реалізувати тест - має кинути виключення для порожньої колекції")
    void shouldThrowExceptionWhenFindingMaximumInEmptyCollection() {
        NumberAnalyzer analyzerEmpty = new NumberAnalyzer(new ArrayList<>());

        assertThrows(IllegalStateException.class, analyzerEmpty::findMaximum);
    }

    // ===== calculateAverage() tests =====

    @Test
        //Реалізувати тест - має обчислити середнє значення")
    void shouldCalculateAverageValue() {
        double averageExpected = findExpectedAVRInTest(testNumbers);
        double averageActual = analyzer.calculateAverage();

        assertEquals(averageExpected, averageActual, "Expected average is : " + averageExpected +
                ", but actual average is: " + averageActual);
    }

    public double findExpectedAVRInTest(List<Integer> arrayList) {
        if (arrayList == null || arrayList.isEmpty()) {
            return 0;
        }
        int sum = 0;

        for (int element : arrayList) {
            sum += element;
        }
        return sum / (double) arrayList.size();
    }


    @Test
        //Реалізувати тест - має кинути виключення для порожньої колекції")
    void shouldThrowExceptionWhenCalculatingAverageOfEmptyCollection() {
        NumberAnalyzer analyzerEmpty = new NumberAnalyzer(new ArrayList<>());

        assertThrows(IllegalStateException.class, analyzerEmpty::calculateAverage);
    }

    @Test
        //Реалізувати тест - має правильно обчислити середнє для однієї цифри")
    void shouldCalculateAverageForSingleNumber() {
        NumberAnalyzer analyzerSingleNumber = new NumberAnalyzer(new ArrayList<>(List.of(5)));
        double averageExpected = analyzerSingleNumber.calculateAverage();
        assertEquals(5.0, averageExpected);
    }

    // ===== removeEvenNumbers() tests =====

    @Test
        //Реалізувати тест - має видалити всі парні числа")
    void shouldRemoveAllEvenNumbers() {
        ArrayList<Integer> expectedList = new ArrayList<>(Arrays.asList(
                45, 23, 89, 67, 15,
                73, 29, 61, 5, 19
        ));
        analyzer.removeEvenNumbers();

        assertEquals(expectedList, analyzer.getNumbers());
    }

    @Test
        //Реалізувати тест - має залишити колекцію порожньою якщо всі числа парні")
    void shouldLeaveEmptyCollectionWhenAllNumbersAreEven() {
        ArrayList<Integer> expectedList = new ArrayList<>(List.of());
        testNumbers = new ArrayList<>(Arrays.asList(2, 8, 10, 40, 20, 30));
        analyzer = new NumberAnalyzer(testNumbers);
        analyzer.removeEvenNumbers();

        assertEquals(expectedList, analyzer.getNumbers());
    }

    @Test
        // Реалізувати тест - не має змінювати колекцію якщо всі числа непарні")
    void shouldNotChangeCollectionWhenAllNumbersAreOdd() {
        ArrayList<Integer> expectedList = new ArrayList<>(List.of(1, 3, 7, 11));
        testNumbers = new ArrayList<>(Arrays.asList(1, 3, 7, 11));
        analyzer = new NumberAnalyzer(testNumbers);
        analyzer.removeEvenNumbers();

        assertEquals(expectedList, analyzer.getNumbers());
    }

    // ===== contains() tests =====

    @Test
        // Реалізувати тест - має знайти число яке існує в колекції")
    void shouldReturnTrueWhenNumberExists() {
        int testNumber = 29;

        assertTrue(analyzer.contains(testNumber));
    }

    @Test
        //Реалізувати тест - має повернути false для числа якого немає")
    void shouldReturnFalseWhenNumberDoesNotExist() {
        int testNumber = 20;

        assertFalse(analyzer.contains(testNumber));
    }

    @Test
        //Реалізувати тест - має повернути false для порожньої колекції")
    void shouldReturnFalseForEmptyCollection() {
        analyzer = new NumberAnalyzer(List.of());

        assertFalse(analyzer.size() > 0);
    }

    // ===== sortAscending() tests =====

    @Test
        //Реалізувати тест - має відсортувати числа за зростанням")
    void shouldSortNumbersInAscendingOrder() {
        List<Integer> expectedTestNumbers = testNumbers.stream().sorted().toList();

        analyzer.sortAscending();

        assertEquals(expectedTestNumbers, analyzer.getNumbers());
    }

    @Test
        //Реалізувати тест - має залишити вже відсортовану колекцію без змін")
    void shouldNotChangeAlreadySortedCollection() {
        List<Integer> expectedTestNumbers = testNumbers.stream().sorted().toList();

        analyzer.sortAscending();

        assertEquals(expectedTestNumbers, analyzer.getNumbers());
        assertNotEquals(testNumbers, analyzer.getNumbers());
    }

    @Test
        //Реалізувати тест - має правильно відсортувати колекцію з дублікатами")
    void shouldSortCollectionWithDuplicates() {
        testNumbers = new ArrayList<>(Arrays.asList(1, 7, 11, 3, 3, 3, 1, 11, 3));
        List<Integer> expectedList = testNumbers.stream()
                .sorted()
                .toList();

        analyzer = new NumberAnalyzer(testNumbers);
        analyzer.sortAscending();

        assertEquals(expectedList, analyzer.getNumbers());
    }

    // ===== size() tests =====

    @Test
    void shouldReturnCorrectSize() {
        // Arrange - дані в setUp()

        // Act
        int size = analyzer.size();

        // Assert
        assertEquals(20, size);
    }

    @Test
        // Реалізувати тест - має повернути 0 для порожньої колекції")
    void shouldReturnZeroForEmptyCollection() {
        analyzer = new NumberAnalyzer(new ArrayList<>());

        assertEquals(0, analyzer.size());
    }

    // ===== getNumbers() tests =====

    @Test
        // Реалізувати тест - має повернути копію колекції (не оригінал)")
    void shouldReturnCopyOfNumbers() {
        List<Integer> copyOfAnalyzer = new ArrayList<>(testNumbers);

        assertEquals(copyOfAnalyzer, analyzer.getNumbers());
        assertEquals(analyzer.size(), copyOfAnalyzer.size());

        copyOfAnalyzer.removeFirst();

        assertNotEquals(analyzer.size(), copyOfAnalyzer.size());
        assertTrue(analyzer.size() > copyOfAnalyzer.size());
    }

    // ===== Integration tests =====

    @Test
        //Реалізувати тест - має виконати послідовність операцій (видалити парні, потім сортувати)")
    void shouldRemoveEvenNumbersAndThenSort() {
        List<Integer> copyOfAnalyzer = new ArrayList<>(testNumbers);
        analyzer.removeEvenNumbers();
        analyzer.sortAscending();

        List<Integer> expectedSortedList = new ArrayList<>(copyOfAnalyzer.stream().sorted().toList());
        expectedSortedList.removeIf(num -> num % 2 == 0);

        assertEquals(expectedSortedList, analyzer.getNumbers());
    }

    @Test
        //Реалізувати тест - має правильно працювати після видалення парних чисел")
    void shouldFindMinMaxAfterRemovingEvenNumbers() {
        List<Integer> copyOfAnalyzer = new ArrayList<>(testNumbers);
        analyzer.removeEvenNumbers();
        int actualMax = analyzer.findMaximum();
        int actualMin = analyzer.findMinimum();

        List<Integer> expectedSortedList = new ArrayList<>(copyOfAnalyzer);
        expectedSortedList.removeIf(num -> num % 2 == 0);
        expectedSortedList = expectedSortedList.stream().sorted().toList();
        int expectedMax = expectedSortedList.getLast();
        int expectedMin = expectedSortedList.getFirst();

        assertEquals(expectedMax, actualMax);
        assertEquals(expectedMin, actualMin);
    }

    // ===== Edge cases =====

    @Test
        // Реалізувати тест - має працювати з негативними числами")
    void shouldHandleNegativeNumbers() {
        testNumbers = new ArrayList<>(Arrays.asList(
                -45, -12, -78, -23, -56, -89, -34, -67, -90, -15,
                -42, -8, -73, -29, -61, -5, -38, -82, -50, -19, -1
        ));
        analyzer = new NumberAnalyzer(testNumbers);
        List<Integer> expectedList = new ArrayList<>(testNumbers);

        analyzer.removeEvenNumbers();
        expectedList.removeIf(num -> num % 2 == 0);

        sortFindMinMaxANDAverageANDAssert(expectedList, analyzer);
    }


    @Test
        //Реалізувати тест - має працювати з нулем в колекції")
    void shouldHandleZeroInCollection() {
        testNumbers = new ArrayList<>(Arrays.asList(
                78, 0, 56, -89, 34, -67, 90, 5,
                0, -8, -73, 29, 1, -5, 0, 82, -50, -19, 0
        ));
        analyzer = new NumberAnalyzer(testNumbers);
        List<Integer> expectedList = new ArrayList<>(testNumbers);

        expectedList.removeIf(num -> num % 2 == 0);
        analyzer.removeEvenNumbers();

        assertEquals(
                expectedList,
                analyzer.getNumbers()
        );

        testNumbers = new ArrayList<>(Arrays.asList(
                0, -1, -100
        ));
        analyzer = new NumberAnalyzer(testNumbers);
        expectedList = new ArrayList<>(testNumbers);

        sortFindMinMaxANDAverageANDAssert(expectedList, analyzer);

        testNumbers = new ArrayList<>(Arrays.asList(
                0, 1, 100
        ));
        analyzer = new NumberAnalyzer(testNumbers);
        expectedList = new ArrayList<>(testNumbers);

        sortFindMinMaxANDAverageANDAssert(expectedList, analyzer);
    }

    public void sortFindMinMaxANDAverageANDAssert(
            List<Integer> expectedList, NumberAnalyzer actualList
    ) {
        actualList.sortAscending();
        int actualMax = actualList.findMaximum();
        int actualMin = actualList.findMinimum();
        double actualAverage = actualList.calculateAverage();

        expectedList = expectedList.stream().sorted().toList();
        int expectedMax = expectedList.getLast();
        int expectedMin = expectedList.getFirst();
        double expectedAverage = findExpectedAVRInTest(expectedList);

        assertEquals(expectedMax, actualMax);
        assertEquals(expectedMin, actualMin);
        assertEquals(expectedAverage, actualAverage);
    }
}
