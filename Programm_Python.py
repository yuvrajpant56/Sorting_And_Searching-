import random
Max_size=30
class Sorting:
  # Instance Attribute
  def __init__(self,array1,array2):
    self.Insert_arr=array1
    self.Bubble_arr=array2
    self.merged_arr=[]
  
  def insertion_sort(self):
    for i in range(1,len(self.Insert_arr)):
      key=self.Insert_arr[i]
      j=i-1
      while j>=0 and self.Insert_arr[j]>key:
        self.Insert_arr[j+1]=self.Insert_arr[j]
        j-=1
      self.Insert_arr[j+1]=key
    return self.Insert_arr
  
  def efficient_bubble_sort(self):
    no_more_swaps=False
    while no_more_swaps==False:
      no_more_swaps=True
      for i in range(len(self.Bubble_arr)-1):
        if self.Bubble_arr[i]>self.Bubble_arr[i+1]:
          temp=self.Bubble_arr[i]
          self.Bubble_arr[i]=self.Bubble_arr[i+1]
          self.Bubble_arr[i+1]=temp
          no_more_swaps=False

    return self.Bubble_arr
  
  def merge_two_sorted_array(self):
    
    i,j=0,0

    while i<len(self.Insert_arr) and j<len(self.Bubble_arr):
      if self.Insert_arr[i]<=self.Bubble_arr[j]:
        if len(self.merged_arr)==0 or self.Insert_arr[i] != self.merged_arr[-1]:

          self.merged_arr.append(self.Insert_arr[i])
        i+=1
      else:
        if len(self.merged_arr)==0 or self.Bubble_arr[j]!=self.merged_arr[-1]:
         self.merged_arr.append(self.Bubble_arr[j])
        j+=1

    while i<len(self.Insert_arr):
      if len(self.merged_arr)==0 or self.Insert_arr[i] != self.merged_arr[-1]:
       self.merged_arr.append(self.Insert_arr[i])
      i+=1

    while j<len(self.Bubble_arr):
      if len(self.merged_arr)==0 or self.Bubble_arr[j]!=self.merged_arr[-1]:
       self.merged_arr.append(self.Bubble_arr[j])
      
      j+=1
      
    return self.merged_arr # return the merged and sorted array
  

  def Binary_Search(self,target):
    left=0
    right=len(self.merged_arr)-1

    while (left<=right):
      mid=right+left//2

      if (self.merged_arr[mid]==target):
        return mid
      
      if (self.merged_arr[mid]<target):
        left=mid+1
      else:
        right=mid-1

    return -1
  

  # method to display an array
  def display(self,arr):
    return " ".join(map(str,arr))

  
# main program
def main():
  array1_size=random.randint(1,Max_size)
  array2_size=random.randint(1,Max_size)
  array1=random.sample(range(1,100),array1_size)
  array2=random.sample(range(1,100),array2_size)

  print(f"Please enter a target value to do binary search:\n")
  target=int(input())

  # creating an object of the class sorting 
  sort_obj=Sorting(array1,array2)
  
  # Display initial arrays
  print("Array 1:", sort_obj.display(sort_obj.Insert_arr))
  print(sort_obj.Insert_arr[2])
  print("Array 2:", sort_obj.display(sort_obj.Bubble_arr))
  print(sort_obj.Bubble_arr[1])

  #Perform Insertion sort
  Result_Insertion_sort=sort_obj.insertion_sort()
  print(f"The insertion sort result is {Result_Insertion_sort}\n")


  #perform Bubble sort
  Result_Bubble_Sort=sort_obj.efficient_bubble_sort()
  print(f"The Bubble sort result is {Result_Bubble_Sort}\n")

  # Perform Merge Sort
  Result_merge_sort=sort_obj.merge_two_sorted_array()
  print(f"The Merge sort result is {Result_merge_sort}\n")


  #Peform Binary Search 
  Result_Binary_Search_index=sort_obj.Binary_Search(target)
  if Result_Binary_Search_index!=-1:
    print(f"The target {target} was found at index {Result_Binary_Search_index}.\n")
  else:
    print(f"The target {target} was not found in the array.\n")

# run the main programm
if __name__=="__main__":
  main()
