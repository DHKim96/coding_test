package SSG_coding_test.week4;

import java.io.*;

public class BOJ3107 {
    // IPv6
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String origin = br.readLine(); // 원본 IPv6 저장

        if (origin.length() == 39){
            bw.write(origin);
            bw.flush();
            bw.close();
            br.close();
            return;
        }

        // 미리 구분자 갯수 추가하기
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < origin.length(); i++){
            char ch = origin.charAt(i);

            sb.append(ch);
            
            if (ch == ':' && i + 1 < origin.length() && origin.charAt(i + 1) == ':') {
                while(count++ < 7){
                    ob.append(':');
                }
            }
        }

        String[] nums = origin.split(":", -1); // 문자열이 공백으로 끝날 시 공백 취득

        sb = new StringBuilder();

        String num = "";
        int length = 0;

        for (int i = 0; i < nums.length; i++){
            num = nums[i];
            length = num.length();
            while (length++ < 4){
                sb.append(0);
            }
            sb.append(num);
            if (i != nums.length - 1) sb.append(":");


        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
