public class MinHeap<T extends Comparable> extends Heap<T> {

    public MinHeap(Class<T> clazz) {
        super(clazz);
    }

    public static void main(String[] args) throws HeapFullException, HeapEmptyException {

        MinHeap<Integer> minHeap = new MinHeap<>(Integer.class);
        minHeap.insert(9);
        minHeap.insert(4);
        minHeap.insert(17);
        minHeap.printHeapArray();
        minHeap.insert(6);
        minHeap.printHeapArray();
        minHeap.insert(100);
        minHeap.insert(20);
        minHeap.printHeapArray();
        minHeap.insert(2);
        minHeap.insert(1);
        minHeap.insert(5);
        minHeap.insert(3);
        minHeap.printHeapArray();
        //        System.out.println(minHeap.removeHighestPriority());
        //        minHeap.printHeapArray();
        //        System.out.println(minHeap.removeHighestPriority());
        //        minHeap.printHeapArray();
        //        System.out.println(minHeap.removeHighestPriority());
        //        minHeap.printHeapArray();

        minHeap.findMax(minHeap);
    }

    private void findMax(MinHeap<Integer> minHeap) {
        int lastIndex = minHeap.getCount() - 1;
        int parentIndex = minHeap.getParentIndex(lastIndex);
        int firstLeafIndex = parentIndex + 1;
        T max = getElementAtIndex(firstLeafIndex);
        for (int i = firstLeafIndex; i <= lastIndex; i++) {
//            if(max.compareTo(getElementAtIndex(firstLeafIndex)>0)){
//
//            }
        }
    }
}
