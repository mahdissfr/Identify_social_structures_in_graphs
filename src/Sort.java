package aut.ir;

import java.util.ArrayList;

/**
 * Created by mahdis on 1/18/2018.
 */
public class Sort {

    public void interchange(ArrayList<NodeInfo> nodeInfos, int i, int j) {
        NodeInfo tmp = nodeInfos.get(i);
        nodeInfos.set(i, nodeInfos.get(j));
        nodeInfos.set(j, tmp);
    }

    public void quickSort(ArrayList<NodeInfo> info, int left, int right) {
        if (left < right) {
            int i = left;
            int j = right + 1;
            double pivot = info.get(left).c;
            do {
                do i++; while (info.get(i).c < pivot);
                do j--; while (info.get(j).c > pivot);
                if (i < j) interchange(info, i, j);
            } while (i < j);
            interchange(info, left, j);
            quickSort(info, left, j - 1);
            quickSort(info, j + 1, right);
        }
    }


    public void insertionSort(ArrayList<NodeInfo> info, int start, int end) {
        int n = end-start+1;
        for (int i=1; i<n; ++i)
        {
            double key = info.get(i).c;
            int j = i-1;
            while (j>=0 && info.get(j).c > key)
            {
                info.set(j+1 , info.get(j));
                j = j-1;
            }
            info.set(j+1, info.get(i));
        }
    }

public void merge(ArrayList<NodeInfo> info, int l, int m, int r) {
    int i, j, k;
    int n1 = m - l + 1;
    int n2 = r - m;

    ArrayList<NodeInfo> L = new ArrayList<>();
    ArrayList<NodeInfo> R = new ArrayList<>();


    for (i = 0; i < n1; i++)
        L.add(info.get(l + i));
    for (j = 0; j < n2; j++)
        R.add(info.get(m + 1 + j));

    i = 0;
    j = 0;
    k = l;
    while (i < n1 && j < n2) {
        if (L.get(i).c <= R.get(j).c) {
            info.set(k,L.get(i)) ;
            i++;
        } else {
            info.set(k,R.get(j));
            j++;
        }
        k++;
    }

    while (i < n1) {
        info.set(k,L.get(i));
        i++;
        k++;
    }

    while (j < n2) {
        info.set(k,R.get(j));
        j++;
        k++;
    }
}

    public void mergeSort(ArrayList<NodeInfo> info, int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;

            mergeSort(info, l, m);
            mergeSort(info, m + 1, r);

            merge(info, l, m, r);
        }
    }

    public void bubbleSort(ArrayList<NodeInfo> info, int start, int end) {
        int n = end - start + 1;
        NodeInfo temp;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (info.get(start + j - 1).c > info.get(start + j).c) {
                    //swap elements
                    temp = info.get(start + j - 1);
                    info.set(start + j - 1,info.get(start + j)) ;
                    info.set(start + j,temp);
                }
            }
        }
    }

    public void optimumSort(ArrayList<NodeInfo> info, int left, int right, int n, int selector) {
        if (left < right) {
            int i = left;
            int j = right + 1;
            double pivot = info.get(left).c;
            do {
                do i++; while (info.get(i).c < pivot);
                do j--; while (info.get(j).c > pivot);
                if (i < j) interchange(info, i, j);
            } while (i < j);
            interchange(info, left, j);
            if ((j - left) > n)
                quickSort(info, left, j - 1);
            else {
                if (selector == 1)
                    bubbleSort(info, left, j - 1);
                if (selector == 2)
                    insertionSort(info,left,j-1);
            }
            if ((right-j) > n)
                quickSort(info, j + 1, right);
            else {
                if (selector == 1)
                    bubbleSort(info, j+1, right);
                if (selector == 2)
                    insertionSort(info,j+1,right);
            }
        }
    }
}