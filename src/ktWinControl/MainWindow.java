/**
 * 
 */
package ktWinControl;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JToolBar;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.JButton;
import javax.swing.JPanel;
import org.eclipse.wb.swing.FocusTraversalOnArray;

import java.awt.Component;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;

/**
 * 
 */
public class MainWindow {

	private JFrame frmKtUsbControl;
	private JTable table;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frmKtUsbControl.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmKtUsbControl = new JFrame();
		frmKtUsbControl.setTitle("KT USB Control");
		frmKtUsbControl.setBounds(100, 100, 518, 370);
		frmKtUsbControl.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmKtUsbControl.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		frmKtUsbControl.getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(2, 1, 0, 0));
		
		JMenuBar menuBar = new JMenuBar();
		panel.add(menuBar);
		
		JMenu mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);
		
		JMenuItem menuNuevo = new JMenuItem("Nuevo");
		mnArchivo.add(menuNuevo);
		menuNuevo.setIcon(GetResizedIcon("/resources/new.png"));
		
		JMenuItem menuAbrir = new JMenuItem("Abrir...");
		mnArchivo.add(menuAbrir);
		menuAbrir.setIcon(GetResizedIcon("/resources/open.png"));
		
		JMenuItem menuGuardar = new JMenuItem("Guardar");
		mnArchivo.add(menuGuardar);
		menuGuardar.setIcon(GetResizedIcon("/resources/save.png"));
		
		JMenuItem menuGuardarComo = new JMenuItem("Guardar como...");
		mnArchivo.add(menuGuardarComo);
		
		mnArchivo.addSeparator();
		
		JMenuItem mntmSalir = new JMenuItem("Salir");
		mnArchivo.add(mntmSalir);
		mntmSalir.setIcon(GetResizedIcon("/resources/exit.png"));
		
		JMenu mnConexion = new JMenu("Conexión");
		menuBar.add(mnConexion);
		
		JMenuItem mntmConectar = new JMenuItem("Conectar");
		mnConexion.add(mntmConectar);
		mntmConectar.setIcon(GetResizedIcon("/resources/noconnected.png"));
		
		JMenuItem mntmLeer = new JMenuItem("Leer USB");
		mnConexion.add(mntmLeer);
		mntmLeer.setIcon(GetResizedIcon("/resources/download.png"));
		
		JMenuItem mntmEscribir = new JMenuItem("Escribir USB");
		mnConexion.add(mntmEscribir);
		mntmEscribir.setIcon(GetResizedIcon("/resources/upload.png"));
		
		JMenuItem mntmRecargar = new JMenuItem("Recargar USB");
		mnConexion.add(mntmRecargar);
		mntmRecargar.setIcon(GetResizedIcon("/resources/refresh.png"));
		
		mnConexion.addSeparator();
		
		JMenuItem mntmReproducir = new JMenuItem("Reproducir USB");
		mnConexion.add(mntmReproducir);
		mntmReproducir.setIcon(GetResizedIcon("/resources/play.png"));
		
		JMenuItem mntmDetener = new JMenuItem("Detener USB");
		mnConexion.add(mntmDetener);
		mntmDetener.setIcon(GetResizedIcon("/resources/stop.png"));
		
		mnConexion.addSeparator();
		
		JMenuItem mntmVentanaSalida = new JMenuItem("Ventana de salida");
		mnConexion.add(mntmVentanaSalida);
		mntmVentanaSalida.setIcon(GetResizedIcon("/resources/output.png"));
		
		JMenu mnAyuda = new JMenu("Ayuda");
		menuBar.add(mnAyuda);
		
		JMenuItem mntmAcercaDe = new JMenuItem("Acerca de...");
		mnAyuda.add(mntmAcercaDe);
		mntmAcercaDe.setIcon(GetResizedIcon("/resources/help.png"));
		
		JToolBar toolBar = new JToolBar();
		panel.add(toolBar);
		
		JButton btnNuevo = new JButton();
		btnNuevo.setIcon(GetResizedIcon("/resources/new.png"));
		btnNuevo.setToolTipText("Nuevo");
		toolBar.add(btnNuevo);
		
		JButton btnAbrir = new JButton();
		btnAbrir.setIcon(GetResizedIcon("/resources/open.png"));
		btnAbrir.setToolTipText("Abrir");
		toolBar.add(btnAbrir);
		
		JButton btnGuardar = new JButton();
		btnGuardar.setIcon(GetResizedIcon("/resources/save.png"));
		btnGuardar.setToolTipText("Guardar");
		toolBar.add(btnGuardar);
		
		toolBar.addSeparator();
		
		JButton btnConectar = new JButton();
		btnConectar.setIcon(GetResizedIcon("/resources/noconnected.png"));
		btnConectar.setToolTipText("Conectar");
		toolBar.add(btnConectar);
		
		JButton btnLeer = new JButton();
		btnLeer.setIcon(GetResizedIcon("/resources/download.png"));
		btnLeer.setToolTipText("Leer USB");
		toolBar.add(btnLeer);
		
		JButton btnEscribir = new JButton();
		btnEscribir.setIcon(GetResizedIcon("/resources/upload.png"));
		btnEscribir.setToolTipText("Escribir USB");
		toolBar.add(btnEscribir);
		
		JButton btnRecargar = new JButton();
		btnRecargar.setIcon(GetResizedIcon("/resources/refresh.png"));
		btnRecargar.setToolTipText("Recargar USB");
		toolBar.add(btnRecargar);
		
		toolBar.addSeparator();
		
		JButton btnReproducir = new JButton();
		btnReproducir.setIcon(GetResizedIcon("/resources/play.png"));
		btnReproducir.setToolTipText("Reproducir USB");
		toolBar.add(btnReproducir);
		
		JButton btnDetener = new JButton();
		btnDetener.setIcon(GetResizedIcon("/resources/stop.png"));
		btnDetener.setToolTipText("Detener USB");
		toolBar.add(btnDetener);
		
		toolBar.addSeparator();
		
		JButton btnVentanaSalida = new JButton();
		btnVentanaSalida.setIcon(GetResizedIcon("/resources/output.png"));
		btnVentanaSalida.setToolTipText("Ventana de salida");
		toolBar.add(btnVentanaSalida);
		panel.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{menuBar, mnArchivo, mntmSalir, toolBar, btnNuevo, btnAbrir, btnGuardar, btnConectar, btnLeer, btnEscribir, btnReproducir, btnDetener, btnVentanaSalida}));
		
		
		JToolBar statusBar = new JToolBar();
		frmKtUsbControl.getContentPane().add(statusBar, BorderLayout.SOUTH);
		
		JLabel lblCargando = new JLabel("En espera ...");
		statusBar.add(lblCargando);
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setResizeWeight(0.25);
		frmKtUsbControl.getContentPane().add(splitPane, BorderLayout.CENTER);
		
		JScrollPane scrollTree = new JScrollPane();
		splitPane.setLeftComponent(scrollTree);
		
		JTree tree = new JTree();
		scrollTree.setViewportView(tree);
		
		JScrollPane scrollTable = new JScrollPane();
		splitPane.setRightComponent(scrollTable);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new String[][] {
				{"home","paco"},
				{"dir", "root"},
				{"Prueba", "Si hay prueba"}
			},
			new String[] {
				"Variable", "Valor"
			}
		) {
			@SuppressWarnings("rawtypes")
			Class[] columnTypes = new Class[] {
				String.class, String.class
			};
			@SuppressWarnings({ "unchecked", "rawtypes" })
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			public boolean isCellEditable(int row, int column)
			{
				if(column > 0)
					return true;
				else
					return false;
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(100);
		table.getColumnModel().getColumn(1).setPreferredWidth(250);
		table.setAutoResizeMode(0);
		
		scrollTable.setViewportView(table);
	}
	
	public void showWindow()
	{
		frmKtUsbControl.setVisible(true);
	}
	
	private ImageIcon GetResizedIcon(String resourcePath)
	{
		ImageIcon orgicono, icono;
		Image rzimg, img;
		
		orgicono = new ImageIcon(MainWindow.class.getResource(resourcePath));
		rzimg = orgicono.getImage();
		img = rzimg.getScaledInstance(16, 16, Image.SCALE_SMOOTH);
		icono = new ImageIcon(img);
		return icono;
	}

}
