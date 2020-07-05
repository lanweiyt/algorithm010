class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int left = 0;
        int right = matrix.length - 1;
        int index = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (matrix[mid].length < 1) {
                return false;
            }
            index = mid;
            if (matrix[mid][0] <= target && matrix[mid][matrix[mid].length - 1] >= target) {
                break;
            }
            if (matrix[mid][0] > target) {
                right = mid - 1;
            } else {
                left = left + 1;
            }


        }
        if (index >= 0 && searchedTarget(matrix[index], target)){
            return true;
        }

        return false;
    }

    private boolean searchedTarget(int[] matrix, int target) {
        int left = 0;
        int right = matrix.length - 1;
        while (left <= right) {
            int mid = (left + right)/2;
            if (matrix[mid] == target) {
                return true;
            }
            if (matrix[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return false;
    }
}