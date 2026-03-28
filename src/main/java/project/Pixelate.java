package project;

import java.awt.image.BufferedImage;

public class Pixelate extends Converter {

    public static BufferedImage toPixelate(BufferedImage img) {

        int width = img.getWidth();
        int height = img.getHeight();

        BufferedImage result = new BufferedImage(width, height, img.getType());

        int blockSize = 15; 

        for (int y = 0; y < height; y += blockSize) {
            for (int x = 0; x < width; x += blockSize) {

                int r = 0;
                int g = 0;
                int b = 0;
                int count = 0;

                // get average color of block
                for (int dy = 0; dy < blockSize; dy++) {
                    for (int dx = 0; dx < blockSize; dx++) {

                        int px = x + dx;
                        int py = y + dy;

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

                ARGB avgColor = new ARGB(255, r / count, g / count, b / count);

                // fill block with that color
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