package com.fescfafic.pdi.raiox;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Binarize {
    public static void main(String[] args) {
        try {

            BufferedImage originalImage = ImageIO.read(new File("C:\\Users\\jvictor\\IdeaProjects\\PDI\\src\\com\\fescfafic\\pdi\\raiox\\image\\Hematomas-e-equimoses-web3.jpg"));
            int width = originalImage.getWidth();
            int height = originalImage.getHeight();


            int limiar = 128;


            BufferedImage binarizedImage = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_BINARY);


            List<PixelInfo> changedPixels = new ArrayList<>();


            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {

                    int pixel = originalImage.getRGB(j, i);


                    int red = (pixel >> 16) & 0xff;
                    int green = (pixel >> 8) & 0xff;
                    int blue = pixel & 0xff;
                    int gray = (red + green + blue) / 3;

                    if (gray < limiar) {
                        binarizedImage.setRGB(j, i, 0x000000);
                        changedPixels.add(new PixelInfo(j, i, gray, "Preto"));
                    } else {
                        binarizedImage.setRGB(j, i, 0xffffff);
                        changedPixels.add(new PixelInfo(j, i, gray, "Branco"));
                    }
                }
            }


            ImageIO.write(binarizedImage, "jpg", new File("imagem_binarizada10.jpg"));


            System.out.println("Pixels binarizados:");
            for (PixelInfo pixelInfo : changedPixels) {
                System.out.println("Posição: (" + pixelInfo.x + ", " + pixelInfo.y + "), Valor de Cinza: " + pixelInfo.grayValue + ", Cor: " + pixelInfo.color);
            }

            System.out.println("\nInformações da imagem original:");
            System.out.println("Largura: " + width);
            System.out.println("Altura: " + height);

            System.out.println("Imagem binarizada salva com sucesso.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class PixelInfo {
        int x;
        int y;
        int grayValue;
        String color;

        PixelInfo(int x, int y, int grayValue, String color) {
            this.x = x;
            this.y = y;
            this.grayValue = grayValue;
            this.color = color;
        }
    }
}