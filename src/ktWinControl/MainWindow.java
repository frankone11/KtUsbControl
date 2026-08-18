/**
 * 
 */
package ktWinControl;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JToolBar;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.Box;
import javax.swing.ImageIcon;
import java.awt.event.*;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import KtHidUsb.HidUsbControl;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;

/**
 * 
 */
public class MainWindow implements ActionListener {

	//Ventana principal
	private JFrame frmKtUsbControl;
	
	//Menú Archivo
	private JMenuItem menuNuevo;
	private JMenuItem menuAbrir;
	private JMenuItem menuGuardar;
	private JMenuItem menuGuardarComo;
	private JMenuItem mntmSalir;
	
	//Menú Conexión
	private JMenuItem mntmConectar;
	private JMenuItem mntmLeer;
	private JMenuItem mntmEscribir;
	private JMenuItem mntmRecargar;
	private JMenuItem mntmReproducir;
	private JMenuItem mntmDetener;
	private JMenuItem mntmVentanaSalida;
	
	//Menú Ayuda
	private JMenuItem mntmAcercaDe;
	
	//Toolbar
	private JToolBar toolBar;
	
	//Botones Barra Principal
	private JButton btnNuevo;
	private JButton btnAbrir;
	private JButton btnGuardar;
	private JButton btnConectar;
	private JButton btnLeer;
	private JButton btnEscribir;
	private JButton btnRecargar;
	private JButton btnReproducir;
	private JButton btnDetener;
	private JButton btnVentanaSalida;
	
	//Tree
	private DefaultMutableTreeNode root;
	private JTree tree;
	
	//Table
	private JTable table;
	
	//Statusbar
	private JToolBar statusBar;
	
	//Status Label
	private JLabel lblCargando;
	
	//ProgressBar
	private JProgressBar pgStatus;
	
	//HID USB
	private HidUsbControl hidUsb;
	private boolean usbabierto;
	

	/**
	 * Create the application.
	 */
	public MainWindow() {
		usbabierto = false;
		hidUsb = new HidUsbControl();
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
		frmKtUsbControl.setIconImage(new ImageIcon(MainWindow.class.getResource("/resources/usb.png")).getImage());
		
		JMenuBar menuBar = new JMenuBar();
		frmKtUsbControl.setJMenuBar(menuBar);
		
		JMenu mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);
		
		menuNuevo = new JMenuItem("Nuevo");
		mnArchivo.add(menuNuevo);
		menuNuevo.setIcon(new ImageIcon(MainWindow.class.getResource("/resources/new.png")));
		menuNuevo.addActionListener(this);
		
		menuAbrir = new JMenuItem("Abrir...");
		mnArchivo.add(menuAbrir);
		menuAbrir.setIcon(new ImageIcon(MainWindow.class.getResource("/resources/open.png")));
		menuAbrir.addActionListener(this);
		
		menuGuardar = new JMenuItem("Guardar");
		mnArchivo.add(menuGuardar);
		menuGuardar.setIcon(new ImageIcon(MainWindow.class.getResource("/resources/save.png")));
		menuGuardar.addActionListener(this);
		
		menuGuardarComo = new JMenuItem("Guardar como...");
		mnArchivo.add(menuGuardarComo);
		menuGuardarComo.addActionListener(this);
		
		mnArchivo.addSeparator();
		
		mntmSalir = new JMenuItem("Salir");
		mnArchivo.add(mntmSalir);
		mntmSalir.setIcon(new ImageIcon(MainWindow.class.getResource("/resources/exit.png")));
		mntmSalir.addActionListener(this);
		
		JMenu mnConexion = new JMenu("Conexión");
		menuBar.add(mnConexion);
		
		mntmConectar = new JMenuItem("Conectar");
		mnConexion.add(mntmConectar);
		mntmConectar.setIcon(new ImageIcon(MainWindow.class.getResource("/resources/noconnected.png")));
		mntmConectar.addActionListener(this);
		
		mntmLeer = new JMenuItem("Leer USB");
		mnConexion.add(mntmLeer);
		mntmLeer.setIcon(new ImageIcon(MainWindow.class.getResource("/resources/download.png")));
		mntmLeer.addActionListener(this);
		
		mntmEscribir = new JMenuItem("Escribir USB");
		mnConexion.add(mntmEscribir);
		mntmEscribir.setIcon(new ImageIcon(MainWindow.class.getResource("/resources/upload.png")));
		mntmEscribir.addActionListener(this);
		
		mntmRecargar = new JMenuItem("Recargar USB");
		mnConexion.add(mntmRecargar);
		mntmRecargar.setIcon(new ImageIcon(MainWindow.class.getResource("/resources/refresh.png")));
		mntmRecargar.addActionListener(this);
		
