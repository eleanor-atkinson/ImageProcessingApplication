import org.junit.Test;

import java.util.Arrays;

import model.Image;
import model.PPMImage;
import model.RGBPixel;
import model.TwentyFourBitPixel;

import static org.junit.Assert.assertEquals;

/**
 * Holds the tests for an PPM Image implementation of the Image interface.
 */
public class PPMImageTest {

  private PPMImage ppmImage;

  // tests the first constructor
  @Test
  public void testConstructorThatTakesPixels() {
    // constructing the UAE flag through pixels
    RGBPixel[][] pixels = new RGBPixel[3][4];
    pixels[0][0] = new TwentyFourBitPixel(255, 0, 0);
    pixels[0][1] = new TwentyFourBitPixel(0, 255, 0);
    pixels[0][2] = new TwentyFourBitPixel(0, 255, 0);
    pixels[0][3] = new TwentyFourBitPixel(0, 255, 0);
    pixels[1][0] = new TwentyFourBitPixel(255, 0, 0);
    pixels[1][1] = new TwentyFourBitPixel(255, 255, 255);
    pixels[1][2] = new TwentyFourBitPixel(255, 255, 255);
    pixels[1][3] = new TwentyFourBitPixel(255, 255, 255);
    pixels[2][0] = new TwentyFourBitPixel(255, 0, 0);
    pixels[2][1] = new TwentyFourBitPixel(0, 0, 0);
    pixels[2][2] = new TwentyFourBitPixel(0, 0, 0);
    pixels[2][3] = new TwentyFourBitPixel(0, 0, 0);

    this.ppmImage = new PPMImage(pixels);

    assertEquals("P3\n" +
            "4 3\n" +
            "255\n" +
            "255\n" +
            "0\n" +
            "0\n" +
            "0\n" +
            "255\n" +
            "0\n" +
            "0\n" +
            "255\n" +
            "0\n" +
            "0\n" +
            "255\n" +
            "0\n" +
            "255\n" +
            "0\n" +
            "0\n" +
            "255\n" +
            "255\n" +
            "255\n" +
            "255\n" +
            "255\n" +
            "255\n" +
            "255\n" +
            "255\n" +
            "255\n" +
            "255\n" +
            "0\n" +
            "0\n" +
            "0\n" +
            "0\n" +
            "0\n" +
            "0\n" +
            "0\n" +
            "0\n" +
            "0\n" +
            "0\n" +
            "0\n", this.ppmImage.toString());
  }

  // tests the first constructor when all the pixels are null
  @Test(expected = IllegalArgumentException.class)
  public void testConstructorThatTakesPixelsExceptionAllPixelsNull() {
    RGBPixel[][] pixels = new RGBPixel[2][2];
    pixels[0][0] = null;
    pixels[0][1] = null;
    pixels[1][0] = null;
    pixels[1][1] = null;
    this.ppmImage = new PPMImage(pixels);
  }

  // tests the first constructor when some pixels are null
  @Test(expected = IllegalArgumentException.class)
  public void testConstructorThatTakesPixelsExceptionSomePixelsNull() {
    RGBPixel[][] pixels = new RGBPixel[2][2];
    pixels[0][0] = new TwentyFourBitPixel();
    pixels[0][1] = new TwentyFourBitPixel();
    pixels[1][0] = null;
    pixels[1][1] = null;
    this.ppmImage = new PPMImage(pixels);
  }

  // tests the second constructor
  @Test
  public void testConstructorThatTakesFile() {
    this.ppmImage = new PPMImage("Images/UAEFlag.ppm");
    assertEquals("P3\n" +
            "4 3\n" +
            "255\n" +
            "255\n" +
            "0\n" +
            "0\n" +
            "0\n" +
            "255\n" +
            "0\n" +
            "0\n" +
            "255\n" +
            "0\n" +
            "0\n" +
            "255\n" +
            "0\n" +
            "255\n" +
            "0\n" +
            "0\n" +
            "255\n" +
            "255\n" +
            "255\n" +
            "255\n" +
            "255\n" +
            "255\n" +
            "255\n" +
            "255\n" +
            "255\n" +
            "255\n" +
            "0\n" +
            "0\n" +
            "0\n" +
            "0\n" +
            "0\n" +
            "0\n" +
            "0\n" +
            "0\n" +
            "0\n" +
            "0\n" +
            "0\n", this.ppmImage.toString());
  }

