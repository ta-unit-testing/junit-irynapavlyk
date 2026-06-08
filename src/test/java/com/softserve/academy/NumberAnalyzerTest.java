package com.softserve.academy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
    @Disabled("TODO: Реалізувати тест - має кинути виключення якщо список null")
    void shouldThrowExceptionWhenNumbersListIsNull() {
        fail("Not implemented yet");
    }

    // ===== findMinimum() tests =====

    @Test
    @Disabled("TODO: Реалізувати тест - має знайти мінімальне число в колекції")
    void shouldFindMinimumNumber() {
        fail("Not implemented yet");
    }

    @Test
    @Disabled("TODO: Реалізувати тест - має кинути виключення для порожньої колекції")
    void shouldThrowExceptionWhenFindingMinimumInEmptyCollection() {
        fail("Not implemented yet");
    }

    // ===== findMaximum() tests =====

    @Test
    @Disabled("TODO: Реалізувати тест - має знайти максимальне число в колекції")
    void shouldFindMaximumNumber() {
        fail("Not implemented yet");
    }

    @Test
    @Disabled("TODO: Реалізувати тест - має кинути виключення для порожньої колекції")
    void shouldThrowExceptionWhenFindingMaximumInEmptyCollection() {
        fail("Not implemented yet");
    }

    // ===== calculateAverage() tests =====

    @Test
    @Disabled("TODO: Реалізувати тест - має обчислити середнє значення")
    void shouldCalculateAverageValue() {
        fail("Not implemented yet");
    }

    @Test
    @Disabled("TODO: Реалізувати тест - має кинути виключення для порожньої колекції")
    void shouldThrowExceptionWhenCalculatingAverageOfEmptyCollection() {
        fail("Not implemented yet");
    }

    @Test
    @Disabled("TODO: Реалізувати тест - має правильно обчислити середнє для однієї цифри")
    void shouldCalculateAverageForSingleNumber() {
        fail("Not implemented yet");
    }

    // ===== removeEvenNumbers() tests =====

    @Test
    @Disabled("TODO: Реалізувати тест - має видалити всі парні числа")
    void shouldRemoveAllEvenNumbers() {
        fail("Not implemented yet");
    }

    @Test
    @Disabled("TODO: Реалізувати тест - має залишити колекцію порожньою якщо всі числа парні")
    void shouldLeaveEmptyCollectionWhenAllNumbersAreEven() {
        fail("Not implemented yet");
    }

    @Test
    @Disabled("TODO: Реалізувати тест - не має змінювати колекцію якщо всі числа непарні")
    void shouldNotChangeCollectionWhenAllNumbersAreOdd() {
        fail("Not implemented yet");
    }

    // ===== contains() tests =====

    @Test
    @Disabled("TODO: Реалізувати тест - має знайти число яке існує в колекції")
    void shouldReturnTrueWhenNumberExists() {
        fail("Not implemented yet");
    }

    @Test
    @Disabled("TODO: Реалізувати тест - має повернути false для числа якого немає")
    void shouldReturnFalseWhenNumberDoesNotExist() {
        fail("Not implemented yet");
    }

    @Test
    @Disabled("TODO: Реалізувати тест - має повернути false для порожньої колекції")
    void shouldReturnFalseForEmptyCollection() {
        fail("Not implemented yet");
    }

    // ===== sortAscending() tests =====

    @Test
    @Disabled("TODO: Реалізувати тест - має відсортувати числа за зростанням")
    void shouldSortNumbersInAscendingOrder() {
        fail("Not implemented yet");
    }

    @Test
    @Disabled("TODO: Реалізувати тест - має залишити вже відсортовану колекцію без змін")
    void shouldNotChangeAlreadySortedCollection() {
        fail("Not implemented yet");
    }

    @Test
    @Disabled("TODO: Реалізувати тест - має правильно відсортувати колекцію з дублікатами")
    void shouldSortCollectionWithDuplicates() {
        fail("Not implemented yet");
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
    @Disabled("TODO: Реалізувати тест - має повернути 0 для порожньої колекції")
    void shouldReturnZeroForEmptyCollection() {
        fail("Not implemented yet");
    }

    // ===== getNumbers() tests =====

    @Test
    @Disabled("TODO: Реалізувати тест - має повернути копію колекції (не оригінал)")
    void shouldReturnCopyOfNumbers() {
        fail("Not implemented yet");
    }

    // ===== Integration tests =====

    @Test
    @Disabled("TODO: Реалізувати тест - має виконати послідовність операцій (видалити парні, потім сортувати)")
    void shouldRemoveEvenNumbersAndThenSort() {
        fail("Not implemented yet");
    }

    @Test
    @Disabled("TODO: Реалізувати тест - має правильно працювати після видалення парних чисел")
    void shouldFindMinMaxAfterRemovingEvenNumbers() {
        fail("Not implemented yet");
    }

    // ===== Edge cases =====

    @Test
    @Disabled("TODO: Реалізувати тест - має працювати з негативними числами")
    void shouldHandleNegativeNumbers() {
        fail("Not implemented yet");
    }

    @Test
    @Disabled("TODO: Реалізувати тест - має працювати з нулем в колекції")
    void shouldHandleZeroInCollection() {
        fail("Not implemented yet");
    }
}
