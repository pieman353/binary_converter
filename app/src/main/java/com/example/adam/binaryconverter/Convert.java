package com.example.adam.binaryconverter;

public class Convert {

    private String original;

    Convert(String s) {
        original = s;
    }

    public String toBinary() {
        String answer = "";
        for (int i = 0; i < original.length(); i++) {
            int ascii = (int) original.charAt(i);
            String temp = Integer.toBinaryString(ascii);
            while (temp.length() < 8) {
                temp = "0" + temp;
            }
            answer += temp + " ";
        }
        return answer;
    }

    public String[] toPlain() {
        String answer = "";
        int count = 0;
        while (count < original.length()) {
            if (original.charAt(count) != '0' || original.charAt(count) != '1') {
                return new String[] {answer, "1"};
            }
            if (Character.isDigit(original.charAt(count))) {
                String temp = "";
                while (Character.isDigit(original.charAt(count))) {
                    temp += original.charAt(count++);
                }
                int letter = Integer.parseInt(temp, 2);
                if (letter >= 32 && letter <= 126) {
                    answer += (char) letter;
                }
                else {
                    return new String[] {answer, "1"};
                }
            }
            else {
                count++;
            }
        }
        return new String[] {answer, "0"};
    }
}
