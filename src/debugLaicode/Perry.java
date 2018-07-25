package debugLaicode;

public class Perry {

    public static void main(String[] args)
    {

        int[] arr = {5, 4, 3, 2, 1};
        Perry perry = new Perry();
        perry.mergesort(arr, 0, arr.length - 1);

        // you dont need to know what happens here

        // just print each element in array

        for (int i : arr)

        {

            System.out.println(i);

        }


    }


    // mergesort() do: given an unsorted array, and left, right index, after calling

    // this function, original array becomes sorted.

    private  void mergesort(int[] arr, int left, int right)
    {
        // base-case
        if (left >= right)
        {
            return;
        }

        // recursive rule
        int middle = left + (right - left) / 2;
        mergesort(arr, left, middle); // step1
        mergesort(arr, middle + 1, right); // step2

        //merge() is a helper function, purpuse is to get final result
        merge(arr, left, right);
    }
    // Making two pointers comparing and sorting each other to make a sorted array.
    private  void merge(int[] arr, int left, int right)
    {
        // to do: clone original array to a new array, call it tmpt array
        int[] tmpt = new int[arr.length];
        for (int i = left; i <= right; i++)
        {
            tmpt[i] = arr[i];
        }
        int middle = left + (right - left) / 2;
        int pointer1 = left;
        int pointer2 = middle + 1;
        int pointer3 = left;

        while (pointer1 <= middle && pointer2 <= right)
        {
            if (tmpt[pointer1] >= tmpt[pointer2])
            {
                arr[pointer3] = tmpt[pointer2];
                pointer2++;
                pointer3++;
            } else
            {
                arr[pointer3] = tmpt[pointer1];
                pointer1++;
                pointer3++;
            }

        }
        // Any remainings
        while (pointer1 <= middle)
        {
            arr[pointer3] = tmpt[pointer1];
            pointer1++;
            pointer3++;
        }
    }
}