package project;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class PixelCraft {

    /*
     * Append converter name to the input filename, before the file extension.
     * For example, if the input filename is "image.png" and the converter name is "GrayScale",
     * the output filename will be "image_GrayScale.png".
     */
    static String getOutputFilename(String inputFileName, String converterName) {
        int dotIndex = inputFileName.lastIndexOf(".");
        return inputFileName.substring(0, dotIndex) + "_" + converterName + inputFileName.substring(dotIndex);
    }

    public static void main(String[] args) {

        // Ensure that a converter name and a filename has been provided
        if (args.length < 2) {
            System.out.println("Usage: java -cp \"path/to/classes\" PixelCraft <ConverterName/Greyscale/Invert/Rotate/Blur> <image_file.png>");
            System.exit(1);
        }

        String converterName = args[0];
        String inputFileName = args[1];
        String outputFileName = getOutputFilename(inputFileName, converterName);

        try {
            BufferedImage inputImage = ImageIO.read(new File(inputFileName));
            BufferedImage outputImage = null;

            if (converterName.equals("Greyscale")) {
                outputImage = Greyscale.toGreyscale(inputImage);
            }
            else if (converterName.equals("Invert")) {
                outputImage = Invert.toInvert(inputImage);
            }
            else if (converterName.equals("Rotate")) {
                outputImage = Rotate.toRotate(inputImage);
            }
            else if (converterName.equals("Blur")) {
                outputImage = Blur.toBlur(inputImage);
            }
            else {
                System.out.println("Error: Unknown converter name.");
                System.exit(1);
            }

            ImageIO.write(outputImage, "PNG", new File(outputFileName));

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}