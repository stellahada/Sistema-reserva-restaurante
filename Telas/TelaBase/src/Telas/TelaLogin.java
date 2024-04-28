package Telas;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TelaLogin {

	private static Point mouseDownCompCoords;
	JFrame frame = new JFrame();
	Boolean apertou = false;
	JButton maximo = new JButton("□");
	JButton administrador = new JButton("Entrar como administrador");
	JButton botaoCadastrar = new JButton("Cadastrar");
	JButton botaoEntrar = new JButton("Entrar");
	ImageIcon imagem = new ImageIcon(getClass().getResource("Group 18.png"));
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

		// Cria um botao para fechar a tela
		JButton fecha = new JButton("X");
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

		// Mesma coisa botao de cima
		JButton minimo = new JButton("━");
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
		
		
		//Daqui para baixo é o codigo que vai no centro da tela

		// Define o tamanho do painel
		botoesMeio.setBounds(0, 40, frame.getWidth(), frame.getHeight());
		botoesMeio.setLayout(null);
		// Define a cor
		botoesMeio.setBackground(Color.black);
		//Botao do meio cadastrar
		botaoCadastrar.setBounds(botoesMeio.getWidth() / 2 - 100, botoesMeio.getHeight() / 2 - 10, 200, 30);
		botaoCadastrar.setBackground(new Color(255, 180, 91));
		botaoCadastrar.setForeground(Color.black);
		botaoCadastrar.setFocusPainted(false);
		botaoCadastrar.setBorderPainted(false);
		//Botao do meio Entrar
		botaoEntrar.setBounds(botoesMeio.getWidth() / 2 - 100, botoesMeio.getHeight() / 2 + 30, 200, 30);
		botaoEntrar.setBackground(new Color(255, 180, 91));
		botaoEntrar.setForeground(Color.black);
		botaoEntrar.setFocusPainted(false);
		botaoEntrar.setBorderPainted(false);
		//Botao Administrador
		administrador.setBounds(botoesMeio.getWidth() / 2 - 100, botoesMeio.getHeight() / 2 + 60, 200, 30);
		administrador.setBackground(Color.black);
		administrador.setForeground(new Color(255, 180, 91));
		administrador.setFocusPainted(false);
		administrador.setBorderPainted(false);
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

		frame.setVisible(true);
	}

	public static void main(String[] args) {
		new TelaLogin();
	}

	// Metodo para maximizar a tela e desmaximizar
	private void maximiza(ActionEvent actionEvent) {
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
}