package MianJing.thumbtack;

import com.sun.tools.internal.ws.wsdl.document.soap.SOAPUse;

import java.util.*;

public class ClueGame {
    // fields
    private int[] input;
    private int[] correct;
    private Set<Integer> wrongIndex;
    private int LENGTH;

    // constructor
    public ClueGame (int[] correct) {
        this.correct = correct;
        wrongIndex = new HashSet<>();
        LENGTH = correct.length;
    }

    // API
    public void guess(int[] arr) {
        if (arr == null || arr.length != LENGTH) {
            System.out.println("input is not valid!");
            throw new IllegalStateException("input is not valid!");
        }

        input = arr;

        // update wrong index set
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != correct[i]) {
                // wrong index
                wrongIndex.add(i);
            } else {
                // correct
                wrongIndex.remove(i);
            }
        }
    }

    public void feedback() {
        if (wrongIndex.size() == 0) {
            System.out.println("all correct!");
            return;
        }

        Random random = new Random();
        int index = random.nextInt(wrongIndex.size());
        List<Integer> list = new ArrayList<>(wrongIndex);
        System.out.println("wrong number index: " + list.get(index));
    }

    public static void main(String[] args) {
        int[] correct = {1,2,3};
        ClueGame clueGame = new ClueGame(correct);

        int[] arr = {1,2,3};

        clueGame.guess(arr);
        clueGame.feedback();
        clueGame.feedback();
        clueGame.feedback();
        clueGame.feedback();
        clueGame.feedback();
        clueGame.feedback();

        System.out.println("------");

        arr = new int[] {1,5,5};
        clueGame.guess(arr);
        clueGame.feedback();

        arr = new int[] {5,2,5};
        clueGame.guess(arr);
        System.out.println("--------");
        clueGame.feedback();
        clueGame.feedback();
        clueGame.feedback();
        clueGame.feedback();
        System.out.println("--------");

        arr = new int[] {5,2,3};
        clueGame.guess(arr);
        clueGame.feedback();
    }
}
