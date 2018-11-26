package MianJing.thumbtack.Onsite;

import java.util.*;

import java.util.Random;


/*
*
* 1. clarify uses cases
*
* 2. design APIs -> input, output, corner cases
*
* 3. design class fields, internal states
*
* 4. implement constructor
*
* 5. implement API
*
*
* */
public class ClueGame {
    // fields
    private int[] correct;
    private Set<Integer> wrongIndex;
    private String[] reasons; // wrong reasons

    // constructor
    public ClueGame(int[] correct, String[] reasons) {
        this.correct = correct;
        this.reasons = reasons;
        wrongIndex = new HashSet<>();
    }
    // API
    public void guess(int[] input) {
        // sanity check
        // TODO: 11/24/18

        for (int i = 0; i < input.length; i++) {
            if (input[i] != correct[i]) {
                wrongIndex.add(i);
            } else {
                wrongIndex.remove(i);
            }
        }

        feedback();
    }
    private void feedback() {
        if (wrongIndex.size() == 0) {
            System.out.println("all correct!");
            return;
        }

        int size = wrongIndex.size();
        int i = new Random().nextInt(size);
        int j = 0;
        for (Integer ele : wrongIndex) {
            if (j == i) {
                System.out.println(reasons[ele]);
                break;
            } else {
                j++;
            }
        }
    }

    public static void main(String[] args) {
        int[] correct = {1, 2, 3};
        String[] reasons = {"index 0 is wrong", "index 1 is wrong", "index 2 is wrong"};
        ClueGame clueGame = new ClueGame(correct, reasons);

        int[] input = {11,22,33};

        // random tell a wrong index
        clueGame.guess(input);
        clueGame.guess(input);
        clueGame.guess(input);
        clueGame.guess(input);
        clueGame.guess(input);
        clueGame.guess(input);

        // correct one index
        System.out.println("correct index 0");
        input[0] = 1;
        clueGame.guess(input);
        clueGame.guess(input);
        clueGame.guess(input);
        clueGame.guess(input);
        clueGame.guess(input);
        clueGame.guess(input);

        System.out.println("correct all index");
        input[1] = 2;
        input[2] = 3;

        clueGame.guess(input);

    }
}


//class Test {
//    //memeber
//    private int[] pp = new int[5];
//    private int[] rm = new int[5];
//    private int[] wp = new int[5];
//    private int[] correct;
//
//    public ClueGame(int[] correct) {
//        this.correct = correct;
//    }
//
//    public String play(int pidx, int ridx, int widx) {
//        if (pidx == correct[0] && ridx == correct[1] && widx == correct[2]) {
//            return "Win";
//        }
//
//        String[] wrong = {"pp wrong", "rm wrong", "wp wrong"};
//        List<Integer> list = new ArrayList<>();
//        if (pidx != correct[0]) {
//            list.add(0);
//        }
//
//        if (ridx != correct[1]) {
//            list.add(1);
//        }
//
//        if (widx != correct[2]) {
//            list.add(2);
//        }
//
//        Random rd = new Random();
//        int index = rd.nextInt(list.size());
//        return wrong[list.get(index)];
//    }
//
////    public void simulation() {
////        int[] answer = new int[3];
////        answer[0] = 0;
////        answer[1] = 0;
////        answer[2] = 0; String result = play(answer[0], answer[1], answer[2]);
////        System.out.println("wrong of this try :" + result);
////
////        while (!result.equals("WIN")) {
////            if (result.equals("pp wrong")) {
////                result[0]++;
////            }
////
////            if (result.equals("rm wrong")) {
////                result[1]++;
////            }
////            if (result.equals("wp wrong")) {
////                result[2]++;
////            }
////        }
////        System.out.println("player wins");
////    }
//
//    public static void main(String[] args) {
//        int[] correct = {1, 2, 3};
//        ClueGame test = new ClueGame(correct);
//        String res = test.play(11,22,33);
//        System.out.println(res);
//    }
//}