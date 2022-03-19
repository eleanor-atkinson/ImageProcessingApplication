import org.junit.Test;

import java.io.IOException;

import model.ImageProcessor;
import model.PPMImageProcessor;
import view.ImageProcessorViewImpl;

import static org.junit.Assert.assertEquals;

/**
 * Holds the tests for the implementation of the image processor view.
 */
public class ImageProcessorViewImplTest {

  private ImageProcessorViewImpl view;

  // tests render message
  @Test
  public void testView() {
    ImageProcessor model = new PPMImageProcessor();
    Appendable a = new StringBuilder();
    this.view = new ImageProcessorViewImpl(model, a);

    try {
      view.renderMessage("hello, world!");
    } catch (IOException e) {
      e.printStackTrace();
    }

    assertEquals("hello, world!", a.toString());

  }

  // tests when the model given to the first constructor is null
  @Test(expected = IllegalArgumentException.class)
  public void testFirstConstructorModelNull() {
    ImageProcessor model = null;
    this.view = new ImageProcessorViewImpl(model);
  }

  // tests when the model given to the second constructor is null
  @Test(expected = IllegalArgumentException.class)
  public void testSecondConstructorModelNull() {
    ImageProcessor model = null;
    Appendable a = System.out;
    this.view = new ImageProcessorViewImpl(model, a);
  }

  // tests when the appendable given to the second constructor is null
  @Test(expected = IllegalArgumentException.class)
  public void testSecondConstructorAppendableNull() {
    ImageProcessor model = new PPMImageProcessor();
    Appendable a = null;
    this.view = new ImageProcessorViewImpl(model, a);
  }

}