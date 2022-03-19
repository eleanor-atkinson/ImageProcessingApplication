package model;

/**
 * Interface representing a pixel with RGB Channels, how many bits are used is implementation
 * dependent.
 */
public interface RGBPixel {

  /**
   * Brightens or darkens the pixel by the given amount.
   *
   * @param amount the amount to increment each RGB value by
   */
  void contrast(int amount);

  /*
   * Brighten or darkens this pixel by the given factor.
   * @param amount
   */
  // void factor(double amount);

  /**
   * Sets the pixel such that each RGB value is equal to the max value between the three.
   */
  void value();

  /**
   * Gets the max value component.
   */
  int getMaxValue();

  /**
   * Sets the pixel such that each RGB value is equal to the average value of the three, which is
   * rounded using ceiling rounding.
   */
  void intensity();

  //OBSOLETE DUE TO COLOR TRANSFORMATIONS

  /**
   * Sets the pixel such that each RGB value is equal to the pixel's luma, given by the formula
   * 0.2126r + 0.7152g + 0.0722b.
   */
  void luma();

  /**
   * Sets each RGB value to be equal to the red value.
   */
  void redComponent();

  /**
   * Sets each RGB value to be equal to the green value.
   */
  void greenComponent();

  /**
   * Sets each RGB value to be equal to the blue value.
   */
  void blueComponent();

  /**
   * Returns the components of the pixel in an int[].
   */
  int[] getComponents();

  /**
   * Transforms the channels of this pixel according to this transformation matrix.
   *
   * @param matrix the matrix to be used
   * @throws IllegalArgumentException if the given matrix is invalid.
   */
  void transformation(double[][] matrix) throws IllegalArgumentException;
}