  // tests when the file is not found in the second constructor
  @Test(expected = IllegalArgumentException.class)
  public void testFileNameNotFound() {
    this.ppmImage = new PPMImage("FunDayAtTheBeach");
  }

  // tests the red component method
  @Test
  public void testRedComponent() {
    this.ppmImage = new PPMImage("Images/UAEFlag.ppm");
    Image redComponentUAE = this.ppmImage.redComponent();
    assertEquals("P3\n" +
            "4 3\n" +
            "255\n" +
            "255\n" +
            "255\n" +
            "255\n" +
            "0\n" +
            "0\n" +
            "0\n" +
            "0\n" +
            "0\n" +
            "0\n" +
            "0\n" +
            "0\n" +
            "0\n" +
            "255\n" +
            "255\n" +
            "255\n" +
            "255\n" +
            "255\n" +
            "255\n" +
            "255\n" +
            "255\n" +
            "255\n" +
            "255\n" +
            "255\n" +
            "255\n" +
            "255\n" +
            "255\n" +
            "255\n" +
            "0\n" +
            "0\n" +
            "0\n" +
            "0\n" +
            "0\n" +
            "0\n" +
            "0\n" +
            "0\n" +
            "0\n", redComponentUAE.toString());
  }

  // tests the green component method
  @Test
  public void testGreenComponent() {
    this.ppmImage = new PPMImage("Images/UAEFlag.ppm");
    Image greenComponentUAE = this.ppmImage.greenComponent();
    assertEquals("P3\n" +
            "4 3\n" +
            "255\n" +
            "0\n" +
            "0\n" +
            "0\n" +
            "255\n" +
            "255\n" +
            "255\n" +
            "255\n" +
            "255\n" +
            "255\n" +
            "255\n" +
            "255\n" +
            "255\n" +
            "0\n" +
            "0\n" +
            "0\n" +
            "255\n" +
            "255\n" +
            "255\n" +
            "255\n" +
            "255\n" +
            "255\n" +
            "255\n" +
            "255\n" +
            "255\n" +
            "0\n" +
            "0\n" +
            "0\n" +
            "0\n" +
            "0\n" +
            "0\n" +
            "0\n" +
            "0\n" +
            "0\n" +
            "0\n" +
            "0\n" +
            "0\n", greenComponentUAE.toString());
  }

  // tests the blue component method
  @Test
  public void testBlueComponent() {
    this.ppmImage = new PPMImage("Images/UAEFlag.ppm");
    Image blueComponentUAE = this.ppmImage.blueComponent();
    assertEquals("P3\n" +
            "4 3\n" +
            "255\n" +
            "0\n" +
            "0\n" +
            "0\n" +
            "0\n" +
            "0\n" +
            "0\n" +
            "0\n" +
            "0\n" +
            "0\n" +
            "0\n" +
            "0\n" +
            "0\n" +
            "0\n" +
            "0\n" +
            "0\n" +
            "255\n" +
            "255\n" +
            "255\n" +
            "255\n" +
            "255\n" +
            "255\n" +
            "255\n" +
            "255\n" +
            "255\n" +
            "0\n" +
            "0\n" +
            "0\n" +
            "0\n" +
            "0\n" +
            "0\n" +
            "0\n" +
            "0\n" +
            "0\n" +
            "0\n" +
            "0\n" +
            "0\n", blueComponentUAE.toString());
  }

  // tests the value method
  @Test
  public void testValue() {
    this.ppmImage = new PPMImage("Images/UAEFlag.ppm");
    Image valueUAE = this.ppmImage.value();
    assertEquals("P3\n" +
            "4 3\n" +
            "255\n" +
            "255\n" +
            "255\n" +
            "255\n" +
            "255\n" +
            "255\n" +
            "255\n" +
            "255\n" +
            "255\n" +
            "255\n" +
            "255\n" +
            "255\n" +
            "255\n" +
            "255\n" +
            "255\n" +
            "255\n" +
            "255\n" +
            "255\n" +
            "255\n" +
            "255\n" +
            "255\n" +
            "255\n" +
            "255\n" +
            "255\n" +
            "255\n" +
            "255\n" +
            "255\n" +
            "255\n" +
            "0\n" +
            "0\n" +
            "0\n" +
            "0\n" +
            "0\n" +
            "0\n" +
            "0\n" +
            "0\n" +
            "0\n", valueUAE.toString());
  }

