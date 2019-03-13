import java.util.Arrays;

public class Quick{

  public static int partition(int[] data, int start, int end){
    if (end-start < 1){
      return start;
    }
    int i = start;
    int j = end;
    int middle = (int)(Math.random() * (j-i));
    //System.out.println("random : "+random);
    int pivot = middle;
    if (data[i] >= data[j] && data[j] >= data[middle]){
      pivot = j;
    } else if (data[i] <= data[j] && data[j] <= data[middle]){
      pivot = j;
    } else if (data[j] >= data[i] && data[i] >= data[middle]){
      pivot = i;
    } else if (data[j] <= data[i] && data[i] <= data[middle]){
      pivot = i;
    }
    int temp = data[pivot];
    //System.out.println("temp: " + temp);
    data[pivot] = data[start];
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
    //System.out.println("i:"+i);
    if (data[start] > data[i]){
      temp = data[start];
      data[start] = data[i];
      data[i] = temp;
      //System.out.println("iia:"+i);
      return i;
    } else {
      temp = data[start];
      data[start] = data[i-1];
      data[i-1] = temp;
      //System.out.println("iib:"+i);
      return i - 1;
    }
  }

  /*return the value that is the kth smallest value of the array.
 */
 public static int quickselect(int[]data, int k){
   int s = 0;
   int e = data.length - 1;
   int i = partition(data, s, e);
   //System.out.println("iii: "+i);
   while(i != k && s != e){
     //System.out.println("loop start: " +Arrays.toString(data) + " i: "+i);
     if (i < k){
       //System.out.println("1.i<k, s: " + s + ", e: "+e+", k: "+k+", i: "+i);
       s = i+1;
       i = partition(data,s,e);
       //System.out.println("2.i<k, s: " + s + ", e: "+e+", k: "+k+", i: "+i);
     } else {
       //System.out.println("i>=k, s: " + s + ", e: "+e+", k: "+k+", i: "+i);
       e = i-1;
       i = partition(data,s,e);
       //System.out.println("i>=k, s: " + s + ", e: "+e+", k: "+k+", i: "+i);
     }
   }
   //System.out.println("loop end: " +Arrays.toString(data));
   return data[k];
 }

 /*Modify the array to be in increasing order.
 */
 public static void quicksort(int[] data){
   sortH(data,0,data.length-1);
 }

 public static void sortH(int[] data, int lo, int hi){
   if (lo >= hi){
     return;
   }
   int pivot = partition(data,lo,hi);
   sortH(data,pivot+1,hi);
   sortH(data,lo,pivot-1);
 }

 public static void sortH2(int[] data, int lo, int hi){
   if (lo >= hi){
     return;
   }
   int[] center = partitionDutch(data,lo,hi);
   sortH2(data,center[0]+1,hi);
   sortH2(data,lo,center[1]-1);
 }

 private static int[] partitionDutch(int[] data, int lo, int hi){
    int lt = lo;
    int gt = hi;
    int i = lo;
    int pivot = (int)(Math.random() * (hi-lo));
    int temp = data[pivot];
    data[pivot] = data[lo];
    //System.out.println(Arrays.toString(data));
    data[lo] = temp;
    i++;
    lt++;
    while (i != gt){
      if (data[i] > data[gt]){
        temp = data[gt];
        data[gt] = data[i];
        data[i] = temp;
        gt--;
      } else if (data[i] == data[gt]){
        temp = data[i];
        data[i] = data[lt];
        data[lt] = temp;
        i++;
      } else {
        lt++;
        i++;
      }
    }
    if (data[lo] > data[lt]){
      temp = data[lo];
      data[lo] = data[lt];
      data[lt] = temp;
      int[] output = {lt,gt};
      //System.out.println("iia:"+i);
      return output;
    } else {
      temp = data[lo];
      data[lo] = data[lt-1];
      data[lt-1] = temp;
      int[] output = {lt,gt};
      //System.out.println("iib:"+i);
      return output;
    }
    //return an array [lt,gt]
}

 public static void main(String[] args){
   int[]ary = {2, 10, 15, 23, 0, 5};  //sorted :  {0,2,5,10,15,23}
   //for (int i = 0; i < 10; i++ ){System.out.println((int)(Math.random() + .5));}
   //System.out.println(quickselect( ary , 0 ));// would return 0
   //System.out.println(quickselect( ary , 1 ));//  would return 2
   //System.out.println(quickselect( ary , 2 ));//  would return 5
   //System.out.println(quickselect( ary , 3 ));//   would return 10
   //System.out.println(Quick.quickselect( ary , 4 ));//  would return 15
   //System.out.println(quickselect( ary , 5 ));//  would return 23
   //for (int i = 1; i < 6; i++){
     //System.out.println(partition(ary,0,ary.length-1));
     //System.out.println(Arrays.toString(ary));
   //}
 }


}
