package org.example;

import java.util.Scanner;

public class TriangleClassifier {
    private int a;
    private int b;
    private int c;

    public static void main(String[] args) {
        TriangleClassifier classifier = new TriangleClassifier();
        classifier.readSideLengths();
        System.out.println(classifier.classifyTriangle());
    }

    // 1. Einlesen der Eingabewerte für die Längen der drei Seiten eines Dreiecks a, b und c
    public void readSideLengths() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Länge der Seite a: ");
        a = scanner.nextInt();

        System.out.print("Länge der Seite b: ");
        b = scanner.nextInt();

        System.out.print("Länge der Seite c: ");
        c = scanner.nextInt();
    }

    // 2. Prüfung der Eingabewerte: nur natürliche Zahlen zwischen 1 bis 99 erlaubt (einschließlich 1 und 99)
    public String classifyTriangle() {
        if (!isValidSideLength(a) || !isValidSideLength(b) || !isValidSideLength(c)) {
            return "Ungültige Seitenlänge! Bitte geben Sie natürliche Zahlen zwischen 1 und 99 ein.";
        }

        // 3. Berechnung des Ergebnisses in Abhängigkeit der Werte für die drei Seiten
        if (a + b <= c || a + c <= b || b + c <= a) {                           // Damit 3 Seiten ein Dreieck ergeben, muss die Dreiecksungleichung gelten.
            return "Drei Seiten ergeben kein Dreieck.";
        } else if (a == b && b == c) {
            return "Das Dreieck ist ein gleichseitiges Dreieck.";
        } else if (a == b || b == c || c == a) {
            return "Das Dreieck ist ein gleichschenkliges Dreieck.";
        } else {
            return "Das Dreieck ist ein unregelmäßiges Dreieck.";
        }
    }

    private boolean isValidSideLength(int length) {
        return length >= 1 && length <= 99;                 // nur natürliche Zahlen zwischen 1 bis 99 erlaubt
    }
}
