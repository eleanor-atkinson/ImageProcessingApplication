package model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * This class represents an Image that interacts with and writes to PPM files. It has a width,
 * height, and is made up of RGBPixels.
 */
public class PPMImage implements Image {

  private final RGBPixel[][] pixels;
  private final int width;
  private final int height;
  private final int maxValue;

  /**
   * Constructor that takes the pixels for the image.
   *
   * @param pixels the pixel array that represents the image
   * @throws IllegalArgumentException if pixels is null of if any cell in pixels is null
   */
  public PPMImage(RGBPixel[][] pixels) throws IllegalArgumentException {

    if (pixels == null) {
      throw new IllegalArgumentException("Pixels cannot be null.");
    }

    for (RGBPixel[] row : pixels) {
      for (RGBPixel pixel : row) {
        if (pixel == null) {
          throw new IllegalArgumentException("Each position must have a pixel.");
        }
      }
    }

    int tempMax = 0;

    for (RGBPixel[] row : pixels) {
      for (RGBPixel pixel : row) {
        tempMax = Math.max(tempMax, pixel.getMaxValue());
      }
    }

    this.pixels = pixels;
    this.width = pixels[0].length;
    this.height = pixels.length;
    this.maxValue = tempMax;
  }

  /**
   * Constructor that reads a PPM file and builds the pixel 2D array.
   *
   * @param filename the name of the file
   * @throws IllegalArgumentException if the file is not found
   */
  public PPMImage(String filename) throws IllegalArgumentException {

    //starter code taken from the provided ImageUtil class
    //changes made to populate this image with pixels, rather than printing their colors to console.

    Scanner sc;

    try {
      sc = new Scanner(new FileInputStream(filename));
    } catch (FileNotFoundException e) {
      throw new IllegalArgumentException("File not found.");
    }
    StringBuilder builder = new StringBuilder();
    //read the file line by line, and populate a string. This will throw away any comment lines
    while (sc.hasNextLine()) {
      String s = sc.nextLine();
      if (s.charAt(0) != '#') {
        builder.append(s + System.lineSeparator());
      }
    }

    //now set up the scanner to read from the string we just built
    sc = new Scanner(builder.toString());

    String token;

    token = sc.next();
    if (!token.equals("P3")) {
      throw new IllegalArgumentException("Invalid PPM file: plain RAW file should begin with P3");
    }
    int width = sc.nextInt();
    this.width = width;
    int height = sc.nextInt();
    this.height = height;
    this.maxValue = sc.nextInt();

    RGBPixel[][] pixels = new RGBPixel[this.height][this.width];

    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        int r = sc.nextInt();
        int g = sc.nextInt();
        int b = sc.nextInt();
        pixels[i][j] = new TwentyFourBitPixel(r, g, b);
      }
    }

    this.pixels = pixels;

  }


  @Override
  public Image redComponent() {

    RGBPixel[][] temp = cloneArray(this.pixels);

    for (RGBPixel[] rgbPixels : temp) {
      for (int j = 0; j < temp[0].length; j++) {
        rgbPixels[j].redComponent();
      }
    }

    return new PPMImage(temp);

  }

  @Override
  public Image greenComponent() {
    RGBPixel[][] temp = cloneArray(this.pixels);

    for (RGBPixel[] rgbPixels : temp) {
      for (int j = 0; j < temp[0].length; j++) {
        rgbPixels[j].greenComponent();
      }
    }

    return new PPMImage(temp);
  }

  @Override
  public Image blueComponent() {
    RGBPixel[][] temp = cloneArray(this.pixels);

    for (RGBPixel[] rgbPixels : temp) {
      for (int j = 0; j < temp[0].length; j++) {
        rgbPixels[j].blueComponent();
      }
    }

    return new PPMImage(temp);
  }

  @Override
  public Image value() {
    RGBPixel[][] temp = cloneArray(this.pixels);

    for (RGBPixel[] rgbPixels : temp) {
      for (int j = 0; j < temp[0].length; j++) {
        rgbPixels[j].value();
      }
    }

    return new PPMImage(temp);
  }

  @Override
  public Image intensity() {
    RGBPixel[][] temp = cloneArray(this.pixels);

    for (RGBPixel[] rgbPixels : temp) {
      for (int j = 0; j < temp[0].length; j++) {
        rgbPixels[j].intensity();
      }
    }

    return new PPMImage(temp);
  }

  @Override
  public Image luma() {
    RGBPixel[][] temp = cloneArray(this.pixels);

    for (RGBPixel[] rgbPixels : temp) {
      for (int j = 0; j < temp[0].length; j++) {
        rgbPixels[j].luma();
      }
    }

    return new PPMImage(temp);
  }

  @Override
  public Image flipHorizontal() {
    RGBPixel[][] result = new RGBPixel[this.height][];

    for (int i = 0; i < this.height; i++) {
      RGBPixel[] horizontallyFlipped = new RGBPixel[this.width];
      for (int j = 0; j < horizontallyFlipped.length; j++) {
        horizontallyFlipped[horizontallyFlipped.length - 1 - j] = this.pixels[i][j];
      }

      result[i] = horizontallyFlipped;
    }

    return new PPMImage(result);
  }

  @Override
  public Image flipVertical() {

    RGBPixel[][] result = new RGBPixel[this.height][];

    for (int i = 0; i < this.height; i++) {
      result[result.length - 1 - i] = this.pixels[i];
    }

    return new PPMImage(result);
  }

  @Override
  public Image contrast(int amount) {
    RGBPixel[][] temp = cloneArray(this.pixels);

    for (RGBPixel[] rgbPixels : temp) {
      for (int j = 0; j < temp[0].length; j++) {
        rgbPixels[j].contrast(amount);
      }
    }

    return new PPMImage(temp);
  }

  @Override
  public Image transformation(double[][] matrix) throws IllegalArgumentException {
    RGBPixel[][] temp = cloneArray(this.pixels);

    for (RGBPixel[] rgbPixels : temp) {
      for (int j = 0; j < temp[0].length; j++) {
        rgbPixels[j].transformation(matrix);
      }
    }

    return new PPMImage(temp);
  }

  @Override
  public RGBPixel[][] getPixels() {
    return this.pixels;
  }

  @Override
  public int getHeight() {
    return height;
  }

  @Override
  public int getWidth() {
    return width;
  }


  //code for this helper provided by:
  //https://stackoverflow.com/questions/5617016/how-do-i-copy-a-2-dimensional-array-in-java
  //clones the provided array
  private RGBPixel[][] cloneArray(RGBPixel[][] src) {
    int length = src.length;
    RGBPixel[][] target = new RGBPixel[length][src[0].length];
    for (int i = 0; i < length; i++) {
      System.arraycopy(src[i], 0, target[i], 0, src[i].length);
    }
    return target;
  }

  /**
   * Provides a text string in PPM format to open the image.
   *
   * @return this image in PPM format
   */
  @Override
  public String toString() {
    StringBuilder build = new StringBuilder();
    build.append("P3\n");
    build.append(this.width + " " + this.height + "\n");
    build.append(this.maxValue + "\n");
    for (RGBPixel[] row : this.pixels) {
      for (RGBPixel pixel : row) {
        build.append(pixel.toString());
      }
    }

    return build.toString();
  }

}
