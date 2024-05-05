package BuscarRestaurante;
import java.awt.Color;
import java.util.List;
import javax.swing.*;

public class ListaRestaurante extends JPanel {

    private List<Restaurante> restaurantes;

    public ListaRestaurante(List<Restaurante> restaurantes) {
        this.restaurantes = restaurantes;

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS)); // Define o layout vertical

        // Cria um JPanel principal para conter a lista de restaurantes
        JPanel listaRestaurantesPanel = new JPanel();
        listaRestaurantesPanel.setLayout(new BoxLayout(listaRestaurantesPanel, BoxLayout.Y_AXIS));
        listaRestaurantesPanel.setBackground(new Color(23,23,23));
        
        // Adiciona o JPanel da lista de restaurantes ao painel principal
        for (Restaurante restaurante : restaurantes) {
              Restaurante panelRestaurante = new Restaurante(
                restaurante.getNome(), 
                restaurante.getImagem(), 
               restaurante.getEstrelas()
            );
            listaRestaurantesPanel.add(panelRestaurante);
        }

        // Cria um JScrollPane e adiciona o JPanel da lista de restaurantes a ele
        JScrollPane scrollPane = new JScrollPane(listaRestaurantesPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        // Adiciona o JScrollPane ao painel principal
        add(scrollPane);
    }
}
