package pizza;

import java.util.Comparator;

public class MenuItemPriceComparator implements Comparator<MenuItem> {
  @Override
  public int compare(MenuItem item1, MenuItem item2) {
    return Double.compare(item1.getPrice(), item2.getPrice());
  }

  public int compareTo(MenuItem item1, MenuItem item2) {
    return compare(item1, item2);
  }
}