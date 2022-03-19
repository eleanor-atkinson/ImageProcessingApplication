package model;

/**
 * This class represents a 24-bit pixel, to be used for image processing.
 */
public class TwentyFourBitPixel implements RGBPixel {

  private int red;
  private int green;
  private int blue;


  /**
   * Default constructor produces pixel with RGB values of (0,0,0), i.e. black.
   */
  public TwentyFourBitPixel() {
    this.red = 0;
    this.green = 0;
    this.blue = 0;
  }

  /**
   * Creates a pixel with the given RGB values.
   *
   * @param red   the value for red, between 0-255
   * @param green the value for green, between 0-255
   * @param blue  the value for blue, between 0-255
   * @throws IllegalArgumentException if any value is invalid
   */
  public TwentyFourBitPixel(int red, int green, int blue) throws IllegalArgumentException {

    //INVARIANT: Each channel must have a value between 0 and 255 inclusive
    if (red < 0 || red > 255 || green < 0 || green > 255 || blue < 0 || blue > 255) {
      throw new IllegalArgumentException("Invalid input for RGB value");
    }

    this.red = red;
    this.green = green;
    this.blue = blue;
  }

  @Override
  public void contrast(int amount) {
    this.red += amount;
    this.green += amount;
    this.blue += amount;

    clamp();

  }

  @Override
  public void value() {
    int value = this.getMaxValue();
    this.red = value;
    this.green = value;
    this.blue = value;
  }

  @Override
  public int getMaxValue() {
    return Math.max(this.red, Math.max(this.green, this.blue));
  }

  @Override
  public void intensity() {
    double intensity = ((double) this.red + (double) this.green + (double) this.blue) / 3.0;
    int roundedIntensity = (int) Math.ceil(intensity);

    //the invariant is enforced by the principle that the average of a set
    //cannot be greater than its greatest component
    this.red = roundedIntensity;
    this.green = roundedIntensity;
    this.blue = roundedIntensity;
  }

  @Override
  public void luma() {
    double luma = 0.2126 * (double) this.red
        + 0.7152 * (double) this.green
        + 0.0722 * (double) this.blue;

    int roundedLuma = (int) Math.ceil(luma);

    //the invariant is enforced by each coefficient's being less than 1 and greater than 0,
    //which means that each value is being decreased by some amount, but not enough
    //to reach below 0
    this.red = roundedLuma;
    this.green = roundedLuma;
    this.blue = roundedLuma;

  }

  @Override
  public void redComponent() {
    this.green = this.red;
    this.blue = this.red;
  }

  @Override
  public void greenComponent() {
    this.red = this.green;
    this.blue = this.green;
  }

  @Override
  public void blueComponent() {
    this.red = this.blue;
    this.green = this.blue;
  }

  @Override
  public int[] getComponents() {
    return new int[]{this.red, this.green, this.blue};
  }


  @Override
  public void transformation(double[][] matrix) throws IllegalArgumentException {

    if (matrix.length != 3 || matrix[0].length != 3) {
      throw new IllegalArgumentException("Matrix must be 3x3.");
    }

    double tempr = this.red;
    double tempg = this.green;
    double tempb = this.blue;

    tempr = matrix[0][0] * (double) this.red + matrix[0][1] * (double) this.green
        + matrix[0][2] * (double) this.blue;
    tempg = matrix[1][0] * (double) this.red + matrix[1][1] * (double) this.green
        + matrix[1][2] * (double) this.blue;
    tempb = matrix[2][0] * (double) this.red + matrix[2][1] * (double) this.green
        + matrix[2][2] * (double) this.blue;

    this.red = (int) Math.ceil(tempr);
    this.green = (int) Math.ceil(tempg);
    this.blue = (int) Math.ceil(tempb);

    clamp();

  }

  /**
   * Returns a String in PPM format.
   *
   * @return this pixel represented in PPM format.
   */
  @Override
  public String toString() {

    return this.red + "\n"
        + this.green + "\n"
        + this.blue + "\n";
  }

  //clamps each value to range [0,255]
  private void clamp() {
    //INVARIANT: each channel must be a value between 0 and 255
    if (this.red < 0) {
      this.red = 0;
    }
    if (this.red > 255) {
      this.red = 255;
    }
    if (this.green < 0) {
      this.green = 0;
    }
    if (this.green > 255) {
      this.green = 255;
    }
    if (this.blue < 0) {
      this.blue = 0;
    }
    if (this.blue > 255) {
      this.blue = 255;
    }
  }


}
