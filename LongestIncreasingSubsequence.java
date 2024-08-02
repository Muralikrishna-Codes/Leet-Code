import java.util.*;
class Main
{
  public static int LongestIncreasingSubsequence(int[] arr,int n){
    int l[]=new int[n];
    Arrays.fill(l,1);
    for (int i=1;i<n;i++){
     for(int j=0;j<i;j++){
       if(arr[j]<arr[i])
         l[i]=Math.max(l[j]+1,l[i]);
     }
    }
    int max=l[0];
    for(int ele:l){
      if (ele>max)
        max=ele;
    }
    return max;
  }
  public static void main(String args[])
  {
    Scanner sc=new Scanner(System.in);
    int n = sc.nextInt();
    int arr[]=new int[n];
    for (int i=0;i<n;i++){
      arr[i]=sc.nextInt();
    }
    System.out.println(LongestIncreasingSubsequence(arr,n));
  }
}
