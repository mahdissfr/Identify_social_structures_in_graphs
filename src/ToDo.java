package aut.ir;

import java.io.IOException;
import java.time.Duration;
import java.time.Instant;

/**
 * Created by mahdis on 1/19/2018.
 */
public class ToDo {
    Matrix matrix;
    LinkedList linkedList;
    int selector;
    Graph graph;
    String fiveStepsTime;

    private boolean isConnected() {
        if (selector == 1) {
            graph.applyM();
        } else graph.applyLL();
        return graph.isConnected();
    }

    public ToDo(int selector, int sortTypeSelector, int N, int optSelector) {
        Instant start = Instant.now();
        Instant startFinal = Instant.now();
        ReadFile readFile = new ReadFile(selector);
        this.selector = selector;
        matrix = readFile.matrix;
        linkedList = readFile.linkedList;
        Sort sort = new Sort();
        EdgeInfoArr edgeInfoArr = new EdgeInfoArr();
        if (selector == 1) {
            graph = new Graph(matrix);
        } else graph = new Graph(linkedList);
        while (isConnected()) {
            if (selector == 1) {
                edgeInfoArr.initializeM(graph);
            } else {
                edgeInfoArr.initializeLL(graph);
            }
            switch (sortTypeSelector) {
                case 1: {
                    sort.quickSort(edgeInfoArr.nodeInfos, 0, edgeInfoArr.nodeInfos.size() - 1);
                    break;
                }
                case 2: {
                    sort.insertionSort(edgeInfoArr.nodeInfos, 0, edgeInfoArr.nodeInfos.size() - 1);
                    break;
                }
                case 3: {
                    sort.mergeSort(edgeInfoArr.nodeInfos, 0, edgeInfoArr.nodeInfos.size() - 1);
                    break;
                }
                case 4: {
                    sort.bubbleSort(edgeInfoArr.nodeInfos, 0, edgeInfoArr.nodeInfos.size() - 1);
                    break;
                }
                case 5: {
                    sort.optimumSort(edgeInfoArr.nodeInfos, 0, edgeInfoArr.nodeInfos.size() - 1, N, optSelector);
                    break;
                }
            }
            if (selector == 1) {
                graph.deleteEdgeM(edgeInfoArr.nodeInfos.get(1).verticeI, edgeInfoArr.nodeInfos.get(1).verticeJ);
            } else graph.deleteEdgeLL(edgeInfoArr.nodeInfos.get(1).verticeI, edgeInfoArr.nodeInfos.get(1).verticeJ);
            System.out.println("**");
        }
        Instant end = Instant.now();
        fiveStepsTime = Duration.between(start, end) + "";
        System.out.println("five Steps Time: "+fiveStepsTime);
        try {
            new CreateFile(graph.visited);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Instant endFinal = Instant.now();
        String totalTime = Duration.between(start, end) + "";
        System.out.println("total time: "+totalTime);
    }
}
