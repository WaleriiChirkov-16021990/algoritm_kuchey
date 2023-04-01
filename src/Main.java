import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		int[] A = { 6, 4, 7, 1, 9, -2 };
		heapsort(A);
		System.out.println(Arrays.toString(A));
	}
	
	private static int LEFT(int i) {
		return (2*i + 1);
	}
	
	private static int RIGHT(int i) {
		return (2*i + 2);
	}
	
	private static void swap(int[] A, int i, int j)
	{
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}
	private static void heapify_down(int[] A, int i, int size)
	{
		int left = LEFT(i);
		int right = RIGHT(i);
		
		int largest = i;
		if (left < size && A[left] > A[i]) {
			largest = left;
		}
		
		if (right < size && A[right] > A[largest]) {
			largest = right;
		}

		if (largest != i)
		{
			swap(A, i, largest);
			heapify_down(A, largest, size); // heapify-down для дочернего элемента
		}
	}
	public static int pop(int[] A, int size)
	{
		if (size <= 0) {
			return -1;
		}
		int top = A[0];
		A[0] = A[size-1];
		heapify_down(A, 0, size - 1); // вызов heapify-down на корневом узле
		return top;
	}
	public static void heapsort(int[] A)
	{
		// строю приоритетную очередь и инициализирую ее заданным массивом
		int n = A.length;
		// вызываю heapify, начиная с последнего внутреннего
		// узел до корневого узла
		int i = (n - 2) / 2;
		while (i >= 0) {
			heapify_down(A, i--, n);
		}
		// несколько раз извлекаю из кучи, пока она не станет пустой
		while (n > 0)
		{
			A[n - 1] = pop(A, n);
			n--;
		}
	}
}