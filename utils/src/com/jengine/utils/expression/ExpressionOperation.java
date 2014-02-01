package com.jengine.utils.expression;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExpressionOperation extends ExpressionNode {
    protected List<ExpressionNode> nodes = new ArrayList<ExpressionNode>();

    public ExpressionOperation(List<ExpressionNode> nodes) {
        this.nodes = nodes;
    }

    public ExpressionOperation(ExpressionNode ... nodes) {
        this.nodes = Arrays.asList(nodes);
    }

    public List<ExpressionNode> getNodes() {
        return nodes;
    }

    public void setNodes(List<ExpressionNode> nodes) {
        this.nodes = nodes;
    }
}
