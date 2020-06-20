package gui;

import javax.imageio.stream.FileImageOutputStream;
import javax.imageio.stream.ImageOutputStream;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class GifCreator implements PropertyChangeListener {
    private ArrayList<BufferedImage> images;
    private String gifname;

    @Override
    public void propertyChange(PropertyChangeEvent propertyChangeEvent) {
        images.add((BufferedImage)propertyChangeEvent.getNewValue());
    }

    GifCreator(String gifname) {
        images = new ArrayList<>();
        this.gifname = gifname;
    }

    void createGif() {
        try {
            // grab the output image type from the first image in the sequence
            BufferedImage firstImage = images.get(0);

            // create a new BufferedOutputStream with the last argument
            System.out.println("JJ");
            ImageOutputStream output =
                    new FileImageOutputStream(new File(gifname + ".gif"));

            // create a gif sequence with the type of the first image, 1 second
            // between frames, which loops continuously
            GifSequenceWriter writer =
                    new GifSequenceWriter(output, firstImage.getType(), 1, false);

            // write out the first image to our sequence...
            writer.writeToSequence(firstImage);
            for (int i = 1; i < images.size(); i++) {
                writer.writeToSequence(images.get(i));
            }

            writer.close();
            output.close();
        }
        catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
