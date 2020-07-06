import java.util.Arrays;
import java.util.List;

public class HeapSort<T extends Comparable<T>> {
    public static void main(String[] args)
    { }

    public void heapSort(List<T> list)
    {
        createHeap(list);
        for (int i = list.size()-1; i > 0; i--)
        {
            swapAtIndex(list,0,i);
            sink(list,0,i-1);
        }
    }

    private void createHeap(List<T> list)
    {
        for (int i = list.size()/2; i >= 0; i--)
        {
            sink(list,i,list.size()-1);
        }
    }

    private void sink(List<T> list, int nodeId, int lastId)
    {

        while (leftChildOf(nodeId) <= lastId || rightChildOf(nodeId) <= lastId)
        {
            int maxId = leftChildOf(nodeId);
            if (rightChildOf(nodeId) <= lastId && list.get(leftChildOf(nodeId)).compareTo(list.get(rightChildOf(nodeId))) < 0)
            {
                maxId = rightChildOf(nodeId);
            }
            if (list.get(nodeId).compareTo(list.get(maxId)) < 0)
            {
                swapAtIndex(list,maxId,nodeId);
                nodeId = maxId;
            }
            else return;
        }
    }
    public int rightChildOf(int nodeId)
    {
        return 2 * nodeId+2;
    }
    public int leftChildOf(int nodeId)
    {
        return 2 * nodeId+1;
    }
    public void swapAtIndex(List<T> list, int one, int two)
    {
        T temp = list.get(one);
        list.set(one, list.get(two));
        list.set(two, temp);
    }
}
