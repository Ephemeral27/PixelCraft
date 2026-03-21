package project;

import java.awt.image.BufferedImage;

public class Invert extends Converter{

    public static BufferedImage toInvert (BufferedImage img){
        BufferedImage invertImage = new BufferedImage(
            img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_ARGB); 
        int rgb=0, r=0, g=0, b=0;
        for(int y=0; y<img.getHeight(); y++){
            for(int x=0; x<img.getWidth(); x++){
                //rgb = (int)(img.getRGB(x, y));

                //my changes
                int pixel = img.getRGB(x, y);
                //getting pixel colors
                ARGB color = new ARGB(pixel);
                //getting the grey value
                int newRed = 255 -color.red;
                int newGreen = 255 -color.green;
                int newBlue = 255 -color.blue;

                //make the grey
                ARGB invertColor = new ARGB(color.alpha, newRed, newGreen, newBlue);

                //set the pixel color
                invertImage.setRGB(x, y, invertColor.toInt());


            }
        }
        return invertImage;
    }
    
}