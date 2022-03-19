package controller;

import model.ImageProcessor;

/**
 * Function object that calls the contrast method from the model to brighten or darken the image.
 */
public class Brighten implements ImageProcessorCommands {

  private String originalImageName;
  private String newImageName;
  private int amount;

  /**
   * Constructor for the function object.
   *
   * @param originalImageName the original image name
   * @param newImageName      the new image name
   * @param amount            the amount to brighten or darken (negative) the image by
   */
  public Brighten(String originalImageName, String newImageName, int amount) {
    this.originalImageName = originalImageName;
    this.newImageName = newImageName;
    this.amount = amount;
  }

  @Override
  public void run(ImageProcessor m) {
    m.contrast(originalImageName, newImageName, amount);
  }
}
