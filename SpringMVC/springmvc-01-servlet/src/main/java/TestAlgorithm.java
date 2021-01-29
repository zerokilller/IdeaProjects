import java.util.HashMap;
import java.util.Map;

public class TestAlgorithm {

    /**
     *两数之和暴力解法
     */
    public static int[] twoNumSum1(int[] array,int target){
        for (int i = 0;i < array.length;i++){
            for(int j = i+1;j<array.length;j++){
                if(target - array[i] == array[j]){
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }

    /**
     *两数只和:利用hashMap求解
     */
    public static int[] twoNumSum2(int[] array,int target){
        Map<Integer,Integer> hashMap = new HashMap<>();
        for(int i = 0;i<array.length;i++){
            int partnerNumber = target - array[i];
            if(hashMap.containsKey(partnerNumber)){
                return new int[]{hashMap.get(partnerNumber),i};
            }
            hashMap.put(array[i],i);
        }
        return null;
    }

    public static void main(String[] args) {
        int[] array = {1,3,5,7,33,11};
        int target = 40;
        int[] retValue = twoNumSum2(array,target);
        for(int element:retValue){
            System.out.println(element);
        }
    }
}
