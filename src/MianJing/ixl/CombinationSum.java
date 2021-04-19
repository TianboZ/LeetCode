package MianJing.ixl;

public class CombinationSum {
    int count = 0;
    public int count(int[] arr, int target) {
        dfs(arr, 0, target, 0);
        return count;
    }
    private void dfs(int[] arr, int i, int target, int currSum) {
        // base case
        if (currSum > target) return;
        if (i == arr.length) {
            if (currSum == target) count++;
            return;
        }

        // recursive rule
        int num = arr[i];
        for (int k = 0; k * num + currSum <= target; k++) {
            dfs(arr, i + 1, target, currSum + k * num);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 5};
        CombinationSum sol = new CombinationSum();
        int res = sol.count(arr, 5);
        System.out.println(res);
    }
}
