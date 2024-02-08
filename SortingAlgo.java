
import java.util.Arrays;

public class SortingAlgo {

	static private void bubbleSort(int [] array, boolean asc) {
		int i,j;
		int n = array.length - 1;
		for(i=0;i<n;i++) {
			for(j=0;j<n-i;j++) {
				if(asc) {
					if(array[j]>array[j+1]) {
						swapNext(array, j);
					}				
				}
				else {
					if(array[j+1]>array[j]) {
						swapNext(array, j);
					}
				}
			}
		}
	}

	static private void insertionSort(int array[]) {
		for(int i=1;i<array.length;i++) {
			while(i>0 && array[i]<array[i-1]) {
				swapPrev(array, i);
				--i;
			}
		}
	}
	
	static private void selectionSort(int array[]) {
		int indexOfMin = 0, min;
		for(int i=0;i<=array.length-1;i++) {
			indexOfMin = i;
			min = array[i];
			for(int j=i+1;j<=array.length-1; j++) {
				if(array[j]<min) {
					min = array[j];
					indexOfMin = j;
				}
			} swapIndex(array, indexOfMin, i);	
		}
	}
	
	static private void swapIndex(int array[], int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	static private void swapPrev(int array[], int i) {
		int temp = array[i-1];
		array[i-1] = array[i];
		array[i] = temp;
	}
	static private void swapNext(int array[], int i) {
		int temp = array[i];
		array[i] = array[i+1];
		array[i+1] = temp;
	}
	
	public static void main(String[] args) {
		int [] array1 = {2, 8, 5, 3, 9, 4, 1};
		bubbleSort(array1,true);
		insertionSort(array1);
		selectionSort(array1);
		System.out.println(Arrays.toString(array1));
	}
}
