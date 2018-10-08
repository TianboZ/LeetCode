package debugLaicode;

/*

if a.length < b.length, repeat append a to the end of a, until a.length > b.length, use "count" to record repeat times
if b is the subtring of new a, then return the "count"

*/
public class RepeatedStringMatch {
    public int repeatedStringMatch(String A, String B) {
        StringBuilder sb = new StringBuilder();
        int count = 1;
        sb.append(A);
        while (sb.length() < B.length()) {
            sb.append(A);
            count++;
        }

        if (sb.indexOf(B) >= 0) return count;
        if (sb.append(A).indexOf(B) >= 0) return count + 1;
        return -1;

    }
}