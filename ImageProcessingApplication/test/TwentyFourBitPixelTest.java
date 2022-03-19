import org.junit.Test;

import java.util.Arrays;

import model.TwentyFourBitPixel;

import static org.junit.Assert.assertEquals;

/**
 * Holds the tests for the Pixel implementation for the TwentyFourBitPixel class.
 */
public class TwentyFourBitPixelTest {

  private TwentyFourBitPixel twentyFourBitPixel;

  // tests the to string method using the default constructor
  @Test
  public void testToStringDefaultConstructor() {
    this.twentyFourBitPixel = new TwentyFourBitPixel();
    assertEquals("0\n0\n0\n", twentyFourBitPixel.toString());
  }

  // tests the to string method using the second constructor
  @Test
  public void testToStringRed() {
    this.twentyFourBitPixel = new TwentyFourBitPixel(255, 0, 0);
    assertEquals("255\n0\n0\n", twentyFourBitPixel.toString());
  }

  // tests the default constructor
  @Test
  public void testDefaultConstructor() {
    this.twentyFourBitPixel = new TwentyFourBitPixel();
    assertEquals("0\n0\n0\n", twentyFourBitPixel.toString());
  }

  // tests the second constructor
  @Test
  public void testRGBConstructor() {
    this.twentyFourBitPixel = new TwentyFourBitPixel(179, 87, 182);
    assertEquals("179\n87\n182\n", twentyFourBitPixel.toString());
  }

  // tests the second constructor with an illegal red value (negative)
  @Test(expected = IllegalArgumentException.class)
  public void testIllegalRedNegConstructor() {
    this.twentyFourBitPixel = new TwentyFourBitPixel(-1, 0, 0);
  }

  // tests the second constructor with an illegal red value (>255)
  @Test(expected = IllegalArgumentException.class)
  public void testIllegalRedTooBigConstructor() {
    this.twentyFourBitPixel = new TwentyFourBitPixel(256, 0, 0);
  }

  // tests the second constructor with an illegal green value (negative)
  @Test(expected = IllegalArgumentException.class)
  public void testIllegalGreenNegConstructor() {
    this.twentyFourBitPixel = new TwentyFourBitPixel(0, -5, 0);
  }

  // tests the second constructor with an illegal green value (>255)
  @Test(expected = IllegalArgumentException.class)
  public void testIllegalGreenTooBigConstructor() {
    this.twentyFourBitPixel = new TwentyFourBitPixel(0, 300, 0);
  }

  // tests the second constructor with an illegal blue value (negative)
  @Test(expected = IllegalArgumentException.class)
  public void testIllegalBlueNegConstructor() {
    this.twentyFourBitPixel = new TwentyFourBitPixel(0, 0, -300);
  }

  // tests the second constructor with an illegal blue value (>255)
  @Test(expected = IllegalArgumentException.class)
  public void testIllegalBlueTooBigConstructor() {
    this.twentyFourBitPixel = new TwentyFourBitPixel(0, 0, 259);
  }

  // tests darkening the pixel when the red value is 0
  @Test
  public void testDarkenPixelRedZero() {
    this.twentyFourBitPixel = new TwentyFourBitPixel(0, 255, 255);
    this.twentyFourBitPixel.contrast(-30);
    assertEquals("0\n225\n225\n", this.twentyFourBitPixel.toString());
  }

  // tests darkening the pixel when the green value is 0
  @Test
  public void testDarkenPixelGreenZero() {
    this.twentyFourBitPixel = new TwentyFourBitPixel(255, 0, 255);
    this.twentyFourBitPixel.contrast(-30);
    assertEquals("225\n0\n225\n", this.twentyFourBitPixel.toString());
  }

  // tests darkening the pixel when the blue value is 0
  @Test
  public void testDarkenPixelBlueZero() {
    this.twentyFourBitPixel = new TwentyFourBitPixel(255, 230, 0);
    this.twentyFourBitPixel.contrast(-30);
    assertEquals("225\n200\n0\n", this.twentyFourBitPixel.toString());
  }

  // tests lightening the pixel when the red value is 255
  @Test
  public void testLightenPixelRed255() {
    this.twentyFourBitPixel = new TwentyFourBitPixel(255, 0, 100);
    this.twentyFourBitPixel.contrast(60);
    assertEquals("255\n60\n160\n", this.twentyFourBitPixel.toString());
  }

  // tests lightening the pixel when the green value is 255
  @Test
  public void testLightenPixelGreen255() {
    this.twentyFourBitPixel = new TwentyFourBitPixel(50, 255, 100);
    this.twentyFourBitPixel.contrast(60);
    assertEquals("110\n255\n160\n", this.twentyFourBitPixel.toString());
  }

  // tests lightening the pixel when the blue value is 255
  @Test
  public void testLightenPixelBlue255() {
    this.twentyFourBitPixel = new TwentyFourBitPixel(50, 200, 255);
    this.twentyFourBitPixel.contrast(70);
    assertEquals("120\n255\n255\n", this.twentyFourBitPixel.toString());
  }

  // tests the get max value method when red is the max
  @Test
  public void testGetMaxValueRedMax() {
    this.twentyFourBitPixel = new TwentyFourBitPixel(200, 50, 50);
    assertEquals(200, this.twentyFourBitPixel.getMaxValue());
  }

  // tests the get max value method when blue is the max
  @Test
  public void testGetMaxValueBlueMax() {
    this.twentyFourBitPixel = new TwentyFourBitPixel(0, 50, 0);
    assertEquals(50, this.twentyFourBitPixel.getMaxValue());
  }

  // tests the get max value method when green is the max
  @Test
  public void testGetMaxValueGreenMax() {
    this.twentyFourBitPixel = new TwentyFourBitPixel(0, 0, 2);
    assertEquals(2, this.twentyFourBitPixel.getMaxValue());
  }

