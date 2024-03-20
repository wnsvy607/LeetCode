import java.util.*;

public class Solution {
    public boolean wordBreak(String s, List<String> list) {
        // f[i]의 값은 i전 까지의 결과가 전부 dict에 포함된 단어인지 여부
        boolean[] f = new boolean[s.length() + 1];
        
        Set<String> dict = new HashSet<>(list);
                
        f[0] = true;
        

        
        for(int i=1; i <= s.length(); i++){
            for(int j=0; j < i; j++){
                //f[j]: j 이전까지의 문자열은 모두 dict로 이루어졌는가 
                //뒤에는 (j ~ i - 1) 서브스트링이 dict에 있는지 체크
                if(f[j] && dict.contains(s.substring(j, i))){
                    f[i] = true;
                    break;
                }
            }
        }
        
        return f[s.length()];
    }
}