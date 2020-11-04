package MianJing.thumbtack;

import java.util.*;

public class RemoveDeadLinkJiaRui {
    public RemoveDeadLinkJiaRui() {
    }

    public static boolean[] removeDeadLinks(boolean[] deadLinks, List<List<Integer>> link) {
        int n = deadLinks.length;
        boolean[] visited = new boolean[n];

        for(int i = 0; i < n; ++i) {
            if (!visited[i]) {
                dfs1(deadLinks, visited, link, i);
            }
        }
        return deadLinks;
    }

    private static boolean dfs1(boolean[] deadlinks, boolean[] visited, List<List<Integer>> link, int i) {
        if (visited[i]) {
            return deadlinks[i];
        } else {
            visited[i] = true;
            Iterator var4 = ((List)link.get(i)).iterator();

            while(var4.hasNext()) {
                int child = (Integer)var4.next();
                if (!dfs1(deadlinks, visited, link, child)) {
                    deadlinks[i] = false;
                }
            }

            return deadlinks[i];
        }
    }

    public static Set<Integer> findAllRoots(List<List<Integer>> link) {
        System.out.println(link);
        int n = link.size();

        boolean[] visited = new boolean[n];
        Set<Integer> roots = new HashSet();

        for(int i = 0; i < n; ++i) {
            if (!visited[i]) {
                roots.add(i);
                dfs(visited, link, i, roots);
            }
        }

        return roots;
    }

    private static void dfs(boolean[] visited, List<List<Integer>> link, int i, Set<Integer> roots) {
        if (visited[i]) {
            if (roots.contains(i)) {
                roots.remove(i);
            }

        } else {
            visited[i] = true;
            Iterator var4 = ((List)link.get(i)).iterator();

            while(var4.hasNext()) {
                int child = (Integer)var4.next();
                if (child != i) {
                    dfs(visited, link, child, roots);
                }
            }

        }
    }

    public static void main(String[] args) {
        List<List<Integer>> link = new ArrayList();
        link.add(new ArrayList(Arrays.asList(1, 2)));
        link.add(new ArrayList(Arrays.asList(3)));
        link.add(new ArrayList(Arrays.asList(3,4)));
        link.add(new ArrayList(Arrays.asList()));
        link.add(new ArrayList(Arrays.asList(3)));
        link.add(new ArrayList(Arrays.asList()));

        System.out.println(findAllRoots(link));
    }
}
