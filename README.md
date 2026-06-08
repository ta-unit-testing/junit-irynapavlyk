# Automation Testing. Unit testing. JUnit

## Task Instructions

1.  **Choose one task** from the provided list.
2.  **Implement a solution** for the chosen task.
3.  **Write unit tests** to validate your implementation. The tests should include:
    *   **Positive scenarios** — to verify correct program behavior with valid input data.
    *   **Negative scenarios** — to check the program’s response to invalid or unexpected input.

---

## Task 1: Rectangle Representation

Create a class `Rectangle` to represent a rectangle.

### Fields
*   `width`: the width of the rectangle (`double`).
*   `height`: the height of the rectangle (`double`).
*   `angle`: the angle between the sides (`double`). **The angle is always 90 degrees.**

### Constructors
*   **Default constructor**: initializes all fields to their default values.
*   **Parameterized constructor**: takes `width` and `height`.

### Getters and Setters
*   Implement a getter and a setter for each field.

### Requirements
*   The class should be **encapsulated**.
*   The class should be **tested**.

### Methods to Implement
*   `calculateArea()`: calculates the area of the rectangle.
*   `calculatePerimeter()`: calculates the perimeter of the rectangle.
*   `getDiagonal()`: returns the length of the diagonal of the rectangle.

---

## Task 2: Analysis of a Collection of Numbers

Create an `ArrayList` that will store integers (`Integer`). Fill the collection with predefined numbers to ensure tests are stable and reproducible.

**Example collection:**
```java
List<Integer> numbers = new ArrayList<>(Arrays.asList(
    45, 12, 78, 23, 56, 89, 34, 67, 90, 15,
    42, 8, 73, 29, 61, 5, 38, 82, 50, 19
));
```

1.  **Print** all elements to the console.
2.  **Find and print** the minimum and maximum numbers.
3.  **Calculate and print** the average value.
4.  **Remove all even numbers**, then print the updated collection.
5.  **Check** if the collection contains a given number (e.g., 50), and print the result.
6.  **Sort** the collection in ascending order and print it.

---

## Task 3: Operations with a Book Manager

### Book Class Structure
*   **Fields**: `title`, `author`, `genre`, `year`.
*   **Constructors**: To initialize a book with all fields.
*   **Getters/Setters**: For accessing and modifying fields.

### Tasks
1.  **Print List of Authors**: Print all authors in the collection.
2.  **List Authors by Genre**: Print authors who have written books in a given genre.
3.  **List Authors by Publication Year**: Print authors whose books were published in a given year.
4.  **Find Book by Author**: Find a book written by a given author.
5.  **Find Books by Publication Year**: Find all books written in a given year.
6.  **Find Books by Genre**: Find all books belonging to a given genre.
7.  **Remove Books by Author**: Remove all books written by a given author.
8.  **Sort Collection by Criterion**: Sort books by title, author, or year.
9.  **Merge Book Collections**: Combine two book collections into one.
10. **Subcollection of Books by Genre**: Create a subcollection of books from a given genre.

### Implementation Recommendations
*   Use `ArrayList` to store the book collection.
*   For sorting, use `Collections.sort()` or stream methods with an appropriate comparator.
