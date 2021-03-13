package aut.ir;

import java.util.ArrayList;

/**
 * Created by mahdis on 1/18/2018.
 */
public class LinkedList {
    ArrayList<List> list;
    public LinkedList(){
        list=new ArrayList<>();
        list.add(new List());
        list.get(0).addNode(-1);
    }
    public void add(int i,int j){
        if(list.size()-1<i){
            for(int k=list.size()-1;k<i;k++) {
                list.add(new List());
            }
        }
        list.get(i).addNode(j);
    }
}
