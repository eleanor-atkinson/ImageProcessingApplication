package model;

/**
 * Interface that represents an image of some kind.
 */
public interface Image {


  /**
   * Visualizes the red component of this image, i.e. grayscale using the red value.
   *
   * @return a new Image with the red component visualized
   */
  Image redComponent();

  /**
   * Visualizes the green component of this image, i.e. grayscale using the green value.
   *
   * @return a new image with the green component visualized
   */
  Image greenComponent();

  /**
   * Visualizes the blue component of this image, i.e. grayscale using the blue value.
   *
   * @return a new image with the blue component visualized
   */
  Image blueComponent();

  /**
   * Visualizes the value of this image, i.e. grayscale based on highest RGB value for each pixel.
   *
   * @return a new image with value visualized.
   */
  Image value();

  /**
   * Visualizes the intensity of this image, i.e. grayscale based on the average value of RGB for
   * each pixel.
   *
   * @return a new image with intensity visualized.
   */
  Image intensity();

  //OBSOLETE DUE TO COLOR TRANSFORMATIONS
  /**
   * Visualizes the luma of this image, i.e. grayscale based on each pixel's luma value.
   * Calculations are dependent on the implementation of the pixel.
   *
   * @return a new image with luma visualized.
   */
  Image luma();

  /**
   * Flips this image horizontally.
   *
   * @return a new image that is this, but flipped horizontally
   */
  Image flipHorizontal();

  /**
   * Flips this image vertically.
   *
   * @return a new image that is this, but flipped vertically
   */
  Image flipVertical();

  /**
   * Brightens or darkens the image by the given amount.
   *
   * @param amount the amount to be brightened or darkened by (negative numbers darken the image)
   * @return a new image that is this, but with the applied contrast.
   */
  Image contrast(int amount);

  /**
   * Transforms each pixel in this image by the according to the given matrix.
   * @param matrix the matrix to be used
   * @return the transformed image
   * @throws IllegalArgumentException if the matrix is not 3x3.
   */
  Image transformation(double[][] matrix) throws IllegalArgumentException;

  /**
   * Provides the text-based data for the image.
   *
   * @return the text-based data for the image.
   */
  @Override
  String toString();

  /**
   * Gets the pixel array for this image.
   *
   * @return {@code this.pixels}
   */
  RGBPixel[][] getPixels();

  /**
   * Gets the height of this image.
   *
   * @return {@code this.height}
   */
  int getHeight();

  /**
   * Gets the width of this image.
   *
   * @return {@code this.width}
   */
  int getWidth();

}
