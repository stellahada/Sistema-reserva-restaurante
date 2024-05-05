package BuscarRestaurante;
import javax.swing.*;
import java.awt.*;
class Restaurante extends JPanel {

    private String nome;
    private ImageIcon imagem;
    private int estrelas;

    public Restaurante(String nome, ImageIcon imagem, int estrelas) {
        setBackground(new Color(23, 23, 23));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        
        this.nome = nome;
        JPanel namePanel = new JPanel();
        namePanel.setBackground(new Color(255, 180, 91));
        JLabel nameLabel = new JLabel(nome);
        nameLabel.setFont(new Font("Arial", Font.BOLD, 14)); // Altera a fonte
        nameLabel.setForeground(Color.black);
        namePanel.add(nameLabel); 
        add(namePanel);


        this.imagem = imagem;
        JPanel imagemPainel = new JPanel();
       Image foto = imagem.getImage();
       Image fotoRestaurante = foto.getScaledInstance(300, 180,  java.awt.Image.SCALE_SMOOTH); //renderizando o tamanho da imagem
       imagem = new ImageIcon(fotoRestaurante);
       JLabel imagemLabel = new JLabel(imagem);
       imagemPainel.add(imagemLabel);
       imagemPainel.setBackground(new Color(23, 23, 23)); //cor de fundo do painel
       add(imagemPainel);
       
        this.estrelas = estrelas;
        JPanel estrelasPanel = new JPanel();
        ImageIcon icon = new ImageIcon(getClass().getResource("caminho_da_estrela.png"));
        Image image = icon.getImage();
        Image newimg = image.getScaledInstance(20, 20,  java.awt.Image.SCALE_SMOOTH); 
        // Redimensiona para 20x20
        icon = new ImageIcon(newimg);
        
        estrelasPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
      
        estrelasPanel.setBackground(new Color(23, 23, 23));
        for (int i = 0; i < estrelas; i++) {
            JLabel estrelaLabel = new JLabel(icon);
            estrelasPanel.add(estrelaLabel);
        }
        estrelasPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        add(estrelasPanel);

        
    }

    public String getNome() {
        return nome;
    }

    public ImageIcon getImagem() {
        return imagem;
    }

    public int getEstrelas() {
        return estrelas;
    }
}
