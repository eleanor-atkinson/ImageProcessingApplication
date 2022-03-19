package controller;

import model.Image;
import model.ImageProcessor;

/**
 * The function object that calls the method to load the image.
 */
public class LoadImage implements ImageProcessorCommands {

  private Image image;
  private String imageName;


  /**
   * Constructor for the load image function object.
   *
   * @param image     The image to be loaded.
   * @param imageName The name of the image to be assigned to the file.
   */
  public LoadImage(Image image, String imageName) {
    this.image = image;
    this.imageName = imageName;
  }


  @Override
  public void run(ImageProcessor m) {

    m.load(image, imageName);

  }
}
