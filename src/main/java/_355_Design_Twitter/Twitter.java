package _355_Design_Twitter;

import java.util.*;

public class Twitter {

  Map<Integer, TreeMap<Integer, Integer>> messageMap;
  Map<Integer, List<Integer>> userMap;
  int timeID = 0;

  /** Initialize your data structure here. */
  public Twitter() {
    userMap = new HashMap<> ();
    messageMap = new HashMap<>();
  }

  /** Compose a new tweet. */
  public void postTweet(int userId, int tweetId) {
    messageMap.putIfAbsent(userId, new TreeMap<Integer, Integer>());
    messageMap.get(userId).put(timeID, tweetId);
    timeID ++;
  }

  /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
  public List<Integer> getNewsFeed(int userId) {
    TreeMap<Integer, Integer> curr = new TreeMap<>();
    if(messageMap.get(userId) != null)
      curr.putAll(messageMap.get(userId));
    if(userMap.get(userId) != null)
      for(Integer frd: userMap.get(userId)) {
        if(messageMap.get(frd) != null)
          curr.putAll(messageMap.get(frd));
      }
    List<Integer> retList = new ArrayList<>();
    int count = 0;
    if(curr != null) {
      Iterator<Integer> iter = curr.navigableKeySet().descendingIterator();
      while(iter.hasNext() && count < 10) {
        int key = iter.next();
        // System.out.println("key = " + key);
        retList.add(curr.get(key));
        count ++;
      }
    }
    return retList;
  }

  /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
  public void follow(int followerId, int followeeId) {
    userMap.putIfAbsent(followerId, new ArrayList<Integer>());
    userMap.get(followerId).add(followeeId);
  }

  /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
  public void unfollow(int followerId, int followeeId) {
    if(userMap.get(followerId) != null ){
      userMap.get(followerId).remove(new Integer(followeeId));
    }
  }
}

