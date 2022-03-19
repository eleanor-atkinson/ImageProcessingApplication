package controller;

import model.ImageProcessor;

/**
 * Function object that calls the blue component method from the model.
 */
public class BlueComponent implements ImageProcessorCommands {

  private String originalImageName;
  private String newImageName;

  /**
   * Constructor for the function object.
   * @param originalImageName the original image name
   * @param newImageName the new image name
   */
  public BlueComponent(String originalImageName, String newImageName) {
    this.originalImageName = originalImageName;
    this.newImageName = newImageName;
  }

  @Override
  public void run(ImageProcessor m) {

    m.blueComponent(this.originalImageName, this.newImageName);

  }
}
