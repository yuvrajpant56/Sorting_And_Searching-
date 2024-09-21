import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

class Sorting{
  public ArrayList<Integer> Insert_arr;
  public ArrayList<Integer> Bubble_arr;
  public ArrayList<Integer> Merged_arr;
  public int temp;

  public Sorting(ArrayList<Integer> array1, ArrayList<Integer> array2){
    this.Insert_arr=array1;
    this.Bubble_arr=array2;
    this.Merged_arr=new ArrayList<Integer>();
  }
  

  public ArrayList<Integer> insertion_sort(){
      for (int i=1;i<Insert_arr.size();i++){
        int key=Insert_arr.get(i);
        int j=i-1;
        while (j>=0 && Insert_arr.get(j)>key){
          Insert_arr.set(j+1,Insert_arr.get(j));
          j--;
        }
        Insert_arr.set(j+1,key);
      }
    return Insert_arr;
  }

  public ArrayList<Integer> efficient_bubble_sort(){
    boolean no_more_swaps=false;
    while (!no_more_swaps){
      no_more_swaps=true;
      for (int i=0;i<Bubble_arr.size()-1;i++){
        if (Bubble_arr.get(i)>Bubble_arr.get(i+1)){
          // swap elements
          temp=Bubble_arr.get(i+1);
          Bubble_arr.set(i+1,Bubble_arr.get(i));
          Bubble_arr.set(i,temp);
          no_more_swaps=false;
        }
      }

    }
    return Bubble_arr;
  }
  


  public ArrayList<Integer> merge_two_sorted_array(){
    int i=0,j=0;
    Merged_arr.clear(); //clear the merged array
    while (i<Insert_arr.size()&& j<Bubble_arr.size()){
      if(Insert_arr.get(i)<=Bubble_arr.get(j)){
        if(Merged_arr.size()==0 || Insert_arr.get(i)!=Merged_arr.get(Merged_arr.size()-1)) {
          Merged_arr.add(Insert_arr.get(i));
        }
        i++;
      } else{
        if(Merged_arr.size()==0|| Bubble_arr.get(j)!=Merged_arr.get(Merged_arr.size()-1)){
          Merged_arr.add(Bubble_arr.get(j));
        }
        
        j++;
      }
    }
    while (i<Insert_arr.size()){
       if(Merged_arr.size()==0 || Insert_arr.get(i)!= Merged_arr.get(Merged_arr.size()-1)){
        Merged_arr.add(Insert_arr.get(i));
       }
     
      i++;
    }
    while(j<Bubble_arr.size()){

        if(Merged_arr.size()==0|| Bubble_arr.get(j)!=Merged_arr.get(Merged_arr.size()-1)){
          Merged_arr.add(Bubble_arr.get(j));
        }
      j++;
    }
    return Merged_arr;

  } 

  //Binary search method 
  public int Binary_Search(int target){
    int left=0;
    int right=Merged_arr.size()-1;
    while (left <= right){
      int mid =(left+right)/2;
      if (Merged_arr.get(mid)==target){
        return mid;
      }
      if (target> Merged_arr.get(mid)){
        left=mid+1;
      }else {
        right=mid-1; 
      }
    }
    return -1; // Target not found
  }

  //method to display the array as a strings
  public String display(ArrayList<Integer> arr){
    StringBuilder result =new StringBuilder();
    for (int i=0; i<arr.size();i++){
      result.append(arr.get(i));
      if (i!=arr.size()-1){
        result.append(" ");
      }
    }
    return result.toString();
  }

}





public class Programm_JAVA{

  public static ArrayList<Integer> generate_random_array(int max_size, int range_min, int range_max){
    ArrayList<Integer> array=new ArrayList<>();
    Random rand=new Random();
    int size=rand.nextInt(max_size)+1;

    for (int i=0;i<size;i++){
      int random_value=rand.nextInt(range_max)+range_min;
      array.add(random_value);
    }
    return array;
  }
  public static void main(String[] args){
        Scanner scanner =new Scanner(System.in);
        // Random rand =new Random();
        ArrayList<Integer> array1=generate_random_array(30,1,100);
        ArrayList<Integer> array2=generate_random_array(30,1,100);
        

        System.out.println("Enter a target value to do binary search: ");

        int target= scanner.nextInt();
        
        Sorting sort_obj =new Sorting(array1, array2);
        //Display initial arrays
        System.out.println("Array 1: "+sort_obj.display(sort_obj.Insert_arr)+"\n");

        System.out.println("Array 2:" + sort_obj.display(sort_obj.Bubble_arr)+"\n");

        // Peform insertion sort
        ArrayList<Integer> Result_Insertion_sort = sort_obj.insertion_sort();
        System.out.println("The Insertion sort result is: "+ sort_obj.display(Result_Insertion_sort)+"\n");

        // Perform bubble sort 
        ArrayList<Integer> Result_Bubble_Sort=sort_obj.efficient_bubble_sort();
        System.out.println("The Bubble sort result is: " + sort_obj.display(Result_Bubble_Sort)+"\n");

        ArrayList<Integer> Result_Merged_Sort=sort_obj.merge_two_sorted_array();
        System.out.println("The Merged sort result is: "+ sort_obj.display(Result_Merged_Sort)+"\n");

        int Result_Binary_Search_index=sort_obj.Binary_Search(target);
        if (Result_Binary_Search_index !=-1){
          System.out.println("Binary_Search_Result: "+"The target "+target+" was found at index "+ Result_Binary_Search_index+"."+ "\n");
        } else {
          System.out.println("Binary_Search_Result: "+"The target "+target+" was not found in the array.\n");
        }
    scanner.close();
  }

}