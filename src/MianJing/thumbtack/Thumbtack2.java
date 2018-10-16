package MianJing.thumbtack;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Thumbtack2 {
    int max = 0;

    class Pro {
        // location
        int x;
        int y;

        // id
        int id;

        // hour rate
        int rate;

        // time range
        List<Range> ranges;

        Pro(int x, int y, int rate, int id) {
            this.x = x;
            this.y = y;
            this.rate = rate;
            this.ranges = new ArrayList<>();
            this.id = id;
        }

    }

     class Range {
        // start and end of time range
        int start;
        int end;

        Range(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    class Project {
        // location
        int x;
        int y;

        // user's max budge rate
        int maxBudget;

        // project hours
        int hours;

        // time range
        List<Range> ranges;

        Project(int x, int y, int maxBudget, int hours) {
            this.x = x;
            this.y = y;
            this.hours = hours;
            this.maxBudget = maxBudget;
            this.ranges = new ArrayList<>();
        }
    }

    public int userProMatching(int[][] projectsInfo, String[][] projectsTimeRanges, int[][] prosInfo, String[][] prosTimeRanges) {
        List<Project> projects = new ArrayList<>();
        collectProjectInfo(projects, projectsInfo, projectsTimeRanges);

        List<Pro> pros = new ArrayList<>();
        collectProInfo(pros,prosInfo, prosTimeRanges);

        Set<Integer> usedPros = new HashSet<>();
        dfs(projects, pros, 0, usedPros);
        System.out.println("final solution: " + max);
        return max;
    }

    private void dfs(List<Project> projects, List<Pro> pros, int projectIndex, Set<Integer> usedPros) {

        System.out.println("dfs------------------------------");
        System.out.println("project index: " + projectIndex);
        System.out.println("used pros id: ");
        for (Integer i : usedPros) {
            System.out.println(i);
        }
        System.out.println("dfs------------------------------");


        // base-case
        if (projectIndex == projects.size()) {
            max = Math.max(max, usedPros.size());
            if (max == usedPros.size()) return;
            return;
        }

        // recursive rule
        // current project
        Project project = projects.get(projectIndex);

        // case1: use current project
        // try every time range of this project
        for (Range projRange : project.ranges) {
            // try every pro
            for (Pro pro : pros) {
                int timeOnRoad = getTimeOnRoad(pro, project); // return min, not hour!
                int projTime = project.hours * 60; // min, not hour!
                // try every time range of this pro
                for (Range proRange : pro.ranges) {
                    if (isMatch(timeOnRoad, projTime, proRange, projRange, pro.rate, project.maxBudget) && !usedPros.contains(pro.id)) {
                        //System.out.println("to be added id: " + pro.id);
                        //System.out.println(usedPros.contains(pro.id));
                        usedPros.add(pro.id);
                        dfs(projects, pros, projectIndex + 1, usedPros);
                        usedPros.remove(pro.id);
                    }
                }
            }
        }

        // case2: not use current project
        dfs(projects, pros, projectIndex + 1, usedPros);

    }
    // any time related variable is in min, not hour!
    private boolean isMatch(int timeOnRoad, int projTime, Range proRange, Range projRange, int rate, int budget) {
        if (budget < rate) return false;

        int start = Math.max(proRange.start + timeOnRoad, projRange.start);
        int end = start + projTime;

        if (end <= proRange.end && end <= projRange.end) {
            System.out.println("start: " + start);
            System.out.println("end: " + end);
            System.out.println("duration time: " + (end - start));
            System.out.println("time is enough!");
            return true;
        }
        return false;
    }

    private int getTimeOnRoad(Pro pro, Project project) {
        return Math.abs(pro.x - project.x) + Math.abs(pro.y - project.y);
    }

    private void collectProInfo(List<Pro> pros, int[][] prosInfo, String[][] prosTimeRanges) {
        for (int i = 0; i < prosInfo.length; i++) {
            // pros info
            int x = prosInfo[i][0];
            int y = prosInfo[i][1];
            int rate = prosInfo[i][2];

            Pro pro = new Pro(x, y, rate, i);

            // pros time range
            for (int j = 0; j < prosTimeRanges[i].length; j++) {
                Range range = getRange(prosTimeRanges[i][j]);
                pro.ranges.add(range);
            }

            // add to pros
            pros.add(pro);
        }
    }

    private void collectProjectInfo(List<Project> projects, int[][] projectsInfo, String[][] projectsTimeRanges) {
        for (int i = 0; i < projectsInfo.length; i++) {
            // projects info
            int x = projectsInfo[i][0];
            int y = projectsInfo[i][1];
            int maxBudget = projectsInfo[i][2];
            int size = projectsInfo[i][3];
            int hours = 0;
            if (size == 0) {
                hours = 2;
            } else if (size == 1) {
                hours = 4;
            } else {
                hours = 6;
            }

            Project project = new Project(x, y, maxBudget, hours);

            // projects time info
            for (int j = 0; j < projectsTimeRanges[i].length; j++) {
                Range range = getRange(projectsTimeRanges[i][j]);
                project.ranges.add(range);
            }

            // add to projects
            projects.add(project);
        }
    }
    // input: "16:30-21:00"
    private Range getRange(String s) {
        String[] strings = s.split("-");
        String[] start = strings[0].split(":");
        String[] end = strings[1].split(":");

        int startHour = Integer.parseInt(start[0]);
        int startMin = Integer.parseInt(start[1]);

        int endHour = Integer.parseInt(end[0]);
        int endMin = Integer.parseInt(end[1]);

        Range range = new Range(startHour * 60 + startMin, endHour * 60 + endMin);
        //System.out.println(range);
        return range;
    }

    public static void main(String[] args) {
        Thumbtack2 thumbtack2 = new Thumbtack2();
        thumbtack2.userProMatching(
            new int[][]{
                    new int[]{0, 0, 5, 0},
                    new int[]{1, 2, 8, 1},
                    new int[]{-2, 1, 10, 2}
                    },
            new String[][]{
                    new String[]{"08:00-10:30", "11:59-14:00", "20:30-23:05"},
                    new String[]{"16:30-21:00"},
                    new String[]{"00:00-23:59"}
                    },
            new int[][]{
                    new int[]{5, 0, 7},
                    new int[]{0, 1, 5},
                    new int[]{-1, -1, 8}

                    },
            new String[][]{
                    new String[]{"10:00-16:06"},
                    new String[]{"11:50-14:00", "20:30-23:07"},
                    new String[]{"17:00-23:30"}

                    }
            );

        // timeOnRoad, projTime, proRange, projRange) {
//        boolean res = thumbtack2.isMatch(0, 240, new Range(17 * 60, 23 * 60 + 30), new Range(16 * 60 + 30, 21 * 60));
//        System.out.println(res);
    }
}