		mnConexion.addSeparator();
		
		mntmReproducir = new JMenuItem("Reproducir USB");
		mnConexion.add(mntmReproducir);
		mntmReproducir.setIcon(new ImageIcon(MainWindow.class.getResource("/resources/play.png")));
		mntmReproducir.addActionListener(this);
		
		mntmDetener = new JMenuItem("Detener USB");
		mnConexion.add(mntmDetener);
		mntmDetener.setIcon(new ImageIcon(MainWindow.class.getResource("/resources/stop.png")));
		mntmDetener.addActionListener(this);
		
		mnConexion.addSeparator();
		
		mntmVentanaSalida = new JMenuItem("Ventana de salida");
		mnConexion.add(mntmVentanaSalida);
		mntmVentanaSalida.setIcon(new ImageIcon(MainWindow.class.getResource("/resources/output.png")));		
		mntmVentanaSalida.addActionListener(this);
		
		JMenu mnAyuda = new JMenu("Ayuda");
		menuBar.add(mnAyuda);
		
		mntmAcercaDe = new JMenuItem("Acerca de...");
		mnAyuda.add(mntmAcercaDe);
		mntmAcercaDe.setIcon(new ImageIcon(MainWindow.class.getResource("/resources/help.png")));
		mntmAcercaDe.addActionListener(this);
		
		toolBar = new JToolBar();
		frmKtUsbControl.getContentPane().add(toolBar, BorderLayout.NORTH);
		toolBar.setFloatable(false);
		
		btnNuevo = new JButton();
		btnNuevo.setIcon(new ImageIcon(MainWindow.class.getResource("/resources/new.png")));
		btnNuevo.setToolTipText("Nuevo");
		toolBar.add(btnNuevo);
		btnNuevo.addActionListener(this);
		
		btnAbrir = new JButton();
		btnAbrir.setIcon(new ImageIcon(MainWindow.class.getResource("/resources/open.png")));
		btnAbrir.setToolTipText("Abrir");
		toolBar.add(btnAbrir);
		btnAbrir.addActionListener(this);
		
		btnGuardar = new JButton();
		btnGuardar.setIcon(new ImageIcon(MainWindow.class.getResource("/resources/save.png")));
		btnGuardar.setToolTipText("Guardar");
		toolBar.add(btnGuardar);
		btnGuardar.addActionListener(this);
		
		toolBar.addSeparator();
		
		btnConectar = new JButton();
		btnConectar.setIcon(new ImageIcon(MainWindow.class.getResource("/resources/noconnected.png")));
		btnConectar.setToolTipText("Conectar");
		toolBar.add(btnConectar);
		btnConectar.addActionListener(this);
		
		btnLeer = new JButton();
		btnLeer.setIcon(new ImageIcon(MainWindow.class.getResource("/resources/download.png")));
		btnLeer.setToolTipText("Leer USB");
		toolBar.add(btnLeer);
		btnLeer.addActionListener(this);
		
		btnEscribir = new JButton();
		btnEscribir.setIcon(new ImageIcon(MainWindow.class.getResource("/resources/upload.png")));
		btnEscribir.setToolTipText("Escribir USB");
		toolBar.add(btnEscribir);
		btnEscribir.addActionListener(this);
		
		btnRecargar = new JButton();
		btnRecargar.setIcon(new ImageIcon(MainWindow.class.getResource("/resources/refresh.png")));
		btnRecargar.setToolTipText("Recargar USB");
		toolBar.add(btnRecargar);
		btnRecargar.addActionListener(this);
		
		toolBar.addSeparator();
		
		btnReproducir = new JButton();
		btnReproducir.setIcon(new ImageIcon(MainWindow.class.getResource("/resources/play.png")));
		btnReproducir.setToolTipText("Reproducir USB");
		toolBar.add(btnReproducir);
		btnReproducir.addActionListener(this);
		
		btnDetener = new JButton();
		btnDetener.setIcon(new ImageIcon(MainWindow.class.getResource("/resources/stop.png")));
		btnDetener.setToolTipText("Detener USB");
		toolBar.add(btnDetener);
		btnDetener.addActionListener(this);
		
		toolBar.addSeparator();
		
		btnVentanaSalida = new JButton();
		btnVentanaSalida.setIcon(new ImageIcon(MainWindow.class.getResource("/resources/output.png")));
		btnVentanaSalida.setToolTipText("Ventana de salida");
		toolBar.add(btnVentanaSalida);
		btnVentanaSalida.addActionListener(this);
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setResizeWeight(0.25);
		frmKtUsbControl.getContentPane().add(splitPane, BorderLayout.CENTER);
		
