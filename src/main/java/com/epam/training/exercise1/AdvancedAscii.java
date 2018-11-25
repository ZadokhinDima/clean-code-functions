package com.epam.training.exercise1;

import java.io.IOException;

public class AdvancedAscii {

    private static final int WIDTH = 200;
    private static final int HEIGHT = 60;

	public static void main(String[] args) throws IOException {
		Image image = Image.createImage("pair_hiking.png");

        final AsciiMapper asciiMapper = new AsciiMapper(image, WIDTH, HEIGHT);

        final char[][] asciiRepresentation = asciiMapper.getAsciiRepresentation();

        for (int y = 0; y < HEIGHT; y++) {
			for (int x = 0; x < WIDTH; x++) {
				System.out.print(asciiRepresentation[x][y]);
			}
			System.out.println();
		}
	}

}
