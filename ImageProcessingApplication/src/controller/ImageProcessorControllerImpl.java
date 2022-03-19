package controller;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.function.Function;

import javax.imageio.ImageIO;
import model.Image;
import model.ImageProcessor;
import model.PPMImage;
import model.RGBPixel;
import model.TwentyFourBitPixel;
import view.ImageProcessorView;

/**
 * Specific implementation of the ImageProcessorController interface. Runs the image processor,
 */
public class ImageProcessorControllerImpl implements ImageProcessorController {

  private Map<String, Function<Scanner, ImageProcessorCommands>> knownCommands;

  private ImageProcessor model;
  private ImageProcessorView view;
  private Readable rd;

  /**
   * Constructor for the implementation of the image processor controller.
   *
   * @param model The model used in the controller.
   * @param view  The view used in the controller.
   * @param rd    The readable object used by the controller.
   * @throws IllegalArgumentException if any of the parameters are null.
   */
  public ImageProcessorControllerImpl(ImageProcessor model, ImageProcessorView view, Readable rd)
      throws IllegalArgumentException {

    if (model == null) {
      throw new IllegalArgumentException("model cannot be null.");
    }

    if (view == null) {
      throw new IllegalArgumentException("view cannot be null");
    }

    if (rd == null) {
      throw new IllegalArgumentException("readable cannot be null");
    }

    this.model = model;
    this.view = view;
    this.rd = rd;

    //commands that take 3 arguments
    //commands with different amount of arguments will be dealt with directly in the go method
    this.knownCommands = new TreeMap<>();
    this.knownCommands.put("red-component", s -> new RedComponent(s.next(), s.next()));
    this.knownCommands.put("green-component", s -> new GreenComponent(s.next(), s.next()));
    this.knownCommands.put("blue-component", s -> new BlueComponent(s.next(), s.next()));
    this.knownCommands.put("horizontal-flip", s -> new HorizontalFlip(s.next(), s.next()));
    this.knownCommands.put("vertical-flip", s -> new VerticalFlip(s.next(), s.next()));
    this.knownCommands.put("luma-component", s -> new LumaComponent(s.next(), s.next()));
    this.knownCommands.put("value-component", s -> new ValueComponent(s.next(), s.next()));
    this.knownCommands
        .put("intensity-component", s -> new IntensityComponent(s.next(), s.next()));
    this.knownCommands.put("load", s -> new LoadImage(this.input(s.next()), s.next()));
    this.knownCommands.put("brighten", s -> new Brighten(s.next(), s.next(), s.nextInt()));
    this.knownCommands.put("sepia", s -> new SepiaTone(s.next(), s.next()));


  }

  @Override
  public void run() {

    Scanner scan = new Scanner(rd);

    while (scan.hasNext()) {

      //code sourced from Command Design Pattern Module on Canvas
      ImageProcessorCommands c;
      String in = scan.next();

      if (in.equalsIgnoreCase("q") || in.equalsIgnoreCase("quit")) {
        return;
      }

      if (in.equalsIgnoreCase("save")) {
        try {
          output(scan.next(), scan.next());
          this.sendMessage("Command " + in + " processed successfully.\n");
        } catch (Exception e) {
          this.sendMessage("Invalid inputs for command.\n");
        }
      } else {

        Function<Scanner, ImageProcessorCommands> cmd = knownCommands.getOrDefault(in, null);
        if (cmd == null) {
          this.sendMessage("Invalid command.\n");
        } else {
          try {
            c = cmd.apply(scan);
            c.run(model);
            this.sendMessage("Command " + in + " processed successfully.\n");
          } catch (Exception e) {
            this.sendMessage("Invalid inputs for command.\n");
          }
        }


      }
    }
  }

  //handles trying for exception in the view's renderMessage()
  private void sendMessage(String message) {
    try {
      this.view.renderMessage(message);
    } catch (Exception e) {
      throw new IllegalStateException("Unable to write to appendable.");
    }
  }

