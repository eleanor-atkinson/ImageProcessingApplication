Model:

interface ImageProcessor: represents the model of this program, allows users to load and save images
	as well as brighten, darken, horizontallly flip, vertically flip, and grayscale images using 
	their red, blue, green, intensity, luma, and value components. Color transformations are
	also possible.

	class ImageProcessorImpl: specific implementation of ImageProcessor,
		which allows a user to run the previously defined commands. Images are stored in
		a Map<String, Image>  

interface Image: represents an image of some format (implementation dependent). An Image is able to 
	perform the previously described operations on itself, (with the exception of load and save,
	as those are model-specific)

	class PPMImage: this specific implementation of Image represents a PPM image made up of RGBPixels.
		While the image itself is an RGBPixel[][], the toString method represents the image's text
		representation in PPM format.

interface RGBPixel: represents a pixel with 3 channels: Red, Green, Blue. This pixel can adjust itself
	to its red component, green component, blue component, value component, intensity component,
	and luma component.

	class 24BitPixel: specific implementation of RGBPixel that represents a Pixel with three 24-bit channels,
		i.e. each channel has a value from 0,255. The toString() method returns this 24BitPixel's
		text representation in PPM format. 

View:

interface ImageProcessorView: represents the view for an ImageProcessor. Because there is no GUI currently
		implemented, the only thing this view does is send success and error messages to the user.

	class ImageProcessorViewImpl: specific implementation of ImageProcessorView that takes a model
		and writes messages to be displayed to the user to an Appendable

Controller:

interface ImageProcessorController: represents the controller for the ImageProcessor model. 
	the go() method takes inputs from the user and executes the given command in the model.

	class ImageProcessorControllerImpl: specific implemenation of ImageProcessorController.
		available commands: "load", "save", "red-component", "green-component", "blue-component",
			"intensity-component", "value-component", "luma-component", "brighten", 
			"horizontal-flip", "vertical-flip", "q", "quit", "sepia"

interface ImageProcessorCommands: represent command Objects that are used in the controller. These include:
	class Load
	class Save
	class RedComponent
	class BlueComponent
	class GreenComponent
	class ValueComponent
	class IntensityComponent
	class LumaComponent
	class HorizontalFlip
	class VerticalFlip
	class Sepia

TESTS:

class ImageProcessorControllerImplTest
	tests the controller

class ImageProcessorViewImplTest
	tests the view

class PPMImageTest
	tests the images that we have implemented

class TwentyFourBitPixelTest 
	tests the 24bitpixels we have implemented

SCRIPT:

#type this into the program after running main
load res/UAEflag.ppm flag
vertical-flip flag vflag
red-component vflag vrflag
save res/UAEflipred.ppm vrflag

DESIGN CHANGES:

Before, inputting and outputting images to/from files was being
handled by the model, which does not follow the MVC pattern.
Therefore, in ImageProcessorControllerImpl, we added two private
methods: input() and output(), which handles reading and writing to files

In the ImageProcessor interface, the load() method was changed
to take an Image instead of a String for the file name, and
the save() method was removed because it was now obsolete.
These same changes were repeated in the implementation of this 
interface.

In the Image, ImageProcessor, and RGBPixel interfaces,
the method transformation() was added to allow for color 
transformations. This rendered the lunacomponent() method
from these interfaces obsolete, but these implementations 
were left in, as they still worked.

ORIGINAL IMAGE UAEflag.ppm created using a text editor by Bartosz Mamro
Permission is given to be used in this assignment.
