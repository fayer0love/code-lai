class KSmallest {
  
    public int[] kSmallest(int[] array, int k) {
    // Write your solution here
    /*
      1. MIN HEAP

      2. MAX HEAP

      3. Quick Select
    */

    return maxHeap(array, k);
  }

  public int[] minHeap(int[] array, int k) {
    // 1. MIN HEAP.
    int[] result = new int[k];
    if (array == null || array.length == 0) return result;

    Comparator<Integer> comparator = new MinHeapComparator();
    // Comparator<Integer> comparatorLambda = (Integer x, Integer y) -> Integer.compare(x, y);
    PriorityQueue<Integer> pq = new PriorityQueue<>(array.length, comparator);
    // PriorityQueue<Integer> pq = new PriorityQueue<>(array.length, Comparator.comparingInt(x -> x));

    for (int i : array) {
      pq.add(i);
    }
    for (int i = 0; i < k; i++) {
      result[i] = pq.remove();
    }
    return result;
  }

  public int[] maxHeap(int[] array, int k) {
    // 2. MAX HEAP
    int[] result = new int[k];
    if (array == null || array.length == 0 || k == 0) return result;
    PriorityQueue<Integer> pq = new PriorityQueue<>(k, new Comparator<Integer>(){
      @Override
      public int compare(Integer x, Integer y) {
        return Integer.compare(y, x);
      }
    });
    for (int i : array) {
      if (pq.size() < k) {
        pq.add(i);
      } else if (i < pq.peek()) {
        // pq.size == k
        pq.remove();
        pq.add(i);
      }
    }
    for (int i = k-1; i >= 0; i--) {
      result[i] = pq.remove();
    }
    return result;
  }

  public class MinHeapComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer x, Integer y) {
      return Integer.compare(x, y);
    }
  }

  /*
   * 3 **quick select**
   *
   * select the most right element as pivot
   * the array size is array.length
   * 2 pointers, i and j; i starting from array index = 0
   * j from array index = array.length - 2; as index array.length - 1
   * is the pivot
   * i: 0 - i (including 0 but not including i) represents the number >=pivot
   * j: j - (size-2), (not including j) represents the number < pivot
   */
  public int[] findKSmall(int[] array, k) {
    if (array == null) return array;  
    if (array.length == 0) return new int[k];
    return quickSelect(array, 0, array.length, k);
  }

  public void quickSelect(int[] array, int i, int j, int k) {
    int wall = partition(array, i, j);
    if (wall == k) return;
    else if (wall < k) quickSelect(array, i, wall - 1, k);
    else quickSelect(array, wall + 1, j, k);
  }

  public int partition(int [] array, int i, int j) {
    int pivot = array[j];
    int start = i;
    int end = j - 1;
    while (start <= end) {
      if (array[start] <= pivot) start++;
      else if (array[end] > pivot) end--;
      else swap(array, start++, end--);
    }
    swap(array, start, j);
    return start;
  } 

  public void swap(int[] array, int i, int j) {
    int tmp = array[i];
    array[i] = array[j];
    array[j] = tmp;
  }
}
