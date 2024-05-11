package BuscarRestaurante;
import javax.swing.*;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.geom.RoundRectangle2D;

class Restaurante extends JPanel {
    private String nome;
    private ImageIcon imagem;
    private int estrelas;
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D graphics2D = (Graphics2D) g.create();
        int width = getWidth();
        int height = getHeight();
        int cornerRadius = 20;
        RoundRectangle2D roundedRectangle = new RoundRectangle2D.Float(0, 0, width - 1, height - 1, cornerRadius,cornerRadius);
        graphics2D.setColor(getBackground());
        graphics2D.fill(roundedRectangle);
        graphics2D.setColor(getForeground());
        graphics2D.draw(roundedRectangle);
        graphics2D.dispose();
    }
    
    

    public Restaurante(String nome, ImageIcon imagem, int estrelas) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(new Color(23, 23, 23));
		setBounds(300/ 2 - 230, 180 / 2 - 100, 500, 200);
		setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Adiciona margem ao redor do painel
		setOpaque(false);
       
        this.estrelas = estrelas;
        JPanel estrelasPanel = new JPanel();
        ImageIcon icon = new ImageIcon(getClass().getResource("caminho_da_estrela.png"));
        Image image = icon.getImage();
        Image newimg = image.getScaledInstance(20, 20,  java.awt.Image.SCALE_SMOOTH); 
        icon = new ImageIcon(newimg);
        
        estrelasPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
      
        estrelasPanel.setBackground(new Color(23, 23, 23));
        for (int i = 0; i < estrelas; i++) {
            JLabel estrelaLabel = new JLabel(icon);
            estrelasPanel.add(estrelaLabel);
        }
        estrelasPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        estrelasPanel.setOpaque(false);
    

        JLabel containerImagem = new JLabel(){
		
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D graphics2D = (Graphics2D) g.create();
                int width = getWidth();
                int height = getHeight();
                int cornerRadius = 30;
                RoundRectangle2D roundedRectangle = new RoundRectangle2D.Float(0, 0, width - 1, height - 1, cornerRadius,cornerRadius);
                graphics2D.setColor(getBackground());
                graphics2D.setColor(getForeground());
                graphics2D.setStroke(new BasicStroke(15));
                graphics2D.draw(roundedRectangle);
                graphics2D.dispose();
                
              
            }
            
        };
		
        this.imagem = imagem;
       
		containerImagem.setBounds(500/2-100,400/2-50,200,110);
		containerImagem.setBackground(new Color(23, 23, 23));
		containerImagem.setForeground(new Color(23, 23, 23));
		containerImagem.setOpaque(false);
        Image img = imagem.getImage();
		Image imgScale = img.getScaledInstance(300,180, Image.SCALE_SMOOTH);
		ImageIcon imagempronta = new ImageIcon(imgScale);
		containerImagem.setBackground(new Color(23, 23, 23));
        containerImagem.setLayout(new FlowLayout(FlowLayout.CENTER));
        containerImagem.setHorizontalAlignment(0);

		containerImagem.setOpaque(false);
		containerImagem.setIcon(imagempronta);



        JPanel pNomeRestaurante = new JPanel(new BorderLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D graphics2D = (Graphics2D) g.create();
                int width = getWidth();
                int height = getHeight();
                int cornerRadius = 15;
                RoundRectangle2D roundedRectangle = new RoundRectangle2D.Float(0, 0, width - 1, height - 1, cornerRadius, cornerRadius);
                graphics2D.setColor(getBackground());
                graphics2D.fill(roundedRectangle);
                graphics2D.setColor(getForeground());
                graphics2D.draw(roundedRectangle);
                graphics2D.dispose();
            }
        };
        pNomeRestaurante.setBounds(400/2-247,300/2-100, 495, 25);
		pNomeRestaurante.setBackground(new Color(255, 180, 91));
		pNomeRestaurante.setOpaque(false);
		
		this.nome = nome;
        JLabel nomeRestaurante = new JLabel(nome);
        nomeRestaurante.setForeground(Color.black);
		nomeRestaurante.setHorizontalAlignment(0);
        pNomeRestaurante.add(nomeRestaurante,BorderLayout.CENTER);
        add(pNomeRestaurante);
        add(containerImagem);
        add(estrelasPanel);
        
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                // Código exemplo para lidar com o evento de clique
                JOptionPane.showMessageDialog(null, "Você clicou no restaurante " + nome);
            }
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                setBackground(Color.white);
                nomeRestaurante.setBackground(Color.white);
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                nomeRestaurante.setBackground(new Color(255, 180, 91));
                setBackground(new Color(23, 23, 23));
               
            }
        });
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