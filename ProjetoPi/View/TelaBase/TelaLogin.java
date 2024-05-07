package TelaBase;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;

public class TelaLogin {

	private static Point mouseDownCompCoords;
	JFrame frame = new JFrame();
	Boolean apertou = false;
	JButton maximo = new JButton("□");
	JButton administrador = new JButton("Entrar como administrador");
	JButton botaoCadastrar = new JButton("Cadastrar"){
		
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
	JButton botaoEntrar = new JButton("Entrar"){
		
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
	JButton fecha = new JButton("X");
	JButton minimo = new JButton("━");
	ImageIcon imagem = new ImageIcon("C:\\Users\\User\\eclipse-workspace\\ProjetoPi\\View\\Imagens\\IconMenu.png");
	JLabel containerImagem = new JLabel(imagem);
	JPanel panelImagem = new JPanel();
	JPanel botoesMeio = new JPanel();
	JPanel novaBarra = new JPanel(new BorderLayout()) {
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.black);
			g.fillRect(0, 0, getWidth(), getHeight());
			g.setColor(Color.WHITE);
			g.drawString("Tela Login", getWidth() / 2 - 30, 25);
		}
	};
	public TelaLogin() {
		
	}

	public TelaLogin(boolean ligaTela) {
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
		
		
		//Daqui para baixo é o codigo que vai no centro da tela

		// Define o tamanho do painel
		botoesMeio.setBounds(0, 40, frame.getWidth(), frame.getHeight());
		botoesMeio.setLayout(null);
		// Define a cor
		botoesMeio.setBackground(Color.black);
		//Botao do meio cadastrar
		criaBotao("botaoCadastrar",botaoCadastrar,botoesMeio.getWidth() / 2 - 100, botoesMeio.getHeight() / 2 - 10, 200,30,new Color(255, 180, 91),Color.black,null);
		//Botao do meio Entrar
		criaBotao("botaoEntrar",botaoEntrar,botoesMeio.getWidth() / 2 - 100, botoesMeio.getHeight() / 2 + 30, 200,30,new Color(255, 180, 91),Color.black,null);
		//Botao Administrador
		criaBotao("administrador",administrador,botoesMeio.getWidth() / 2 - 95 , botoesMeio.getHeight() / 2 + 60, 190,20,Color.black,new Color(255, 180, 91),null);
		//Botao X para fechar a tela
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
				minimo.setName("minimo");
				minimo.addMouseListener(eventoMouse(minimo));
				botaoCadastrar.setName("botaoCadastrar");
				botaoCadastrar.addMouseListener(eventoMouse(botaoCadastrar));
				botaoEntrar.setName("botaoEntrar");
				botaoEntrar.addMouseListener(eventoMouse(botaoEntrar));
				administrador.setName("administrador");
				administrador.addMouseListener(eventoMouse(administrador));
				
		
		//Adiciona a imagem em um painel
		panelImagem.add(containerImagem);
		panelImagem.setBackground(Color.black);
		panelImagem.setBounds(botoesMeio.getWidth() / 2 - 80, botoesMeio.getHeight() / 2 + -200, 200, 200);
		//Adiciona os botoes em um painel
		botoesMeio.add(botaoCadastrar);
		botoesMeio.add(administrador);
		botoesMeio.add(botaoEntrar);
		//adiciona os paineis na tela
		frame.getContentPane().add(panelImagem);
		frame.getContentPane().add(botoesMeio);

		frame.setVisible(ligaTela);
	}

	// Metodo para maximizar a tela e desmaximizar
	public void maximiza(ActionEvent actionEvent) {
		if (apertou == false) {
			frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
			novaBarra.setBounds(0, 0, frame.getWidth(), 40);
			botoesMeio.setBounds(0, 40, frame.getWidth(), frame.getHeight());
			botaoEntrar.setBounds(botoesMeio.getWidth() / 2 - 100, botoesMeio.getHeight() / 2 + 30, 200, 30);
			administrador.setBounds(botoesMeio.getWidth() / 2 - 100, botoesMeio.getHeight() / 2 + 60, 200, 30);
			botaoCadastrar.setBounds(botoesMeio.getWidth() / 2 - 100, botoesMeio.getHeight() / 2 - 10, 200, 30);
			panelImagem.setBounds(botoesMeio.getWidth() / 2 - 80, botoesMeio.getHeight() / 2 + -200, 200, 200);
			maximo.setText("❐");
			apertou = true;
		} else {
			frame.setSize(1000, 600);
			frame.setLocationRelativeTo(null);
			novaBarra.setBounds(0, 0, frame.getWidth(), 40);
			botoesMeio.setBounds(0, 40, frame.getWidth(), frame.getHeight());
			botaoEntrar.setBounds(botoesMeio.getWidth() / 2 - 100, botoesMeio.getHeight() / 2 + 30, 200, 30);
			administrador.setBounds(botoesMeio.getWidth() / 2 - 100, botoesMeio.getHeight() / 2 + 60, 200, 30);
			botaoCadastrar.setBounds(botoesMeio.getWidth() / 2 - 100, botoesMeio.getHeight() / 2 - 10, 200, 30);
			panelImagem.setBounds(botoesMeio.getWidth() / 2 - 80, botoesMeio.getHeight() / 2 + -200, 200, 200);
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
		}else if(botao.getName().equalsIgnoreCase("botaoEntrar") || botao.getName().equalsIgnoreCase("botaoCadastrar")) {
			evento =new java.awt.event.MouseAdapter() {
			    public void mouseEntered(java.awt.event.MouseEvent evt) {
			    	botao.setBackground(Color.white);
					botao.setForeground(Color.black);
			    }

			    public void mouseExited(java.awt.event.MouseEvent evt) {
			    	botao.setBackground(new Color(255, 180, 91));
			    	botao.setForeground(Color.black);
			    }};
		}else if(botao.getName().equalsIgnoreCase("administrador")){
			evento =new java.awt.event.MouseAdapter() {
				    public void mouseEntered(java.awt.event.MouseEvent evt) {
						botao.setForeground(Color.white);
				    }

				    public void mouseExited(java.awt.event.MouseEvent evt) {
				    	botao.setForeground(new Color(255, 180, 91));
				    }};
		}  
		return evento;
	}
	
	
}