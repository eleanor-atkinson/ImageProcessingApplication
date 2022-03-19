package view;

import java.io.IOException;
import model.ImageProcessor;

/**
 * Specific implementation of {@code ImageProcessorView}, that is able to send the user messages
 * about what is happeneing in the program.
 */
public class ImageProcessorViewImpl implements ImageProcessorView {

  private ImageProcessor model;
  private Appendable a;

  /**
   * Creates a view with the given model, and defaults the Appendable to System.out
   *
   * @param model the model to be viewed
   * @throws IllegalArgumentException if the model is null
   */
  public ImageProcessorViewImpl(ImageProcessor model) throws IllegalArgumentException {
    if (model == null) {
      throw new IllegalArgumentException("Model cannot be null.");
    }

    this.model = model;
    this.a = System.out;
  }

  /**
   * Creates a view with the given model and given Appendable.
   *
   * @param model the model to be viewed
   * @param a     the appendable to be used as output
   * @throws IllegalArgumentException if either parameters are null
   */
  public ImageProcessorViewImpl(ImageProcessor model, Appendable a)
      throws IllegalArgumentException {

    if (model == null) {
      throw new IllegalArgumentException("Model cannot be null.");
    }
    if (a == null) {
      throw new IllegalArgumentException("Appendable cannot be null.");
    }

    this.model = model;
    this.a = a;
  }

  @Override
  public void renderMessage(String message) throws IOException {
    a.append(message);
  }
}
