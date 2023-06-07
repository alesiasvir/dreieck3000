package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TriangleClassifierTest {
    private TriangleClassifier classifier;

    @BeforeEach
    public void setup() {
        classifier = new TriangleClassifier();
    }

    @Test
    public void testClassifyEquilateralTriangle() {
        simulateUserInput("5", "5", "5");
        classifier.readSideLengths();
        assertEquals("Das Dreieck ist ein gleichseitiges Dreieck.", classifier.classifyTriangle());
    }

    @Test
    public void testClassifyIsoscelesTriangle() {
        simulateUserInput("4", "4", "6");
        classifier.readSideLengths();
        assertEquals("Das Dreieck ist ein gleichschenkliges Dreieck.", classifier.classifyTriangle());
    }

    @Test
    public void testClassifyIrregularTriangle() {
        simulateUserInput("3", "4", "5");
        classifier.readSideLengths();
        assertEquals("Das Dreieck ist ein unregelmäßiges Dreieck.", classifier.classifyTriangle());
    }

    @Test
    public void testClassifyNotATriangle() {
        simulateUserInput("1", "2", "3");
        classifier.readSideLengths();
        assertEquals("Drei Seiten ergeben kein Dreieck.", classifier.classifyTriangle());
    }

    @Test
    public void testInvalidSideLength() {
        simulateUserInput("0", "100", "50");
        classifier.readSideLengths();
        assertEquals("Ungültige Seitenlänge! Bitte geben Sie natürliche Zahlen zwischen 1 und 99 ein.", classifier.classifyTriangle());
    }

    private void simulateUserInput(String... inputs) {
        String inputString = String.join(System.lineSeparator(), inputs);
        InputStream inputStream = new ByteArrayInputStream(inputString.getBytes());
        System.setIn(inputStream);
    }
}
