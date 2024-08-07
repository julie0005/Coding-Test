package programmers.binary_search;
import java.util.*;
import java.util.stream.*;
class BestSearchRank {
    Map<String, List<Integer>> graph = new HashMap<>();
    public int[] solution(String[] info, String[] query) {
        int[] answers = new int[query.length];
        String[] language = {"cpp","java","python","-"};
        String[] career = {"junior", "senior", "-"};
        String[] position = {"frontend", "backend", "-"};
        String[] soulFood = {"chicken", "pizza", "-"};
        
        for(int i=0; i<language.length; i++) {
            for(int j=0; j<position.length; j++) {
                for(int k=0; k<career.length; k++) {
                    for(int l=0; l<soulFood.length; l++) {
                        graph.put(language[i]+position[j]+career[k]+soulFood[l], new ArrayList<>());
                    }
                }
            }
        }
        
        for(String unitInfo : info) {
            String[] conditions = unitInfo.split(" ");
            String[] lan = {conditions[0], "-"};
            String[] pos = {conditions[1], "-"};
            String[] car = {conditions[2], "-"};
            String[] soul = {conditions[3], "-"};
            for(int i=0; i<lan.length; i++) {
                for(int j=0; j<pos.length; j++) {
                    for(int k=0; k<car.length; k++) {
                        for(int l=0; l<soul.length; l++) {
                            String key = lan[i]+pos[j]+car[k]+soul[l];
                            List<Integer> list = graph.get(key);
                            list.add(Integer.parseInt(conditions[4]));
                            graph.put(key, list);
                        }
                    }
                }
            }
        }
        
        for (String key : graph.keySet())
            Collections.sort(graph.get(key));
        
        int i=0;
        for(String unitQuery : query) {
            String temp = unitQuery.replaceAll(" and ", "");
            String[] conditions = temp.split(" ");
            int count = binarySearch(conditions[0], Integer.parseInt(conditions[1]));
            answers[i++] = count;
        }
        return answers;
    }
    
    int binarySearch(String key, int score) {
        List<Integer> list = graph.get(key);
        int start = 0, end = list.size() - 1;
 
        while (start <= end) {
            int mid = (start + end) / 2;
            if (list.get(mid) < score)
                start = mid + 1;
            else
                end = mid - 1;
        }
 
        return list.size() - start;
    }
}