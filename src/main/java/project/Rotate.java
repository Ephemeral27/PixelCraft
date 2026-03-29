package project;

import java.awt.image.BufferedImage;

public class Rotate extends Converter {

    public Rotate() {
    }

    public static BufferedImage toRotate(BufferedImage img) {

        // Get original image dimensions
        int width = img.getWidth();
        int height = img.getHeight();

        // Create a new image with swapped dimensions
        BufferedImage rotatedImage = new BufferedImage(height, width, BufferedImage.TYPE_INT_ARGB);
       
        // Loop through every pixel in the original image
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {

                // Get the color of the current pixel
                int pixel = img.getRGB(x, y);
                
                // Place the pixel in its new rotated position
                // (x, y) -> (height - 1 - y, x)
                rotatedImage.setRGB(height - 1 - y, x, pixel);
            }
        }

        return rotatedImage;
    }
}