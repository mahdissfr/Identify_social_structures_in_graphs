package aut.ir;

import java.util.ArrayList;

/**
 * Created by mahdis on 1/17/2018.
 */
public class Matrix {
    ArrayList<Element> matrixArr;
    public Matrix(){
        matrixArr=new ArrayList<>();
    }
    public void add(int i,int j){
        matrixArr.add(new Element(i,j));
    }
}
class Element{
    int vl,vr;

    public Element(int vl, int vr) {
        this.vl = vl;
        this.vr = vr;
    }
}
