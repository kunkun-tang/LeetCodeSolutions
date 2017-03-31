package _341_Flatten_Nested_Iterator;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

interface NestedInteger {
public boolean isInteger();

public Integer getInteger();

// @return the nested list that this NestedInteger holds, if it holds a nested list
// Return null if this NestedInteger holds a single integer
public List<NestedInteger> getList();
}

public class NestedIterator implements Iterator<Integer> {

  private List<Integer> nestedList;
  private int index = 0;

  public NestedIterator(List<NestedInteger> nestedList) {
    this.nestedList = new ArrayList<Integer>();
    consolidate(nestedList);
  }

  @Override
  public Integer next() {
    Integer curr = nestedList.get(index);
    index ++;
    return curr;
  }

  @Override
  public boolean hasNext() {
    return nestedList.size() > 0 && index < nestedList.size();
  }

  public void consolidate(List<NestedInteger> listNI) {

    for(NestedInteger ni : listNI) {
      if(ni.isInteger()) {
        this.nestedList.add(ni.getInteger());
      }
      else {
        consolidate(ni.getList());
      }
    }
  }
}
