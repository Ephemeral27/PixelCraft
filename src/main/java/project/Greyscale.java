package project;

import java.awt.image.BufferedImage;

public class Greyscale extends Converter{

    public static BufferedImage toGreyscale (BufferedImage img){
        BufferedImage greyImage = new BufferedImage(
            img.getWidth(), img.getHeight(), BufferedImage.TYPE_BYTE_GRAY);
        int rgb=0, r=0, g=0, b=0;
        for(int y=0; y<img.getHeight(); y++){
            for(int x=0; x<img.getWidth(); x++){
                //rgb = (int)(img.getRGB(x, y));

                //my changes
                int pixel = img.getRGB(x, y);
                //getting pixel colors
                ARGB color = new ARGB(pixel);
                //getting the grey value
                int grey = (color.red + color.green + color.blue)/3;

                //make the grey
                ARGB greyColor = new ARGB(color.alpha, grey, grey, grey);

                //set the pixel color
                greyImage.setRGB(x, y, greyColor.toInt());


            }
        }
        return greyImage;
    }
    
}