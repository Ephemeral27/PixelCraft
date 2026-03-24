package project;

import java.awt.image.BufferedImage;

public class Blur extends Converter {

    public Blur() {
    }

    public static BufferedImage toBlur(BufferedImage img) {

        BufferedImage blurImage = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_ARGB);

        for (int y = 0; y < img.getHeight(); y++) {
            for (int x = 0; x < img.getWidth(); x++) {

                int alpha = 0;
                int r = 0;
                int g = 0;
                int b = 0;
                int count = 0;

                // loop through surrounding pixels (3x3)
                for (int i = y - 1; i <= y + 1; i++) {
                    for (int j = x - 1; j <= x + 1; j++) {

                        // check boundaries
                        if (j >= 0 && j < img.getWidth() && i >= 0 && i < img.getHeight()) {

                            int pixel = img.getRGB(j, i);
                            ARGB color = new ARGB(pixel);

                            alpha += color.alpha;
                            r += color.red;
                            g += color.green;
                            b += color.blue;

                            count++;
                        }
                    }
                }

                // average values
                ARGB blurColor = new ARGB(
                        alpha / count,
                        r / count,
                        g / count,
                        b / count
                );

                blurImage.setRGB(x, y, blurColor.toInt());
            }
        }

        return blurImage;
    }
}