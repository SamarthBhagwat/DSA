// import static org.junit.jupiter.api.Assertions.assertEquals;

// import org.junit.jupiter.api.Test;
import java.util.*;
// import java.util.Arrays;
class Main {
  public static void main(String[] args) {

    int arr1[] = createArray();
    // int arr2[] = createArray();
    // int ans = findUniqueElement(arr);
    // List<Integer> ans = findUnion(arr1, arr2);
    // List<Integer> ans = findIntersection(arr1, arr2);
    // Scanner sc = new Scanner(System.in);
    // int targetSum = sc.nextInt();
    // int ans[] = findPairSum(arr1, targetSum);
    // List<List<Integer>> ans = tripletSum(arr1, targetSum);
    int ans[] = sort01(arr1);
    printArray(ans);
    // System.out.println(ans);
  }

  public static void printArray(int arr[]){
    for(int i = 0 ; i< arr.length ; i++){
      System.out.print(arr[i] + " ");
    }
    System.out.println();
  }

  public static int[] createArray(){
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int arr[] = new int[n];
    for(int i=0;i<n;i++){
      arr[i] = sc.nextInt();
    }
    return arr;
  }

  public static int findUniqueElement(int arr[]){
    int uniqueElement = 0;
    for(int i = 0 ; i < arr.length ; i++){
      uniqueElement = uniqueElement ^ arr[i];
    }

    return uniqueElement;
  }

  public static List<Integer> findUnion(int arr1[], int arr2[]){
    List<Integer> ans = new ArrayList<>();
    for(int i = 0 ; i < arr1.length ; i++){
      if(!ans.contains(arr1[i])){
        ans.add(arr1[i]);
      }
    }

    for(int i = 0; i < arr2.length ; i++){
      if(!ans.contains(arr2[i])){
        ans.add(arr2[i]);
      }
    }

    return ans;
  }

  public static List<Integer> findIntersection(int[] arr1, int[] arr2){
    List<Integer> ans = new ArrayList<>();
    for(int i = 0 ; i< arr1.length ; i++){
      for(int j = 0 ; j < arr2.length; j++){
        if(arr1[i] == arr2[j]){
          ans.add(arr1[i]);
          break;
        }
      }
    }
    return ans;
  }

  public static int[] findPairSum(int arr[], int targetSum){
    // int ans[] = new int[2];
    // for(int i = 0 ; i < arr.length ; i++){
    //   int element = arr[i];
    //   for(int j = i+1; j<arr.length; j++){
    //     if(element + arr[j] == targetSum){
    //       ans[0] = element;
    //       ans[1] = arr[j];
    //       return ans;
    //     }
    //   }
    // }
    // return ans;
    int ans[] = new int[2];
    Set<Integer> set = new HashSet<>();
    for(int i = 0 ; i< arr.length ; i++){
      if(set.contains(targetSum - arr[i])){
        ans[0] = arr[i];
        ans[1] = targetSum - arr[i];
        return ans;
      }
      else{
        set.add(arr[i]);
      }
    }
    return ans;
  }

  public static List<List<Integer>> tripletSum(int arr[], int targetSum){
    List<List<Integer>> finalAns = new ArrayList<>();
    for(int i = 0 ; i < arr.length ; i++){
      List<List<Integer>> ans = pairSum(arr, i+1, targetSum - arr[i]);
      for(List<Integer> list: ans){
        list.add(arr[i]);
        finalAns.add(list);
      }
    }
    return finalAns;
  }

  public static List<List<Integer>> pairSum(int arr[], int startIndex, int targetSum){
      List<List<Integer>> ans = new ArrayList<>();
      Set<Integer> set = new HashSet<>();
      for(int i = startIndex; i < arr.length ; i++){
        if(set.contains(targetSum - arr[i])){
          List<Integer> subAns = new ArrayList<>();
          subAns.add(arr[i]);
          subAns.add(targetSum - arr[i]);
          set.remove(targetSum - arr[i]);
          ans.add(subAns);
        }
        else{
          set.add(arr[i]);
        }
      }
      return ans;
  }

  public static int[] sort01(int[] arr){
    int i = 0 ;
    int j = arr.length - 1;

    while(i <= j){
      if(arr[i] == 0){
        i++;
      }
      else{
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        j--;
      }
    }
    return arr;
  }
  
  // @Test
  // void addition() {
  //     assertEquals(2, 1 + 1);
  // }
}
