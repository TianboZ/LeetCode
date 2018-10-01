package debugLaicode;

import java.util.*;

public class SequenceReconstruction {
    // sol1:
    public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
        // key: node    value: indegree
        Map<Integer, Integer> indegree = new HashMap<>();
        // key: node     value: nodes that come into this node
        Map<Integer, Set<Integer>> map = new HashMap<>();

        //System.out.println(seqs.size());

        for (List<Integer> list : seqs) {
            //System.out.println(list.size());
            for (int i = 0; i < list.size(); i++) {
                Set<Integer> set = map.get(list.get(i));
                if (set == null) {
                    set = new HashSet<>();
                    map.put(list.get(i), set);
                }
                if (i != 0) {
                    set.add(list.get(i - 1));
                    map.put(list.get(i), set);
                    //System.out.println(map);
                }
            }

        }

        int countNode = 0;
        while (map.size() > 0) {
            int count = 0;
            int node = -1;
            for (Map.Entry<Integer, Set<Integer>> entry: map.entrySet()) {
                if (entry.getValue().size() == 0) {
                    count++;
                    node = entry.getKey();
                }
            }
            if (count == 0) {
                return false; // cycle
            } else if(count > 1) {
                return false; // more than one solution
            }

            map.remove(node);
            countNode++;
            for (Map.Entry<Integer, Set<Integer>> entry: map.entrySet()) {
                entry.getValue().remove(node);
            }

        }

        //System.out.println(map);
        return countNode == org.length;
    }

    // sol2: optimize
    public boolean sequenceReconstruction1(int[] org, List<List<Integer>> seqs) {

        Map<Integer, Set<Integer>> map = new HashMap<>();
        Map<Integer, Integer> indegree = new HashMap<>();

        for(List<Integer> seq: seqs) {
            if(seq.size() == 1) {
                if(!map.containsKey(seq.get(0))) {
                    map.put(seq.get(0), new HashSet<>());
                    indegree.put(seq.get(0), 0);
                }
            } else {
                for(int i = 0; i < seq.size() - 1; i++) {
                    if(!map.containsKey(seq.get(i))) {
                        map.put(seq.get(i), new HashSet<>());
                        indegree.put(seq.get(i), 0);
                    }

                    if(!map.containsKey(seq.get(i + 1))) {
                        map.put(seq.get(i + 1), new HashSet<>());
                        indegree.put(seq.get(i + 1), 0);
                    }

                    if(map.get(seq.get(i)).add(seq.get(i + 1))) {
                        indegree.put(seq.get(i + 1), indegree.get(seq.get(i + 1)) + 1);
                    }
                }
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for(Map.Entry<Integer, Integer> entry: indegree.entrySet()) {
            if(entry.getValue() == 0) queue.offer(entry.getKey());
        }

        int index = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            if(size > 1) return false;
            int curr = queue.poll();
            if(index == org.length || curr != org[index++]) return false;
            for(int next: map.get(curr)) {
                indegree.put(next, indegree.get(next) - 1);
                if(indegree.get(next) == 0) queue.offer(next);
            }
        }
        return index == org.length && index == map.size();
    }

    public static void main(String[] args) {
        SequenceReconstruction sequenceReconstruction = new SequenceReconstruction();
        List<List<Integer>> seqs = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);

        List<Integer> list2 = new ArrayList<>();
        list2.add(4);
        list2.add(5);
        list2.add(3);
        seqs.add(list1);
        seqs.add(list2);

        sequenceReconstruction.sequenceReconstruction(null, seqs);
    }
}
