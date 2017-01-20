package _454_4Sum_II;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import utils.*;


public class SolutionTest {
  /** Test method for {@link _454_4Sum_II.Solution } */
  Solution solution;
  int[][] inputs;

  @Rule
  public Timeout globalTimeout = new Timeout(1000);

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
    inputs = FileUtils.convertFileLineToIntArray("src/test/java/_454_4Sum_II/sample1.input");
  }

  @After
  public void tearDown() throws Exception {
    solution = null;
  }

  @Test
  public void Test1() {
    final int[] A = inputs[0];
    final int[] B = inputs[1];
    final int[] C = inputs[2];
    final int[] D = inputs[3];
    int output1 = solution.fourSumCount(A, B, C, D);
    assertTrue(output1 == 17);
  }

  @Test
  public void Test2() {
    final int[] A = inputs[4];
    final int[] B = inputs[5];
    final int[] C = inputs[6];
    final int[] D = inputs[7];
    int output1 = solution.fourSumCount(A, B, C, D);
    assertTrue(output1 == 17);
  }

}