  // tests the intensity method
  @Test
  public void testIntensity() {
    this.ppmImage = new PPMImage("Images/UAEFlag.ppm");
    Image intensityUAE = this.ppmImage.intensity();
    assertEquals("P3\n" +
            "4 3\n" +
            "255\n" +
            "85\n" +
            "85\n" +
            "85\n" +
            "85\n" +
            "85\n" +
            "85\n" +
            "85\n" +
            "85\n" +
            "85\n" +
            "85\n" +
            "85\n" +
            "85\n" +
            "85\n" +
            "85\n" +
            "85\n" +
            "255\n" +
            "255\n" +
            "255\n" +
            "255\n" +
            "255\n" +
            "255\n" +
            "255\n" +
            "255\n" +
            "255\n" +
            "85\n" +
            "85\n" +
            "85\n" +
            "0\n" +
            "0\n" +
            "0\n" +
            "0\n" +
            "0\n" +
            "0\n" +
            "0\n" +
            "0\n" +
            "0\n", intensityUAE.toString());
  }

  // tests the luma method
  @Test
  public void testLuma() {
    this.ppmImage = new PPMImage("Images/UAEFlag.ppm");
    Image lumaUAE = this.ppmImage.luma();
    assertEquals("P3\n" +
            "4 3\n" +
            "255\n" +
            "55\n" +
            "55\n" +
            "55\n" +
            "183\n" +
            "183\n" +
            "183\n" +
            "183\n" +
            "183\n" +
            "183\n" +
            "183\n" +
            "183\n" +
            "183\n" +
            "55\n" +
            "55\n" +
            "55\n" +
            "255\n" +
            "255\n" +
            "255\n" +
            "255\n" +
            "255\n" +
            "255\n" +
            "255\n" +
            "255\n" +
            "255\n" +
            "55\n" +
            "55\n" +
            "55\n" +
            "0\n" +
            "0\n" +
            "0\n" +
            "0\n" +
            "0\n" +
            "0\n" +
            "0\n" +
            "0\n" +
            "0\n", lumaUAE.toString());
  }

  // tests the flip horizontal method
  @Test
  public void testFlipHorizontal() {
    this.ppmImage = new PPMImage("Images/UAEFlag.ppm");
    Image horizontalUAE = this.ppmImage.flipHorizontal();
    assertEquals("P3\n" +
            "4 3\n" +
            "255\n" +
            "0\n" +
            "255\n" +
            "0\n" +
            "0\n" +
            "255\n" +
            "0\n" +
            "0\n" +
            "255\n" +
            "0\n" +
            "255\n" +
            "0\n" +
            "0\n" +
            "255\n" +
            "255\n" +
            "255\n" +
            "255\n" +
            "255\n" +
            "255\n" +
            "255\n" +
            "255\n" +
            "255\n" +
            "255\n" +
            "0\n" +
            "0\n" +
            "0\n" +
            "0\n" +
            "0\n" +
            "0\n" +
            "0\n" +
            "0\n" +
            "0\n" +
            "0\n" +
            "0\n" +
            "255\n" +
            "0\n" +
            "0\n", horizontalUAE.toString());
  }

  // tests the flip vertical method
  @Test
  public void testFlipVertical() {
    this.ppmImage = new PPMImage("Images/UAEFlag.ppm");
    Image verticalUAE = this.ppmImage.flipVertical();
    assertEquals("P3\n" +
            "4 3\n" +
            "255\n" +
            "255\n" +
            "0\n" +
            "0\n" +
            "0\n" +
            "0\n" +
            "0\n" +
            "0\n" +
            "0\n" +
            "0\n" +
            "0\n" +
            "0\n" +
            "0\n" +
            "255\n" +
            "0\n" +
            "0\n" +
            "255\n" +
            "255\n" +
            "255\n" +
            "255\n" +
            "255\n" +
            "255\n" +
            "255\n" +
            "255\n" +
            "255\n" +
            "255\n" +
            "0\n" +
            "0\n" +
            "0\n" +
            "255\n" +
            "0\n" +
            "0\n" +
            "255\n" +
            "0\n" +
            "0\n" +
            "255\n" +
            "0\n", verticalUAE.toString());
  }

