class LRUCache {
    class Node{
        int key;
        int value;
        Node prev;
        Node next;
        Node(int key,int value){
            this.key=key;
            this.value=value;
        }
    }
        Node head;
        Node tail;
        
    
    HashMap<Integer,Node> hm;
    int capacity;
    public void remove(Node x){
        x.prev.next=x.next;
        x.next.prev=x.prev;


    }
    public void insert(Node x){
        x.next=head.next;
        x.prev=head;

        head.next.prev=x;
        head.next=x;


    }

    public LRUCache(int capacity) {
        this.capacity=capacity;
        hm=new HashMap<>();
        head=new Node(0,0);
        tail=new Node(0,0);
        head.next=tail;
        tail.prev=head;

       

      
        
    }
    
    public int get(int key) {
        if(!hm.containsKey(key)){
            return -1;
        }
        Node ans=hm.get(key);
        remove(ans);
        insert(ans);
        return ans.value;

        
    }
    
    public void put(int key, int value) {
        Node curr=new Node(key,value);
        if(hm.containsKey(key)){
            Node old=hm.get(key);
            remove(old);
            hm.remove(key);

        }
        if(hm.size()==capacity){
            Node y=tail.prev;
            remove(y);
            hm.remove(y.key);
        }
       
        insert(curr);
        hm.put(key,curr);
        
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */