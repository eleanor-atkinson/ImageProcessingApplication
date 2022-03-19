import model.PPMImage;

import org.junit.Test;


import model.ImageProcessor;
import model.PPMImageProcessor;


import static org.junit.Assert.assertEquals;

/**
 * Test class for PPMImageProcessor.
 */
public class PPMImageProcessorTest {

  private PPMImage ppmImage;

  //tests the model's methods
  @Test
  public void testModel() {
    // need original UAEflag.ppm

    ImageProcessor model = new PPMImageProcessor();
    model.load(new PPMImage("res/UAEflag.ppm"), "flag");
    assertEquals("P3\n"
            + "4 3\n"
            + "255\n"
            + "255\n"
            + "0\n"
            + "0\n"
            + "0\n"
            + "255\n"
            + "0\n"
            + "0\n"
            + "255\n"
            + "0\n"
            + "0\n"
            + "255\n"
            + "0\n"
            + "255\n"
            + "0\n"
            + "0\n"
            + "255\n"
            + "255\n"
            + "255\n"
            + "255\n"
            + "255\n"
            + "255\n"
            + "255\n"
            + "255\n"
            + "255\n"
            + "255\n"
            + "0\n"
            + "0\n"
            + "0\n"
            + "0\n"
            + "0\n"
            + "0\n"
            + "0\n"
            + "0\n"
            + "0\n"
            + "0\n"
            + "0\n", model.getImage("flag").toString());
    model.redComponent("flag", "rflag");
    assertEquals("P3\n"
            + "4 3\n"
            + "255\n"
            + "255\n"
            + "255\n"
            + "255\n"
            + "0\n"
            + "0\n"
            + "0\n"
            + "0\n"
            + "0\n"
            + "0\n"
            + "0\n"
            + "0\n"
            + "0\n"
            + "255\n"
            + "255\n"
            + "255\n"
            + "255\n"
            + "255\n"
            + "255\n"
            + "255\n"
            + "255\n"
            + "255\n"
            + "255\n"
            + "255\n"
            + "255\n"
            + "255\n"
            + "255\n"
            + "255\n"
            + "0\n"
            + "0\n"
            + "0\n"
            + "0\n"
            + "0\n"
            + "0\n"
            + "0\n"
            + "0\n"
            + "0\n", model.getImage("rflag").toString());
    model.greenComponent("flag", "gflag");
    assertEquals("P3\n"
            + "4 3\n"
            + "255\n"
            + "255\n"
            + "255\n"
            + "255\n"
            + "0\n"
            + "0\n"
            + "0\n"
            + "0\n"
            + "0\n"
            + "0\n"
            + "0\n"
            + "0\n"
            + "0\n"
            + "255\n"
            + "255\n"
            + "255\n"
            + "255\n"
            + "255\n"
            + "255\n"
            + "255\n"
            + "255\n"
            + "255\n"
            + "255\n"
            + "255\n"
            + "255\n"
            + "255\n"
            + "255\n"
            + "255\n"
            + "0\n"
            + "0\n"
            + "0\n"
            + "0\n"
            + "0\n"
            + "0\n"
            + "0\n"
            + "0\n"
            + "0\n", model.getImage("gflag").toString());
    model.blueComponent("flag", "blueflag");
    assertEquals("P3\n"
            + "4 3\n"
            + "255\n"
            + "255\n"
            + "255\n"
            + "255\n"
            + "0\n"
            + "0\n"
            + "0\n"
            + "0\n"
            + "0\n"
            + "0\n"
            + "0\n"
            + "0\n"
            + "0\n"
            + "255\n"
            + "255\n"
            + "255\n"
            + "255\n"
            + "255\n"
            + "255\n"
            + "255\n"
            + "255\n"
            + "255\n"
            + "255\n"
            + "255\n"
            + "255\n"
            + "255\n"
            + "255\n"
            + "255\n"
            + "0\n"
            + "0\n"
            + "0\n"
            + "0\n"
            + "0\n"
            + "0\n"
            + "0\n"
            + "0\n"
            + "0\n", model.getImage("blueflag").toString());
    model.horizontalFlip("flag", "hflag");
    assertEquals("P3\n"
            + "4 3\n"
            + "255\n"
            + "0\n"
            + "0\n"
            + "0\n"
            + "0\n"
            + "0\n"
            + "0\n"
            + "0\n"
            + "0\n"
            + "0\n"
            + "255\n"
            + "255\n"
            + "255\n"
            + "255\n"
            + "255\n"
            + "255\n"
            + "255\n"
            + "255\n"
            + "255\n"
            + "255\n"
            + "255\n"
            + "255\n"
            + "255\n"
            + "255\n"
            + "255\n"
            + "0\n"
            + "0\n"
            + "0\n"
            + "0\n"
            + "0\n"
            + "0\n"
            + "0\n"
            + "0\n"
            + "0\n"
            + "255\n"
            + "255\n"
            + "255\n", model.getImage("hflag").toString());
    model.verticalFlip("flag", "vflag");
    assertEquals("P3\n"
            + "4 3\n"
            + "255\n"
            + "255\n"
            + "255\n"
            + "255\n"
            + "0\n"
            + "0\n"
            + "0\n"
            + "0\n"
            + "0\n"
            + "0\n"
            + "0\n"
            + "0\n"
            + "0\n"
            + "255\n"
            + "255\n"
            + "255\n"
            + "255\n"
            + "255\n"
            + "255\n"
            + "255\n"
            + "255\n"
            + "255\n"
            + "255\n"
            + "255\n"
            + "255\n"
            + "255\n"
            + "255\n"
            + "255\n"
            + "0\n"
            + "0\n"
            + "0\n"
            + "0\n"
            + "0\n"
            + "0\n"
            + "0\n"
            + "0\n"
            + "0\n", model.getImage("vflag").toString());
    model.lumaComponent("flag", "lumaflag");
    assertEquals("P3\n"
            + "4 3\n"
            + "255\n"
            + "255\n"
            + "255\n"
            + "255\n"
            + "0\n"
            + "0\n"
            + "0\n"
            + "0\n"
            + "0\n"
            + "0\n"
            + "0\n"
            + "0\n"
            + "0\n"
            + "255\n"
            + "255\n"
            + "255\n"
            + "255\n"
            + "255\n"
            + "255\n"
            + "255\n"
            + "255\n"
            + "255\n"
            + "255\n"
            + "255\n"
            + "255\n"
            + "255\n"
            + "255\n"
            + "255\n"
            + "0\n"
            + "0\n"
            + "0\n"
            + "0\n"
            + "0\n"
            + "0\n"
            + "0\n"
            + "0\n"
            + "0\n", model.getImage("lumaflag").toString());
    model.valueComponent("flag", "valueflag");
    assertEquals("P3\n"
            + "4 3\n"
            + "255\n"
            + "255\n"
            + "255\n"
            + "255\n"
            + "0\n"
            + "0\n"
            + "0\n"
            + "0\n"
            + "0\n"
            + "0\n"
            + "0\n"
            + "0\n"
            + "0\n"
            + "255\n"
            + "255\n"
            + "255\n"
            + "255\n"
            + "255\n"
            + "255\n"
            + "255\n"
            + "255\n"
            + "255\n"
            + "255\n"
            + "255\n"
            + "255\n"
            + "255\n"
            + "255\n"
            + "255\n"
            + "0\n"
            + "0\n"
            + "0\n"
            + "0\n"
            + "0\n"
            + "0\n"
            + "0\n"
            + "0\n"
            + "0\n", model.getImage("valueflag").toString());
    model.intensityComponent("flag", "iflag");
    assertEquals("P3\n"
            + "4 3\n"
            + "255\n"
            + "255\n"
            + "255\n"
            + "255\n"
            + "0\n"
            + "0\n"
            + "0\n"
            + "0\n"
            + "0\n"
            + "0\n"
            + "0\n"
            + "0\n"
            + "0\n"
            + "255\n"
            + "255\n"
            + "255\n"
            + "255\n"
            + "255\n"
            + "255\n"
            + "255\n"
            + "255\n"
            + "255\n"
            + "255\n"
            + "255\n"
            + "255\n"
            + "255\n"
            + "255\n"
            + "255\n"
            + "0\n"
            + "0\n"
            + "0\n"
            + "0\n"
            + "0\n"
            + "0\n"
            + "0\n"
            + "0\n"
            + "0\n", model.getImage("iflag").toString());
    model.contrast("flag", "contrastflag", 10);
    assertEquals("P3\n"
            + "4 3\n"
            + "255\n"
            + "255\n"
            + "255\n"
            + "255\n"
            + "10\n"
            + "10\n"
            + "10\n"
            + "10\n"
            + "10\n"
            + "10\n"
            + "10\n"
            + "10\n"
            + "10\n"
            + "255\n"
            + "255\n"
            + "255\n"
            + "255\n"
            + "255\n"
            + "255\n"
            + "255\n"
            + "255\n"
            + "255\n"
            + "255\n"
            + "255\n"
            + "255\n"
            + "255\n"
            + "255\n"
            + "255\n"
            + "10\n"
            + "10\n"
            + "10\n"
            + "10\n"
            + "10\n"
            + "10\n"
            + "10\n"
            + "10\n"
            + "10\n", model.getImage("contrastflag").toString());
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
    model.transformation("flag", "transformflag", matrix);
    assertEquals("P3\n" +
            "4 3\n" +
            "255\n" +
            "255\n" +
            "255\n" +
            "255\n" +
            "10\n" +
            "10\n" +
            "10\n" +
            "10\n" +
            "10\n" +
            "10\n" +
            "10\n" +
            "10\n" +
            "10\n" +
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
            "10\n" +
            "10\n" +
            "10\n" +
            "10\n" +
            "10\n" +
            "10\n" +
            "10\n" +
            "10\n" +
            "10\n", model.getImage("transformflag").toString());
  }

