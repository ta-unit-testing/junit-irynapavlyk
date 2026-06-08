package com.softserve.academy;

import java.util.*;
import java.util.stream.Collectors;

public class BookManager {
    private List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        if (book == null) throw new IllegalArgumentException("Book cannot be null");
        if (books.stream()
                .anyMatch(b -> b.getTitle().equalsIgnoreCase(book.getTitle())
                        && b.getAuthor().equalsIgnoreCase(book.getAuthor()))) {
            throw new IllegalArgumentException("Duplicate book entry");
        }
        books.add(book);
    }

    public List<String> listOfAllAuthors() {
        return books.stream()
                .map(Book::getAuthor)
                .distinct()
                .collect(Collectors.toList());
    }


    public List<String> listAuthorsByGenre(String genre) {
        if (genre == null || genre.isBlank()) throw new IllegalArgumentException("Genre cannot be null or empty");
        return books.stream()
                .filter(b -> b.getGenre().equalsIgnoreCase(genre))
                .map(Book::getAuthor)
                .distinct()
                .collect(Collectors.toList());
    }

    public List<String> listAuthorsByYear(int year) {
        if (year <= 0) throw new IllegalArgumentException("Year must be positive");
        return books.stream()
                .filter(b -> b.getPublicationYear() == year)
                .map(Book::getAuthor)
                .distinct()
                .collect(Collectors.toList());
    }

    public Optional<Book> findBookByAuthor(String author) {
        if (author == null || author.isBlank()) throw new IllegalArgumentException("Author cannot be null or empty");
        return books.stream()
                .filter(b -> b.getAuthor().equalsIgnoreCase(author))
                .findFirst();
    }

    public List<Book> findBooksByYear(int year) {
        if (year <= 0) throw new IllegalArgumentException("Year must be positive");
        return books.stream()
                .filter(b -> b.getPublicationYear() == year)
                .collect(Collectors.toList());
    }


    public List<Book> findBooksByGenre(String genre) {
        if (genre == null || genre.isBlank()) throw new IllegalArgumentException("Genre cannot be null or empty");
        return books.stream()
                .filter(b -> b.getGenre().equalsIgnoreCase(genre))
                .collect(Collectors.toList());
    }

    public void removeBooksByAuthor(String author) {
        if (author == null || author.isBlank()) throw new IllegalArgumentException("Author cannot be null or empty");
        books.removeIf(b -> b.getAuthor().equalsIgnoreCase(author));
    }

    public void sortBooksByCriterion(String criterion) {
        Comparator<Book> comparator = switch (criterion.toLowerCase()) {
            case "title" -> Comparator.comparing(Book::getTitle, String.CASE_INSENSITIVE_ORDER);
            case "author" -> Comparator.comparing(Book::getAuthor, String.CASE_INSENSITIVE_ORDER);
            case "year" -> Comparator.comparingInt(Book::getPublicationYear);
            default -> throw new IllegalArgumentException("Invalid criterion. Use 'title', 'author', or 'year'");
        };
        books.sort(comparator);
    }


    public void mergeCollections(List<Book> otherBooks) {
        if (otherBooks == null) throw new IllegalArgumentException("Other collection cannot be null");
        for (Book book : otherBooks) {
            if (book == null) continue;
            if (books.stream()
                    .noneMatch(b -> b.getTitle().equalsIgnoreCase(book.getTitle())
                            && b.getAuthor().equalsIgnoreCase(book.getAuthor()))) {
                books.add(book);
            }
        }
    }

    public List<Book> subCollectionByGenre(String genre) {
        if (genre == null || genre.isBlank()) throw new IllegalArgumentException("Genre cannot be null or empty");
        return books.stream()
                .filter(b -> b.getGenre().equalsIgnoreCase(genre))
                .collect(Collectors.toList());
    }

    public int size() {
        return books.size();
    }
}