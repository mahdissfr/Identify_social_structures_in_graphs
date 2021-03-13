package aut.ir;

import java.util.ArrayList;

/**
 * Created by mahdis on 1/18/2018.
 */
public class EdgeInfoArr {
    ArrayList<NodeInfo> nodeInfos;

    public EdgeInfoArr() {
        nodeInfos = new ArrayList<>();
        addToArray(-1, -1, -1);
    }

    public void addToArray(double c, int i, int j) {
        nodeInfos.add(new NodeInfo(c, i, j));
    }

    public double computeC(int degreei, int degreeJ, int cycleL3) {
        if (degreei == 1 || degreeJ == 1)
            return 1000000000;
        return (double) (cycleL3 + 1) / (double) Math.min(degreei - 1, degreeJ - 1);
    }

    public void initializeLL(Graph graphLL) {
        for (int i = 1; i < graphLL.verticsInfo.list.size(); i++) {
            Node w = graphLL.verticsInfo.list.get(i).first;
            while (w != null) {
                if (w.data > i) {
                    addToArray(computeC(graphLL.degreeLL(i), graphLL.degreeLL(w.data), graphLL.nCycleOfL3LL(i, w.data)), i, w.data);
                }
                w = w.link;

            }
        }
    }

    public void initializeM(Graph graphM) {
        Element w;
        for (int i = 0; i < graphM.matrix.matrixArr.size(); i++) {
            w = graphM.matrix.matrixArr.get(i);
            if (w.vr > w.vl) {
                addToArray(computeC(graphM.degreeMatrix(w.vl), graphM.degreeMatrix(w.vr), graphM.nCycleOfL3M(w.vl, w.vr)), w.vl, w.vr);
            }
        }
    }
}


class NodeInfo {
    double c;
    int verticeI, verticeJ;

    public NodeInfo(double c, int verticeI, int verticeJ) {
        this.c = c;
        this.verticeI = verticeI;
        this.verticeJ = verticeJ;
    }
}
