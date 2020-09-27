package com.dubbo.serviceconsumer.filter;
public class Solution {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length + nums2.length;
        if(nums1.length == 0){
            return getMid(nums2, n, 0);
        } else if(nums2.length == 0){
            return getMid(nums1, n, 0);
        }
        if(nums1.length == 1 && nums2.length == 1){
            return (nums1[0] + nums2[0] + 0.0)/2;
        }
        int deleteP1 = -1;
        int deleteP2 = -1;
        int mid = n >> 1;
        mid = (n&1) == 1 ? mid : mid - 1; // 删除前 mid 个元素，计算的是长度
        int tempMid = mid;
        int smid, p1 = 0, p2 = 0;
        while(true){
            smid = tempMid >> 1;
            // 计算 p1
            if(deleteP1 == -1 && smid == 0){
                p1 = 0;
            } else if(deleteP1 + smid >= nums1.length) {
                p1 = nums1.length - 1;
            } else {
                p1 = deleteP1 + smid;
                if(tempMid == 1 && p1 + 1 < nums1.length){
                    p1++;
                }
            }
            // 计算 p2
            if(deleteP2 == -1 && smid == 0){
                p2 = 0;
            } else if(deleteP2 + smid >= nums2.length) {
                p2 = nums2.length - 1;
            } else {
                p2 = deleteP2 + smid;
                if (tempMid == 1&& p2 + 1 < nums2.length) {
                    p2++;
                }
            }
            // 对比 p1 和 p2：删除小数组前 k 个元素
            if(nums1[p1] > nums2[p2]){
                deleteP2 = p2;
            } else if(nums1[p1] < nums2[p2]){
                deleteP1 = p1;
            } else {
                deleteP1 = p1;
                deleteP2 = p2;
            }
            // 一个数组已经完全可以排除：可直接得出结果
            if(deleteP1 == nums1.length - 1){
                return getMid(nums2, n, nums1.length);
            } else if(deleteP2 == nums2.length - 1){
                return getMid(nums1, n, nums2.length);
            }
            // 已删除的元素已经达到要求，可以直接得出结果
            if(deleteP1 + deleteP2 + 2 == mid){
                return getMid(nums1, deleteP1, nums2, deleteP2, n);
            } else if(deleteP1 + deleteP2 + 2 > mid){
                if(nums1[deleteP1] > nums2[deleteP2]){
                    return (nums1[deleteP1] + Math.min(nums1[deleteP1 + 1], nums2[deleteP2]) + 0.0)/2;
                } else if(nums1[deleteP1] < nums2[deleteP2]){
                    return (nums2[deleteP2] + Math.min(nums1[deleteP1], nums2[deleteP2 + 1]) + 0.0)/2;
                } else {
                    return (nums2[deleteP2] + Math.min(nums1[deleteP1 + 1], nums2[deleteP2 + 1]) + 0.0)/2;
                }
            }
            // 否则：修改 tempMid 继续删除元素
            tempMid = mid - deleteP1 - deleteP2 - 2;
        }
    }
    private static double getMid(int[] arr1, int p1, int[] arr2, int p2, int n){
        if((n & 1) == 1){
            return Math.min(arr1[p1 + 1], arr2[p2 + 1]) + 0.0;
        }
        p1++;
        p2++;
        int min1 = Math.min(arr1[p1], arr2[p2]);
        int min2;
        if(p1 == arr1.length - 1){
            if(arr1[p1] == min1){
                min2 = arr2[p2];
            } else {
                min2 = Math.min(arr1[p1], arr2[p2 + 1]);
            }
        } else if(p2 == arr2.length - 1){
            if(arr1[p1] == min1){
                min2 = Math.min(arr1[p1 + 1], arr2[p2]);
            } else {
                min2 = arr1[p1];
            }
        } else {
            if(arr1[p1] == min1){
                min2 = Math.min(arr1[p1 + 1], arr2[p2]);
            } else {
                min2 = Math.min(arr1[p1], arr2[p2 + 1]);
            }
        }
        return (min1 + min2 + 0.0) / 2;
    }
    private static double getMid(int[] arr, int n, int sub){
        int mid = n >> 1;
        if((n&1) == 1){
            return arr[mid - sub] + 0.0;
        } else {
            return (arr[mid - sub] + arr[mid - sub - 1] + 0.0) / 2;
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {1,3};
        int[] arr2 = {2, 4, 5, 6,7};
        System.out.println(findMedianSortedArrays(arr1, arr2));
    }
}