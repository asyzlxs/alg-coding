package CodingInterview;

public class _04_FindInPartiallySortedMatrix {

    public static boolean Find(int[][] matrix, int num) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;

        int row = 0;
        int column = matrix[0].length - 1;

        while ((row <= matrix.length) && (column >= 0)) {
            if (matrix[row][column] == num)
                return true;
            else if (matrix[row][column] > num)
                --column;
            else
                ++row;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        System.out.println(Find(matrix, 7));
        System.out.println(Find(matrix, 3));
    }
}
