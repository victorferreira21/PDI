package Questao4;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Questao4 {
    public static void main(String[] args) {
        try {
            BufferedImage imagemOriginal = ImageIO.read(new File("C:\\Users\\jvictor\\IdeaProjects\\PDI\\src\\Questao4\\image\\imagem2.jpg"));

            int largura = imagemOriginal.getWidth();
            int altura = imagemOriginal.getHeight();

            BufferedImage imagemResultado = new BufferedImage(largura, altura, BufferedImage.TYPE_INT_ARGB);

            Color corRosa = new Color(210, 195, 198);

            for (int x = 0; x < largura; x++) {
                for (int y = 0; y < altura; y++) {
                    Color corPixel = new Color(imagemOriginal.getRGB(x, y));

                    if (isTonalidadeRosa(corPixel, corRosa)) {
                        corPixel = new Color(corPixel.getRed(), corPixel.getGreen(), corPixel.getBlue(), 0);
                    }

                    imagemResultado.setRGB(x, y, corPixel.getRGB());
                }
            }

            File output = new File("C:\\Users\\jvictor\\IdeaProjects\\PDI\\src\\Questao4\\image\\Flor.png");
            ImageIO.write(imagemResultado, "png", output);

            System.out.println("Fundo transparente Conluido");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean isTonalidadeRosa(Color cor, Color corRosa) {
        int limiteRed = 40; 
        int limiteGreen = 40;
        int limiteBlue = 40; 

        int diffRed = Math.abs(cor.getRed() - corRosa.getRed());
        int diffGreen = Math.abs(cor.getGreen() - corRosa.getGreen());
        int diffBlue = Math.abs(cor.getBlue() - corRosa.getBlue());

        return diffRed <= limiteRed && diffGreen <= limiteGreen && diffBlue <= limiteBlue;
    }
}

