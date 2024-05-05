package BuscarRestaurante;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class BuscarRestaurante extends JFrame {
    int distTopo = 20;
    JButton pesquisar = new JButton("Pesquisar");
    JTextField txtBuscar;
	JPanel panel = new JPanel();

	private static Point mouseDownCompCoords;
	JFrame frame = new JFrame();
	Boolean apertou = false;
	JButton maximo = new JButton("□");
	JButton fecha = new JButton("X");
	JButton minimo = new JButton("━");
	JPanel painelMeio = new JPanel();
	JPanel novaBarra = new JPanel(new BorderLayout()) {
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.black);
			g.fillRect(0, 0, getWidth(), getHeight());
			g.setColor(Color.WHITE);
			g.drawString("Restaurantes", getWidth() / 2 - 30, 25);
		}
	};
	public BuscarRestaurante() {
		
	}

	public BuscarRestaurante(boolean ligaTela) {
		frame.setUndecorated(true);
		frame.setSize(1000, 600);
		frame.setLocationRelativeTo(null);
		frame.setLayout(null);
		novaBarra.setBounds(0, 0, frame.getWidth(), 40);

		JPanel botoes = new JPanel();
		botoes.setSize(300, 30);
		botoes.setBackground(Color.black);
		botoes.add(minimo);
		botoes.add(maximo);
		botoes.add(fecha);
		novaBarra.add(botoes, BorderLayout.EAST);

		// Adiciona um evento para quando clicar o mouse na tela, pegar as coordenadas
		frame.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				mouseDownCompCoords = e.getPoint();
			}
		});
		frame.addMouseMotionListener(new MouseAdapter() {
			public void mouseDragged(MouseEvent e) {
				Point currCoords = e.getLocationOnScreen();
				frame.setLocation(currCoords.x - mouseDownCompCoords.x, currCoords.y - mouseDownCompCoords.y);
			}
		});
		frame.getContentPane().add(novaBarra);
		
		painelMeio.setBounds(0, 40, frame.getWidth(), frame.getHeight());
		painelMeio.setLayout(null);
		painelMeio.setBackground(Color.black);
		criaBotao("fecha",fecha, 0, 0, 0, 0, Color.black, Color.white,fecha.getFont().deriveFont(Font.BOLD, 14));
		criaBotao("maximo",maximo, 0, 0, 0, 0, Color.black, Color.white,maximo.getFont().deriveFont(Font.BOLD, 14));
		criaBotao("minimo",minimo, 0, 0, 0, 0, Color.black, Color.white,minimo.getFont().deriveFont(Font.BOLD, 14));
		
		// Chama a funcao para fechar a tela
		fecha.addActionListener(e -> frame.dispose());
		maximo.addActionListener(this::maximiza);
		minimo.addActionListener(e -> frame.setState(JFrame.ICONIFIED));
		//adiciona o metodo de hover nos botoes do barra de titulo e da nome a eles
				fecha.addMouseListener(eventoMouse(fecha));
				maximo.addMouseListener(eventoMouse(maximo));
				minimo.addMouseListener(eventoMouse(minimo));
		frame.getContentPane().add(painelMeio);
        

		//CÓDIGO DA TELA BUSCAR RESTAURANTE
		//código para o botao pesquisar
		pesquisar.setBackground(new Color(255, 180, 91));
		pesquisar.setForeground(Color.black);
		pesquisar.setFocusPainted(false);
		pesquisar.setBorderPainted(false);

        frame.getContentPane().add(pesquisar);
       
		//adicionando ao painel meio
        painelMeio.add(criarJTextField(txtBuscar,distTopo));
		pesquisar.setBounds(760,20,120,30);
		painelMeio.add(pesquisar);


		// Criando objetos Restaurante
		Restaurante restaurante1 = new Restaurante("Coco Bambu", new ImageIcon(getClass().getResource("coco-bambu-iguatemi.jpg")), 4);
		Restaurante restaurante2 = new Restaurante("Restaurante B", new ImageIcon(getClass().getResource("coco-bambu-iguatemi.jpg")), 3);
		Restaurante restaurante3 = new Restaurante("Restaurante C", new ImageIcon(getClass().getResource("coco-bambu-iguatemi.jpg")), 4);

		// Criando lista de restaurantes exemplo
		List<Restaurante> restaurantes = new ArrayList<>();
		restaurantes.add(restaurante1);
		restaurantes.add(restaurante2);
		restaurantes.add(restaurante3);

		// Criando o RestaurantePanel com a lista de restaurantes
		ListaRestaurante panelRestaurantes = new ListaRestaurante(restaurantes);
		panelRestaurantes.setPreferredSize(new Dimension(500, 400)); //tamanho do painel restaurante
		panel.setBounds(250,100,0,0);
		//adionando a um painel
		panel.add(panelRestaurantes); 
		panel.setSize(500, 400); //tamanho do painel
		painelMeio.add(panel);

        frame.setVisible(ligaTela);

       
	}
    private JTextField criarJTextField(JTextField jt, int distTopo) {
        jt = new JTextField();
        jt.setFont(new Font("Garamond", Font.PLAIN, 20));
        jt.setSize(580,30);
        jt.selectAll();
        jt.setLocation(170, distTopo);
        return jt;
    }

	

	// Metodo para maximizar a tela e desmaximizar
	public void maximiza(ActionEvent actionEvent) {
		if (apertou == false) {
			frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
			novaBarra.setBounds(0, 0, frame.getWidth(), 40);
			painelMeio.setBounds(0, 40, frame.getWidth(), frame.getHeight());
			maximo.setText("❐");
			apertou = true;
		} else {
			frame.setSize(1000, 600);
			frame.setLocationRelativeTo(null);
			novaBarra.setBounds(0, 0, frame.getWidth(), 40);
			painelMeio.setBounds(0, 40, frame.getWidth(), frame.getHeight());
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
		}
		return evento;
	}
	
	public static void main(String[] args) {
		new BuscarRestaurante(true);
	}
	
	
}