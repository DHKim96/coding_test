package dataStructure;

public class UnionFind {
    private static int[] parent;

    public static void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX != rootY) {
            parent[rootY] = rootX;
        }
    }

    public static int find(int x) {
        if (parent[x] == x) { // 인덱스와 value 가 일치 == 루트 노드
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    public static void main(String[] args) {
        parent = new int[7];

        for (int i = 1; i < parent.length; i++) {
            parent[i] = i;
        }

        union(1,4);
        union(5,6);
        union(4,6);

        find(6);

        for (int i = 1; i < parent.length; i++) {
            System.out.println("index = " + i + " / value = " + parent[i]);
        }

    }


}
