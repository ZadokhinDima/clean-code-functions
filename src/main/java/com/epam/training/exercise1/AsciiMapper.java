package com.epam.training.exercise1;

public class AsciiMapper {

    private int darkest = 255 * 3;
    private int brightest = 0;

    private static final char[] charsByDarkness = { '#', '@', 'X', 'L', 'I', ':', '.', ' ' };


    private Image image;
    private int width;
    private int height;

    private ImageFrame[][] frames;

    public AsciiMapper(final Image image, final int width, final int height) {
        this.image = image;
        this.width = width;
        this.height = height;
        init();
    }

    public char[][] getAsciiRepresentation() {
        final char[][] result = new char[frames.length][frames[0].length];
        for (int i = 0 ; i < width; i++) {
            for (int j = 0; j < height; j++) {
                result[i][j] = calculateCharForFrame(frames[i][j]);
            }
        }
        return result;
    }

    private void init() {
        frames = ImageProcessor.getFrameMatrix(image, width, height);
        for (int i = 0 ; i < width; i++) {
            for (int j = 0; j < height; j++) {
                final int averageBrightness = FrameProcessor.findAverageBrightness(frames[i][j]);
                if (brightest < averageBrightness) {
                    brightest = averageBrightness;
                }
                if (darkest > averageBrightness) {
                    darkest = averageBrightness;
                }
            }
        }
    }

    private char calculateCharForFrame(ImageFrame frame) {
        final int brightness = FrameProcessor.findAverageBrightness(frame);
        return charsByDarkness[(brightness - darkest) * charsByDarkness.length / (brightest - darkest + 1)];
    }

}
