package TelasAdm;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class TelaAltera {
	private static Point mouseDownCompCoords;
	JFrame frame = new JFrame();
	Boolean apertou = false;
	JButton maximo = new JButton("□");
	JButton fecha = new JButton("X");
	JButton minimo = new JButton("━");
	JPanel painelMeio = new JPanel();
	JTextField nPesquisar = new JTextField() {        
		
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D graphics2D = (Graphics2D) g.create();
            int width = getWidth();
            int height = getHeight();
            int cornerRadius = 10;
            RoundRectangle2D roundedRectangle = new RoundRectangle2D.Float(0, 0, width - 1, height - 1, cornerRadius,cornerRadius);
            graphics2D.setColor(getBackground());
            graphics2D.setColor(getForeground());
            graphics2D.setStroke(new BasicStroke(5));
            graphics2D.draw(roundedRectangle);
            graphics2D.dispose();
            
          
        }
        
	};
	ImageIcon imagem = new ImageIcon("C:\\Users\\User\\eclipse-workspace\\ProjetoPi\\View\\Imagens\\Pesquisar.png");
	ImageIcon imagemHover = new ImageIcon("C:\\Users\\User\\eclipse-workspace\\ProjetoPi\\View\\Imagens\\pesquisarHover.png");
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
	JButton pesquisar = new JButton();
	JLabel nomeRestaurante = new JLabel();
	ImageIcon rImagem = new ImageIcon("C:\\Users\\User\\eclipse-workspace\\ProjetoPi\\View\\Imagens\\mani.jpg");
	ImageIcon imagems = new ImageIcon("C:\\Users\\User\\eclipse-workspace\\ProjetoPi\\View\\Imagens\\Estrelas.png");
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
JLabel containerStrelas = new JLabel();
	JPanel restaurante = new JPanel(new BorderLayout()) {
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
        
    };
	JPanel novaBarra = new JPanel(new BorderLayout()) {
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.black);
			g.fillRect(0, 0, getWidth(), getHeight());
			g.setColor(Color.WHITE);
			g.drawString("Alterar Restaurante", getWidth() / 2 - 30, 25);
		}
	};
	public TelaAltera() {
		
	}

	public TelaAltera(boolean ligaTela) {
		// Remove a barra de titulo padrao
		frame.setUndecorated(true);
		// Define o tamanho
		frame.setSize(1000, 600);
		// Centraliza
		frame.setLocationRelativeTo(null);
		frame.setLayout(null);
		// Cria um barra de titulo nova
		// define o tamanho da barra com a largura no tamanho da tela e a altura em 30
		novaBarra.setBounds(0, 0, frame.getWidth(), 40);

		// cria um painel para juntar os botoes
		JPanel botoes = new JPanel();
		// Define o tamanho do painel
		botoes.setSize(300, 30);
		// Define a cor
		botoes.setBackground(Color.black);
		// Adiciona os botoes ao painel
		botoes.add(minimo);
		botoes.add(maximo);
		botoes.add(fecha);
		// adiciona o painel de botoes na barra de titulo
		novaBarra.add(botoes, BorderLayout.EAST);

		// Adiciona um evento para quando clicar o mouse na tela, pegar as coordenadas
		frame.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				mouseDownCompCoords = e.getPoint();
			}
		});
		// Adiciona um evento para quando clicar o mouse na tela e arrastar pegar as coordenadas e subtrair com a antiga parada
		frame.addMouseMotionListener(new MouseAdapter() {
			public void mouseDragged(MouseEvent e) {
				Point currCoords = e.getLocationOnScreen();
				frame.setLocation(currCoords.x - mouseDownCompCoords.x, currCoords.y - mouseDownCompCoords.y);
			}
		});
		
		// Adiciona a barra de titulo na tela
		frame.getContentPane().add(novaBarra);
		criaBotao("fecha",fecha, 0, 0, 0, 0, Color.black, Color.white,fecha.getFont().deriveFont(Font.BOLD, 14));
		//Botao que maximiza a tela
		criaBotao("maximo",maximo, 0, 0, 0, 0, Color.black, Color.white,maximo.getFont().deriveFont(Font.BOLD, 14));
		//Botao que minimiza a tela
		criaBotao("minimo",minimo, 0, 0, 0, 0, Color.black, Color.white,minimo.getFont().deriveFont(Font.BOLD, 14));
		// Chama a funcao para fechar a tela
				fecha.addActionListener(e -> frame.dispose());
				// Chama a funçao para evento de maximizar a tela
				maximo.addActionListener(this::maximiza);
				// Chama a funçao para evento de minimizar a tela
				minimo.addActionListener(e -> frame.setState(JFrame.ICONIFIED));
				//adiciona o metodo de hover nos botoes do barra de titulo e da nome a eles
				fecha.addMouseListener(eventoMouse(fecha));
				maximo.addMouseListener(eventoMouse(maximo));
				minimo.addMouseListener(eventoMouse(minimo));
		//Daqui para baixo é o codigo que vai no centro da tela

		// Define o tamanho do painel
		painelMeio.setBounds(0, 40, frame.getWidth(), frame.getHeight());
		painelMeio.setLayout(null);
		// Define a cor
		painelMeio.setBackground(Color.black);
		
		criaBotao("pesquisa",pesquisar,painelMeio.getWidth()/2+220,painelMeio.getHeight()/2-210, 30, 40, Color.black, Color.white,pesquisar.getFont().deriveFont(Font.BOLD, 14));
		pesquisar.setLayout(null);
		pesquisar.setIcon(imagem);
		pesquisar.addMouseListener(eventoMouse(pesquisar));
		
		nPesquisar.setBounds(painelMeio.getWidth() / 2 - 190, painelMeio.getHeight() / 2 - 200, 400, 30);
		nPesquisar.setBackground(Color.gray);
		nPesquisar.setBorder(null);
		nPesquisar.setText("Digite o nome do restaurante que deseja Alterar"); 
		nPesquisar.setForeground(Color.black);
		nPesquisar.setHorizontalAlignment(0);
		nPesquisar.setName("Texto");
		nPesquisar.addMouseListener(eventoMouseField(nPesquisar));
   
		
		restaurante.setBackground(new Color(23, 23, 23));
		restaurante.setBounds(painelMeio.getWidth() / 2 - 230, painelMeio.getHeight() / 2 - 100, 500, 200);
		restaurante.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Adiciona margem ao redor do painel
		restaurante.setLayout(null);
		restaurante.setOpaque(false);
		
		containerImagem.setBounds(restaurante.getWidth()/2-100,restaurante.getHeight()/2-50,200,110);
		containerImagem.setBackground(new Color(23, 23, 23));
		containerImagem.setForeground(new Color(23, 23, 23));
		containerImagem.setOpaque(false);
		Image img = rImagem.getImage();
		Image imgScale = img.getScaledInstance(containerImagem.getWidth(),containerImagem.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon imagempronta = new ImageIcon(imgScale);
		containerImagem.setBackground(new Color(23, 23, 23));
		containerImagem.setOpaque(false);
		containerImagem.setIcon(imagempronta);
		
		
		containerStrelas.setBounds(restaurante.getWidth()/2-55,restaurante.getHeight()/2+50, 120, 40);
		containerStrelas.setIcon(imagems);
		restaurante.add(containerImagem);
		restaurante.add(containerStrelas);
		restaurante.addMouseListener(eventoMouseRestaurante(restaurante));
		
		pNomeRestaurante.setBounds(restaurante.getWidth()/2-247,restaurante.getHeight()/2-100, 495, 25);
		pNomeRestaurante.setBackground(new Color(255, 180, 91));
		pNomeRestaurante.setOpaque(false);
		
		
		nomeRestaurante.setText("Mani");
		nomeRestaurante.setForeground(Color.black);
		nomeRestaurante.setHorizontalAlignment(0);
		
		pNomeRestaurante.add(nomeRestaurante,BorderLayout.CENTER);
		restaurante.add(pNomeRestaurante);
		
		
		painelMeio.add(pesquisar);
		painelMeio.add(nPesquisar);
		painelMeio.add(restaurante);
		//adiciona o painel preto na tela
		frame.getContentPane().add(painelMeio);

		frame.setVisible(ligaTela);
	}
	 
	
	// Metodo para maximizar a tela e desmaximizar
	public void maximiza(ActionEvent actionEvent) {
		if (apertou == false) {
			frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
			novaBarra.setBounds(0, 0, frame.getWidth(), 40);
			painelMeio.setBounds(0, 40, frame.getWidth(), frame.getHeight());
			pesquisar.setBounds(painelMeio.getWidth()/2+220,painelMeio.getHeight()/2-210, 30, 40);
			nPesquisar.setBounds(painelMeio.getWidth() / 2 - 190, painelMeio.getHeight() / 2 - 200, 400, 30);
			restaurante.setBounds(painelMeio.getWidth() / 2 - 230, painelMeio.getHeight() / 2 - 100, 500, 200);
			restaurante.add(pNomeRestaurante,BorderLayout.NORTH);
			maximo.setText("❐"); 
			apertou = true;
		} else {
			frame.setSize(1000, 600);
			frame.setLocationRelativeTo(null);
			novaBarra.setBounds(0, 0, frame.getWidth(), 40);
			painelMeio.setBounds(0, 40, frame.getWidth(), frame.getHeight());
			pesquisar.setBounds(painelMeio.getWidth()/2+220,painelMeio.getHeight()/2-210, 30, 40);
			nPesquisar.setBounds(painelMeio.getWidth() / 2 - 190, painelMeio.getHeight() / 2 - 200, 400, 30);
			restaurante.setBounds(painelMeio.getWidth() / 2 - 230, painelMeio.getHeight() / 2 - 100, 500, 200);
			restaurante.add(pNomeRestaurante,BorderLayout.NORTH);
			maximo.setText("□");
			apertou = false;
		}
	}
	//Metodo Cria botao
	public JButton criaBotao(String nome,JButton botao,int x, int y, int largura, int altura,Color corB,Color corF,Font fonte) {
		botao.setName(nome);
		botao.setBounds(x, y, largura, altura);
		botao.setBackground(corB);
		botao.setForeground(corF);
		botao.setFocusPainted(false);
		botao.setBorderPainted(false);
		botao.setFont(fonte);
		return botao;
	}
	//Metodo adiciona evento de mouse botoes
	public MouseAdapter eventoMouse(JButton botao) {
		MouseAdapter evento = null;
		if(botao.getName().equalsIgnoreCase("fecha") || botao.getName().equalsIgnoreCase("maximo") || botao.getName().equalsIgnoreCase("minimo")){
			evento = new java.awt.event.MouseAdapter() {
				 public void mouseEntered(java.awt.event.MouseEvent evt) {
				        botao.setBackground(Color.red);
				    }
				    public void mouseExited(java.awt.event.MouseEvent evt) {
				        botao.setBackground(Color.black);
				    }};
		}if(botao.getName().equalsIgnoreCase("pesquisa")){
			evento = new java.awt.event.MouseAdapter() {
				 public void mouseEntered(java.awt.event.MouseEvent evt) {
					 pesquisar.setIcon(imagemHover);
				    }
				    public void mouseExited(java.awt.event.MouseEvent evt) {
				    	pesquisar.setIcon(imagem);
				    }};
		}
		return evento;
	}
	public MouseAdapter eventoMouseField(JTextField j) {
		MouseAdapter evento = null;
		if(j.getName().equalsIgnoreCase("Texto")){
			evento = new java.awt.event.MouseAdapter() {
				 public void mouseClicked(java.awt.event.MouseEvent evt) {
				       j.setText("");
				    }
				    };
		}
		return evento;
	}
	public MouseAdapter eventoMouseRestaurante(JPanel p ) {
		MouseAdapter evento = null;
		
			evento = new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent evt) {
			       JOptionPane.showMessageDialog(null,"Alterar Restaurante ?");
			    }
				 public void mouseEntered(java.awt.event.MouseEvent evt) {
				        p.setBackground(Color.white);
				        pNomeRestaurante.setBackground(Color.white);
				    }
				    public void mouseExited(java.awt.event.MouseEvent evt) {
				    	 p.setBackground(new Color(23, 23, 23));
				    	 pNomeRestaurante.setBackground(new Color(255, 180, 91));
				    }};
		
		return evento;
	}
	
	public static void main(String[] args) { 
		new TelaAltera(true);
	}
	
}
