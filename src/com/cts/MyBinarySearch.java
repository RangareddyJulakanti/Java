package com.cts;

public class MyBinarySearch {

	public static void main(String[] args) {
		int arr[]={11,12,23,34,45,66,77,88,99};
		int r=99;
		
		int e=arr.length-1;
		int s=0;
		int index=binarySearch(arr, s, e, r);
		System.out.println(index+" is the index of "+r);
	}
static int	binarySearch(int[] arr,int s,int e,int r)
{
     int mid=(s+e)/2;
     if(s<=e){
    	 if(arr[mid]<r){
        	 s=mid+1;
        return	 binarySearch(arr, s, e, r);
         }else if(arr[mid]>r){
        	 e=mid-1;
        return	 binarySearch(arr, s, e, r);
         }else {
        	 return mid;
         }
     }else{
    	 return -1;
     }
     
	
	
}

}
