package BOJ.recursionFunction;

import java.io.*;

public class BOJ25501 {
    /*
        * 재귀의 귀재
     */
    static String s;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수

        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            s = br.readLine();
            count = 0;

            sb.append(isPalindrome(0,s.length() - 1))
                    .append(" ").append(count).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }

    public static int isPalindrome(int l, int r){
        count++;
        if (l >= r) return 1;
        if (s.charAt(l) != s.charAt(r)) return 0;
        return isPalindrome(l + 1, r - 1);
    }
}
