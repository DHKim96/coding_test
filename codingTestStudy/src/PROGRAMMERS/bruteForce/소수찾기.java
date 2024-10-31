package PROGRAMMERS.bruteForce;

import java.util.Set;
import java.util.HashSet;

class 소수찾기 {
    private static boolean[] isPrime;
    private static Set<Integer> primeSet;
    
    public int solution(String numbers) {
        int max = 9999999;
        isPrime = new boolean[max + 1];
        primeSet = new HashSet<>();
        
        primeCheck(max);
        
        generateCombination("", numbers);
        
        return primeSet.size();
    }
    
    public void primeCheck(int num){
        for(int i = 2; i <= num; i++){
            isPrime[i] = true;
        }
        
        for(int i = 2; i * i <= num; i++){
            if(isPrime[i]){
                for(int j = i * i; j <= num; j += i){ // i의 제곱부터 시작해서 i의 배수 처리
                    isPrime[j] = false;
                }
            }
        }
    }
    
    public void generateCombination(String current, String numbers){
        if(!current.isEmpty()){
            int num = Integer.parseInt(current);
            if(isPrime[num]){
                primeSet.add(num);
            }
        }
        
        for(int i = 0; i < numbers.length(); i++){
            generateCombination(current + numbers.charAt(i), numbers.substring(0, i) + numbers.substring(i + 1));
        }
    }
}
