public class Solution {
    public double findMedianSortedArrays(int A[], int B[]) {
        // solve by finding the top K smllest elements
        if ((A.length + B.length) % 2 == 1) {
            return findTopK(A, B, 0, A.length, 0, B.length, (A.length + B.length + 1) / 2);
        } else {
            return (findTopK(A, B, 0, A.length, 0, B.length, (A.length + B.length) / 2) + findTopK(A, B, 0, A.length, 0, B.length, (A.length + B.length) / 2 + 1)) / 2.0;
        }
    }
    
    public int findTopK(int[] A, int[] B, int As, int Ae, int Bs, int Be, int k) {
        int lenA = Ae - As;
        int lenB = Be - Bs;
        // keep `A` the shorter array
        if (lenA > lenB) return findTopK(B, A, Bs, Be, As, Ae, k);
        if (lenA == 0) return B[Bs + k - 1];
        // notice A and B are both within a certain range
        if (k == 1) return A[As] < B[Bs] ? A[As] : B[Bs];
        // choose pivot in A and in B (pivot is 1-based here)
        // the pivot in A is the k/2 th element, or lenA-th element is lenA < k/2
        int pivotA = Math.min(k/2, lenA);
        // the pivot in B is the k-pivotA th element in B
        int pivotB = k - pivotA;
        // in normal case, pivotA = pivotB = k/2, if k is odd, pivotA = k/2 = pivotB - 1;
        // if the two pivots value are the same, that value is sure to be the k th smallest value in A and B
        if (A[As + pivotA - 1] == B[Bs + pivotB - 1]) return A[As + pivotA - 1];
        // if pivotA's value is bigger, it must be equal to or bigger than the first k th smallest element
        // and pivotB's value is smaller than k th smallest element, so we can instead find k - pivotB th smallest element
        else if (A[As + pivotA - 1] > B[Bs + pivotB - 1]) {
            return findTopK(A, B, As, As + pivotA, Bs + pivotB, Be, k - pivotB);
        }
        // else, vice versa
        else {
            return findTopK(A, B, As + pivotA, Ae, Bs, Bs + pivotB, k - pivotA);
        }
    }
}
