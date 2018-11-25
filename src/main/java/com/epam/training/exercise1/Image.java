package com.epam.training.exercise1;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

import javax.imageio.ImageIO;

import static com.google.common.base.Preconditions.checkPositionIndex;

public class Image {

    private static final int LAST_BYTE = 0xFF;
    private static final int BYTE = 8;
    private static final int TWO_BYTES = 16;

    private BufferedImage imageObject;

    public static Image createImage(String fileName) {
        return new Image(fileName);
    }

    public int getHeight() {
        return imageObject.getHeight();
    }

    public int getWidth() {
        return imageObject.getWidth();
    }

    public int getIntensity(Coordinate coordinate) {
        return getRed(coordinate) + getBlue(coordinate) + getGreen(coordinate);
    }

    public int getRed(Coordinate coordinate) {
        int rgbValue = getRgbValue(coordinate);
        return (rgbValue >> TWO_BYTES) & LAST_BYTE;
    }

    public int getGreen(Coordinate coordinate) {
        int rgbValue = getRgbValue(coordinate);
        return (rgbValue >> BYTE) & LAST_BYTE;
    }

    public int getBlue(Coordinate coordinate) {
        int rgbValue = getRgbValue(coordinate);
        return rgbValue & LAST_BYTE;
    }

    private Image(String fileName) {
        this.imageObject = loadImageFromFile(fileName);
    }

    private int getRgbValue(Coordinate coordinate) {
        validateCoordinate(coordinate);
        return imageObject.getRGB(coordinate.getX(), coordinate.getY());
    }

    private BufferedImage loadImageFromFile(String fileName) {
        try {
            return ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResource(fileName)));
        } catch (IOException e) {
            throw new IllegalArgumentException("Image " + fileName + " is not found.");
        }
    }

    private void validateCoordinate(Coordinate coordinate) {
        checkPositionIndex(coordinate.getX(), imageObject.getWidth());
        checkPositionIndex(coordinate.getY(), imageObject.getHeight());
    }

}