  //REFACTOR FOR ASSIGNMENT 5: CONTROLLER NEEDS TO HANDLE I/O
  //transforms a file of the given filename into an image to be loaded into the model
  private Image input(String fileName) {

    Scanner sc;
    FileInputStream file;
    RGBPixel[][] pixels;
    BufferedImage bufferedImage;
    int height;
    int width;
    Image result;

    try {
      file = new FileInputStream(fileName);
    } catch (FileNotFoundException e) {
      throw new IllegalArgumentException("File not found.");
    }

    if (fileName == null) {
      throw new IllegalArgumentException("Parameters cannot be null.");
    }
    sc = new Scanner(file);
    if (fileName.lastIndexOf(".") < 1) {
      throw new IllegalArgumentException("Invalid name of file.");
    }
    String extension = fileName.substring(fileName.lastIndexOf(".")).toLowerCase();
    switch (extension) {
      case ".ppm":
        //starter code taken from the provided ImageUtil class
        //changes made to populate this image with pixels, 
        //rather than printing their colors to console.

        StringBuilder builder = new StringBuilder();
        //read the file line by line, and populate a string. This will throw away any comment lines
        while (sc.hasNextLine()) {
          String s = sc.nextLine();
          if (s.charAt(0) != '#') {
            builder.append(s + System.lineSeparator());
          }
        }

        //now set up the scanner to read from the string we just built
        sc = new Scanner(builder.toString());

        String token;

        token = sc.next();
        if (!token.equals("P3")) {
          throw new IllegalArgumentException(
              "Invalid PPM file: plain RAW file should begin with P3");
        }
        width = sc.nextInt();
        height = sc.nextInt();
        sc.nextInt(); //maxvalue, not used in constructor

        pixels = new RGBPixel[height][width];

        for (int i = 0; i < height; i++) {
          for (int j = 0; j < width; j++) {
            int r = sc.nextInt();
            int g = sc.nextInt();
            int b = sc.nextInt();
            pixels[i][j] = new TwentyFourBitPixel(r, g, b);
          }
        }

        result = new PPMImage(pixels);
        break;
      case "png":
      case "jpg":
      case "jpeg":
      case "bmp":
        try {
          bufferedImage = ImageIO.read(file);
        } catch (IOException e) {
          throw new IllegalArgumentException("Unable to read file.");
        }
        height = bufferedImage.getHeight();
        width = bufferedImage.getWidth();
        pixels = new RGBPixel[height][width];
        for (int i = 0; i < pixels.length; i++) {
          for (int j = 0; j < pixels[0].length; j++) {
            Color color = new Color(bufferedImage.getRGB(j, i));
            int r = color.getRed();
            int g = color.getGreen();
            int b = color.getBlue();
            pixels[i][j] = new TwentyFourBitPixel(r, g, b);
          }
        }
        result = new PPMImage(pixels);
        break;
      default:
        throw new IllegalArgumentException("Unexpected value: " + extension);
    }
    return result;
  }


  //writes the given image to a file with the given file name and file type
  //the file type is determined by fileName's extension
  //throws exception if parameters are null, or there is no valid extension
  private void output(String fileName, String imageName)
      throws IllegalArgumentException {
    if (imageName == null || fileName == null) {
      throw new IllegalArgumentException("Parameters cannot be null.");
    }
    String extension = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();
    switch (extension) {
      case "ppm":
        try {
          FileWriter fileWriter = new FileWriter(fileName);
          fileWriter.write(model.getImage(imageName).toString());
          fileWriter.close();
        } catch (Exception e) {
          sendMessage("Unable to write to file.");
        }
        break;
      case "png":
      case "jpg":
      case "jpeg":
      case "bmp":
        int width = model.getImage(imageName).getWidth();
        int height = model.getImage(imageName).getHeight();
        RGBPixel[][] pixels = model.getImage(imageName).getPixels();
        BufferedImage b = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        for (int x = 0; x < width; x++) {
          for (int y = 0; y < height; y++) {
            int[] components = pixels[y][x].getComponents();
            int red = components[0];
            int green = components[1];
            int blue = components[2];
            Color color = new Color(red, green, blue);
            int rgb = color.getRGB();
            b.setRGB(x, y, rgb);
          }
        }
        try {
          ImageIO.write(b, extension, new File(fileName));
        } catch (Exception e) {
          sendMessage("Unable to write to file.");
        }
        break;
      default:
        throw new IllegalArgumentException("Unsupported file format.");

    }
  }

}
