package com.guava.cache.dataStructure;

/**
 * Created by heshuanglin on 2017/12/14.
 */
public class DoublyLinked<T> {


    int size;
    T element;
    Node<T> first;
    Node<T> last;

    DoublyLinked(){

    }


    public void addFirst(T element){
        Node<T> f = first;
        Node<T> node = new Node<>(null,element,f);

        first = node;
        if (f == null){
            last = node;
        }else {
            f.pre = node;
        }
        size++;
    }


    public  void  addLast(T element){
        Node<T> l = last;
        Node<T> node = new Node<T>(l,element,null);

        last = node;
        if (l == null){
            first = node;
        }else {
            l.next = node;
        }
        size++;
    }

    public void add(T element){
        addFirst(element);
    }


    public void eachList(Node<T> node){

        while (node != null){
            System.out.println(node.toString());
            node = node.next;
        }

    }


    public Node<T> getFirst(){
        return first;
    }


    public Node<T> getLast(){
        return last;

    }

    public int getSize(){
        return  size;
    }


    class Node<T> {

        T element;
        Node<T> next;
        Node<T> pre;

        Node(Node<T> pre,T element ,Node<T> next){
            this.element = element;
            this.next = next;
            this.pre = pre;
        }

        public String toString(){
            return element+"";
        }
    }


}
