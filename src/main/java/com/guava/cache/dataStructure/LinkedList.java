package com.guava.cache.dataStructure;


/**
 * 链表、栈、队列、排序、数组、树
 * Created by heshuanglin on 2017/12/13.
 */
public class LinkedList<T> {

    Node<T> head;

    int size;

    LinkedList(){
        head = null;
        size = 0;
    }

    public void add(T value){
        Node<T> node = new Node<>(value);
        node.next = head;
        head = node;
        size++;
    }

    public void addEnd(T value){
        Node<T> node = new Node<>(value);
        if (head == null){
            head = node;
            return;
        }
        Node<T> temp = head.next;

        Node<T> last = null;

        if (temp == null){
            last = head;
        }
        while (temp != null){
            if(temp.next == null){
                last = temp;
            }
            temp = temp.next;
        }
        last.next = node;
    }

    public void eachNode(Node<T> node){
        System.out.println(node.toString());
        Node<T> temp = node.next;

        while (temp != null){
            System.out.println(temp.toString());
            temp = temp.next;
        }
    }



    public int getSize(){
        return  size;
    }


    public Node getHead(){
        return head;
    }


    class Node<T>{
        T value;
        Node<T> next;

        Node(T value){
            this.value = value;
        }

        public String toString(){
            return ""+value;
        }
    }


}
