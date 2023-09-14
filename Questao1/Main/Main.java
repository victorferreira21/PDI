package Main;

import Questao1.Cores;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Main {
    public static void main(String[] args) {
        try {
            BufferedImage imagemOriginal = ImageIO.read(new File("C:\\Users\\jvictor\\IdeaProjects\\PDI\\src\\Image\\12-Cores.png"));
            BufferedImage imagemDestacada = Cores.extrairCorBranca(imagemOriginal);

            File output = new File("C:\\Users\\jvictor\\IdeaProjects\\PDI\\src\\Image\\12-Cores.png");
            ImageIO.write(imagemDestacada, "png", output);

            System.out.println("Extração de cor concluída");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
