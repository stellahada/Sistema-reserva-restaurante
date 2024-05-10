package TelasLogin;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TelaLoginADM {

	private static Point mouseDownCompCoords;
	JFrame frame = new JFrame();
	Boolean apertou = false;
	
	JButton maximo = new JButton("□");
	JButton fecha = new JButton("X");
	JButton minimo = new JButton("━");
	
	ImageIcon imagem = new ImageIcon(getClass().getResource("user.png"));
	JLabel containerImagem = new JLabel(imagem);
	
	JTextField campoNome, campoSenha;
	JLabel labelNome, labelSenha, labelLogin;
	
	JButton botaoLogin;
	
	JPanel barraLogin = new JPanel();
	JPanel panelImagem = new JPanel();
	JPanel conteudoMeioDaTela = new JPanel();
	JPanel panelGeral = new JPanel();
	JPanel novaBarra = new JPanel(new BorderLayout()) {
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setFont(fecha.getFont().deriveFont(Font.BOLD, 14));
			g.setColor(Color.black);
			g.fillRect(0, 0, getWidth(), getHeight());
			g.setColor(Color.white);
			g.drawString("", getWidth() / 2 - 80, 25);
		}
	};

	public TelaLoginADM() {
		// Remove a barra de titulo padrao
		frame.setUndecorated(true);
		// Define o tamanho
		frame.setSize(1000, 600);
		// Centraliza
		frame.setLocationRelativeTo(null);
		frame.setLayout(null);

		// Cria um barra de titulo nova
		// define o tamanho da barra com a largura no tamanho da tela e a altura em 40
		novaBarra.setBounds(0, 0, frame.getWidth(), 40);

		// cria um painel para juntar os botoes
		JPanel botoes = new JPanel();
		// Define o tamanho do painel
		botoes.setSize(300, 30);
		// Define a cor
		botoes.setBackground(Color.black);

		// Adiciona uma açao no botao para fechar a tela
		fecha.addActionListener(e -> frame.dispose());
		// Muda a fonte e o tamanho da letra do botao
		fecha.setFont(fecha.getFont().deriveFont(Font.BOLD, 14));
		// Tira o design que fica em volta do botao
		fecha.setFocusPainted(false);
		// Tira o sublinhado do botao
		fecha.setBorderPainted(false);
		// Muda a cor
		fecha.setBackground(Color.black);
		fecha.setForeground(Color.white);
		

		// Mesma coisa do botao de cima
		maximo.setFont(maximo.getFont().deriveFont(Font.BOLD, 14));
		maximo.setFocusPainted(false);
		maximo.setBorderPainted(false);
		maximo.setBackground(Color.black);
		maximo.setForeground(Color.white);
		// Chama a funçao para evento de maximizar a tela
		maximo.addActionListener(this::maximiza);

		minimo.addActionListener(e -> frame.setState(JFrame.ICONIFIED));
		minimo.setFont(minimo.getFont().deriveFont(Font.BOLD, 14));
		minimo.setFocusPainted(false);
		minimo.setBorderPainted(false);
		minimo.setBackground(Color.black);
		minimo.setForeground(Color.white);
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
		// Adiciona um evento para quando clicar o mouse na tela e arrastar pegar as
		// coordenadas e subtrair com a antiga parada
		frame.addMouseMotionListener(new MouseAdapter() {
			public void mouseDragged(MouseEvent e) {
				Point currCoords = e.getLocationOnScreen();
				frame.setLocation(currCoords.x - mouseDownCompCoords.x, currCoords.y - mouseDownCompCoords.y);
			}
		});
		// Adiciona a barra de titulo na tela
		frame.getContentPane().add(novaBarra);
		
		//cria a barra de laranja acima do 'form'
		barraLogin.setBounds(20,30,frame.getWidth()-40,50);
		barraLogin.setBackground(new Color(255,180,91));
		barraLogin.setLayout(null);

		
		//cria a label de login
		labelLogin = criaLabel(barraLogin.getWidth()/2+-80, 10, 250, 30, "labelLogin" , "login Administrador");
		labelLogin.setForeground(Color.black);
		labelLogin.setFont(fecha.getFont().deriveFont(Font.BOLD, 14));
		
		barraLogin.add(labelLogin);
		
		
		
		// =======DAQUI PARA BAIXO É O CÓDIGO QUE VAI NO CENTRO DA TELA========
		
		// Define o tamanho e posicao do painel de fundo
		panelGeral.setBounds(0, 0, frame.getWidth(), frame.getHeight());
		panelGeral.setLayout(null);
		// Define a cor
		panelGeral.setBackground(Color.BLACK);

		// Define o tamanho e posicao do painel do conteúdo do meio da tela
		conteudoMeioDaTela.setBounds(frame.getHeight()/20, frame.getWidth()/10, frame.getWidth()-50, frame.getHeight()-240);
		conteudoMeioDaTela.setLayout(null);
		// Define a cor
		conteudoMeioDaTela.setBackground(Color.black);
		conteudoMeioDaTela.setBorder(BorderFactory.createLineBorder(Color.white, 1, true));
		
		//Adiciona a imagem em um painel
		panelImagem.add(containerImagem);
		panelImagem.setBackground(Color.black);
		panelImagem.setBounds(conteudoMeioDaTela.getWidth() / 20, conteudoMeioDaTela.getHeight() + -200, 200, 200);

		//Cria os campos da tela
		campoNome = criaCampo(conteudoMeioDaTela.getWidth()/4+40, conteudoMeioDaTela.getHeight()+-260,400,30,"campoNome");
		campoSenha = criaCampo(conteudoMeioDaTela.getWidth()/4+40, conteudoMeioDaTela.getHeight()+-140,400,30,"campoSenha");
		//Adiciona os campos em um painel
		conteudoMeioDaTela.add(campoNome);
		conteudoMeioDaTela.add(campoSenha);
		
		//cria os labels da tela
		labelNome = criaLabel(conteudoMeioDaTela.getWidth()/4+40, conteudoMeioDaTela.getHeight()+-290,60,30,"labelNome","Nome");
		labelSenha = criaLabel(conteudoMeioDaTela.getWidth()/4+40, conteudoMeioDaTela.getHeight()+-170,400,30,"campoSenha","Senha");
		//Adiciona os labels em um painel
		conteudoMeioDaTela.add(labelNome);
		conteudoMeioDaTela.add(labelSenha);
		
		//cria o botão da tela
		botaoLogin = criaBotao(panelGeral.getWidth()/2+-150, panelGeral.getHeight()/2+200,280,40,"botaoLogin", "Entrar");
		//Adiciona os campos em um painel
		panelGeral.add(botaoLogin);
		
		//adiciona o evento hover no botao
		botaoLogin.addMouseListener(eventoMouse(botaoLogin));
		
		//adiciona os paineis na tela
		frame.getContentPane().add(barraLogin);
		frame.getContentPane().add(panelImagem);
		frame.getContentPane().add(conteudoMeioDaTela);
		frame.getContentPane().add(panelGeral);
		
		
		frame.setVisible(true);
		acoes();
}
	
	public JLabel criaLabel(int x, int y, int width, int heigth, String nome, String texto) {
		JLabel jl = new JLabel();
		jl.setText(texto);
		jl.setName(nome);
		jl.setForeground(Color.white);
		jl.setBounds(x, y, width, heigth);
		
		return jl;
	}
	
	public JTextField criaCampo(int x, int y, int width, int heigth, String nome) {
		JTextField jtf = new JTextField();
		jtf.setName(nome);
		jtf.setBackground(Color.BLACK);
		jtf.setForeground(Color.white);
		jtf.setBorder(BorderFactory.createLineBorder(Color.white, 1, true));
		jtf.setBounds(x, y, width, heigth);
		
		return jtf;
	}

	public JButton criaBotao(int x, int y, int width, int heigth, String nome, String Texto) {
		JButton jb = new JButton();
		jb.setText(Texto);
		jb.setName(nome);
		jb.setBackground(new Color(255,180,91));
		jb.setBounds(x, y, width, heigth);
		
		return jb;
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
		} else if (botao.getName().equalsIgnoreCase("botaoLogin")) {
			evento = new java.awt.event.MouseAdapter() {
				public void mouseEntered(java.awt.event.MouseEvent evt) {
					botao.setBackground(new Color(217, 217, 217));
				}

				public void mouseExited(java.awt.event.MouseEvent evt) {
					botao.setBackground(new Color(255, 180, 91));
				}
			};
		}
		return evento;
	}

