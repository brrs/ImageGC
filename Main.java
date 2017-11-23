import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.RescaleOp;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;

public class Main {
    private static void methodWhatMakeWhiteFrameOnPic(WritableRaster raster){
        for (int i = 0; i < raster.getWidth(); i++) {
            for (int j = 0; j < 20; j++) {
                int[] pixel = raster.getPixel(i,j, new int[4]);
                pixel[0] = 255; // red
                pixel[1] = 255; // green
                pixel[2] = 255; // blue
                //pixel[3] = 255; // alpha ch
                raster.setPixel(i, j, pixel);
            }
        }
        for (int i = 0; i < raster.getWidth(); i++) {
            for (int j = 0; j < 584; j++) {
                if (i < 20 || i > 584) {
                    int[] pixel = raster.getPixel(i,j, new int[4]);
                    pixel[0] = 255; // red
                    pixel[1] = 255; // green
                    pixel[2] = 255; // blue
                    //pixel[3] = 255; // alpha ch
                    raster.setPixel(i, j, pixel);
                }

            }
        }
        for (int i = 0; i < raster.getHeight(); i++) {
            if (i > 583)
            {
                for (int j = 0; j < raster.getWidth(); j++) {
                    int[] pixel = raster.getPixel(i,j, new int[4]);
                    pixel[0] = 255; // red
                    pixel[1] = 255; // green
                    pixel[2] = 255; // blue
                    //pixel[3] = 255; // alpha ch
                    raster.setPixel(j, i, pixel);
                }
            }
        }
    }
    public static void main(String[] args) throws IOException{
        String from = "C:\\Users\\Bohdan\\Desktop\\f\\Изображение 073.jpg";
        String where = "C:\\Users\\Bohdan\\Desktop\\f\\result.jpg";
        ImageFrame.aMethodThatMakesAFrameForAnImage(20, 255, 255, 255,from, where);
    }
}
