public class Arrays{
    //print all elements of the array
    //Find the sum of elements
    public static boolean isPalindrome(int[] arr){
        int left = 0;
        int right = arr.length - 1;
        while(left < right){
            if(arr[left] != arr[right])
                return false;
            left++;
            right--;
        }
        return true;
    }
    
}