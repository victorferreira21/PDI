package Questao1;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Cores {
    public static void main(String[] args) {
        try {
            BufferedImage imagemOriginal = ImageIO.read(new File("caminho_da_sua_imagem.png"));
            BufferedImage imagemDestacada = extrairCorBranca(imagemOriginal);

            File output = new File("caminho_da_imagem_destacada.png");
            ImageIO.write(imagemDestacada, "png", output);

            System.out.println("Extração de cor branca concluída");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static BufferedImage extrairCorBranca(BufferedImage imagemOriginal) {
        int largura = imagemOriginal.getWidth();
        int altura = imagemOriginal.getHeight();

        BufferedImage imagemDestacada = new BufferedImage(largura, altura, BufferedImage.TYPE_INT_ARGB);

        for (int x = 0; x < largura; x++) {
            for (int y = 0; y < altura; y++) {
                Color corOriginal = new Color(imagemOriginal.getRGB(x, y));
                int red = corOriginal.getRed();
                int green = corOriginal.getGreen();
                int blue = corOriginal.getBlue();

                if (red == 150 && green == 150 && blue == 150) {
                    imagemDestacada.setRGB(x, y, Color.LIGHT_GRAY.getRGB());
                } else {
                    imagemDestacada.setRGB(x, y, Color.BLACK.getRGB());
                }
            }
        }

        return imagemDestacada;
    }
}
