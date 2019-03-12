import java.util.Arrays;

public class Quick{

  public static int partition(int[] data, int start, int end){
    int random = (int)(Math.random() * (end-start));
    //System.out.println("random : "+random);
    int ori = start;
    int temp = data[random + start];
    System.out.println("temp: " + temp);
    if (data.length <= 1){
      return 0;
    }
    data[random + start] = data[start];
    //System.out.println(Arrays.toString(data));
    data[start] = temp;
    while (start != end){
      //System.out.println(Arrays.toString(data));
      if (data[start] > data[ori]){
        temp = data[start];
        data[start] = data[end];
        data[end] = temp;
        end--;
      }else {
        start++;
      }
    }
    System.out.println("start:"+start);
    if (data[ori] > data[start]){
      temp = data[ori];
      data[ori] = data[start];
      data[start] = temp;
      return start;
    } else {
      if (start == 0){
        return start;
      }
      temp = data[ori];
      data[ori] = data[start-1];
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
   System.out.println("i: "+i);
   while(i != k){
     System.out.println("loop start: " +Arrays.toString(data));
     if (i < k){
       System.out.println("i<k, s: " + s + ", e: "+e);
       s = i+1;
       i = partition(data,s,e);
     } else {
       System.out.println("i>=k, s: " + s + ", e: "+e);
       e = i-1;
       i = partition(data,s,e);
     }
   }
   System.out.println("loop end: " +Arrays.toString(data));
   return data[k];
 }

 public static void main(String[] args){
   int[]ary = { 2, 10, 15, 23, 0,  5};  //sorted :  {0,2,5,10,15,23}
   System.out.println(quickselect( ary , 0 ));// would return 0
   //System.out.println(quickselect( ary , 1 ));//  would return 2
   //System.out.println(quickselect( ary , 2 ));//  would return 5
   //System.out.println(quickselect( ary , 3 ));//   would return 10
   //System.out.println(quickselect( ary , 4 ));//  would return 15
   //System.out.println(quickselect( ary , 5 ));//  would return 23
   /*for (int i = 1; i < 6; i++){
     System.out.println(partition(ary,0,i));
     System.out.println(Arrays.toString(ary));
   }*/
 }


}
