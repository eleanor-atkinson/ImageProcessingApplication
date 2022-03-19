package controller;

import model.ImageProcessor;

/**
 * Each implementation of this interface represents a command that can be executed on a
 * ImageProcessor.
 */
public interface ImageProcessorCommands {

  /**
   * Runs the created function object on the given model.
   * @param m the given model
   */
  void run(ImageProcessor m);
}

