package PROGRAMMERS.dfs;

class 타겟넘버 {
    public int solution(int[] numbers, int target) {
        return dfs(numbers, target, 0, 0);
    }
    
    public static int dfs(int[] numbers, int target, int index, int sum){
        if(index == numbers.length) return sum == target ? 1 : 0;
        
        int add = dfs(numbers, target, index + 1, sum + numbers[index]);
        int subtract = dfs(numbers, target, index + 1, sum - numbers[index]);
        
        return add + subtract;
    }
}