  //tests GetImage()
  @Test
  public void testGetImage() {
    //need res/UAEflag.ppm
    ImageProcessor model = new PPMImageProcessor();
    model.load(new PPMImage("res/UAEflag.ppm"), "flag");
    assertEquals("P3\n"
            + "4 3\n"
            + "255\n"
            + "255\n"
            + "0\n"
            + "0\n"
            + "0\n"
            + "255\n"
            + "0\n"
            + "0\n"
            + "255\n"
            + "0\n"
            + "0\n"
            + "255\n"
            + "0\n"
            + "255\n"
            + "0\n"
            + "0\n"
            + "255\n"
            + "255\n"
            + "255\n"
            + "255\n"
            + "255\n"
            + "255\n"
            + "255\n"
            + "255\n"
            + "255\n"
            + "255\n"
            + "0\n"
            + "0\n"
            + "0\n"
            + "0\n"
            + "0\n"
            + "0\n"
            + "0\n"
            + "0\n"
            + "0\n"
            + "0\n"
            + "0\n", model.getImage("flag").toString());

  }

  //tests getImage() if not there
  @Test(expected = IllegalArgumentException.class)
  public void testExceptionGetImage() {
    //need res/UAEflag.ppm
    ImageProcessor model = new PPMImageProcessor();
    model.load(new PPMImage("res/UAEflag.ppm"), "flag");
    model.getImage("bonk");
  }

  //tests invalid input
  @Test(expected = IllegalArgumentException.class)
  public void testExceptionOperation() {
    //need res/UAEflag.ppm
    ImageProcessor model = new PPMImageProcessor();
    model.load(new PPMImage("res/UAEflag.ppm"), "flag");
    model.redComponent("bonk", "bonk");
  }
}