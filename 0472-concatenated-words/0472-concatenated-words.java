import java.util.*;

class Solution {
    
    
    
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        
        Arrays.sort(words, (s1, s2) -> s1.length() - s2.length());
        Set<String> dict = new HashSet<>();
        List<String> answer = new ArrayList<>();
        
        for(String word: words) {
            if(isConcatenated(word, dict))
                answer.add(word);                
            dict.add(word);
        }

        
        return answer;
    }
    
    
    boolean isConcatenated(String word, Set<String> dict) {
        if(dict.isEmpty())
            return false;
        
        boolean[] exist = new boolean[word.length() + 1];
        exist[0] = true;
        
        for(int i = 1; i <= word.length(); i++) {
            for(int j = i - 1; j >= 0; j--) {
                if(!exist[j]) continue;
                if(dict.contains(word.substring(j,i))) {
                    exist[i] = true;
                    break;
                }
            }
        }
        
        return exist[word.length()];
    }
}