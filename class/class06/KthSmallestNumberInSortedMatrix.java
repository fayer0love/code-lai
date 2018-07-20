/*
 *Kth Smallest Number In Sorted Matrix
 Description
 Given a matrix of size N x M. For each row the elements are sorted in ascending order, and for each column the elements are also sorted in ascending order. Find the Kth smallest number in it.

 Assumptions

 the matrix is not null, N > 0 and M > 0
 K > 0 and K <= N * M
 Examples

 { {1,  3,   5,  7},

 {2,  4,   8,   9},

 {3,  5, 11, 15},

 {6,  8, 13, 18} }

 the 5th smallest number is 4
 the 8th smallest number is 6
 * */
public class Solution {

  public int kthSmallest(int[][] matrix, int k) {
    // Write your solution here
    int rows = matrix.length;
    int columns = matrix[0].length;
    PriorityQueue<Cell> minHeap = new PriorityQueue<>(k);
    //, new Comparator<Cell>() {
    //  @Override
    //  public int compare(Cell c1, Cell c2) {
    //   return Integer.compare(c1.value, c2.value);
    //  }
    //});
    boolean isVisited[][] = new boolean[rows][columns];
    minHeap.add(new Cell(0, 0, matrix[0][0]));
    isVisited[0][0] = true;
    for (int i = 0; i < k - 1; i++) {
      Cell cur = minHeap.remove();
      if (cur.row + 1 < rows && !isVisited[cur.row + 1][cur.column]) {
        minHeap.add(new Cell(cur.row + 1, cur.column, matrix[cur.row + 1][cur.column]));
        isVisited[cur.row + 1][cur.column] = true;
      }
      if (cur.column + 1 < columns && !isVisited[cur.row][cur.column + 1]) {
        minHeap.add(new Cell(cur.row, cur.column + 1, matrix[cur.row][cur.column + 1]));
        isVisited[cur.row][cur.column + 1] = true;
      }
    }
    return minHeap.peek().value;
  }

}
