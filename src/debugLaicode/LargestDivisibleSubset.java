package debugLaicode;

import java.util.*;

public class LargestDivisibleSubset {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        List<OPT> list = new ArrayList<OPT>();

        for (int i = 0; i < n; i++) {
            OPT opt = new OPT(1, i);
            list.add(opt);
        }

        for (int i = 1; i < n; i++) {
            System.out.println("loop");
            int max = Integer.MIN_VALUE;
            int keep = 0;
            for (int x = 1; x <= i; x++) {
                if (nums[i] % nums[i - x] == 0) {
                    if (list.get(i - x).count > max) {
                        max = list.get(i - x).count;
                        keep = i - x;
                        System.out.println("keep "+keep);
                    }
                }
            }
            if (list.get(i).count < list.get(keep).count + 1) {
                //System.out.println("aaaa");
                list.get(i).setCount(1 + list.get(keep).count);
                list.get(i).setSet(list.get(keep).set);
            }
        }

        for (int i = 0; i < list.size(); i++) {
            System.out.println("opt: "+i);
            System.out.println("count: "+list.get(i).count);
            System.out.println("index set: ");
            for (Integer j : list.get(i).set) {
                System.out.println(j);
            }
            System.out.println();
        }

        int max = Integer.MIN_VALUE;
        int keep = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).count > max) {
                keep = i;
                max = list.get(i).count;
            }
        }

        List<Integer> result = new ArrayList<Integer>();
        for (Integer i : list.get(keep).set) {
            result.add(i);
        }
        return result;
    }

    class OPT {
        int count;
        Set<Integer> set = new HashSet<Integer>();

        OPT (int count, int index){
            this.count = count;
            this.set.add(index);
        }

        public void setCount(int newCount) {
            this.count = newCount;
        }

        public void setSet(Set newSet) {
            Set<Integer> set1 = new HashSet<>(newSet);
            for (Integer i : set1) {
                this.set.add(i);
            }
        }
    }
}



