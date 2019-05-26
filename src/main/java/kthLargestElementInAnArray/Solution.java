package kthLargestElementInAnArray;

import java.util.Arrays;

/**
 * created by huang 5/25/19
 */
public class Solution {

    public static void main(String[] args) {
        new Solution().findKthLargest(new int[]{3,2,3,1,2,4,5,5,6}, 4);
    }

    public int findKthLargest(int[] nums, int k) {
        int[] heap = new int[k];
        for(int i = 0 ; i < k ; i ++) {
            heap[i] = nums[i];
        }
        Arrays.sort(heap);
        for(int i = k ; i < nums.length ; i ++) {
            add(nums[i] , heap);
        }
        return heap[0];
    }

    // 最小堆的实现
    public void add(int n, int[] heap) {
        if(n < heap[0]) return;
        int length = heap.length;
        int tailIndex = length - 1;
        if(n >= heap[tailIndex]) {
            int curr = n;
            while(tailIndex >= 0) {
                int temp = heap[tailIndex];
                heap[tailIndex] = curr;
                tailIndex --;
                curr = temp;
            }
        }else if(heap[0] < n && n < heap[length - 1]) {
            heap[0] = n;
            for(int i = 0 ; i < length - 1 ; i ++) {
                if(heap[i] > heap[i + 1]) {
                    int l = heap[i + 1];
                    heap[i + 1] = heap[i];
                    heap[i] = l;
                }else if(heap[i] < heap[i + 1]) {
                    break;
                }
            }
        }
     }

}
