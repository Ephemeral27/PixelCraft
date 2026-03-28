package project;

import java.awt.image.BufferedImage;

public class Flip extends Converter{

    public static BufferedImage toFlip(BufferedImage img){ 
        int width = img.getWidth();
        int height = img.getHeight();

        BufferedImage result = new BufferedImage(width,height, img.getType());
        //BufferedImage result = new BufferedImage(width,height, BufferedImage.TYPE_INT_ARGB);

        for(int y=0; y<img.getHeight(); y++){
            for(int x=0; x<img.getWidth(); x++){
                int pixelColor = img.getRGB(x, y);
                result.setRGB(width -1 -x, y, pixelColor);
            }
        }
        return result;
    }
}