package debugLaicode;

public class CompareVersionNumbers {
    public int compareVersion(String version1, String version2) {
        int i = 0;
        int j = 0;

        String[] nums1 = version1.split("[.]");
        String[] nums2 = version2.split("[.]");

        while (i < nums1.length || j < nums2.length) {
            int n1 = i < nums1.length ? Integer.parseInt(nums1[i]) : 0;
            int n2 = j < nums2.length ? Integer.parseInt(nums2[j]) : 0;

            System.out.println(n1 + ", " + n2);
            if (n1 < n2) return -1;
            if (n1 > n2) return 1;

            i++;
            j++;
        }

        return 0;
    }

    public static void main(String[] args) {
        CompareVersionNumbers sol = new CompareVersionNumbers();
        sol.compareVersion("1.01", "1.2");


    }
}
