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

  /*return the value that is the kth smallest value of the array.
 */
 public static int quickselect(int[]data, int k){
   int s = 0;
   int e = data.length - 1;
   int i = partition(data, s, e);
   while(i != k){
     if (i < k){
       s = i+1;
       i = partition(data,s,e);
     } else {
       e = i-1;
       i = partition(data,s,e);
     }
   }
   return data[k];
 }

}
