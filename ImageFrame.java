import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;

public class ImageFrame {
    public static void aMethodThatMakesAFrameForAnImage(int factor, int red, int green, int blue, String pathFrom, String pathWhere) throws IOException {
        File file = new File(pathFrom);
        BufferedImage image = ImageIO.read(file);
        int width, height, k, kw, kh;
        k = factor;
        kw = (int)(image.getWidth() / 100 * k);
        kh = (int)(image.getHeight() / 100 * k);
        width = kw * 2 + image.getWidth();
        height = kh * 2 + image.getHeight();

        BufferedImage bi = new BufferedImage(width, height, 1);

        WritableRaster raster = image.getRaster();
        WritableRaster rasterReSize = bi.getRaster();

        for (int i = 0; i < rasterReSize.getWidth(); i++) {
            for (int j = 0; j < rasterReSize.getHeight(); j++) {
                int[] pixel = rasterReSize.getPixel(i, j, new int[4]);
                pixel[0] = red;
                pixel[1] = green;
                pixel[2] = blue;
                rasterReSize.setPixel(i, j, pixel);
            }
        }
        for (int i = kh, iForOriginal = 0;  i < raster.getHeight() + kh; i++) {
            for (int j = kw, jForOriginal = 0; j < raster.getWidth() + kw; j++) {
                int[] pixelFrom = raster.getPixel(jForOriginal , iForOriginal, new int[4]);
                rasterReSize.setPixel(j, i, pixelFrom);
                jForOriginal++;
            }
            iForOriginal++;
        }
        ImageIO.write(bi, "jpg", new File(pathWhere));

    }
}
