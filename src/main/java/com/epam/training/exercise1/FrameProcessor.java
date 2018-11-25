package com.epam.training.exercise1;

public class FrameProcessor {

    public static int findAverageBrightness(ImageFrame imageFrame) {
        int sum = 0;
        for (int x = 0; x < imageFrame.getWidth(); x++) {
            for (int y = 0; y < imageFrame.getHeight(); y++) {
                final Coordinate coordinate = new Coordinate(x, y);
                sum = sum + imageFrame.getIntencity(coordinate);
            }
        }
        return sum / imageFrame.getHeight() / imageFrame.getWidth();
    }


}
