package aut.ir;

import java.util.ArrayList;

public class Graph {
    public LinkedList verticsInfo;
    public Matrix matrix;
    public ArrayList<Boolean> visited;
    public int vSize, countTrue;
    int[] lenghtOfI, firstOfI;

    public Graph(LinkedList linkedList) {
        countTrue = 0;
        vSize = linkedList.list.size() - 1;
        verticsInfo = linkedList;

    }


    public Graph(Matrix matrix) {
        countTrue = 0;
        this.matrix = matrix;
        vSize = matrix.matrixArr.get(matrix.matrixArr.size() - 1).vl;
        lenghtOfI = new int[vSize];
        firstOfI = new int[vSize];
    }

    public void setVisited(ArrayList<Boolean> visited){
        this.visited=visited;
    }
    public void applyLL() {
        BFSinLinkedList(1);
    }

    public void BFSinLinkedList(int vertice) {
        ArrayList<Boolean> visited = new ArrayList<>();
        for (int i = 0; i < verticsInfo.list.size()-1; i++) {
            visited.add(false);
        }
        countTrue=0;
        visited.set(vertice - 1, true);
        countTrue++;
        Queue q = new Queue(visited.size());
        q.add(vertice);
        Node w;
        while (!q.isEmpty()) {
            vertice = q.delete();
            w = verticsInfo.list.get(vertice).first;
            while (w != null) {
                if (!visited.get(w.data - 1)) {
                    q.add(w.data);
                    visited.set(w.data - 1, true);
                    countTrue++;
                }
                w = w.getLink();
            }
        }
        setVisited(visited);
    }

    public void applyM() {
        initializinHelpingArrs();
        BFSinMatrix(matrix.matrixArr.get(0).vl);
    }

    public int findIndex(int vi) {
        return firstOfI[vi - 1];
    }

    public void initializinHelpingArrs() {
        for (int i = 0; i < vSize; i++) {
            lenghtOfI[i] = 0;
        }
        for (int i = 0; i < matrix.matrixArr.size(); i++) {
            lenghtOfI[matrix.matrixArr.get(i).vl - 1]++;
        }
        firstOfI[0] = 0;
        for (int i = 1; i < firstOfI.length; i++) {
            firstOfI[i] = firstOfI[i - 1] + lenghtOfI[i - 1];
        }
    }


    public void BFSinMatrix(int vertice) {
        ArrayList<Boolean> visited = new ArrayList<>();
        for (int i = 0; i < matrix.matrixArr.get(matrix.matrixArr.size() - 1).vl; i++) {
            visited.add(false);
        }
        countTrue=0;
        visited = new ArrayList<>();
        for (int i = 0; i < vSize; i++) {
            visited.add(false);
        }
        visited.set(vertice - 1, true);
        countTrue++;
        Queue q = new Queue(visited.size());
        q.add(vertice);
        while (!q.isEmpty()) {
            vertice = q.delete();
            Element e;
            for (int i = firstOfI[vertice - 1]; i < firstOfI[vertice - 1] + lenghtOfI[vertice - 1]; i++) {
                e = matrix.matrixArr.get(i);
                if (!visited.get(e.vr - 1)) {
                    q.add(e.vr);
                    visited.set(e.vr - 1, true);
                    countTrue++;
                }
            }
        }
        setVisited(visited);
    }


    public int degreeLL(int v) {
        int counter = 0;
        Node w = verticsInfo.list.get(v).first;
        while (w != null) {
            counter++;
            w = w.getLink();
        }
        return counter;
    }

    public int degreeMatrix(int v) {
        return lenghtOfI[v - 1];
    }

    public int nCycleOfL3LL(int vi, int vj) {
        int nCycle = 0;
        Node w = verticsInfo.list.get(vi).first;
        while (w != null) {
            if (isConnectedToLL(w.data, vj)) nCycle++;
            w = w.getLink();
        }
        return nCycle;
    }

    public boolean isConnectedToLL(int v1, int v2) {
        Node w = verticsInfo.list.get(v1).first;
        while (w != null) {
            if (w.data == v2) {
                return true;
            }
            w = w.getLink();
        }
        return false;
    }

    private boolean isConnectedToM(int v, int vd) {
        int index = findIndex(v);
        Element e = matrix.matrixArr.get(index);
        for (int i = firstOfI[v - 1]; i < firstOfI[v - 1] + lenghtOfI[v - 1]; i++) {
            if (e.vr == vd)
                return true;
        }
        return false;
    }

    public int nCycleOfL3M(int vi, int vj) {
        int nCycle = 0;
        int indexI = findIndex(vi);
        Element e = matrix.matrixArr.get(indexI);
        while (e.vl == vi) {
            if (isConnectedToM(e.vr, vj)) nCycle++;
            indexI++;
            if (indexI < matrix.matrixArr.size() - 1) {
                e = matrix.matrixArr.get(++indexI);
            }
        }
        return nCycle;
    }


    public boolean isConnected() {
        return countTrue == vSize;
    }

    public void delLL(int vi, int vj) {
        Node w = verticsInfo.list.get(vi).first;
        Node previous = null;
        while (w != null) {
            if (w.data == vj) {
                if (previous == null)
                    verticsInfo.list.set(vi,new List());
                else {
                    previous.link = w.link;
                    w = null;
                    break;
                }
            }
            previous = w;
            w = w.link;
        }
    }

    public void deleteEdgeLL(int vi, int vj) {
        delLL(vi, vj);
        delLL(vj, vi);
    }

    public void deleteEdgeM(int vi, int vj) {
        int index1=0, index2=0;
        for (int j = firstOfI[vi - 1]; j < firstOfI[vi - 1] + lenghtOfI[vi - 1]; j++) {
            if (matrix.matrixArr.get(j).vr == vj) {
                index1 = j;
                break;
            }

        }
        for (int j = firstOfI[vj - 1]; j < firstOfI[vj - 1] + lenghtOfI[vj - 1]; j++) {
            if (matrix.matrixArr.get(j).vr == vi) {
                index2 = j;
                break;
            }

        }
        matrix.matrixArr.remove(index1);
        if(index1<index2)
             matrix.matrixArr.remove(index2-1);
        else matrix.matrixArr.remove(index2);
    }
}