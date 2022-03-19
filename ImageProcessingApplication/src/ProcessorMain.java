import controller.ImageProcessorController;
import controller.ImageProcessorControllerImpl;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import model.ImageProcessor;
import model.PPMImageProcessor;
import view.ImageProcessorView;
import view.ImageProcessorViewImpl;

/**
 * Main class for the processor.
 */
public class ProcessorMain {

  /**
   * Main method to run the Image Processor so that it can load and save images as well as perform
   * operations on those images.
   *
   * @param args the command-line arguments passed into the main method
   */
  public static void main(String[] args) {
    ImageProcessor model = new PPMImageProcessor();
    ImageProcessorView view = new ImageProcessorViewImpl(model);
    FileInputStream fileInputStream;
    Readable rd;
    if (args.length != 0) {
      if (args[0].equals("-file")) {
        if (args[1].substring(args[1].lastIndexOf(".")).equals(".txt")) {
          try {
            fileInputStream = new FileInputStream(args[1]);
            rd = new InputStreamReader(fileInputStream);
          } catch (Exception e) {
            e.printStackTrace();
            rd = new InputStreamReader(System.in);
          }
        } else {
          rd = new InputStreamReader(System.in);
        }
      } else {
        rd = new InputStreamReader(System.in);
      }
    } else {
      rd = new InputStreamReader(System.in);
    }
    ImageProcessorController controller = new ImageProcessorControllerImpl(model, view,
        rd);
    controller.run();
  }


}
