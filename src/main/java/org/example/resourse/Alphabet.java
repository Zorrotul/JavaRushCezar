package org.example.resourse;

import java.util.List;

public class Alphabet {
    private static final char[] ALPHABET = {'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж', 'з',
            'и', 'й', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ',
            'ъ', 'ы', 'ь', 'э', 'ю', 'я'
    };
    private static final List<Character> ALPHABET2 = List.of('а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж', 'з',
            'и', 'й', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ',
            'ъ', 'ы', 'ь', 'э', 'ю', 'я');



    private static final char[] SYMBOLS = {'.', ',', '«', '»', '"', '\'', ':', '!', '?', ' '};

    private static final List<Character> SYMBOLS2 = List.of('.', ',', '«', '»', '"', '\'', ':', '!', '?', ' ');

    public static int ALPHABET_LENGTH = ALPHABET.length;

    public static int getIndexByChar(char c) {

        return ALPHABET2.indexOf(c);
//        int laterNumber = -1;
//        c = Character.toLowerCase(c);
//        for (int i = 0; i < alphabetLength; i++) {
//            if (c == ALPHABET[i]) {
//                laterNumber = i;
//                break;
//            }
//        }
//        if (laterNumber != -1) {
//            return laterNumber;
//        } else throw new RuntimeException("нет такого символа: " + c);
    }

    public static char getEncodedChar(int key, char c) {
        for (int i = 0; i < SYMBOLS.length; i++) {
            if (SYMBOLS[i] == c) {
                return c;
            }
        }
        return ALPHABET[(key + getIndexByChar(c)) % ALPHABET_LENGTH];
    }



    public static char getCharByIndex(int index) {
        return ALPHABET[index];
    }
    //public static char getIndexByChar(char c) {р
    //    for (char a:ALPHABET){
//
    //    }
    //    return ALPHABET[];
    //}
}
