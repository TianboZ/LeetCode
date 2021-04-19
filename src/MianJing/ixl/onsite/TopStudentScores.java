package MianJing.ixl.onsite;

import java.util.*;


/*
*
* assumption:
*   k << # of students
*
*clarification:
* given unsorted input, find top k largest student score
*
* solution:
* use a min heap, add  each element into heap one by one, while keeping min heap size <= k
*
* e.g.
* 1, 3, -1, 10, 100
* k = 2
*
* min heap:
* [ 10, 100]
*
*
* Student {
*   name,
*   score,
* }
*
*
* complexity:
* time O(logk * n)     k is min heap size, n is # of students
* space O(k)
*
* */


class Student {
    public String name;
    public int score;
    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }
}

public class TopStudentScores {

//    public void topK(List<Student> students, int k) {
//        Queue<Student> pq = new PriorityQueue<>((s1, s2) -> s1.score - s2.score); // min heap
//
//        for (Student s: students) {
//            pq.offer(s);
//            if (pq.size() > k) {
//                pq.poll();
//            }
//        }
//
//        while (!pq.isEmpty()) {
//            System.out.println(pq.poll().score);
//        }
//    }

    public List<Student> topK(List<Student> students, int k) {
        // sanity check
        // todo
        if (students == null || k <= 0) return null;

        Queue<Student> pq = new PriorityQueue<>((s1, s2) -> s1.score - s2.score); // min heap, sort Student by score

        for (Student s : students) {
            pq.offer(s);
            if (pq.size() > k) pq.poll();
        }

        List<Student> topk = new ArrayList<>();
        while (!pq.isEmpty()) {
            topk.add(pq.poll());
        }
        return topk;
    }

    public static void main(String[] args) {
        Student s1 = new Student("a", 1);
        Student s2 = new Student("b", 10);
        Student s3 = new Student("c", 5);
        Student s4 = new Student("d", 1000);
        Student s5 = new Student("e", 1001);
        Student s6 = new Student("f", -10);

        List<Student> list = Arrays.asList(s1, s2, s3, s4, s5, s6);
        TopStudentScores sol = new TopStudentScores();
        List<Student> res = sol.topK(list, 3);

        for (Student s : res) {
            System.out.println(s.name + ": " + s.score);
        }
    }
}
