package view;

import java.io.IOException;

/**
 * Represents the view for Image Processors. At current, it only displays messages that tell the
 * user about successful or unsuccessful actions.
 */
public interface ImageProcessorView {

  /**
   * Renders the given message.
   * @param message the message to be rendered
   * @throws IOException if unable to write to the Appendable
   */
  void renderMessage(String message) throws IOException;

}
