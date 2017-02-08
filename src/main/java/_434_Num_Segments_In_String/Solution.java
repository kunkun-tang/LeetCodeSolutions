package _434_Num_Segments_In_String;


public class Solution {
  public int countSegments(String s) {
    if(s == null || s.length() == 0) return 0;
    char[] chArr = s.toCharArray();
    int index = 0, num =0;
    while(index < chArr.length) {
      if(chArr[index] == ' ') {
        index ++;
      }
      else {
        num++;
        while(index < chArr.length && chArr[index] != ' ') index++;
      }
    }
    return num;
  }
}
