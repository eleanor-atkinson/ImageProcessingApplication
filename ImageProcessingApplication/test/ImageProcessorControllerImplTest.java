import org.junit.Test;

import java.io.StringReader;

import controller.ImageProcessorController;
import controller.ImageProcessorControllerImpl;
import model.ImageProcessor;
import model.PPMImageProcessor;
import view.ImageProcessorView;
import view.ImageProcessorViewImpl;

import static org.junit.Assert.assertEquals;

/**
 * Holds the tests for the implementation of the image processor controller class.
 */
public class ImageProcessorControllerImplTest {

  // tests run
  @Test
  public void testRunningTheProgram() {
    Appendable a = new StringBuilder("");
    ImageProcessor model = new PPMImageProcessor();
    ImageProcessorView view = new ImageProcessorViewImpl(model, a);
    Readable r = new StringReader(
        "load Images/UAEflag.ppm flag horizontal-flip flag hflag " +
            "vertical-flip hflag vhflag red-component vhflag rflag green-component rflag gflag " +
            "blue-component gflag bflag luma-component bflag lumaflag value-component lumaflag " +
            "valueflag intensity-component valueflag intenseflag brighten intenseflag " +
            "brightenflag 30 save Images/bigflag.jpg brightenflag weihrwi wqiuwqi blah " +
            "red-component bonk");
    ImageProcessorController controller = new ImageProcessorControllerImpl(model, view, r);

    controller.run();

    assertEquals("Command load processed successfully.\n" +
        "Command horizontal-flip processed successfully.\n" +
        "Command vertical-flip processed successfully.\n" +
        "Command red-component processed successfully.\n" +
        "Command green-component processed successfully.\n" +
        "Command blue-component processed successfully.\n" +
        "Command luma-component processed successfully.\n" +
        "Command value-component processed successfully.\n" +
        "Command intensity-component processed successfully.\n" +
        "Command brighten processed successfully.\n" +
        "Command save processed successfully.\n" +
        "Invalid command.\n" +
        "Invalid command.\n" +
        "Invalid command.\n" +
        "Invalid inputs for command.\n", a.toString());

  }

}