package _332_Reconstruct_Itinerary;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
  public List<String> findItinerary(String[][] tickets) {
    if(tickets.length < 1) return null;
    Map<String, List<String>> map = new HashMap<String, List<String>> ();
    for(int i=0; i<tickets.length; i++) {
      String from = tickets[i][0], to = tickets[i][1];
      map.putIfAbsent(from, new ArrayList<String>());
      map.get(from).add(to);
    }
    // for(Map.Entry<String, List<String>> entry : map) {
    //     Collection.sort(entry.getValue());
    // }
    List<String> list = new ArrayList<String> ();
    return dfs(map, "JFK", list, tickets.length+1);
  }

  public List<String> dfs(Map<String, List<String>> map, String city, List<String> list, int limit) {
    list.add(city);
    if(list.size() == limit) return list;
    if(map.containsKey(city) == true && map.get(city).size() >= 1) {
      List<String> stringList = new ArrayList(map.get(city));
      Collections.sort(stringList);
      for(int i=0; i<stringList.size(); i++) {
        String toCity = stringList.get(i);
        // System.out.println("city =" + city + " toCity =" + toCity);
        map.get(city).remove(toCity);
        dfs(map, toCity, list, limit);
        if(list.size() == limit) return list;
        map.get(city).add(toCity);
      }
    }
    list.remove(list.size() -1);
    return list;
  }
}
