import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class ImageResizer implements Runnable {

    private final File[] files;
    private final int newWidth;
    private final String dstFolder;
    private final long start;

    public ImageResizer(File[] files, int newWidth, String dstFolder, long start) {
        this.files = files;
        this.newWidth = newWidth;
        this.dstFolder = dstFolder;
        this.start = start;
    }

    public static BufferedImage resize(BufferedImage src, int newWidth) {

        int newHeight = (int) Math.round(src.getHeight() / (src.getWidth() / (double) newWidth));
        int type = (src.getTransparency() == Transparency.OPAQUE) ?
                BufferedImage.TYPE_INT_RGB : BufferedImage.TYPE_INT_ARGB;
        BufferedImage newImage = new BufferedImage(newWidth, newHeight, type);

        int widthStep = src.getWidth() / newWidth;
        int heightStep = src.getHeight() / newHeight;
        for (int x = 0; x < newWidth; x++) {
            for (int y = 0; y < newHeight; y++) {
                int rgb = src.getRGB(x * widthStep, y * heightStep);
                newImage.setRGB(x, y, rgb);
            }
        }
        return newImage;
    }

    @Override
    public void run() {

        try {
            for (File file : files) {
                BufferedImage image = ImageIO.read(file);
                if (image == null) {
                    continue;
                }

                BufferedImage newImage = resize(image, newWidth);

                File newFile = new File(dstFolder + "/" + file.getName());
                ImageIO.write(newImage, "jpg", newFile);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " finish: " + (System.currentTimeMillis() - start) + " ms");
    }
}
