package com.softserve.academy;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RectangleTest {

    // AAA: Arrange-Act-Assert pattern
    // Arrange - підготовка даних
    // Act - виконання дії
    // Assert - перевірка результату

    @Test
    void shouldCreateRectangleWithDefaultValues() {
        // Arrange & Act
        Rectangle rectangle = new Rectangle();

        // Assert
        assertEquals(0.0, rectangle.getWidth(), 0.001);
        assertEquals(0.0, rectangle.getHeight(), 0.001);
        assertEquals(90.0, rectangle.getAngle(), 0.001);
    }

    @Test
    void shouldCreateRectangleWithSpecifiedDimensions() {
        // Arrange
        double width = 5.0;
        double height = 10.0;

        // Act
        Rectangle rectangle = new Rectangle(width, height);

        // Assert
        assertEquals(5.0, rectangle.getWidth(), 0.001);
        assertEquals(10.0, rectangle.getHeight(), 0.001);
        assertEquals(90.0, rectangle.getAngle(), 0.001);
    }

    @Test
    void shouldUpdateWidthHeightAndAngleUsingSetters() {
        // Arrange
        Rectangle rectangle = new Rectangle();

        // Act
        rectangle.setWidth(7.5);
        rectangle.setHeight(4.0);
        rectangle.setAngle(90.0);

        // Assert
        assertEquals(7.5, rectangle.getWidth(), 0.001);
        assertEquals(4.0, rectangle.getHeight(), 0.001);
        assertEquals(90.0, rectangle.getAngle(), 0.001);
    }

    @Test
    void shouldCalculateAreaCorrectly() {
        // Arrange
        Rectangle rectangle = new Rectangle(5.0, 4.0);

        // Act
        double area = rectangle.calculateArea();

        // Assert
        assertEquals(20.0, area, 0.001);
    }

    @Test
    void shouldCalculatePerimeterCorrectly() {
        // Arrange
        Rectangle rectangle = new Rectangle(5.0, 4.0);

        // Act
        double perimeter = rectangle.calculatePerimeter();

        // Assert
        assertEquals(18.0, perimeter, 0.001);
    }

    @Test
    void shouldCalculateDiagonalCorrectly() {
        // Arrange - використовуємо класичний трикутник 3-4-5
        Rectangle rectangle = new Rectangle(3.0, 4.0);

        // Act
        double diagonal = rectangle.getDiagonal();

        // Assert
        assertEquals(5.0, diagonal, 0.001);
    }

    @Test
    void shouldHandleNegativeValuesWithoutValidation() {
        // Arrange - тест для перевірки поведінки з від'ємними значеннями
        Rectangle rectangle = new Rectangle(-5.0, 4.0);

        // Act
        double area = rectangle.calculateArea();
        double perimeter = rectangle.calculatePerimeter();

        // Assert - від'ємні значення дають від'ємні результати (валідації немає)
        assertEquals(-20.0, area, 0.001);
        assertEquals(-2.0, perimeter, 0.001);
    }
}
