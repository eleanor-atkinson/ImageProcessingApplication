package controller;

import model.ImageProcessor;

/**
 * Function object that calls the vertical flip method from the model that vertically
 * flips the image.
 */
public class VerticalFlip implements ImageProcessorCommands {

  private String originalImageName;
  private String newImageName;

  /**
   * Constructor for the function object.
   *
   * @param originalImageName the original image name
   * @param newImageName      the new image name
   */
  public VerticalFlip(String originalImageName, String newImageName) {
    this.originalImageName = originalImageName;
    this.newImageName = newImageName;
  }

  @Override
  public void run(ImageProcessor m) {
    m.verticalFlip(originalImageName, newImageName);
  }
}
