package model;

import java.io.IOException;

/**
 * Represents an Image Processor that can manipulate images in various ways.
 */
public interface ImageProcessor {

  //REFACTOR FOR ASSIGNMENT 5: load(String, String) now load(Image, String) to remove I/O from model

  /**
   * Loads the image into the processor and gives it the provided imageName.
   *
   * @param image     the image to be loaded into the processor
   * @param imageName the name to be given the image
   */
  void load(Image image, String imageName);

  //REFACTOR FOR ASSIGNMENT 5: REMOVE OBSOLETE METHOD
  /*
   * Saves the given image as the given file name.
   *
   * @param imageName the image to be saved
   * @param fileName  the file name for the image to be saved as
   * @throws IllegalArgumentException if the Image to be saved does not exist
   */
  // void save(String imageName, String fileName) throws IllegalArgumentException, IOException;

  /**
   * Creates a grayscale image of the given image using the red component, and saves it under the
   * given image name.
   *
   * @param originalImageName the name of the original image
   * @param newImageName      the name of the created image to be added to the processor
   * @throws IllegalArgumentException if the Image to be saved does not exist
   * @throws IOException              if the method is unable to write to the file
   */
  void redComponent(String originalImageName, String newImageName) throws IllegalArgumentException;

  /**
   * Creates a grayscale image of the given image using the green component, and saves it under the
   * given image name.
   *
   * @param originalImageName the name of the original image
   * @param newImageName      the name of the created image to be added to the processor
   * @throws IllegalArgumentException if the Image to be saved does not exist
   */
  void greenComponent(String originalImageName, String newImageName)
      throws IllegalArgumentException;

  /**
   * Creates a grayscale image of the given image using the blue component, and saves it under the
   * given image name.
   *
   * @param originalImageName the name of the original image
   * @param newImageName      the name of the created image to be added to the processor
   * @throws IllegalArgumentException if the Image to be saved does not exist
   */
  void blueComponent(String originalImageName, String newImageName) throws IllegalArgumentException;

  /**
   * Creates a grayscale image of the given image using the value component, and saves it under the
   * given image name.
   *
   * @param originalImageName the name of the original image
   * @param newImageName      the name of the created image to be added to the processor
   * @throws IllegalArgumentException if the Image to be saved does not exist
   */
  void valueComponent(String originalImageName, String newImageName)
      throws IllegalArgumentException;

  /**
   * Creates a grayscale image of the given image using the intensity component, and saves it under
   * the given image name.
   *
   * @param originalImageName the name of the original image
   * @param newImageName      the name of the created image to be added to the processor
   * @throws IllegalArgumentException if the Image to be saved does not exist
   */
  void intensityComponent(String originalImageName, String newImageName)
      throws IllegalArgumentException;

  //OBSOLETE DUE TO COLOR TRANSFORMATIONS

  /**
   * Creates a grayscale image of the given image using the luma component, and saves it under the
   * given image name.
   *
   * @param originalImageName the name of the original image
   * @param newImageName      the name of the created image to be added to the processor
   * @throws IllegalArgumentException if the Image to be saved does not exist
   */
  void lumaComponent(String originalImageName, String newImageName) throws IllegalArgumentException;

  /**
   * Creates a horizontally-flipped image of the given image, and saves it under the given name.
   *
   * @param originalImageName the name of the original image
   * @param newImageName      the name of the created image to be added to the processor
   * @throws IllegalArgumentException if the Image to be saved does not exist
   */
  void horizontalFlip(String originalImageName, String newImageName)
      throws IllegalArgumentException;

  /**
   * Creates a vertically-flipped image of the given image, and saves it under the given name.
   *
   * @param originalImageName the name of the original image
   * @param newImageName      the name of the created image to be added to the processor
   * @throws IllegalArgumentException if the Image to be saved does not exist
   */
  void verticalFlip(String originalImageName, String newImageName) throws IllegalArgumentException;

  /**
   * Brightens or darkens the given image by the given amount and saves it under the new image
   * name.
   *
   * @param originalImageName the name of the original image
   * @param newImageName      the name of the created image to be added to the processor
   * @param amount            the amount to be brightened or darkened by (negative values darken)
   * @throws IllegalArgumentException if the Image to be saved does not exist
   */
  void contrast(String originalImageName, String newImageName, int amount)
      throws IllegalArgumentException;


  /**
   * Transforms each pixel in the image according to the given matrix.
   *
   * @param originalImageName the original image to be transformed
   * @param newImageName      the name of the new image
   * @param matrix            the matrix to be used
   * @throws IllegalArgumentException if the matrix is not 3x3
   */
  void transformation(String originalImageName, String newImageName, double[][] matrix)
      throws IllegalArgumentException;

  /**
   * Gets the image with the given name from the model.
   *
   * @param imageName the name of the image
   * @return the image
   * @throws IllegalArgumentException if the image is not loaded in the model
   */
  Image getImage(String imageName) throws IllegalArgumentException;

}
