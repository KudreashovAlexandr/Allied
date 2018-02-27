import org.testng.Assert;
import org.testng.annotations.Test;

public class MainTest {
  @Test
  public void selectionSort() {
	  int arrayExpected[] = {0, 1, 2, 4, 4, 7, 7, 8, 13};
	  int arrayActual[] = new int[9];
	  for (int i = 0; i < 9; i++) {
		  arrayActual[i] = Main.getSortedArray(i);
	  }
	  Assert.assertEquals(arrayActual, arrayExpected);;
  }
}
