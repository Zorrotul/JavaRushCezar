package org.example.resorse;

public class Alphabet {
    private static final char[] ALPHABET = {'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж', 'з',
            'и', 'й', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ',
            'ъ', 'ы', 'ь', 'э', 'ю', 'я', '.', ',', '«', '»', '"', '\'', ':', '!', '?', ' '};

    public static int getLaterNumber(char c) {
        for (int i : ALPHABET) {
            if (c == ALPHABET[i]) {
                return i;
            } else throw new RuntimeException("нет такого символа: " + c);
        }
        return -1; //TODO: придумать лучшее решение
    }

    public static char getEncodedChar(int key, char c) {
        return ALPHABET[(key + getLaterNumber(c)) % 42];
    }
}