// Metodo para maximizar a tela e desmaximizar
	private void maximiza(ActionEvent actionEvent) {
		if (apertou == false) {
			frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
			novaBarra.setBounds(0, 0, frame.getWidth(), 40);
			panelGeral.setBounds(0, 0, frame.getWidth(), frame.getHeight());
			conteudoMeioDaTela.setBounds(frame.getHeight()/8, frame.getWidth()/10, frame.getWidth()-250, frame.getHeight()-380);
			panelImagem.setLocation(conteudoMeioDaTela.getWidth() / 8 +-50, conteudoMeioDaTela.getHeight() / 4+100);
			botaoLogin.setLocation(panelGeral.getWidth()/2+-165, conteudoMeioDaTela.getHeight()+250);
			barraLogin.setBounds(20,30,frame.getWidth()-40,50);
			labelLogin.setLocation(barraLogin.getWidth()/2+-80, 10);
			maximo.setText("❐");
			apertou = true;
		} else {
			frame.setSize(1000, 600);
			frame.setLocationRelativeTo(null);
			novaBarra.setBounds(0, 0, frame.getWidth(), 40);
			conteudoMeioDaTela.setBounds(frame.getHeight()/20, frame.getWidth()/10, frame.getWidth()-50, frame.getHeight()-240);
			panelImagem.setLocation(conteudoMeioDaTela.getWidth() / 20, conteudoMeioDaTela.getHeight() + -200);
			botaoLogin.setLocation(conteudoMeioDaTela.getWidth()/2+-130, conteudoMeioDaTela.getHeight()+140);
			barraLogin.setBounds(20,30,frame.getWidth()-40,50);
			labelLogin.setLocation(barraLogin.getWidth()/2+-80, 10);
			maximo.setText("□");
			apertou = false;
		}
	}
	
	//Funcao destinadada as acoes dos botoes
	public void acoes() {
		String nome, senha;
		
		nome = campoNome.getText();
		senha = campoSenha.getText();
		
		if(nome.length()>0 && senha.length()>0) {
			//Logica de implmentacao
		}
	}
	
	public static void main(String[] args) {
		new TelaLoginADM();
	}
}
