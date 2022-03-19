package controller;

import model.ImageProcessor;

/**
 * Function object that calls the transformation method from the model using a sepia tone matrix.
 */
public class SepiaTone implements ImageProcessorCommands {

  private String originalImageName;
  private String newImageName;
  private double[][] sepiaMatrix;

  /**
   * Constructor for the function object.
   *
   * @param originalImageName the original image name
   * @param newImageName      the new image name
   */
  public SepiaTone(String originalImageName, String newImageName) {
    this.originalImageName = originalImageName;
    this.newImageName = newImageName;
    this.sepiaMatrix = new double[][]{{0.393, 0.769, 0.189}, {0.349, 0.686, 0.168},
        {0.272, 0.534, 0.131}};
  }

  @Override
  public void run(ImageProcessor m) {

    m.transformation(originalImageName, newImageName, sepiaMatrix);

  }
}
