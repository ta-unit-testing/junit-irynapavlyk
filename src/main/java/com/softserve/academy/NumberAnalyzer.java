package com.softserve.academy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NumberAnalyzer {
    private List<Integer> numbers;

    public NumberAnalyzer(List<Integer> numbers) {
        if (numbers == null) {
            throw new IllegalArgumentException("Numbers list cannot be null");
        }
        this.numbers = new ArrayList<>(numbers);
    }

    public List<Integer> getNumbers() {
        return new ArrayList<>(numbers);
    }

    public int findMinimum() {
        if (numbers.isEmpty()) {
            throw new IllegalStateException("Cannot find minimum in empty collection");
        }
        return Collections.min(numbers);
    }

    public int findMaximum() {
        if (numbers.isEmpty()) {
            throw new IllegalStateException("Cannot find maximum in empty collection");
        }
        return Collections.max(numbers);
    }

    public double calculateAverage() {
        if (numbers.isEmpty()) {
            throw new IllegalStateException("Cannot calculate average of empty collection");
        }
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);
    }

    public void removeEvenNumbers() {
        numbers.removeIf(num -> num % 2 == 0);
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }

    public void sortAscending() {
        Collections.sort(numbers);
    }

    public int size() {
        return numbers.size();
    }

    public void printAll() {
        System.out.println("Numbers: " + numbers);
    }
}
