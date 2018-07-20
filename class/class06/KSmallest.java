class KSmallest {

  /** 
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

  public int[] quickSelect(int[] array, int i, int j, int k) {
    int wall = partition(array, i, j);
    if (wall == k) return Arrays.copyOf(array, k);
    else if (wall < k) return quickSelect(array, i, wall - 1, k);
    else return quickSelect(array, wall + 1, j, k);
  }

  public int partition(int [] array, int i, int j) {
    int pivot = array[k-1];
    while (i < j) {
      while(i < j && array[i] <= pivot) i++;
      while(i < j && array[j] > pivot) j--;
      if (i < j) swap(i, j);
    } 
    return i;
  } 

  public void swap(int[] array, int i, int j) {
    int tmp = array[i];
    array[i] = array[j];
    array[j] = tmp;
  }
}
