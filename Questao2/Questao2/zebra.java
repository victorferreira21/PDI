package Questao2.image;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class zebra {
    public static void main(String[] args) {
        try {
            BufferedImage imagemPrincipal = ImageIO.read(new File("C:\\Users\\nalar\\IdeaProjects\\peepeepoopoo\\src\\Questao2\\image\\zebra.png"));
            BufferedImage imagemSubstituicao = ImageIO.read(new File("C:\\Users\\nalar\\IdeaProjects\\peepeepoopoo\\src\\Questao2\\image\\oceano.png"));

            int largura = imagemPrincipal.getWidth();
            int altura = imagemPrincipal.getHeight();

            BufferedImage imagemResultado = new BufferedImage(largura, altura, BufferedImage.TYPE_INT_ARGB);

            Color corSubstituir = new Color(18, 255, 0);

            for (int x = 0; x < largura; x++) {
                for (int y = 0; y < altura; y++) {
                    Color corPixel = new Color(imagemPrincipal.getRGB(x, y));

                    if (corPixel.equals(corSubstituir)) {
                        imagemResultado.setRGB(x, y, imagemSubstituicao.getRGB(x, y));
                    } else {
                        imagemResultado.setRGB(x, y, corPixel.getRGB());
                    }
                }
            }

            File output = new File("C:\\Users\\nalar\\IdeaProjects\\peepeepoopoo\\src\\Questao2\\image\\cleiton.png");
            ImageIO.write(imagemResultado, "png", output);

            System.out.println("Substituição de cor concluída.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}