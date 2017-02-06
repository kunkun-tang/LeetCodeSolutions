package utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class StringFileUtils {

  public static final String[] convertFileLineToString(String path) {
    try{

      String[] stringArray = Files.lines(Paths.get(path))
          .map(s -> s.substring(1, s.length()-1))
          .toArray(String[]::new);

      return stringArray;
    } catch (IOException e) {
      e.printStackTrace();
    }
    return null;
  }

  public static void main(String[] arr) {
    String[] testInputs = convertFileLineToString("src/test/java/_456_132Pattern/sample1.input");
  }
}
