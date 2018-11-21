package newcode;

class MedianTwoSortedArrayWithoutExtraMemory {

    public static void main(String args[]) {
        System.out.println(findMedianSortedArrays(new int[]{1 ,2}, new int[]{3}));
    }

    private static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null && nums2 == null) {
            return 0.0;
        }

        int l1 = nums1.length;
        int l2 = nums2.length;

        int n = (l1 + l2)/2;
        boolean isEven = true;
        if ((l1 + l2) % 2 != 0) {
            ++n;
            isEven = false;
        }

        int i = 0;
        int j = 0;
        int count = 0;
        int num = -1;
        int num1 = -1;

        while (i < l1 || j < l2) {
            ++count;
            if (i < l1 && j < l2) {
                if (nums1[i] < nums2[j]) {
                    if (count == n) {
                        num = nums1[i];
                    } else if (count == n+1) {
                        num1 = nums1[i];
                        break;
                    }
                    ++i;
                } else if (nums1[i] > nums2[j]) {
                    if (count == n) {
                        num = nums2[j];
                    } else if (count == n + 1) {
                        num1 = nums2[j];
                        break;
                    }
                    ++j;
                } else {
                    if (count == n) {
                        num = nums1[i];
                        num1 = nums2[j];
                        break;
                    }
                    ++count;
                    ++i;
                    ++j;
                }
            } else if (i < l1) {
                if (count == n) {
                    num = nums1[i];
                } else if (count == n+1) {
                    num1 = nums1[j];
                    break;
                }
                ++i;
            } else {
                if (count == n) {
                    num = nums2[j];
                } else if (count == n+1) {
                    num1 = nums2[j];
                    break;
                }
                ++j;
            }
        }

        if (isEven) {
            return (num + num1)/2.0;
        } else {
            return (double) num;
        }
    }
}