		JScrollPane scrollTree = new JScrollPane();
		splitPane.setLeftComponent(scrollTree);
		
		root = new DefaultMutableTreeNode("Dispositivo USB");
		
		DefaultMutableTreeNode leido = new DefaultMutableTreeNode("Leido");
		DefaultMutableTreeNode enviado = new DefaultMutableTreeNode("Enviado");
		
		DefaultMutableTreeNode propiedades = new DefaultMutableTreeNode("Propiedades");
		DefaultMutableTreeNode datosleidos = new DefaultMutableTreeNode("Datos");
		DefaultMutableTreeNode eventosleidos = new DefaultMutableTreeNode("Eventos");
		
		DefaultMutableTreeNode comandos = new DefaultMutableTreeNode("Comandos");
		DefaultMutableTreeNode eventosenviados = new DefaultMutableTreeNode("Eventos");
		DefaultMutableTreeNode rutinas = new DefaultMutableTreeNode("Rutinas");
		
		leido.add(propiedades);
		leido.add(datosleidos);
		leido.add(eventosleidos);
		
		enviado.add(comandos);
		enviado.add(eventosenviados);
		enviado.add(rutinas);
		
		
		root.add(leido);
		root.add(enviado);
		
		tree = new JTree(root);
		scrollTree.setViewportView(tree);
		
		tree.setShowsRootHandles(true);
		tree.putClientProperty("JTree.lineStyle", "Angled");
		DefaultTreeCellRenderer renderer = (DefaultTreeCellRenderer) tree.getCellRenderer();
		renderer.setLeafIcon(new ImageIcon(MainWindow.class.getResource("/resources/right.png")));
		
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
		) 
		{
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
		
		statusBar = new JToolBar();
		frmKtUsbControl.getContentPane().add(statusBar, BorderLayout.SOUTH);
		statusBar.setFloatable(false);
		
		lblCargando = new JLabel("En espera ...");
		statusBar.add(lblCargando);
		
		statusBar.addSeparator();
		
		statusBar.add(Box.createHorizontalGlue());
		
		statusBar.addSeparator();
		
		pgStatus = new JProgressBar();
		statusBar.add(pgStatus);		
		
		Dimension pref = lblCargando.getPreferredSize();
		
		pref = pgStatus.getPreferredSize();
		pref.width = 100;
		pgStatus.setMaximumSize(pref);
		pgStatus.setMinimumSize(pref);
	}
	
	public void showWindow()
	{
		frmKtUsbControl.setVisible(true);
	}
	
	public void close()
	{
		frmKtUsbControl.dispose();
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// TODO Auto-generated method stub
		if(e.getSource() == mntmSalir)
		{
			close();
		}
		else if(e.getSource() == mntmAcercaDe)
		{
			JOptionPane.showMessageDialog(frmKtUsbControl, "KT USB Control V0.1 - 2026\nBy FJGO.", "Acerca De KT USB Control", JOptionPane.INFORMATION_MESSAGE);
		}
		else if(e.getSource() == btnConectar || e.getSource() == mntmConectar)
		{
			if(usbabierto)
			{
				usbabierto = false;
				//hidUsb.CierraHidUsb();
				
				mntmConectar.setText("Conectar");
				mntmConectar.setIcon(new ImageIcon(MainWindow.class.getResource("/resources/noconnected.png")));
				btnConectar.setIcon(new ImageIcon(MainWindow.class.getResource("/resources/noconnected.png")));
				btnConectar.setToolTipText("Conectar");
			}
			else
			{
				if(!hidUsb.AbreHidUsb(0x1169, 0x5678))
				{
					JOptionPane.showMessageDialog(frmKtUsbControl, "Error de conexión con el dispositivo USB.\nVerifique que el dispositivo esté conectado y funcionando correctamente.", "Error de KT USB Control", JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					usbabierto = true;
					mntmConectar.setText("Desconectar");
					mntmConectar.setIcon(new ImageIcon(MainWindow.class.getResource("/resources/connected.png")));
					btnConectar.setIcon(new ImageIcon(MainWindow.class.getResource("/resources/connected.png")));
					btnConectar.setToolTipText("Desconectar");				
				}
			}
		}
		else if(e.getSource() == mntmVentanaSalida || e.getSource() == btnVentanaSalida)
		{
			JOptionPane.showMessageDialog(frmKtUsbControl, "No hay nada que mostrar.", "Alerta de KT USB Control", JOptionPane.WARNING_MESSAGE);
		}
		else
		{
			JOptionPane.showMessageDialog(frmKtUsbControl, "No implementado.", "Error de KT USB Control", JOptionPane.ERROR_MESSAGE);
		}
	}

}