  // tests the get max value method when all RGB values are the same
  @Test
  public void testGetMaxValueAllSame() {
    this.twentyFourBitPixel = new TwentyFourBitPixel(4, 4, 4);
    assertEquals(4, this.twentyFourBitPixel.getMaxValue());
  }

  // tests the get max value method when red and green values are the same
  @Test
  public void testGetMaxValueRGSame() {
    this.twentyFourBitPixel = new TwentyFourBitPixel(4, 4, 0);
    assertEquals(4, this.twentyFourBitPixel.getMaxValue());
  }

  // tests the get max value method when red and blue values are the same
  @Test
  public void testGetMaxValueRBSame() {
    this.twentyFourBitPixel = new TwentyFourBitPixel(4, 0, 4);
    assertEquals(4, this.twentyFourBitPixel.getMaxValue());
  }

  // tests the get max value method when green and blue values are the same
  @Test
  public void testGetMaxValueGBSame() {
    this.twentyFourBitPixel = new TwentyFourBitPixel(0, 1, 1);
    assertEquals(1, this.twentyFourBitPixel.getMaxValue());
  }

  // tests the value method when the max value is red
  @Test
  public void testValueMaxRed() {
    this.twentyFourBitPixel = new TwentyFourBitPixel(255, 0, 0);
    this.twentyFourBitPixel.value();
    assertEquals("255\n255\n255\n", this.twentyFourBitPixel.toString());
  }

  // tests the value method when the max value is green
  @Test
  public void testValueMaxGreen() {
    this.twentyFourBitPixel = new TwentyFourBitPixel(9, 60, 11);
    this.twentyFourBitPixel.value();
    assertEquals("60\n60\n60\n", this.twentyFourBitPixel.toString());
  }

  // tests the value method when the max value is blue
  @Test
  public void testValueMaxBlue() {
    this.twentyFourBitPixel = new TwentyFourBitPixel(9, 60, 90);
    this.twentyFourBitPixel.value();
    assertEquals("90\n90\n90\n", this.twentyFourBitPixel.toString());
  }

  // tests the value method when all RGB values are the same
  @Test
  public void testValueAllMax() {
    this.twentyFourBitPixel = new TwentyFourBitPixel(90, 90, 90);
    this.twentyFourBitPixel.value();
    assertEquals("90\n90\n90\n", this.twentyFourBitPixel.toString());
  }

  // tests the intensity method
  @Test
  public void testIntensity() {
    this.twentyFourBitPixel = new TwentyFourBitPixel(59, 0, 3);
    this.twentyFourBitPixel.intensity();
    assertEquals("21\n21\n21\n", this.twentyFourBitPixel.toString());
  }

  // tests the luma method
  @Test
  public void testLuma() {
    this.twentyFourBitPixel = new TwentyFourBitPixel(255, 0, 255);
    this.twentyFourBitPixel.luma();
    assertEquals("73\n73\n73\n", this.twentyFourBitPixel.toString());
  }

  // tests the red component method
  @Test
  public void testRedComponent() {
    this.twentyFourBitPixel = new TwentyFourBitPixel(30, 70, 90);
    this.twentyFourBitPixel.redComponent();
    assertEquals("30\n30\n30\n", this.twentyFourBitPixel.toString());
  }

  // tests the green component method
  @Test
  public void testGreenComponent() {
    this.twentyFourBitPixel = new TwentyFourBitPixel(50, 40, 40);
    this.twentyFourBitPixel.greenComponent();
    assertEquals("40\n40\n40\n", this.twentyFourBitPixel.toString());
  }

  // tests the green component method where all values are equal
  @Test
  public void testGreenComponentAllSame() {
    this.twentyFourBitPixel = new TwentyFourBitPixel(40, 40, 40);
    this.twentyFourBitPixel.greenComponent();
    assertEquals("40\n40\n40\n", this.twentyFourBitPixel.toString());
  }

  // tests the blue component method
  @Test
  public void testBlueComponent() {
    this.twentyFourBitPixel = new TwentyFourBitPixel(1, 90, 0);
    this.twentyFourBitPixel.blueComponent();
    assertEquals("0\n0\n0\n", this.twentyFourBitPixel.toString());
  }

  // tests the get components method
  @Test
  public void testGetComponents() {
    this.twentyFourBitPixel = new TwentyFourBitPixel();
    int[] intArray = new int[]{0, 0, 0};
    int[] componentsArray = twentyFourBitPixel.getComponents();
    assertEquals(true, Arrays.equals(intArray, componentsArray));
  }

  // testing transformation method illegal argument exception
  @Test(expected = IllegalArgumentException.class)
  public void testTransformationIllegalMatrix() {
    this.twentyFourBitPixel = new TwentyFourBitPixel(255, 0, 0);
    double[][] matrix = new double[4][4];
    this.twentyFourBitPixel.transformation(matrix);
  }

  // testing the transformation method
  @Test
  public void testTransformation() {
    this.twentyFourBitPixel = new TwentyFourBitPixel();
    double[][] matrix = new double[3][3];
    matrix[0][0] = 0.2126;
    matrix[0][1] = 0.7152;
    matrix[0][2] = 0.0722;
    matrix[1][0] = 0.2126;
    matrix[1][1] = 0.7152;
    matrix[1][2] = 0.0722;
    matrix[2][0] = 0.2126;
    matrix[2][1] = 0.7152;
    matrix[2][2] = 0.0722;
    this.twentyFourBitPixel.transformation(matrix);
    assertEquals("0\n" +
            "0\n" +
            "0\n", this.twentyFourBitPixel.toString());
  }
}