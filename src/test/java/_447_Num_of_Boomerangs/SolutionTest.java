package _447_Num_of_Boomerangs;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;
import utils.FileUtils;

import static org.junit.Assert.assertTrue;


public class SolutionTest {
  /** Test method for {@link Solution } */
  Solution solution;
  int[][] inputs;

  @Rule
  public Timeout globalTimeout = new Timeout(1000);

  @Before
  public void setUp() throws Exception {
    solution = new Solution();

    inputs = FileUtils.convertFileLineToIntArray("src/test/java/_447_Num_of_Boomerangs/sample1.input");
  }

  @After
  public void tearDown() throws Exception {
    solution = null;
  }

  @Test @Ignore
  public void Test1() {
    int output1 = solution.numberOfBoomerangs(inputs);
    assertTrue(output1 == 17);
  }

}
