package project;

import java.awt.image.BufferedImage;

public class Rotate extends Converter {

    public Rotate() {
    }

    public static BufferedImage toRotate(BufferedImage img) {

        int width = img.getWidth();
        int height = img.getHeight();

       BufferedImage rotatedImage = new BufferedImage(height, width, BufferedImage.TYPE_INT_ARGB);

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {

                int pixel = img.getRGB(x, y);

                rotatedImage.setRGB(height - 1 - y, x, pixel);
            }
        }

        return rotatedImage;
    }
}