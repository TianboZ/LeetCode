package debugLaicode;

public class EncodeAndDecodeString {
    public String encode(String s) {
        StringBuilder sb = new StringBuilder();
        // 11111abbbb4 -> 1#5,a#1,b#4,4#1
        for (int i = 0; i < s.length(); i++) {
            int j = i;
            int count = 1;
            while (j + 1 < s.length() && s.charAt(j) == s.charAt(j + 1)) {
                j++;
                count++;
            }
            // j is last index of same character

            sb.append(s.charAt(i));
            sb.append('#');
            sb.append(count);
            sb.append(',');

            i = j; // i skip to last same element's index
        }

        System.out.println(sb.toString());
        return sb.toString();
    }


    public String decode(String s) {
        StringBuilder sb = new StringBuilder();
        // 1#5,a#1,b#4,4#1  ->   11111abbbb4
        for (int i = 0; i < s.length(); i++) {
            int j = i + 2; // first index of digit
            int num = 0;
            while (j < s.length() && Character.isDigit(s.charAt(j))) {
                num = num * 10 + Character.getNumericValue(s.charAt(j));
                j++;
            }
            // j is index of ','
            for (int k = 0; k < num; k++) {
                sb.append(s.charAt(i));
            }
            i = j;
        }
        System.out.println(sb.toString());
        return sb.toString();
    }

    public static void main(String[] args) {
        EncodeAndDecodeString encodeAndDecodeString = new EncodeAndDecodeString();
        String encoded = encodeAndDecodeString.encode("111111abbbb551");
        String decoded = encodeAndDecodeString.decode("1#6,a#1,b#4,5#2,1#1,a#0,");
        System.out.println(decoded.equals("111111abbbb551")); // true
    }
}
