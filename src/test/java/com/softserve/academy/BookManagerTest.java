package com.softserve.academy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class BookManagerTest {

    // AAA: Arrange-Act-Assert pattern
    // Arrange - підготовка даних (BeforeEach створює базову колекцію)
    // Act - виконання дії
    // Assert - перевірка результату

    private BookManager bookManager;

    @BeforeEach
    void setUp() {
        // Arrange - створюємо базову колекцію книг для кожного тесту
        bookManager = new BookManager();
        bookManager.addBook(new Book("The Great Adventure", "Alice Johnson", "Drama", 2022));
        bookManager.addBook(new Book("Space Odyssey", "Alice Johnson", "Fantastic", 2024));
        bookManager.addBook(new Book("Life's Journey", "Bob Smith", "Drama", 2021));
        bookManager.addBook(new Book("Science Explained", "Charlie Brown", "Science", 2019));
    }

    // ===== addBook() tests =====

    @Test
    void shouldAddNewUniqueBook() {
        // Arrange
        Book newBook = new Book("New Discoveries", "Diana Green", "Drama", 2024);

        // Act
        bookManager.addBook(newBook);

        // Assert
        assertEquals(5, bookManager.size());
    }

    @Test
    void shouldThrowExceptionWhenAddingNullBook() {
        // Arrange & Act & Assert
        assertThrows(IllegalArgumentException.class, () -> bookManager.addBook(null));
    }

    @Test
    void shouldThrowExceptionWhenAddingDuplicateBook() {
        // Arrange
        Book duplicateBook = new Book("The Great Adventure", "Alice Johnson", "Drama", 2022);

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> bookManager.addBook(duplicateBook));
    }

    // ===== listOfAllAuthors() tests =====

    @Test
    void shouldReturnListOfAllUniqueAuthors() {
        // Arrange - дані вже в setUp()

        // Act
        List<String> authors = bookManager.listOfAllAuthors();

        // Assert
        assertEquals(3, authors.size());
        assertTrue(authors.contains("Alice Johnson"));
        assertTrue(authors.contains("Bob Smith"));
        assertTrue(authors.contains("Charlie Brown"));
    }

    @Test
    void shouldReturnEmptyListWhenNoBooks() {
        // Arrange
        BookManager emptyManager = new BookManager();

        // Act
        List<String> authors = emptyManager.listOfAllAuthors();

        // Assert
        assertTrue(authors.isEmpty());
    }

    // ===== listAuthorsByGenre() tests =====

    @Test
    void shouldReturnAuthorsForExistingGenre() {
        // Arrange
        String genre = "Drama";

        // Act
        List<String> authors = bookManager.listAuthorsByGenre(genre);

        // Assert
        assertEquals(2, authors.size());
        assertTrue(authors.contains("Alice Johnson"));
        assertTrue(authors.contains("Bob Smith"));
    }

    @Test
    void shouldReturnEmptyListForNonExistingGenre() {
        // Arrange
        String genre = "Horror";

        // Act
        List<String> authors = bookManager.listAuthorsByGenre(genre);

        // Assert
        assertTrue(authors.isEmpty());
    }

    @Test
    void shouldThrowExceptionWhenGenreIsNull() {
        // Arrange & Act & Assert
        assertThrows(IllegalArgumentException.class, () -> bookManager.listAuthorsByGenre(null));
    }

    @Test
    void shouldThrowExceptionWhenGenreIsBlank() {
        // Arrange & Act & Assert
        assertThrows(IllegalArgumentException.class, () -> bookManager.listAuthorsByGenre("   "));
    }

    // ===== listAuthorsByYear() tests =====

    @Test
    @Disabled("TODO: Реалізувати тест - має повертати авторів для конкретного року")
    void shouldReturnAuthorsForSpecificYear() {
        fail("Not implemented yet");
    }

    @Test
    @Disabled("TODO: Реалізувати тест - має повертати порожній список для року без книг")
    void shouldReturnEmptyListForYearWithNoBooks() {
        fail("Not implemented yet");
    }

    @Test
    void shouldThrowExceptionWhenYearIsNegative() {
        // Arrange & Act & Assert
        assertThrows(IllegalArgumentException.class, () -> bookManager.listAuthorsByYear(-2022));
    }

    @Test
    void shouldThrowExceptionWhenYearIsZero() {
        // Arrange & Act & Assert
        assertThrows(IllegalArgumentException.class, () -> bookManager.listAuthorsByYear(0));
    }

    // ===== findBookByAuthor() tests =====

    @Test
    @Disabled("TODO: Реалізувати тест - має знайти першу книгу існуючого автора")
    void shouldFindFirstBookByExistingAuthor() {
        fail("Not implemented yet");
    }

    @Test
    void shouldReturnEmptyOptionalForNonExistingAuthor() {
        // Arrange
        String author = "Unknown Author";

        // Act
        Optional<Book> result = bookManager.findBookByAuthor(author);

        // Assert
        assertFalse(result.isPresent());
    }

    @Test
    void shouldThrowExceptionWhenAuthorIsNull() {
        // Arrange & Act & Assert
        assertThrows(IllegalArgumentException.class, () -> bookManager.findBookByAuthor(null));
    }

    @Test
    @Disabled("TODO: Реалізувати тест - має кинути виключення для blank автора")
    void shouldThrowExceptionWhenAuthorIsBlank() {
        fail("Not implemented yet");
    }

    // ===== findBooksByYear() tests =====

    @Test
    @Disabled("TODO: Реалізувати тест - має знайти всі книги за роком")
    void shouldFindAllBooksByYear() {
        fail("Not implemented yet");
    }

    @Test
    @Disabled("TODO: Реалізувати тест - має повертати порожній список якщо немає книг за роком")
    void shouldReturnEmptyListWhenNoBooksByYear() {
        fail("Not implemented yet");
    }

    @Test
    void shouldThrowExceptionWhenYearIsInvalid() {
        // Arrange & Act & Assert
        assertThrows(IllegalArgumentException.class, () -> bookManager.findBooksByYear(-1));
    }

    // ===== findBooksByGenre() tests =====

    @Test
    @Disabled("TODO: Реалізувати тест - має знайти всі книги за жанром")
    void shouldFindAllBooksByGenre() {
        fail("Not implemented yet");
    }

    @Test
    void shouldReturnEmptyListWhenNoBooksByGenre() {
        // Arrange
        String genre = "Comedy";

        // Act
        List<Book> books = bookManager.findBooksByGenre(genre);

        // Assert
        assertTrue(books.isEmpty());
    }

    @Test
    @Disabled("TODO: Реалізувати тест - має кинути виключення якщо жанр null")
    void shouldThrowExceptionWhenGenreIsNullInFind() {
        fail("Not implemented yet");
    }

    // ===== removeBooksByAuthor() tests =====

    @Test
    @Disabled("TODO: Реалізувати тест - має видалити всі книги автора")
    void shouldRemoveAllBooksByAuthor() {
        fail("Not implemented yet");
    }

    @Test
    @Disabled("TODO: Реалізувати тест - не має робити нічого при видаленні неіснуючого автора")
    void shouldDoNothingWhenRemovingNonExistingAuthor() {
        fail("Not implemented yet");
    }

    @Test
    void shouldThrowExceptionWhenAuthorIsNullInRemove() {
        // Arrange & Act & Assert
        assertThrows(IllegalArgumentException.class, () -> bookManager.removeBooksByAuthor(null));
    }

    // ===== sortBooksByCriterion() tests =====

    @Test
    @Disabled("TODO: Реалізувати тест - має відсортувати книги за назвою")
    void shouldSortBooksByTitle() {
        fail("Not implemented yet");
    }

    @Test
    @Disabled("TODO: Реалізувати тест - має відсортувати книги за автором")
    void shouldSortBooksByAuthor() {
        fail("Not implemented yet");
    }

    @Test
    @Disabled("TODO: Реалізувати тест - має відсортувати книги за роком")
    void shouldSortBooksByYear() {
        fail("Not implemented yet");
    }

    @Test
    void shouldThrowExceptionWhenCriterionIsInvalid() {
        // Arrange & Act & Assert
        assertThrows(IllegalArgumentException.class, () -> bookManager.sortBooksByCriterion("invalid"));
    }

    // ===== mergeCollections() tests =====

    @Test
    @Disabled("TODO: Реалізувати тест - має об'єднати колекції без дублікатів")
    void shouldMergeNonDuplicateBooks() {
        fail("Not implemented yet");
    }

    @Test
    @Disabled("TODO: Реалізувати тест - має пропустити дублікати при об'єднанні")
    void shouldSkipDuplicateBooksWhenMerging() {
        fail("Not implemented yet");
    }

    @Test
    void shouldThrowExceptionWhenMergingNullCollection() {
        // Arrange & Act & Assert
        assertThrows(IllegalArgumentException.class, () -> bookManager.mergeCollections(null));
    }

    @Test
    @Disabled("TODO: Реалізувати тест - має пропускати null книги в колекції")
    void shouldSkipNullBooksInCollection() {
        fail("Not implemented yet");
    }

    // ===== subCollectionByGenre() tests =====

    @Test
    @Disabled("TODO: Реалізувати тест - має повернути підколекцію за жанром")
    void shouldReturnSubCollectionByGenre() {
        fail("Not implemented yet");
    }

    @Test
    @Disabled("TODO: Реалізувати тест - має повернути порожню підколекцію для неіснуючого жанру")
    void shouldReturnEmptySubCollectionForNonExistingGenre() {
        fail("Not implemented yet");
    }

    @Test
    void shouldThrowExceptionWhenGenreIsNullInSubCollection() {
        // Arrange & Act & Assert
        assertThrows(IllegalArgumentException.class, () -> bookManager.subCollectionByGenre(null));
    }

    // ===== size() tests =====

    @Test
    void shouldReturnCorrectSize() {
        // Arrange - дані в setUp()

        // Act
        int size = bookManager.size();

        // Assert
        assertEquals(4, size);
    }

    @Test
    void shouldReturnZeroForEmptyCollection() {
        // Arrange
        BookManager emptyManager = new BookManager();

        // Act
        int size = emptyManager.size();

        // Assert
        assertEquals(0, size);
    }

    // ===== Додаткові тести (заглушки для майбутньої реалізації) =====

    @Test
    @Disabled("TODO: Додати тест на case-insensitive порівняння при пошуку автора")
    void shouldFindBookByAuthorCaseInsensitive() {
        fail("Not implemented yet");
    }

    @Test
    @Disabled("TODO: Додати тест на збереження порядку після merge")
    void shouldPreserveOrderAfterMerge() {
        fail("Not implemented yet");
    }

    @Test
    @Disabled("TODO: Додати тест на роботу з порожніми strings у Book")
    void shouldHandleEmptyStringsInBook() {
        fail("Not implemented yet");
    }

    @Test
    @Disabled("TODO: Додати тест на перевірку, що listOfAllAuthors не повертає null")
    void shouldNeverReturnNullFromListOfAllAuthors() {
        fail("Not implemented yet");
    }

    @Test
    @Disabled("TODO: Додати тест на великі колекції (performance test)")
    void shouldHandleLargeCollectionsEfficiently() {
        fail("Not implemented yet");
    }

    @Test
    @Disabled("TODO: Додати тест на concurrent modifications")
    void shouldHandleConcurrentModifications() {
        fail("Not implemented yet");
    }

    @Test
    @Disabled("TODO: Додати тест на сортування стабільності")
    void shouldMaintainStableSortOrder() {
        fail("Not implemented yet");
    }

    @Test
    @Disabled("TODO: Додати тест на видалення всіх книг")
    void shouldHandleRemovalOfAllBooks() {
        fail("Not implemented yet");
    }
}