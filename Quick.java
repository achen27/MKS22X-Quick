import java.util.*;

public class Quick{

  public static int partition(int[] data, int start, int end){
    Random r = new Random();
    int i = start;
    int j = end;
    int middle = r.nextInt(end-start+1)+start;
    int pivot = start; //changes pivot to median on start, end, and middle values
    if (data[i] > data[j] && data[j] >= data[middle]){
      pivot = j;
    } else if (data[i] < data[j] && data[j] <= data[middle]){
      pivot = j;
    } else if (data[j] >= data[middle] && data[middle] > data[i]){
      pivot = middle;
    } else if (data[j] < data[middle] && data[middle] <= data[i]){
      pivot = middle;
    }
    int temp = data[pivot]; //swaps pivot to beginning
    data[pivot] = data[start];
    data[start] = temp;
    i++;

    while (i <= j){ //loops through array and swaps when i is > or = to the pivot
      if (data[i] > data[start]){
        temp = data[i];
        data[i] = data[j];
        data[j] = temp;
        j--;
      } else if (data[i] == data[start]){
        if (r.nextInt(2) == 0){
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
    if (data[start] > data[i]){ //swaps pivot to where i if pivot is > the int a i
      temp = data[start];
      data[start] = data[i];
      data[i] = temp;
      return i;
    } else { //swaps pivot to the index before i
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
   int i = partition(data, s, e); //first partition to find a center
   while(i != k && s != e){ //the kth number has not been found and starting ind is != ending idx
     if (i < k){
       s = i+1;
       i = partition(data,s,e); //parition right side
     } else {
       e = i-1;
       i = partition(data,s,e); //partition left side
     }
   }
   return data[k]; //return the value
 }

 /*Modify the array to be in increasing order.
 */
 public static void quicksort(int[] data){ //wrapper
   sortH(data,0,data.length-1); //helper
 }

 public static void sortH(int[] data, int lo, int hi){
   if (hi - lo <= 70){ //threshold
     insertionsort(data,lo,hi);
  } else {
     int pivot = partition(data,lo,hi); //places one value in proper position
     sortH(data,pivot+1,hi); //sorts right side
     sortH(data,lo,pivot-1); //sorts left side
   }
 }

 public static void insertionsort(int[] data, int lo, int hi){
    for (int i = lo+1; i <= hi; i++){
      int temp = data[i];
      int j = i;
      while (j > lo && data[j-1] > temp){
        data[j] = data[j-1];
        j--;
      }
      data[j] = temp;
    }
  }

 private static void sortH2(int[] data, int lo, int hi){
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
        i++;
      }
    }
    if (data[lo] > data[lt]){
      temp = data[lo];
      data[lo] = data[lt];
      data[lt] = temp;
      int[] output = {lt,gt};
      return output;
    } else {
      temp = data[lo];
      data[lo] = data[lt-1];
      data[lt-1] = temp;
      int[] output = {lt,gt};
      return output;
    }
    //return an array [lt,gt]
}

public static void main(String[]args){
 System.out.println("Size\t\tMax Value\tquick/builtin ratio ");
 int[]MAX_LIST = {1000000000,500,10};
 for(int MAX : MAX_LIST){
   for(int size = 31250; size < 2000001; size*=2){
     long qtime=0;
     long btime=0;
     //average of 5 sorts.
     for(int trial = 0 ; trial <=5; trial++){
       int []data1 = new int[size];
       int []data2 = new int[size];
       for(int i = 0; i < data1.length; i++){
         data1[i] = (int)(Math.random()*MAX);
         data2[i] = data1[i];
       }
       long t1,t2;
       t1 = System.currentTimeMillis();
       Quick.quicksort(data2);
       t2 = System.currentTimeMillis();
       qtime += t2 - t1;
       t1 = System.currentTimeMillis();
       Arrays.sort(data1);
       t2 = System.currentTimeMillis();
       btime+= t2 - t1;
       if(!Arrays.equals(data1,data2)){
         System.out.println("FAIL TO SORT!");
         System.exit(0);
       }
     }
     System.out.println(size +"\t\t"+MAX+"\t"+1.0*qtime/btime);
   }
   System.out.println();
 }
 int[] ary = new int[100];
 for (int i = 0; i < ary.length; i++){
   ary[i] = (int)(Math.random()*10+1);
 }

 /*System.out.println(Arrays.toString(ary));
 insertionsort(ary,0, ary.length-1);
 System.out.println(Arrays.toString(ary));
 System.out.println(Arrays.toString(partitionDutch(ary,0,ary.length-1)));
 System.out.println(Arrays.toString(ary));*/
}


}
