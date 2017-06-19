package Inicio;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Models.Pokemon;
import Models.Contenedor;

import javax.swing.AbstractListModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuItem;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class Inicio extends JFrame {
/**
 * Atributos
 */
	JFrame frame;
	private JPanel contentPane;
	private JTextField txnombre;
	private JTextField txnumero;
	private JTextField txnivel;
	private JTextField txregion;
	private JTextField txcomentario;
	private JButton btinsertar;
	private JButton btbuscar;
	private JList listita;
	private ArrayList<Pokemon> lista = new ArrayList<Pokemon>();
	private JMenuItem lectura;
	private JTextField txtIntroduzcaElNombre;
	private JLabel nombre;
	private JLabel numero;
	private JLabel nivel;
	private JLabel region;
	private JLabel tipo;
	private JLabel comentario;
	

	
	/**
	 * Metodos para validar
	 */
		public static String validarnombre(String nombre){
			String mensaje="";
			if(nombre.isEmpty()){
				mensaje="No has introducido el nombre";
			}
			return mensaje;
		}
		
		public static String validarnumero(String numero){
			String mensaje="";
			if(numero.isEmpty()){
				mensaje="No has introducido un numero";
			}
			return mensaje;
		}

		public static String validarnivel(String nivel){
			String mensaje="";
			if(nivel.isEmpty()){
				mensaje="No has introducido el nivel";
			}
			return mensaje;
		}
		public static String validarregion(String region){
			String mensaje="";
			if(region.isEmpty()){
				mensaje="No has introducido una region";
			}
			return mensaje;
		}
		public static String validarcomentario(String comentarios){
			String mensaje="";
			if(comentarios.isEmpty()){
				mensaje="No has introducido un comentario";
			}
			return mensaje;
		}
		

	/**
	 * Inicializa y muestra todos los componentes de la ventana
	 */
	public Inicio() {
		lista = Contenedor.getInstance().getLista();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 608, 398);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btinsertar = new JButton("Insertar pokemon");
		
		btinsertar.setBounds(69, 261, 179, 65);
		contentPane.add(btinsertar);
		
		btbuscar = new JButton("Buscar");
		
		btbuscar.setBounds(366, 261, 179, 65);
		contentPane.add(btbuscar);
		
		txnombre = new JTextField();
		
		txnombre.setBounds(111, 46, 86, 20);
		contentPane.add(txnombre);
		txnombre.setColumns(10);
		
		nombre = new JLabel("Nombre");
		nombre.setBounds(22, 48, 79, 17);
		contentPane.add(nombre);
		
		 numero = new JLabel("Numero");
		 numero.setBounds(22, 86, 79, 20);
		contentPane.add(numero);
		
		 nivel = new JLabel("Nivel evolucion");
		 nivel.setBounds(22, 134, 79, 20);
		contentPane.add(nivel);
		
		 region = new JLabel("Region");
		 region.setBounds(22, 177, 79, 17);
		contentPane.add(region);
		
		txnumero = new JTextField();
		
		txnumero.setBounds(111, 86, 86, 20);
		contentPane.add(txnumero);
		txnumero.setColumns(10);
		
		txnivel = new JTextField();
		
		txnivel.setBounds(111, 134, 86, 20);
		contentPane.add(txnivel);
		txnivel.setColumns(10);
		
		txregion = new JTextField();
		
		txregion.setBounds(111, 175, 86, 20);
		contentPane.add(txregion);
		txregion.setColumns(10);
		
		listita = new JList();
		listita.setModel(new AbstractListModel() {
			String[] values = new String[] {"Agua", "Fuego", "Planta"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		listita.setBounds(405, 48, 115, 65);
		contentPane.add(listita);
		
		 tipo = new JLabel("Lista");
		 tipo.setBounds(333, 48, 62, 17);
		contentPane.add(tipo);
		
		 comentario = new JLabel("Comentario");
		 comentario.setBounds(305, 153, 79, 20);
		contentPane.add(comentario);
		
		txcomentario = new JTextField();
		
		txcomentario.setBounds(396, 153, 149, 79);
		contentPane.add(txcomentario);
		txcomentario.setColumns(10);
		
		lectura = new JMenuItem("Modo lectura");
		
		lectura.setBounds(0, 0, 129, 22);
		contentPane.add(lectura);
		
		txtIntroduzcaElNombre = new JTextField();
		txtIntroduzcaElNombre.setText("Introduzca el nombre del pokemon que deseas encontrar");
		txtIntroduzcaElNombre.setBounds(44, 205, 312, 121);
		contentPane.add(txtIntroduzcaElNombre);
		txtIntroduzcaElNombre.setColumns(10);
		txtIntroduzcaElNombre.setVisible(false);
		
		adaptadores();
		
	}
	/**
	 *Añade y define los adaptadores y listeners de los componentes de la
	 * ventana.
	 */
	
	public void adaptadores(){
		
		/**
		 * TEXTFIELD
		 */
		
		txnombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evento) {
				char c = evento.getKeyChar();
				if (Character.isDigit(c)) {
					evento.consume();
					JOptionPane.showMessageDialog(frame, "No se admiten numeros", "Autenticación",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		txnumero.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
						if ( ( txnumero.LEADING > 3)) {
						} else {
							JOptionPane.showMessageDialog(frame, " No se admite letras.", "ERROR",
									JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		txnivel.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				if ( txnumero.LEADING > 36) {
				} else {
					JOptionPane.showMessageDialog(frame, " No admite letras.", "ERROR",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		txregion.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evento) {
				char c = evento.getKeyChar();
				if (Character.isDigit(c)) {
					evento.consume();
					JOptionPane.showMessageDialog(frame, "No se admiten numeros", "Autenticación",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		txcomentario.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evento) {
				char c = evento.getKeyChar();
				if (Character.isDigit(c)) {
					evento.consume();
					JOptionPane.showMessageDialog(frame, "No se admiten numeros", "Autenticación",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		/**
		 * BOTONES
		 */
		
		btinsertar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean correctotipo = false;
				
				String cadenaError = "";
				String numero=txnumero.getText();
				String nombre=txnombre.getText();
				String nivel=txnivel.getText();
				String region=txregion.getText();
				String comentarios=txcomentario.getText();
				
				cadenaError+=validarnombre(nombre);
				cadenaError+=validarnumero(numero);
				cadenaError+=validarregion(region);
				cadenaError+=validarnivel(nivel);
				cadenaError+=validarcomentario(comentarios);
				
				if(listita.getSelectedIndex() >=0){
					correctotipo=true;
				}else{
					cadenaError +="No ha seleccionado ningun Tipo\n";
				}
				
				if ( !cadenaError.equals("") ) {

					JOptionPane.showMessageDialog(frame, cadenaError);

				} else {
				Pokemon p=new Pokemon(txnombre.getText(), txnumero.getText(), txnivel.getText(),
						txregion.getText(),txcomentario.getText(),listita.getSelectedValue().toString());
				
				lista.add(p);
				
				JOptionPane.showMessageDialog(frame, "Pokemon creado");
				txnombre.setText("");
				txnumero.setText("");
				listita.clearSelection();
				txnivel.setText("");
				txcomentario.setText("");
				txregion.setText("");
				}
			}
		});
		btbuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				txnombre.setVisible(false);
				txnumero.setVisible(false);
				listita.setVisible(false);
				txcomentario.setVisible(false);
				txregion.setVisible(false);
				txnivel.setVisible(false);
				btinsertar.setVisible(false);
				nombre.setVisible(false);
				
				txtIntroduzcaElNombre.setVisible(true);
				
			}
		});
		
		lectura.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(frame, "Modo Lectura");
				txnombre.setEnabled(false);
				txnumero.setEnabled(false);
				listita.setEnabled(false);
				txcomentario.setEnabled(false);
				txregion.setEnabled(false);
				txnivel.setEnabled(false);

				txnombre.setText(lista.get(0).getNombre());
				txnumero.setText(lista.get(0).getNumero());
				listita.setSelectedIndex(0);
				
				btinsertar.setVisible(true);
			
			}
		});
		
	}
}
