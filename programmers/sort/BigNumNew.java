package programmers.sort;

import java.util.*;
import java.util.stream.Collectors;
// 사용자 정의 정렬의 포인트는 comparator 안에서는 두 변수의 대소관계만 생각하면 된다는 것.
// 처음 아이디어 : 앞자리부터 큰 것이 더 우위, 동일할 때는.. ?
// 그 후 : 31113과 3111 예시로 생각하다 둘이 붙여보면서, 아 둘이 붙여봐서 비교하면 되겠구나
class BigNumNew {
    public String solution(int[] numbers) {
        List<Integer> nums = Arrays.stream(numbers)
                        .boxed()
                        .collect(Collectors.toList());;
        Collections.sort(nums, new Comparator<Integer>() {
            @Override
            public int compare(Integer num1, Integer num2) {
                String s1 = Integer.toString(num1);
                String s2 = Integer.toString(num2);
                return Integer.parseInt(s2+s1) - Integer.parseInt(s1+s2);
            }
                
        });
        if (nums.get(0) == 0) return "0";
        StringBuilder sb = new StringBuilder();
        for (Integer num : nums) {
            sb.append(Integer.toString(num));
        }
        return sb.toString();
    }
}
