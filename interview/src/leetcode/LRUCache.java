package leetcode;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    class Node {
        public int key;
        public int value;
        public Node prev;
        public Node next;
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private Map<Integer, Node> map;
    private Node head;
    private Node tail;
    private int size;
    private int capacity;
    public LRUCache(int capacity) {
        map = new HashMap<>(capacity);
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
        this.size = 0;
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node node = map.get(key);
        moveToTail(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            moveToTail(node);
        }  else {
            Node node = new Node(key, value);
            map.put(key, node);
            addToTail(node);
            size++;
            if (size > capacity) {
                Node next = head.next;
                removeNode(next);
                map.remove(next.key);
                size--;
            }
        }
    }

    private void addToTail(Node node) {
        node.prev =  tail.prev;
        node.next = tail;
        tail.prev.next = node;
        tail.prev = node;
    }

    private void removeNode(Node next) {
        next.prev.next = next.next;
        next.next.prev = next.prev;
    }

    private void moveToTail(Node node) {
        removeNode(node);
        addToTail(node);
    }
}
