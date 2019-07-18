package CodingInterview;

public class _13_RobotMove {

    public static int movingCount(int threshold, int rowLen, int colLen) {
        if (threshold < 0 || rowLen <= 0 || colLen <= 0)
            return 0;

        boolean[][] visited = new boolean[rowLen][colLen];

        return movingCountCore(threshold, rowLen, colLen, 0, 0, visited);

    }

    private static int movingCountCore(int threshold, int rowLen, int colLen, int row, int col, boolean[][] visited) {
        int count = 0;
        if (check(threshold, rowLen, colLen, row, col, visited)) {
            visited[row][col] = true;
            count = 1 +
                    movingCountCore(threshold, rowLen, colLen, row - 1, col, visited) +
                    movingCountCore(threshold, rowLen, colLen, row + 1, col, visited) +
                    movingCountCore(threshold, rowLen, colLen, row, col - 1, visited) +
                    movingCountCore(threshold, rowLen, colLen, row, col + 1, visited);

        }
        return count;

    }

    private static boolean check(int threshold, int rowLen, int colLen, int row, int col, boolean[][] visited) {
        return row >= 0 && row < rowLen && col >= 0 && col < colLen && !visited[row][col] && (digitSum(row) + digitSum(col) <= threshold);

    }

    private static int digitSum(int digit) {
        int sum = 0;
        while (digit > 0) {
            sum += (digit % 10);
            digit /= 10;
        }
        return sum;
    }


    public static void main(String[] args) {
        System.out.println(movingCount(0,3,4)); //1
        System.out.println(movingCount(1,3,4)); //3
        System.out.println(movingCount(9,2,20)); //36

    }
}
