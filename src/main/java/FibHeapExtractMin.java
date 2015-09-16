import java.util.HashMap;
import java.util.Map;


/**
 * public class FibonacciHeap {
    public FibNode minNode;
    int size;

    public FibonacciHeap() {
	minNode = null;
	size = 0;
    }
    public boolean isEmpty() {
	return minNode == null;
    }
    public int minKey() {
	if (isEmpty()) {
	    return -1;
	}
	return minNode.key;
    }
    public int minRank() {
	if (isEmpty()) {
	    return -1;
	}
	return minNode.rank;
    }
 */
/**
 * public class FibNode {
    int key, rank;
    FibNode prev, next, parent, child;
    boolean isMarked, isMinimum;

    public FibNode() {
	this.key = 0;
    }
    public FibNode(int key) {
	this.key = key;
	this.next = this;
	this.prev = this;
	rank = 0;
    }

Problem:
 Implement methods for Fibonacci Heap data structure:
 FibNode extractMin(FibonacciHeap heap) and 
 void consolidate(FibNode minNode, FibonacciHeap heap)
 Helper: for simplification you can use these methods(see below): void removeNode(FibNode node), 
 FibNode linkHeaps(FibNode min, FibNode max) and class NodeIterator() to iterate throw the roots' or children's Linked List 
 */
public class FibHeapExtractMin {

    public static FibNode extractMin(FibonacciHeap heap) {
      return null;
    }

    public static void consolidate(FibNode minNode, FibonacciHeap heap) {

    }
}
