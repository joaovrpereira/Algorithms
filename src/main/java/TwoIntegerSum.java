import java.util.Arrays;
import java.util.HashMap;

public class TwoIntegerSum {
    public static void main(String[] args) {

        int nums[] = new int[]{0,5,0};
        int target = 0;
        Solution_TIS_01 solution = new Solution_TIS_01();
        System.out.println(Arrays.toString(solution.twoSum(nums, target)));
    }
}

class Solution_TIS_01 {

    //Solução por força bruta, complexidade de O(n²)

    public int[] twoSum(int[] nums, int target) {

        for(int i = 0; i < nums.length - 1; i++){
            for(int j = i+1; j < nums.length; j++){
                if(nums[i] + nums[j] == target && i != j ){
                    if(i<=j){
                        return new int[]{i, j};
                    }else{
                        return new int[]{j, i};
                    }
                }
            }
        }
        return new int[]{};
    }
}

class Solution_TIS_02 {

    public int[] twoSum(int[] nums, int target) {

        // <valor, indice>
        //Utilizando Hash, a solução para o problema é de complexidade O(n)

        HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();
        for(int i = 0; i<nums.length; i++){

            int valor = target - nums[i];

            if(hash.containsKey(valor)){

                if(hash.get(valor) <= i){
                    return new int[]{hash.get(valor), i};
                } else {
                    return new int[]{i, hash.get(valor)};
                }

            } else {
                hash.put(nums[i], i);
            }
        }
        return new int[]{};

    }
}