  // tests the contrast method with darkening the image
  @Test
  public void testContrastDarken() {
    this.ppmImage = new PPMImage("Images/UAEFlag.ppm");
    Image darkenUAE = this.ppmImage.contrast(-30);
    assertEquals("P3\n" +
            "4 3\n" +
            "225\n" +
            "225\n" +
            "0\n" +
            "0\n" +
            "0\n" +
            "225\n" +
            "0\n" +
            "0\n" +
            "225\n" +
            "0\n" +
            "0\n" +
            "225\n" +
            "0\n" +
            "225\n" +
            "0\n" +
            "0\n" +
            "225\n" +
            "225\n" +
            "225\n" +
            "225\n" +
            "225\n" +
            "225\n" +
            "225\n" +
            "225\n" +
            "225\n" +
            "225\n" +
            "0\n" +
            "0\n" +
            "0\n" +
            "0\n" +
            "0\n" +
            "0\n" +
            "0\n" +
            "0\n" +
            "0\n" +
            "0\n" +
            "0\n", darkenUAE.toString());
  }

  // tests the transform method
  @Test
  public void testTransform() {
    this.ppmImage = new PPMImage("Images/UAEFlag.ppm");
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
    Image transformationUAE = this.ppmImage.transformation(matrix);
    assertEquals("P3\n" +
            "4 3\n" +
            "255\n" +
            "55\n" +
            "55\n" +
            "55\n" +
            "183\n" +
            "183\n" +
            "183\n" +
            "183\n" +
            "183\n" +
            "183\n" +
            "183\n" +
            "183\n" +
            "183\n" +
            "55\n" +
            "55\n" +
            "55\n" +
            "255\n" +
            "255\n" +
            "255\n" +
            "255\n" +
            "255\n" +
            "255\n" +
            "255\n" +
            "255\n" +
            "255\n" +
            "55\n" +
            "55\n" +
            "55\n" +
            "0\n" +
            "0\n" +
            "0\n" +
            "0\n" +
            "0\n" +
            "0\n" +
            "0\n" +
            "0\n" +
            "0\n", transformationUAE.toString());
  }

  // tests the contrast method with lightening the image
  @Test
  public void testContrastLighten() {
    this.ppmImage = new PPMImage("Images/UAEFlag.ppm");
    Image lightenUAE = this.ppmImage.contrast(70);
    assertEquals("P3\n" +
            "4 3\n" +
            "255\n" +
            "255\n" +
            "70\n" +
            "70\n" +
            "70\n" +
            "255\n" +
            "70\n" +
            "70\n" +
            "255\n" +
            "70\n" +
            "70\n" +
            "255\n" +
            "70\n" +
            "255\n" +
            "70\n" +
            "70\n" +
            "255\n" +
            "255\n" +
            "255\n" +
            "255\n" +
            "255\n" +
            "255\n" +
            "255\n" +
            "255\n" +
            "255\n" +
            "255\n" +
            "70\n" +
            "70\n" +
            "70\n" +
            "70\n" +
            "70\n" +
            "70\n" +
            "70\n" +
            "70\n" +
            "70\n" +
            "70\n" +
            "70\n", lightenUAE.toString());
  }

  // tests the to string method using the second constructor
  @Test
  public void testToString() {
    this.ppmImage = new PPMImage("Images/UAEFlag.ppm");
    assertEquals("P3\n" +
            "4 3\n" +
            "255\n" +
            "255\n" +
            "0\n" +
            "0\n" +
            "0\n" +
            "255\n" +
            "0\n" +
            "0\n" +
            "255\n" +
            "0\n" +
            "0\n" +
            "255\n" +
            "0\n" +
            "255\n" +
            "0\n" +
            "0\n" +
            "255\n" +
            "255\n" +
            "255\n" +
            "255\n" +
            "255\n" +
            "255\n" +
            "255\n" +
            "255\n" +
            "255\n" +
            "255\n" +
            "0\n" +
            "0\n" +
            "0\n" +
            "0\n" +
            "0\n" +
            "0\n" +
            "0\n" +
            "0\n" +
            "0\n" +
            "0\n" +
            "0\n", this.ppmImage.toString());
  }

