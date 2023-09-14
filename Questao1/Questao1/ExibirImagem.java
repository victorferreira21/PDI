package Questao1;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ExibirImagem {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            exibirImagemDestacada();
        });
    }

    public static void exibirImagemDestacada() {
        try {
            BufferedImage imagemDestacada = ImageIO.read(new File("C:\\Users\\jvictor\\IdeaProjects\\PDI\\src\\Image\\12-Cores.png"));

            JFrame frame = new JFrame("Imagem Destacada");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            ImageIcon icon = new ImageIcon(imagemDestacada);
            JLabel label = new JLabel(icon);

            frame.getContentPane().add(label);
            frame.pack();
            frame.setVisible(true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
