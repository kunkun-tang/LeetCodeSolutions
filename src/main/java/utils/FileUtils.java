package utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class FileUtils {

  public static final int[][] convertFileLineToIntArray(String path) {
    try{

      int[][] intArray = Files.lines(Paths.get(path))
                              .map(s -> s.substring(1, s.length()-1))
                              .map(s -> s.split(","))
                              .map(FileUtils::stringArrToIntArr)
                              .toArray(int[][]::new);

      return intArray;
    } catch (IOException e) {
      e.printStackTrace();
    }
    return null;
  }

  public static int[] stringArrToIntArr(String [] strArr) {
    return Arrays.stream(strArr).mapToInt(Integer::parseInt).toArray();
  }


  public static void printStringArray(String[] arr) {

    System.out.print("[");
    for(int i =0; i <arr.length; i++)
        System.out.print(arr[i] + " ");
    System.out.print("]\n");
  }

  public static void printStringDoubleArray(String[][] arr) {
    for(int i =0; i <arr.length; i++) {
      System.out.print("[");
      for (int j = 0; j < arr[i].length; j++)
        System.out.print(arr[i][j] + " ");
      System.out.print("]\n");
    }
  }

  public static void printIntArray(int[] arr) {
    System.out.print("[");
    for(int i =0; i <arr.length; i++)
      System.out.print(arr[i] + " ");
    System.out.print("]\n");
  }

  public static void printIntDoubleArray(int[][] arr) {
    for(int i =0; i <arr.length; i++) {
      System.out.print("[");
      for (int j = 0; j < arr[i].length; j++)
        System.out.print(arr[i][j] + " ");
      System.out.print("]\n");
    }
  }

  public static void main(String[] arr) {
    int[][] testInputs = convertFileLineToIntArray("src/test/java/_456_132Pattern/sample1.input");
    printIntDoubleArray(testInputs);
  }
}
