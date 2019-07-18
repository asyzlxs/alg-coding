package CodingInterview;

public class _12_StringPathInMatrix {

    public static boolean hasPath(char[][] data, String str) {
        if (data == null || data.length <= 0 || data[0].length <= 0 || str == null || str.length() <= 0)
            return false;

        int rowLen = data.length;
        int colLen = data[0].length;

        boolean[][] visited = new boolean[rowLen][colLen];
        for (int i = 0; i < rowLen; ++i) {
            for (int j = 0; j < colLen; ++j) {
                visited[i][j] = false;
            }
        }


        for (int row = 0; row < rowLen; ++row) {
            for (int col = 0; col < colLen; ++col) {
                if (hasPathCore(data, row, col, visited, str, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean hasPathCore(char[][] data, int row, int col, boolean[][] visited, String str, int strIndex) {
        if (strIndex >= str.length())
            return true;

        if (row < 0 || col < 0 || row >= data.length || col >= data[row].length)
            return false;

        if (!visited[row][col] && data[row][col] == str.charAt(strIndex)) {
            visited[row][col] = true;
            boolean result = hasPathCore(data, row - 1, col, visited, str, strIndex + 1) ||
                    hasPathCore(data, row + 1, col, visited, str, strIndex + 1) ||
                    hasPathCore(data, row, col - 1, visited, str, strIndex + 1) ||
                    hasPathCore(data, row, col + 1, visited, str, strIndex + 1);
            if (result)
                return true;
            else
                visited[row][col] = false;
        }

        return false;

    }

    public static void main(String[] args) {
        char[][] data = {
                {'a','b','t','g'},
                {'c','f','c','s'},
                {'j','d','e','h'}};
        System.out.println(hasPath(data,"bfce")); //true
        System.out.println(hasPath(data,"abfb")); //false,访问过的位置不能再访问
    }


}
