package project;

import java.awt.image.BufferedImage;

public class Blur extends Converter {

    public Blur() {
    }

    public static BufferedImage toBlur(BufferedImage img) {
        // Create a new image with the same dimensions as the input
        BufferedImage blurImage = new BufferedImage(
                img.getWidth(),
                img.getHeight(),
                BufferedImage.TYPE_INT_ARGB
        );

        // Loop through every pixel in the image
        for (int y = 0; y < img.getHeight(); y++) {
            for (int x = 0; x < img.getWidth(); x++) {
                
                // Variables to accumulate color values
                int alpha = 0;
                int r = 0;
                int g = 0;
                int b = 0;
                int count = 0;
                
                // Loop through neighboring pixels (15x15 block)
                for (int i = y - 7; i <= y + 7; i++) {
                    for (int j = x - 7; j <= x + 7; j++) {
                        
                        // Check if the neighbor pixel is inside image bounds
                        if (j >= 0 && j < img.getWidth() && i >= 0 && i < img.getHeight()) {
                            
                            // Get pixel color
                            int pixel = img.getRGB(j, i);
                            ARGB color = new ARGB(pixel);
                            
                            // Add color values to totals
                            alpha += color.alpha;
                            r += color.red;
                            g += color.green;
                            b += color.blue;
                            count++;
                        }
                    }
                }
                // Compute average color of the block
                ARGB blurColor = new ARGB(
                        alpha / count,
                        r / count,
                        g / count,
                        b / count
                );
                
                // Set blurred pixel into new image
                blurImage.setRGB(x, y, blurColor.toInt());
            }
        }

        return blurImage;
    }
}