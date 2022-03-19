package model;

import java.util.Map;
import java.util.TreeMap;

/**
 * Specific implementation of that allows for the processing of PPM images.
 */
public class PPMImageProcessor implements ImageProcessor {

  private Map<String, Image> images;

  /**
   * Initializes the processor with an empty map of images.
   */
  public PPMImageProcessor() {
    this.images = new TreeMap<>();
  }


  @Override
  public void load(Image image, String imageName) {

    if (this.images.containsKey(imageName)) {
      images.replace(imageName, image);
    } else {
      images.put(imageName, image);
    }
  }

  //REFACTOR FOR ASSIGNMENT 5: REMOVE OBSOLETE CODE
  /*
  public void save(String fileName, String imageName) throws IllegalArgumentException, IOException {

    if (!this.images.containsKey(imageName)) {
      throw new IllegalArgumentException("Given image name not loaded in processor");
    }

    FileWriter fileWriter = new FileWriter(fileName);
    fileWriter.write(images.get(imageName).toString());
    fileWriter.close();
  }*/

  @Override
  public void redComponent(String originalImageName, String newImageName)
      throws IllegalArgumentException {

    if (!this.images.containsKey(originalImageName)) {
      throw new IllegalArgumentException("Given image name not loaded in processor");
    }

    images.put(newImageName, images.get(originalImageName).redComponent());

  }

  @Override
  public void greenComponent(String originalImageName, String newImageName)
      throws IllegalArgumentException {

    if (!this.images.containsKey(originalImageName)) {
      throw new IllegalArgumentException("Given image name not loaded in processor");
    }

    images.put(newImageName, images.get(originalImageName).greenComponent());

  }

  @Override
  public void blueComponent(String originalImageName, String newImageName)
      throws IllegalArgumentException {

    if (!this.images.containsKey(originalImageName)) {
      throw new IllegalArgumentException("Given image name not loaded in processor");
    }

    images.put(newImageName, images.get(originalImageName).blueComponent());
  }

  @Override
  public void valueComponent(String originalImageName, String newImageName)
      throws IllegalArgumentException {

    if (!this.images.containsKey(originalImageName)) {
      throw new IllegalArgumentException("Given image name not loaded in processor");
    }

    images.put(newImageName, images.get(originalImageName).value());
  }

  @Override
  public void intensityComponent(String originalImageName, String newImageName)
      throws IllegalArgumentException {

    if (!this.images.containsKey(originalImageName)) {
      throw new IllegalArgumentException("Given image name not loaded in processor");
    }

    images.put(newImageName, images.get(originalImageName).intensity());
  }

  @Override
  public void lumaComponent(String originalImageName, String newImageName)
      throws IllegalArgumentException {

    if (!this.images.containsKey(originalImageName)) {
      throw new IllegalArgumentException("Given image name not loaded in processor");
    }

    images.put(newImageName, images.get(originalImageName).luma());
  }

  @Override
  public void horizontalFlip(String originalImageName, String newImageName)
      throws IllegalArgumentException {

    if (!this.images.containsKey(originalImageName)) {
      throw new IllegalArgumentException("Given image name not loaded in processor");
    }

    images.put(newImageName, images.get(originalImageName).flipHorizontal());
  }

  @Override
  public void verticalFlip(String originalImageName, String newImageName)
      throws IllegalArgumentException {

    if (!this.images.containsKey(originalImageName)) {
      throw new IllegalArgumentException("Given image name not loaded in processor");
    }

    images.put(newImageName, images.get(originalImageName).flipVertical());
  }

  @Override
  public void contrast(String originalImageName, String newImageName, int amount)
      throws IllegalArgumentException {

    if (!this.images.containsKey(originalImageName)) {
      throw new IllegalArgumentException("Given image name not loaded in processor");
    }

    images.put(newImageName, images.get(originalImageName).contrast(amount));
  }

  @Override
  public void transformation(String originalImageName, String newImageName, double[][] matrix)
      throws IllegalArgumentException {

    if (!this.images.containsKey(originalImageName)) {
      throw new IllegalArgumentException("Given image name not loaded in processor");
    }

    if (matrix.length != 3 || matrix[0].length != 3) {
      throw new IllegalArgumentException("Matrix must be 3x3.");
    }

    images.put(newImageName, images.get(originalImageName).transformation(matrix));


  }

  @Override
  public Image getImage(String imageName) throws IllegalArgumentException {
    Image result = this.images.getOrDefault(imageName, null);
    if (result == null) {
      throw new IllegalArgumentException("Image not found.");
    } else {
      return result;
    }
  }
}
