package com.epam.training.exercise1;

public class ImageFrame {

    private Image image;
    private Coordinate topLeft;
    private Coordinate bottomRight;

    public ImageFrame(final Image image, final Coordinate topLeft, final Coordinate bottomRight) {
        this.image = image;
        this.topLeft = topLeft;
        this.bottomRight = bottomRight;
    }

    public Coordinate getTopLeft() {
        return topLeft;
    }

    public void setTopLeft(final Coordinate topLeft) {
        this.topLeft = topLeft;
    }

    public Coordinate getBottomRight() {
        return bottomRight;
    }

    public void setBottomRight(final Coordinate bottomRight) {
        this.bottomRight = bottomRight;
    }

    public int getIntencity(final Coordinate coordinate) {
        return image.getIntensity(getAbsoluteCoordinate(coordinate));
    }

    public int getWidth() {
        return bottomRight.getX() - topLeft.getX();
    }

    public int getHeight() {
        return bottomRight.getY() - topLeft.getY();
    }

    public int getRed(Coordinate coordinate) {
        final Coordinate absoluteCoordinate = getAbsoluteCoordinate(coordinate);
        return image.getRed(absoluteCoordinate);
    }

    public int getGreen(Coordinate coordinate) {
        final Coordinate absoluteCoordinate = getAbsoluteCoordinate(coordinate);
        return image.getGreen(absoluteCoordinate);
    }

    public int getBlue(Coordinate coordinate) {
        final Coordinate absoluteCoordinate = getAbsoluteCoordinate(coordinate);
        return image.getBlue(absoluteCoordinate);
    }

    private Coordinate getAbsoluteCoordinate(Coordinate frameCoordinate) {
        return new Coordinate(topLeft.getX() + frameCoordinate.getX(), topLeft.getY() + frameCoordinate.getY());
    }



}
