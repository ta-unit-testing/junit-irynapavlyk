package com.softserve.academy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;
import java.util.function.BooleanSupplier;

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
        // Реалізувати тест - має повертати авторів для конкретного року")
    void shouldReturnAuthorsForSpecificYear() {
        int year = 2021;

        List<String> authors = bookManager.listAuthorsByYear(year);

        // Assert
        assertEquals(1, authors.size());
        assertTrue(authors.contains("Bob Smith"));
    }

    @Test
        // Реалізувати тест - має повертати порожній список для року без книг")
    void shouldReturnEmptyListForYearWithNoBooks() {
        int year = 2000;

        List<String> authors = bookManager.listAuthorsByYear(year);

        assertTrue(authors.isEmpty());
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
        //Реалізувати тест - має знайти першу книгу існуючого автора")
    void shouldFindFirstBookByExistingAuthor() {
        String author = "Alice Johnson";

        Optional<Book> book = bookManager.findBookByAuthor(author);
        String title = book.get().getTitle();

        assertEquals("The Great Adventure", title);
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
        // Реалізувати тест - має кинути виключення для blank автора")
    void shouldThrowExceptionWhenAuthorIsBlank() {
        assertThrows(IllegalArgumentException.class, () -> bookManager.findBookByAuthor(""));
    }

    // ===== findBooksByYear() tests =====

    @Test
        // Реалізувати тест - має знайти всі книги за роком")
    void shouldFindAllBooksByYear() {
        bookManager.addBook(new Book("Kobzar", "Taras Shevchenko", "Poems", 1840));
        bookManager.addBook(new Book("The Old Curiosity Shop", "Charles Dickens", "Novel", 1840));
        bookManager.addBook(new Book("Master Humphrey's Clock", "Charles Dickens", "Novel", 1840));
        int year = 1840;

        List<Book> books = bookManager.findBooksByYear(year);
        String title1 = books.get(0).getTitle();
        String title2 = books.get(1).getTitle();
        String title3 = books.get(2).getTitle();

        assertEquals(3, books.size());
        assertEquals("Kobzar", title1);
        assertEquals("The Old Curiosity Shop", title2);
        assertEquals("Master Humphrey's Clock", title3);
    }

    @Test
        // Реалізувати тест - має повертати порожній список якщо немає книг за роком")
    void shouldReturnEmptyListWhenNoBooksByYear() {
        int year = 1899;

        List<Book> books = bookManager.findBooksByYear(year);

        assertTrue(books.isEmpty());
        assertEquals(0, books.size());
    }

    @Test
    void shouldThrowExceptionWhenYearIsInvalid() {
        // Arrange & Act & Assert
        assertThrows(IllegalArgumentException.class, () -> bookManager.findBooksByYear(-1));
    }

    // ===== findBooksByGenre() tests =====

    @Test
        // Реалізувати тест - має знайти всі книги за жанром")
    void shouldFindAllBooksByGenre() {
        String genre = "Drama";

        List<Book> books = bookManager.findBooksByGenre(genre);

        assertEquals(2, books.size());

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
        // Реалізувати тест - має кинути виключення якщо жанр null")
    void shouldThrowExceptionWhenGenreIsNullInFind() {
        String genre = null;

        assertThrows(IllegalArgumentException.class, () -> bookManager.findBooksByGenre(genre));
    }

    // ===== removeBooksByAuthor() tests =====

    @Test
        //TODO: Реалізувати тест - має видалити всі книги автора")
    void shouldRemoveAllBooksByAuthor() {
        String author = "Alice Johnson";

        bookManager.removeBooksByAuthor(author);
        List<String> authors = bookManager.listOfAllAuthors();


        assertEquals(2, bookManager.listOfAllAuthors().size());
        assertEquals("Bob Smith", authors.get(0));
        assertEquals("Charlie Brown", authors.get(1));
        assertFalse(authors.contains(author));
    }

    @Test
        //Реалізувати тест - не має робити нічого при видаленні неіснуючого автора")
    void shouldDoNothingWhenRemovingNonExistingAuthor() {
        assertEquals(4, bookManager.size());

        try {
            bookManager.removeBooksByAuthor("Lesia Ukrainka");
        } catch (RuntimeException e) {
            System.out.println("Error: " + e.getMessage());
            assertNull(e.getMessage());
        }

        assertEquals(4, bookManager.size());
    }

    @Test
    void shouldThrowExceptionWhenAuthorIsNullInRemove() {
        // Arrange & Act & Assert
        assertThrows(IllegalArgumentException.class, () -> bookManager.removeBooksByAuthor(null));
    }

    // ===== sortBooksByCriterion() tests =====

    @Test
        // Реалізувати тест - має відсортувати книги за назвою")
    void shouldSortBooksByTitle() {
        bookManager.sortBooksByCriterion("title");
        List<Book> books = bookManager.getBooks();

        assertEquals("Life's Journey", books.get(0).getTitle());
        assertEquals("Science Explained", books.get(1).getTitle());
        assertEquals("Space Odyssey", books.get(2).getTitle());
        assertEquals("The Great Adventure", books.get(3).getTitle());
    }

    @Test
        // Реалізувати тест - має відсортувати книги за автором")
    void shouldSortBooksByAuthor() {
        bookManager.sortBooksByCriterion("author");
        List<Book> books = bookManager.getBooks();

        assertEquals("Alice Johnson", books.get(0).getAuthor());
        assertEquals("Alice Johnson", books.get(1).getAuthor());
        assertEquals("Bob Smith", books.get(2).getAuthor());
        assertEquals("Charlie Brown", books.get(3).getAuthor());
    }

    @Test
        // Реалізувати тест - має відсортувати книги за роком")
    void shouldSortBooksByYear() {
        bookManager.sortBooksByCriterion("year");
        List<Book> books = bookManager.getBooks();

        assertEquals(2019, books.get(0).getPublicationYear());
        assertEquals(2021, books.get(1).getPublicationYear());
        assertEquals(2022, books.get(2).getPublicationYear());
        assertEquals(2024, books.get(3).getPublicationYear());
    }

    @Test
    void shouldThrowExceptionWhenCriterionIsInvalid() {
        // Arrange & Act & Assert
        assertThrows(IllegalArgumentException.class, () -> bookManager.sortBooksByCriterion("invalid"));
    }

    // ===== mergeCollections() tests =====

    @Test
        // Реалізувати тест - має об'єднати колекції без дублікатів")
    void shouldMergeNonDuplicateBooks() {
        List<Book> books2 = List.of(
                new Book("New Book", "Diana Green", "Drama", 2023),
                new Book("Abc test", "Test test", "Drama", 2023),
                new Book("The Great Adventure", "Alice Johnson", "Drama", 2022)
        );

        bookManager.mergeCollections(books2);

        assertEquals(6, bookManager.size());
    }

    @Test
        // Реалізувати тест - має пропустити дублікати при об'єднанні")
    void shouldSkipDuplicateBooksWhenMerging() {
        List<Book> books2 = List.of(
                new Book("New Book", "Diana Green", "Drama", 2023),
                new Book("Abc test", "Test test", "Drama", 2023),
                new Book("The Great Adventure", "Alice Johnson", "Drama", 2022)
        );

        bookManager.mergeCollections(books2);
        List<Book> bookByTitle = bookManager.findBooksByTitle("The Great Adventure");

        assertEquals(6, bookManager.size());
        assertEquals(1, bookByTitle.size());
    }

    @Test
    void shouldThrowExceptionWhenMergingNullCollection() {
        // Arrange & Act & Assert
        assertThrows(IllegalArgumentException.class, () -> bookManager.mergeCollections(null));
    }

    @Test
        // Реалізувати тест - має пропускати null книги в колекції")
    void shouldSkipNullBooksInCollection() {
        List<Book> listBeforeChanges = bookManager.getBooks();

        try {
            bookManager.addBook(null);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        List<Book> listAfterChanges = bookManager.getBooks();

        assertTrue(listBeforeChanges.size() == listAfterChanges.size());
    }

    // ===== subCollectionByGenre() tests =====

    @Test
        // Реалізувати тест - має повернути підколекцію за жанром")
    void shouldReturnSubCollectionByGenre() {
        String genre = "Drama";
        List<Book> collectionByGenre = bookManager.findBooksByGenre(genre);

        assertEquals(2, collectionByGenre.size());
    }

    @Test
        // Реалізувати тест - має повернути порожню підколекцію для неіснуючого жанру")
    void shouldReturnEmptySubCollectionForNonExistingGenre() {
        String genre = "Poem";
        List<Book> collectionByGenre = bookManager.findBooksByGenre(genre);

        assertEquals(0, collectionByGenre.size());
        assertTrue(collectionByGenre.isEmpty());
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
        // Додати тест на case-insensitive порівняння при пошуку автора")
    void shouldFindBookByAuthorCaseInsensitive() {
        String author = "BOB SMITH";
        Optional<Book> books = bookManager.findBookByAuthor(author);

        assertEquals("Bob Smith", books.get().getAuthor());
    }

    @Test
        // TODO: Додати тест на збереження порядку після merge")
    void shouldPreserveOrderAfterMerge() {
        bookManager.sortBooksByCriterion("title");

        List<Book> books2 = List.of(
                new Book("Book", "Diana Green", "Drama", 2023),
                new Book("Abc test", "Test test", "Drama", 2023)
        );

        bookManager.mergeCollections(books2);

        List<Book> books = bookManager.getBooks();

        assertEquals(6, bookManager.size());
        assertEquals("Life's Journey", books.get(0).getTitle());
        assertEquals("Science Explained", books.get(1).getTitle());
        assertEquals("Space Odyssey", books.get(2).getTitle());
        assertEquals("The Great Adventure", books.get(3).getTitle());
        assertEquals("Book", books.get(4).getTitle());
        assertEquals("Abc test", books.get(5).getTitle());

    }

    @Test
        // Додати тест на роботу з порожніми strings у Book")
    void shouldHandleEmptyStringsInBook() {
        List<Book> books2 = List.of(
                new Book("", "", "", 2023));

        bookManager.mergeCollections(books2);

        List<Book> books = bookManager.getBooks();

        assertEquals(5, bookManager.size());
        assertEquals("", books.get(4).getTitle());
        assertEquals("", books.get(4).getAuthor());
        assertEquals("", books.get(4).getGenre());
    }

    @Test
        // Додати тест на перевірку, що listOfAllAuthors не повертає null")
    void shouldNeverReturnNullFromListOfAllAuthors() {
        bookManager.removeBooksByAuthor("Alice Johnson");
        bookManager.removeBooksByAuthor("Bob Smith");
        bookManager.removeBooksByAuthor("Charlie Brown");

        assertTrue(null != bookManager.listOfAllAuthors());
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
        //Додати тест на видалення всіх книг")
    void shouldHandleRemovalOfAllBooks() {
        bookManager.removeAllBooks();

        assertTrue(bookManager.getBooks().isEmpty());
        assertEquals(0, bookManager.size());
    }
}