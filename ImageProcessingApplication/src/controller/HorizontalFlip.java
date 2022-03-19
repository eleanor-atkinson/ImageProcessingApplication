package controller;

import model.ImageProcessor;

/**
 * Function object that calls the horizontal method from the model.
 */
public class HorizontalFlip implements ImageProcessorCommands {

  private String originalImageName;
  private String newImageName;


  /**
   * Constructor for the function object.
   *
   * @param originalImageName the original image name
   * @param newImageName      the new image name
   */
  public HorizontalFlip(String originalImageName, String newImageName) {
    this.originalImageName = originalImageName;
    this.newImageName = newImageName;
  }

  @Override
  public void run(ImageProcessor m) {

    m.horizontalFlip(this.originalImageName, this.newImageName);

  }

}