  // tests the to string method using the first constructor
  @Test
  public void testToStringFirstConstructor() {
    // constructing the UAE flag through pixels
    RGBPixel[][] pixels = new RGBPixel[3][4];
    pixels[0][0] = new TwentyFourBitPixel(255, 0, 0);
    pixels[0][1] = new TwentyFourBitPixel(0, 255, 0);
    pixels[0][2] = new TwentyFourBitPixel(0, 255, 0);
    pixels[0][3] = new TwentyFourBitPixel(0, 255, 0);
    pixels[1][0] = new TwentyFourBitPixel(255, 0, 0);
    pixels[1][1] = new TwentyFourBitPixel(255, 255, 255);
    pixels[1][2] = new TwentyFourBitPixel(255, 255, 255);
    pixels[1][3] = new TwentyFourBitPixel(255, 255, 255);
    pixels[2][0] = new TwentyFourBitPixel(255, 0, 0);
    pixels[2][1] = new TwentyFourBitPixel(0, 0, 0);
    pixels[2][2] = new TwentyFourBitPixel(0, 0, 0);
    pixels[2][3] = new TwentyFourBitPixel(0, 0, 0);

    this.ppmImage = new PPMImage(pixels);

    assertEquals("P3\n" +
            "4 3\n" +
            "255\n" +
            "255\n" +
            "0\n" +
            "0\n" +
            "0\n" +
            "255\n" +
            "0\n" +
            "0\n" +
            "255\n" +
            "0\n" +
            "0\n" +
            "255\n" +
            "0\n" +
            "255\n" +
            "0\n" +
            "0\n" +
            "255\n" +
            "255\n" +
            "255\n" +
            "255\n" +
            "255\n" +
            "255\n" +
            "255\n" +
            "255\n" +
            "255\n" +
            "255\n" +
            "0\n" +
            "0\n" +
            "0\n" +
            "0\n" +
            "0\n" +
            "0\n" +
            "0\n" +
            "0\n" +
            "0\n" +
            "0\n" +
            "0\n", this.ppmImage.toString());
  }

  @Test
  public void testGetHeight() {
    this.ppmImage = new PPMImage("Images/UAEFlag.ppm");
    assertEquals(3, this.ppmImage.getHeight());
  }

  @Test
  public void testGetWidth() {
    this.ppmImage = new PPMImage("Images/UAEFlag.ppm");
    assertEquals(4, this.ppmImage.getWidth());
  }

  @Test
  public void testGetPixels() {
    RGBPixel[][] pixels = new RGBPixel[3][4];
    pixels[0][0] = new TwentyFourBitPixel(255, 0, 0);
    pixels[0][1] = new TwentyFourBitPixel(0, 255, 0);
    pixels[0][2] = new TwentyFourBitPixel(0, 255, 0);
    pixels[0][3] = new TwentyFourBitPixel(0, 255, 0);
    pixels[1][0] = new TwentyFourBitPixel(255, 0, 0);
    pixels[1][1] = new TwentyFourBitPixel(255, 255, 255);
    pixels[1][2] = new TwentyFourBitPixel(255, 255, 255);
    pixels[1][3] = new TwentyFourBitPixel(255, 255, 255);
    pixels[2][0] = new TwentyFourBitPixel(255, 0, 0);
    pixels[2][1] = new TwentyFourBitPixel(0, 0, 0);
    pixels[2][2] = new TwentyFourBitPixel(0, 0, 0);
    pixels[2][3] = new TwentyFourBitPixel(0, 0, 0);

    this.ppmImage = new PPMImage(pixels);

    RGBPixel[][] resultingPixels = this.ppmImage.getPixels();

    assertEquals(true, Arrays.equals(pixels, resultingPixels));
  }

}