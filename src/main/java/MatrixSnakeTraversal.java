public class MatrixSnakeTraversal {
  public int[] print(int[][] input) {
// определяем длинну 1д массива 
    int arrLength = 0;
    for (int i=0; i<input.length; i++) {
      for (int j=0; j<input[i].length; j++) {
        arrLength ++;
      }
    }
// заполняем 1д массив
    int output[] = new int[arrLength];
    int l = 0 ;
    for (int i=0; i<input.length; i++) {
      if (i % 2 == 0) {
        for (int j=0; j<input[i].length; j++) {
          output[l++] = input[j][i];
        }
      }
      else {
        for (int j=input[i].length-1; j>=0; j--) {
          output[l++] = input[j][i];
        }
      }
    }
    return output;
  }
}