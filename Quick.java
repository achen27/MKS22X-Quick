public class Quick{

  public static int partition(int[] data, int start, int end){
    int random = (int)(Math.random() * data.length);
    int temp = data[random];
    if (data.length <= 1){
      return 0;
    }
    data[random] = data[0];
    data[0] = temp;
    while (start != end){
      if (data[start] > data[0]){
        temp = data[start];
        data[start] = data[end];
        data[end] = temp;
        end--;
      }else {
        start++;
      }
    }
    if (data[0] > data[start]){
      temp = data[0];
      data[0] = data[start];
      data[start] = temp;
      return start;
    } else {
      temp = data[0];
      data[0] = data[start-1];
      data[start-1] = temp;
      return start - 1;
    }
  }
}
