package Algorithms.strings;

public class MultipleBigIntegers {
    String multiply(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();
        if (len1 == 0 || len2 == 0) return "0";
        int[] result = new int[len1 + len2];
        int index_n1 = 0;
        int index_n2 = 0;
        for (int i = len1 - 1; i >= 0; i--) {
            int carry = 0;
            int n1 = num1.charAt(i) - '0';
            index_n2 = 0;
            for (int j = len2 - 1; j >= 0; j--) {
                int n2 = num2.charAt(j) - '0';
                int sum = (n1 * n2) + carry + result[index_n1 + index_n2];
                carry = sum / 10;
                result[index_n1 + index_n2] = sum % 10;
                index_n2++;
            }
            if (carry > 0)
                result[index_n1 + index_n2] += carry;
            index_n1++;
        }

        int i = result.length - 1;
        String ans = "";
        while (i >= 0) ans += (result[i--]);
        return ans;
    }

    public static void main(String[] args) {
        MultipleBigIntegers multiply = new MultipleBigIntegers();
        String s1 = "12";
        String s2 = "12";
        System.out.println(multiply.multiply(s1, s2));
    }
}
