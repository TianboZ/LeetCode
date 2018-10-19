package MianJing.thumbtack;

import java.util.*;

public class Oa3 {

    String[][] categorySuggestions(String[] categories, String[] projects, int k) {
        // sanity check
        if (categories == null || projects == null || k < 0) return null;

        if (k == 0) {
            String[][] res = new String[projects.length][0];
            return res;
        }

        // graph of relevance
        Map<String, TreeSet<Cell>> map = new HashMap<>();

        // record each categories used or not
        Map<String, Cell> used = new HashMap<>();

        // use treeset to sor every recommend
        TreeSet<Cell> recommend = new TreeSet<>(new CP());

        buildCategoryMap(categories, map);

        // record the result
        List<List<String>> res = new ArrayList<>();

        for (String proj : projects) {
            TreeSet<Cell> relevants = map.get(proj);


            System.out.println(proj);
            // add itself to the recommend
            update(recommend, used, (double)1.0, proj);



            // for loop each current project's recommendation
            for (Cell relevant : relevants) {
                update(recommend, used, relevant.score, relevant.cate);
            }

            int count = 0;
            Iterator iterator = recommend.iterator();
            List<String> list = new ArrayList<>();
            while (iterator.hasNext()) {
                Cell cell = (Cell)iterator.next();
                list.add(cell.cate);
                count++;
                if (count >= k) break;
            }
            res.add(list);
        }



        // test
        String[][] test = new String[projects.length][0];
        return test;

    }

    private void update(TreeSet<Cell> recommend, Map<String, Cell> used, double score, String cate) {
        // check cate if has been recommmeded before
        System.out.println("update: " + cate);
        if (used.containsKey(cate)) {
            // cate is recommended before, if new cate with higher score, should update old cate's score
            if (used.get(cate).score < score) {
                // update to new higher score
                Cell oldCell = used.get(cate);
                Cell newCell = new Cell(cate, score);
                used.put(cate, newCell);
                recommend.remove(oldCell);
                recommend.add(newCell);
            }
        } else {
            // not recommend before
            Cell newCell = new Cell(cate, score);
            used.put(cate, newCell);
            recommend.add(newCell);
        }
    }
    private void buildCategoryMap(String[] categories, Map<String, TreeSet<Cell>> map) {
        for (String s : categories) {
            String[] arr = s.split(",");
            String s1 = arr[0];
            String s2 = arr[1];
            double score = Double.valueOf(arr[2]);

            TreeSet<Cell> set = map.get(s1);
            if (set == null) {
                set = new TreeSet<>(new CP());
                map.put(s1, set);
            }
            set.add(new Cell(s2, score));

            set = map.get(s2);
            if (set == null) {
                set = new TreeSet<>(new CP());
                map.put(s2, set);
            }
            set.add(new Cell(s1, score));
        }
    }
    class CP implements Comparator<Cell> {
        @Override
        public int compare(Cell c1, Cell c2) {
            if (c1.score == c2.score) {
                return c1.cate.compareTo(c2.cate); // categories ascending order
            } else {
                return c1.score < c2.score ? 1 : -1; // score decreasing order
            }
        }
    }

    class Cell {
        String cate;
        double score;
        Cell (String cate, double score) {
            this.cate = cate;
            this.score = score;
        }
    }




    public static void main(String[] args) {

        Oa3 oa3 = new Oa3();
        String[] category = {
                "Electric and Wiring Repair,House Repair,0.8",
                "Electric and Wiring Repair,House Painting,0.2",
                "Electric and Wiring Repair,House Cleaning,0.25",
                "Junk Removal,Electric and Wiring Repair,0.1",
                "House Painting,Interior Painting,0.9",
                "Handyman,Massage Therapy,0.1",
                "Handyman,House Painting,0.5",
                "House Painting,House Cleaning,0.7",
                "Furniture Assembly,Handyman,0.8",
                "Furniture Assembly,Massage Therapy,0.1",
                "Plumbing Drain Repair,Junk Removal,0.3",
                "Dog Training,House Cleaning,0.0001"
        };
        String[] projects = {"Personal Training"};

        oa3.categorySuggestions(category, projects, 5);
    }
}
