package controller;

import model.ImageProcessor;

/**
 * The function object that calls the luma component method from the model.
 */
public class LumaComponent implements ImageProcessorCommands {

  //REFACTOR FOR ASSIGNMENT 5: NOW USES COLOR TRANSFORMATIONS
  private String originalImageName;
  private String newImageName;
  private double[][] lumaMatrix;

  /**
   * Constructor for the function object.
   *
   * @param originalImageName the original image name
   * @param newImageName      the new image name
   */
  public LumaComponent(String originalImageName, String newImageName) {
    this.originalImageName = originalImageName;
    this.newImageName = newImageName;
    this.lumaMatrix = new double[][]{{0.2126, 0.7152, 0.0722}, {0.2126, 0.7152, 0.0722},
        {0.2126, 0.7152, 0.0722}};
  }

  @Override
  public void run(ImageProcessor m) {

    m.transformation(originalImageName, newImageName, lumaMatrix);

  }
}
