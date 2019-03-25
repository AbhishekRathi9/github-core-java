import java.util.HashMap;
import java.util.Map;

public class RansomNote {

    public static void main(String[] args) {

        String[] magazine = {"ive","got"};
        String[] note = {"ive","coco"};
        
        checkMagazine(magazine,note);
    }

    private static void checkMagazine(String[] magazine, String[] note) {
        Map<String,Integer> map = new HashMap<>();
        for( String word : magazine){
            map.put(word,map.get(word)==null?1:map.get(word)+1);
        }
        for(String word : note){
            if(!map.containsKey(word)){
                System.out.println("No");
                return;
            } else{
                map.put(word,map.get(word)-1);
                if(map.get(word)<0){
                    System.out.println("No");
                    return;
                }
            }
        }
        System.out.println("Yes");
    }
}
