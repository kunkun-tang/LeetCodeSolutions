package _456_132Pattern;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import utils.*;

public class SolutionTest {
  /** Test method for {@link _456_132Pattern.Solution } */
  Solution solution;
  int[][] inputs;

  @Rule
  public Timeout globalTimeout = new Timeout(300);

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
    inputs = FileUtils.convertFileLineToIntArray("src/test/java/_456_132Pattern/sample1.input");
  }

  @After
  public void tearDown() throws Exception {
    solution = null;
  }

  @Test
  public void Test1() {
    final int[] sampleInput1 = inputs[0];
    boolean output1 = solution.find132pattern(sampleInput1);
    assertTrue(output1 == false);
  }

  @Test
  public void Test2() {
    final int[] sampleInput2 = inputs[1];
    boolean output2 = solution.find132pattern(sampleInput2);
    assertTrue(output2 == false);
  }

  @Test
  public void Test3() {
    final int[] sampleInput3 = inputs[2];
    boolean output3 = solution.find132pattern(sampleInput3);
    assertTrue(output3 == true);
  }
}