package BOJ.string.advencedString;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ25206 {
	/*
	 * BOJ NO.25206 : 너의 평점은
	 * 
	 * 입력 갯수를 모른다
	 * => br.readLine() == null && line.isEmpty() 일 때까지 입력 받는다
	 * 
	 * 입력 받은 것 중 중요한건 해당 과목의 학점과 등급
	 * br.readLine().split(" ") 을 Stirng[]에 넣되 String[1](학점), String[2](등급)만 넣는다.
	 * 
	 * P 등급일 경우 무시하기
	 * 
	 * p 등급인 과목을 제외한 나머지를 switch문을 통해 등급을 과목평점으로 치환
	 * 
	 * 과목별 이수단위(currCredit) 추출하기
	 * 
	 * 과목별 평점(score) 산출하기
	 * 
	 * 이수단위 * 평점값을 creditTimesScore에 더하기
	 * 
	 * currCredit 을 전체 이수단위 값(totalCredit)에 더하기
	 * 
	 * creditTimesScore / totalCredit 값의 소수점 6자리까지 출력하기
	 * 
	 */
	
	/**
	 * 등급을 과목평점으로 반환해주는 메소드
	 * @param grade
	 * @return
	 */
	public static double calcScoresAccordingToGrade(String grade) {
		double score = 0.0;
		switch ( grade ) {
			case "A+":
				score = 4.5;
				break;
			case "A0":
				score = 4.0;
				break;
			case "B+":
				score = 3.5;
				break;
			case "B0":
				score = 3.0;
				break;
			case "C+":
				score = 2.5;
				break;
			case "C0":
				score = 2.0;
				break;
			case "D+":
				score = 1.5;
				break;
			case "D0":
				score = 1.0;
				break;
			default:
				score = 0.0;
		}
		return score;
	}
	
	public static void main(String[] args) throws IOException {
		// 입력 스트림 열기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력한 데이터를 저장할 변수 선언
		String line;
		// 학점 저장할 변수 생성
		double totalCredit = 0.0;
		// 과목의 학점 * 과목평점을 저장할 변수 생성
		double creditTimesScore = 0.0;
		// 입력한 데이터가 더 이상 없을 때까지 입력 받기
		while ( ( line = br.readLine() ) != null && !line.isEmpty()) {
			String[] strs = line.split(" ");
			// 과목 등급
			String grade = strs[2];
			// 만약 P등급 받았을 경우 이하 생략
			if(grade.equals("P")) continue;
			// 현 과목의 이수단위
			double currCredit = Double.parseDouble(strs[1]);
			// 과목평점 산출
			double score = calcScoresAccordingToGrade(grade);
			// creditTimesScore에 이수단위 * 과목평점한 값을 더하기
			creditTimesScore += (currCredit * score);
			// totalCredit에 현 과목의 이수단위 더하기
			totalCredit += currCredit;
		}
		// creditTimesScore / totalCredit 산출하기
		double result = creditTimesScore / totalCredit;
		// 출력하기(소수점 6자리로 출력)
		System.out.printf("%.6f", result);
		// 입력 스트림 닫기
		br.close();
	}
}
