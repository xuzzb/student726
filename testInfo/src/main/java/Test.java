import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author xuzzb
 * @Create 2023/4/5
 */
public class Test {
    static ArrayList<Integer> res =new ArrayList<>();
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int size = Integer.parseInt((in.nextLine()));
        int [][] nodes=new int[size][];
        for(int i=0;i<size;i++) {
            nodes[i]=parseOneLine(in.nextLine());
        }
        int[] xy=parseOneLine(in.nextLine());
        String result = doQuery(nodes,xy[0],xy[1]);
        System.out.println(result);
    }

    private static int [] parseOneLine(String text) {
        ByteArrayInputStream stream =
                new ByteArrayInputStream(text.getBytes(StandardCharsets.UTF_8));
        Scanner in = new Scanner(stream);
        List<Integer> list =new ArrayList<>();
        while(in.hasNext()) {
            list.add(in.nextInt());
        }
        return list.stream().mapToInt(it -> it).toArray();
    }
    static Node createNode(int [][] nodes,int index) {
        Node node = new Node(nodes[index][0]);
        for(int i=1;i<nodes[index].length;i++)
            node.nexts.add(createNode(nodes,nodes[index][i]));
        return node;


    }
    static void dfs(Node node,int height,int x, int y) {
        if(node==null)
            return;

        if(height>x)
            return;
        if(height==x)
            res.add(node.value);
        for(int i=0;i<node.nexts.size();i++) {
            dfs(node.nexts.get(i),height+1,x,y);

        }
    }
    private static String doQuery(int[][] nodes, int x, int y) {
        if(x<0||y<0) {
            return"{}";
        }
        Node root = createNode(nodes, 0);
        dfs(root,0,x,y);
        if(y>res.size()) {
            return "{}";
        }
        return"{"+res.get(y)+"}";
    }

    static class Node{
        int value;
        ArrayList<Node> nexts = new ArrayList<>();

        public Node(int value) {
            this.value=value;
        }
    }
}
