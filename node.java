import java.util.ArrayList;

public class Node {
    static ArrayList <Node> list_of_nodes = new ArrayList<>();
    Integer data;
    Node left;
    Node right;

    Node(Integer data){
        this.data = data;
    }
    void Node_Max(){
        if(this.left != null && this.left.data != null) {
            if (this.left.data > this.data) {
                int temp = this.data;
                this.data = this.left.data;
                this.left.data = temp;
            }
        }
        if(this.right != null && this.right.data != null) {
            if (this.right.data > this.data) {
                int temp = this.data;
                this.data = this.right.data;
                this.right.data = temp;
            }
        }
    }
    void Add_Nodes(Integer data1, Integer data2){
        left = new Node(data1);
        list_of_nodes.add(left);
        right = new Node(data2);
        list_of_nodes.add(right);
        Node_Max();
    }
    static void build_tree(ArrayList<Integer>array) {
        list_of_nodes.clear();
        list_of_nodes.add(new Node(array.get(0)));
        int index = 1;
        for(int i = 0; i <= array.size(); i++) {
            if (valid_index(index + 1, array.size())) {
                list_of_nodes.get(i).Add_Nodes(array.get(index), array.get(index + 1));
            } else if (valid_index(index, array.size())) {
                list_of_nodes.get(i).Add_Nodes(array.get(index), null);
            }
            index += 2;
        }
    }
    static boolean valid_index(int index, int length) {
        return index < length;
    }
    static void max_heap() {
        for(int index = list_of_nodes.size() - 1; index > -1; index--){
            list_of_nodes.get(index).Node_Max();
        }
    }
    static ArrayList<Integer> heap_sort(ArrayList<Integer> array) {
        ArrayList<Integer> result = new ArrayList<>();
        while(array.size() > 1) {
            build_tree(array);
            Node.max_heap();
            result.add(list_of_nodes.get(0).data);
            array.clear();
            for(Node i: list_of_nodes){
                if(i != null && i.data != null)
                    array.add(i.data);
            }
            array.remove(0);
            build_tree(array);
        }
        result.add(array.get(0));
        return result;
    }
}
