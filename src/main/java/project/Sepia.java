package project;

import java.awt.image.BufferedImage;

public class Sepia extends Converter{

    public static BufferedImage toGreyscale (BufferedImage img){
        BufferedImage result = new BufferedImage(
            img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_ARGB);
        //int rgb=0, r=0, g=0, b=0;
        for(int y=0; y<img.getHeight(); y++){
            for(int x=0; x<img.getWidth(); x++){
                int pixel = img.getRGB(x, y);
                //getting pixel colors
                ARGB color = new ARGB(pixel);

                int alpha = color.alpha;
                int red = color.red;
                int blue = color.blue;
                int green = color.green;

                int newR = (int)(0.393*red + 0.769*green + 0.189*blue);
                int newG = (int)(0.349*red + 0.686*green + 0.168*blue);
                int newB = (int)(0.272*red + 0.534*green + 0.131*blue);

                newR = Math.min(255, newR);
                newG = Math.min(255, newG);
                newB = Math.min(255, newB);

                int newRGB = (alpha << 24) | (newR << 16) | (newG << 8) | newB;

                result.setRGB(x, y, newRGB);

            }
        }
        return result;
    }
}