public class GenericSort {

    void merge(int arr[], int left, int middle, int right)
    {
        int low = middle - left + 1;                    //size of the left subarray
        int high = right - middle;                      //size of the right subarray
 
        int L[] = new int[low];                             //create the left and right subarray
        int R[] = new int[high];

        int i = 0, j = 0;
 
        for (i = 0; i < low; i++)                               //copy elements into left subarray
        {
            L[i] = arr[left + i];
        }
        for (j = 0; j < high; j++)                              //copy elements into right subarray
        {
            R[j] = arr[middle + 1 + j];
        }
        
 
        int k = left;                                           //get starting index for sort
        i = 0;                                             //reset loop variables before performing merge
        j = 0;

        while (i < low && j < high)                     //merge the left and right subarrays
        {
            if (L[i] <= R[j]) 
            {
                arr[k] = L[i];
                i++;
            }
            else 
            {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
 
        while (i < low)                             //merge the remaining elements from the left subarray
        {
            arr[k] = L[i];
            i++;
            k++;
        }
 
        while (j < high)                           //merge the remaining elements from right subarray
        {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
 

    void mergeSort(int arr[], int left, int right)       //helper function that creates the sub cases for sorting
    {
        int middle;
        if (left < right) {                             //sort only if the left index is lesser than the right index (meaning that sorting is done)
            middle = (left + right) / 2;
 
            mergeSort(arr, left, middle);                    //left subarray
            mergeSort(arr, middle + 1, right);               //right subarray
 
            merge(arr, left, middle, right);                //merge the two subarrays
        }
    }
 
    void display(int arr[])                 //display the array
    {  
        for (int i=0; i<arr.length; ++i) 
        {
            System.out.print(arr[i]+" ");
        } 
    } 
    
    void reverse(int[] array)
    {
  
        // Length of the array
        int n = array.length;
  
        // Swaping the first half elements with last half
        // elements
        for (int i = 0; i < n / 2; i++) {
  
            // Storing the first half elements temporarily
            int temp = array[i];
  
            // Assigning the first half to the last half
            array[i] = array[n - i - 1];
  
            // Assigning the last half to the first half
            array[n - i - 1] = temp;
        }
    }
}

