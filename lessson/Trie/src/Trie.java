import java.util.TreeMap;

public class Trie {
    private class Node{
        Boolean isWord;
        TreeMap<Character,Node> next;

        public Node(Boolean isWord) {
            this.isWord = isWord;
            next = new TreeMap<>();
        }

        public Node(){
            isWord = false;
            next = new TreeMap<>();
        }
    }

    private Node root;
    private int size;

    public Trie() {
        root = new Node();
        size = 0;
    }

    /*
    public void add(String word){
        Node cur = root;
        for(int i = 0; i < word.length(); i ++){
            Character c = word.charAt(i);
            if(!cur.next.containsKey(c)){
                cur.next.put(c,new Node());
            }else {
                cur = cur.next.get(c);
            }
        }

        if(cur.isWord == false){
            size ++;
            cur.isWord = true;
        }
    }

     */

    public void add(String word){
        int l = word.length();
        add(word,root,l,0);
    }


    private void add(String word,Node cur,int l,int c){
        if(c == l){
            if(!cur.isWord){
                cur.isWord =true;
                size ++;
            }
            return;
        }

        if(!cur.next.containsKey(word.charAt(c)))
            cur.next.put(word.charAt(c),new Node());
        add(word,cur.next.get(word.charAt(c)),l,c ++);

    }
    public int getSize() {
        return size;
    }
}
