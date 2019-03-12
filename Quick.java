import java.util.Arrays;

public class Quick{

  public static int partition(int[] data, int start, int end){
    int i = start;
    int j = end;
    int random = (int)(Math.random() * (j-i));
    //System.out.println("random : "+random);
    int temp = data[random + i];
    //System.out.println("temp: " + temp);
    if (data.length <= 1){
      return start;
    }
    data[random + i] = data[start];
    //System.out.println(Arrays.toString(data));
    data[start] = temp;
    i++;
    while (i != j){
      //System.out.println(Arrays.toString(data));
      if (data[i] > data[start]){
        temp = data[i];
        data[i] = data[j];
        data[j] = temp;
        j--;
      } else if (data[i] == data[start]){
        if ((int)(Math.random() + .5) == 0){
          temp = data[i];
          data[i] = data[j];
          data[j] = temp;
          j--;
        } else {
          i++;
        }
      } else {
        i++;
      }
    }
    //System.out.println("start:"+start);
    if (data[start] >= data[i]){
      temp = data[start];
      data[start] = data[i];
      data[i] = temp;
      return i;
    } else {
      temp = data[start];
      data[start] = data[i-1];
      data[i-1] = temp;
      return i - 1;
    }
  }

  /*return the value that is the kth smallest value of the array.
 */
 public static int quickselect(int[]data, int k){
   int s = 0;
   int e = data.length - 1;
   int i = partition(data, s, e);
   //System.out.println("i: "+i);
   while(i != k && s != e){
     //System.out.println("loop start: " +Arrays.toString(data) + " i: "+i);
     if (i < k){
       //System.out.println("i<k, s: " + s + ", e: "+e);
       s = i+1;
       i = partition(data,s,e);
     } else {
       //System.out.println("i>=k, s: " + s + ", e: "+e);
       e = i-1;
       i = partition(data,s,e);
     }
   }
   //System.out.println("loop end: " +Arrays.toString(data));
   return data[k];
 }

 public static void main(String[] args){
   int[]ary = {2, 10, 15, 23, 0, 5};  //sorted :  {0,2,5,10,15,23}
   //for (int i = 0; i < 10; i++ ){System.out.println((int)(Math.random() + .5));}
   //System.out.println(quickselect( ary , 0 ));// would return 0
   //System.out.println(quickselect( ary , 1 ));//  would return 2
   //System.out.println(quickselect( ary , 2 ));//  would return 5
   //System.out.println(quickselect( ary , 3 ));//   would return 10
   //System.out.println(quickselect( ary , 4 ));//  would return 15
   //System.out.println(quickselect( ary , 5 ));//  would return 23
   //for (int i = 1; i < 6; i++){
     System.out.println(partition(ary,0,ary.length-1));
     System.out.println(Arrays.toString(ary));
   //}
 }


}
