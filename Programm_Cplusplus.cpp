#include <iostream>
#include <vector> 
#include <ctime> // for time(),used in random number seeding
#include <algorithm> // for random_shuffle 
#include <string>
#include <sstream>

using namespace std;
const int Max_size = 30; 

class Sorting {
  public:
  vector<int> Insert_arr;
  vector<int> Bubble_arr;
  vector<int> Merged_arr;
  int temp;
  

  //Constructor to define the object
  Sorting(vector<int>array1,vector<int>array2){
    Insert_arr=array1;
    Bubble_arr=array2;
  }

  // Insertion sort method 
  vector<int> insertion_sort(){
    for (int i=1;i<Insert_arr.size();i++){
      int key=Insert_arr[i];
      int j=i-1;
      while (j>=0 && Insert_arr[j]>key){
        Insert_arr[j+1]=Insert_arr[j];
        j-=1;
      }
      Insert_arr[j+1]=key;
    }
    return Insert_arr;
  }
  
  // Efficient bubble sort method 
  vector<int> efficient_bubble_sort(){
    bool no_more_swaps=false;
    while (!no_more_swaps){
      no_more_swaps=true;
      for (int i=0;i<Bubble_arr.size()-1;i++){
        if (Bubble_arr[i]>Bubble_arr[i+1]){
            temp=Bubble_arr[i+1];
            Bubble_arr[i+1]=Bubble_arr[i];
            Bubble_arr[i]=temp;
            no_more_swaps=false;
          }
        }
      }
    
    return Bubble_arr;
  }

  vector<int> merge_two_sorted_array(){
    int i=0,j=0;
    Merged_arr.clear(); //reset the merged array
    while(i<Insert_arr.size() && j<Bubble_arr.size()){
      if (Insert_arr[i]<=Bubble_arr[j]){
        if (Merged_arr.size()==0 || Insert_arr[i] != Merged_arr.back()){
         Merged_arr.push_back(Insert_arr[i]);
        }
      i++;
      }
      else{
        if (Merged_arr.size()==0||Bubble_arr[j] != Merged_arr.back()){
          Merged_arr.push_back(Bubble_arr[j]);
        }
        j++;
      }

    }
  
    while(i<Insert_arr.size()){
       if (Merged_arr.size()==0 || Insert_arr[i] != Merged_arr.back()){
         Merged_arr.push_back(Insert_arr[i]);
        }
      i++;
    }
    while(j<Bubble_arr.size()){
       if (Merged_arr.size()==0||Bubble_arr[j] != Merged_arr.back()){
          Merged_arr.push_back(Bubble_arr[j]);
        }
      j++;
    }
    return Merged_arr;
  }


  int Binary_Search(int a){
  int left=0;
  int right=Merged_arr.size()-1;

  while (left<=right){
    int mid=(left+right)/2;
    if (Merged_arr[mid]== a) {
      return mid;  // Target found, return index
    }

    if (a>Merged_arr[mid]){
      left=mid+1;
    }
    else {
      right=mid-1;
    }
    
  }
  return -1;
}

  string display(const vector<int>& arr){
    string result;
    for (int i=0;i<arr.size();++i){
      result+=to_string(arr[i]); 
      if (i !=arr.size()-1){
        result+=" ";
      }

    }
    return result;
  
  }
};

//Function to generate a random array of integers
// refrence chatgpt 
vector<int> generate_random_array(int max_size, int range_min, int range_max){
  vector<int> array;
  int size =rand() % max_size+1; // random size between 1 and max_size
  for (int i=0; i<size;i++){
    int random_value=rand()%(range_max)+range_min;
    array.push_back(random_value); 
  }
  return array;
}
    
int main(){
  srand(time(0)); //seed the random number generator with the current time
  vector<int> array1= generate_random_array(Max_size,1,100);
  vector<int> array2=generate_random_array(Max_size,1,100);

  cout<<"Enter a target value to do binary search: \n"<<endl;
  int target;
  cin>>target;

  Sorting sort_obj(array1,array2);
  
  cout<<"Array 1:"<<sort_obj.display(sort_obj.Insert_arr)<<"\n"<<endl;
  cout<<"Array 2:"<<sort_obj.display(sort_obj.Bubble_arr)<<"\n"<<endl;

  vector<int> Result_Insertion_sort=sort_obj.insertion_sort();
  cout<<"The Insertion sort result is: "<< sort_obj.display(Result_Insertion_sort)<<"\n"<<endl;

  vector<int> Result_Bubble_Sort=sort_obj.efficient_bubble_sort();
  cout<<"The Bubble sort result is: "<< sort_obj.display(Result_Bubble_Sort)<<"\n"<<endl;

  vector<int> Result_merge_two_sorted_array=sort_obj.merge_two_sorted_array();
  cout<<"The Merge sort result is: "<<sort_obj.display(Result_merge_two_sorted_array)<<"\n"<<endl;
  
  // perform Binary Search
  int Result_Binary_Search_index=sort_obj.Binary_Search(target);
  if (Result_Binary_Search_index!=-1){
    cout<<"Binary_Search_Result: "<<"The target "<< target << " was found at index "<< Result_Binary_Search_index<<".\n"<<endl;
  } else{
    cout<<"Binary_Search_Result: "<<"the target "<< target<<" was not found in the array.\n"<<endl;
  }
  return 0;
}