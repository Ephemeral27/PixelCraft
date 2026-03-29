package project;

import java.awt.image.BufferedImage;

public class Pixelate extends Converter {

    public static BufferedImage toPixelate(BufferedImage img) {
        
        // Get image dimensions
        int width = img.getWidth();
        int height = img.getHeight();
        
        // Create output image
        BufferedImage result = new BufferedImage(width, height, img.getType());

        // Size of each pixel block
        int blockSize = 15; 

        // Loop through image in blocks
        for (int y = 0; y < height; y += blockSize) {
            for (int x = 0; x < width; x += blockSize) {

                int r = 0;
                int g = 0;
                int b = 0;
                int count = 0;

                // Get average color of block
                for (int dy = 0; dy < blockSize; dy++) {
                    for (int dx = 0; dx < blockSize; dx++) {

                        int px = x + dx;
                        int py = y + dy;
                        
                        // Make sure we stay inside image bounds
                        if (px < width && py < height) {
                            int pixel = img.getRGB(px, py);
                            ARGB color = new ARGB(pixel);

                            r += color.red;
                            g += color.green;
                            b += color.blue;
                            count++;
                        }
                    }
                }
                // Compute average color
                ARGB avgColor = new ARGB(255, r / count, g / count, b / count);

                // Fill block with that color
                for (int dy = 0; dy < blockSize; dy++) {
                    for (int dx = 0; dx < blockSize; dx++) {

                        int px = x + dx;
                        int py = y + dy;

                        if (px < width && py < height) {
                            result.setRGB(px, py, avgColor.toInt());
                        }
                    }
                }
            }
        }

        return result;
    }
}