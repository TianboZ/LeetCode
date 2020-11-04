package MianJing;

/*
version 1
Recruiter直接联系拿的OA， 应该是新的，和之前的propel项目的都不一样，75分钟3道题。整体来看不算特别难
1. 给一个int array，然后给另一个array是表示向左rotate这个array多少个position，然后输出每次进行这样操作后最大值所在的Index
2. int数组排序，只不过要先按照二进制1的个数排，比如7是111，8是1000，7的1比8的1多，所以7比8大。如果1的个数相同再比较十进制值的大小. from: 1point3acres.com/bbs
3. 这个题特别tricky，求一个数有多少种consecutive sum，比如15=1+2+3+4+5=4+5+6=7+8，所以有三种。这个geeksforgeeks上有，但会超时。特别坑的数学问题，大家看看这个吧
https://math.stackexchange.com/questions/1100897/sum-of-consecutive-numbers

吐槽一下VMware不好好考编程，考数学实在是不知道怎么想的。
做完当天就收到Onsite了，求onsite组织

version 2
1. 遍历一个int array，对每一个数有两种操作，加入或删除，每操作一次返回当前min＊max， 用treemap test都能过
*/


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class VMWARE {
    ////////////////////////////////q2 //////////////////////////////////////

    public int partition(int arr[], int low, int high)
    {
        int pivot = arr[high];
        int i = (low-1); // index of smaller element
        for (int j=low; j<high; j++)
        {
            // If current element is smaller than or
            // equal to pivot
            //if (pivot >= arr[j])
            if (compare(pivot, arr[j])) {
                i++;
                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;

        return i+1;
    }

    public void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }

    /* The main function that implements QuickSort()
    arr[] --> Array to be sorted,
    low --> Starting index,
    high --> Ending index */
    public void sort(int arr[], int low, int high)
    {
        if (low < high)
        {
			/* pi is partitioning index, arr[pi] is
			now at right place */
            int pi = partition(arr, low, high);

            // Recursively sort elements before
            // partition and after partition
            sort(arr, low, pi-1);
            sort(arr, pi+1, high);
        }
    }

    public void test1(int[] arr) {
        int n = arr.length;
        sort(arr, 0, n-1);
        System.out.println("sorted array");
        printArray(arr);
    }

    public void bubbleSort(int[] arr) {
        int n = arr.length;
        int temp = 0;
        for(int i=0; i < n; i++){
            for(int j=1; j < (n-i); j++){
                if (compare(arr[j-1], arr[j])) {
                //if(arr[j-1] >= arr[j]){ // ascending
                    //swap elements
                    temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                }

            }
        }
        for (int i : arr) {
            System.out.println(i);
        }
    }

    // compare e1, e2. compare binary first, then compare decimal
    // if e1 >= e2, return true
    public boolean compare(int e1, int e2) {
        String s1 = Integer.toBinaryString(e1);
        String s2 = Integer.toBinaryString(e2);

        int count1 = 0;
        int count2 = 0;

        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            if (c == '1') {
                count1++;
            }
        }

        for (int i = 0; i < s2.length(); i++) {
            char c = s2.charAt(i);
            if (c == '1') {
                count2++;
            }
        }

        if (count1 > count2) {
            return true;
        }

        if (count1 < count2) {
            return false;
        }

        // now compare decimal
        if(e1 >= e2) {
            return true;
        } else {
            return false;
        }
    }


    //////////////////////////////////q3 ////////////////////////////////////
    public void findConsecutive(int N)
    {
        // Note that we don't ever have to sum
        // numbers > ceil(N/2)
        int start = 1, end = (N+1)/2;

        // Repeat the loop from bottom to half
        while (start < end)
        {
            // Check if there exist any sequence
            // from bottom to half which adds up to N
            int sum = 0;
            for (int i = start; i <= end; i++)
            {
                sum = sum + i;

                // If sum = N, this means consecutive
                // sequence exists
                if (sum == N)
                {
                    // found consecutive numbers! print them
                    for (int j = start; j <= i; j++) {
                        System.out.println(j);
                    }
                    System.out.println("//");
                    break;
                }

                // if sum increases N then it can not exist
                // in the consecutive sequence starting from
                // bottom
                if (sum > N)
                    break;
            }
            sum = 0;
            start++;
        }
    }

    public void printSums(int N)
    {
        int start = 1, end = 1;
        int sum = 1;

        while (start <= N/2)
        {
            if (sum < N)
            {
                end += 1;
                sum += end;
            }
            else if (sum > N)
            {
                sum -= start;
                start += 1;
            }
            else if (sum == N)
            {
                for (int i = start; i <= end; ++i) {
                    System.out.println(i);
                }
                System.out.println("//");
                sum -= start;
                start += 1;
            }
        }
    }

    ///////////////////////////////////////////////////////////////////////
    public void test3(int[] counts) {
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();

        for (int i = 0; i < counts.length; i++) {
            if (!map.containsKey(counts[i])) {
                map.put(counts[i], new ArrayList<>());
            }
            ArrayList<Integer> temp = map.get(counts[i]);
            temp.add(i);
            if (temp.size() == counts[i]) {
                for (int j = 0; j < temp.size(); j++) {
                    System.out.print(temp.get(j) + " ");
                }
                System.out.println();
                temp = new ArrayList<>();
            }
            map.put(counts[i], temp);
        }
    }
}
