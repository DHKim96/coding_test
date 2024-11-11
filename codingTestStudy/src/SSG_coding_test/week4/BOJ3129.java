package SSG_coding_test.week4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class BOJ3129 {
	// 상범이의 은밀한 메세지

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 입력 받기
		String encryptedMessage = br.readLine(); // 암호화 메세지

		String partialDecryptedMessage = br.readLine(); // 암호화되지 않은 메시지

		// substring 통해서 일일이 대조해서 키 찾기
		// 키 추출
		String key = extractKey(encryptedMessage, partialDecryptedMessage);
				
		// 원래 메시지 복호화
        String originalMessage = decryptMessage(encryptedMessage, key);
      
		bw.write(originalMessage);
		bw.flush();
		bw.close();
		br.close();
	}

	// 암호화된 메시지에서 복호화된 일부분을 이용해 키를 추출
	private static String extractKey(String encryptedMessage, String partialDecryptedMessage) {
		int encryptedMessageLen = encryptedMessage.length();
		int partialDecryptedMessageLen = partialDecryptedMessage.length();

		for (int i = 0; i < encryptedMessageLen - partialDecryptedMessageLen + 1; i++) {
			String subEncryptedMessage = encryptedMessage.substring(i, partialDecryptedMessageLen + i);

			String candidate = checkCandidate(i, subEncryptedMessage, partialDecryptedMessage);

			if (candidate != null) {
				return candidate;
			}
		}

		return "";
	}

	private static String checkCandidate(int startIdx, String subEncryptedMessage, String partialDecrypted) {
		List<Character> list = new ArrayList<>();
		char[] chArr = {};
		boolean isTrue = true;

		// partialDecrypted 와 비교하여 반복되는 구간 체크
		for (int i = 0; i <= partialDecrypted.length() / 2; i++) {
			char curr = calcForDecrypt(subEncryptedMessage.charAt(i), partialDecrypted.charAt(i));

			if (!list.isEmpty() && list.get(0) == curr) { // 반복 시작 지점 찾을 시 해당 지점부터 끝까지 반복하는지 확인
				int idx = i + 1;
				int listIdx = 1;

				while (listIdx < list.size() && idx < partialDecrypted.length()) {
					curr = calcForDecrypt(subEncryptedMessage.charAt(idx), partialDecrypted.charAt(idx));

					if (list.get(listIdx) != curr) {
						isTrue = false;
						break;
					} else {
						listIdx++;
						idx++;
					}
				}
				break; // 끝까지 반복할 경우 for 문 탈출
			}
			list.add(curr);
		}
		
		// 반복 검사 후 유효하지 않으면 즉시 null 반환
		if (!isTrue) return null;
		
		// 키의 길이와 substring 시작 인덱스를 통해 주어진 임시키의 순서를 조정
		// 예컨대 키의 길이가 3이고 시작 인덱스가 1이라면 임시키의 2번 인덱스가 첫 번째 철자임
		// 키의 길이 - (시작 인덱스 % 키의 길이)
		int keyLen = list.size();
		chArr = new char[keyLen];

		for (int idx = 0; idx < keyLen; idx++) {
			chArr[idx] = list.get(((keyLen - (startIdx % keyLen)) + idx) % keyLen);
		}

		for (int idx = 0; idx < partialDecrypted.length(); idx++) {
			if (calcForEncrypt(partialDecrypted.charAt(idx), list.get(idx % keyLen)) != subEncryptedMessage.charAt(idx)) {
				return null;
			}
		}
		
		return new String(chArr);
	}

    // 주어진 키를 통해 메세지 복호화
    private static String decryptMessage(String encryptedMessage, String key) {
    	int ecnLen = encryptedMessage.length();
    	int keyLen = key.length();
    	
    	
    	char[] result = new char[ecnLen];
    	
    	for (int i = 0; i < ecnLen; i++) {
    		result[i] = decrypt(encryptedMessage.charAt(i), key.charAt(i % keyLen));
		}
    	
    	return new String(result);
    	
    }
    
    private static char decrypt(char a, char keyChar) {
    	return (char) (((a - keyChar + 26) % 26) + 'a');
    }

	private static char calcForDecrypt(char a, char b) {
		return (char) (((a - b + 26) % 26) + 'a');
	}

	private static char calcForEncrypt(char a, char keyChar) {
		return (char) ((((a - 'a') + (keyChar - 'a')) % 26) + 'a');
	}
	
}
