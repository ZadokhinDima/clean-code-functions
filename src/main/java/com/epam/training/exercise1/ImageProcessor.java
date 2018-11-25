package com.epam.training.exercise1;

public class ImageProcessor {

    public static ImageFrame[][] getFrameMatrix(Image image, int matrixWidth, int matrixHeight) {
        int stepY = image.getHeight() / matrixHeight;
        int stepX = image.getWidth() / matrixWidth;

        final ImageFrame[][] imageFrames = new ImageFrame[matrixWidth][matrixHeight];
        for (int i = 0; i < matrixWidth; i++) {
            for (int j = 0; j < matrixHeight; j++) {
                final Coordinate topLeft = new Coordinate(stepX * i, stepY * j);
                final Coordinate bottomRight = new Coordinate(stepX * (i + 1), stepY * (j + 1));
                imageFrames[i][j] = new ImageFrame(image, topLeft , bottomRight);
            }
        }
        return imageFrames;
    }

}
