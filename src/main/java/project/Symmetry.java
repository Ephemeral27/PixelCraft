package project;

import java.awt.image.BufferedImage;

public class Symmetry extends Converter {

    public static BufferedImage toSymmetry(BufferedImage img) {
        // Get the dimensions of the image
        int width = img.getWidth();
        int height = img.getHeight();

        // Create a new image with the same size and type
        BufferedImage result = new BufferedImage(width, height, img.getType());

        // First copy original image into result
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                result.setRGB(x, y, img.getRGB(x, y));
            }
        }

        // Copy left side onto right side
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width / 2; x++) {
                int pixelColor = img.getRGB(x, y);
                result.setRGB(width - 1 - x, y, pixelColor);
            }
        }

        return result;
    }
}