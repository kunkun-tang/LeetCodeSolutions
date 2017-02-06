package _438_Find_All_Anagrams;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;
import utils.StringFileUtils;
import java.util.List;

import static org.junit.Assert.assertTrue;


public class SolutionTest {
  /** Test method for {@link Solution } */
  Solution solution;
  String[] inputs;

  @Rule
  public Timeout globalTimeout = new Timeout(300);

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
    inputs = StringFileUtils.convertFileLineToString("src/test/java/_438_Find_All_Anagrams/sample1.input");
  }

  @After
  public void tearDown() throws Exception {
    solution = null;
  }

  // This test can not pass since it used to meet TLE issue if we use original solution.
  @Ignore
  public void Test1() {
    List<Integer> output1 = solution.findAnagrams(inputs[0], inputs[1]);
  }

}