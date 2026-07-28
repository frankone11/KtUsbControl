/**
 * 
 */
package ktWinControl;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JToolBar;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.JButton;
import java.awt.Image;
import javax.swing.JLabel;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;
import java.awt.event.*;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

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
	
	
	private JTree tree;
	private JTable table;
	
	//Statusbar
	private JToolBar statusBar;
	
	//Status Label
	private JLabel lblCargando;
	
	//ProgressBar
	private JProgressBar pgStatus;

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
		frmKtUsbControl.setIconImage(new ImageIcon(MainWindow.class.getResource("/resources/usb.png")).getImage());
		
		JMenuBar menuBar = new JMenuBar();
		frmKtUsbControl.setJMenuBar(menuBar);
		
		JMenu mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);
		
		menuNuevo = new JMenuItem("Nuevo");
		mnArchivo.add(menuNuevo);
		menuNuevo.setIcon(GetResizedIcon("/resources/new.png"));
		menuNuevo.addActionListener(this);
		
		menuAbrir = new JMenuItem("Abrir...");
		mnArchivo.add(menuAbrir);
		menuAbrir.setIcon(GetResizedIcon("/resources/open.png"));
		menuAbrir.addActionListener(this);
		
		menuGuardar = new JMenuItem("Guardar");
		mnArchivo.add(menuGuardar);
		menuGuardar.setIcon(GetResizedIcon("/resources/save.png"));
		menuGuardar.addActionListener(this);
		
		menuGuardarComo = new JMenuItem("Guardar como...");
		mnArchivo.add(menuGuardarComo);
		menuGuardarComo.addActionListener(this);
		
		mnArchivo.addSeparator();
		
		mntmSalir = new JMenuItem("Salir");
		mnArchivo.add(mntmSalir);
		mntmSalir.setIcon(GetResizedIcon("/resources/exit.png"));
		mntmSalir.addActionListener(this);
		
		JMenu mnConexion = new JMenu("Conexión");
		menuBar.add(mnConexion);
		
		mntmConectar = new JMenuItem("Conectar");
		mnConexion.add(mntmConectar);
		mntmConectar.setIcon(GetResizedIcon("/resources/noconnected.png"));
		mntmConectar.addActionListener(this);
		
		mntmLeer = new JMenuItem("Leer USB");
		mnConexion.add(mntmLeer);
		mntmLeer.setIcon(GetResizedIcon("/resources/download.png"));
		mntmLeer.addActionListener(this);
		
		mntmEscribir = new JMenuItem("Escribir USB");
		mnConexion.add(mntmEscribir);
		mntmEscribir.setIcon(GetResizedIcon("/resources/upload.png"));
		mntmEscribir.addActionListener(this);
		
		mntmRecargar = new JMenuItem("Recargar USB");
		mnConexion.add(mntmRecargar);
		mntmRecargar.setIcon(GetResizedIcon("/resources/refresh.png"));
		mntmRecargar.addActionListener(this);
		
		mnConexion.addSeparator();
		
		mntmReproducir = new JMenuItem("Reproducir USB");
		mnConexion.add(mntmReproducir);
		mntmReproducir.setIcon(GetResizedIcon("/resources/play.png"));
		mntmReproducir.addActionListener(this);
		
		mntmDetener = new JMenuItem("Detener USB");
		mnConexion.add(mntmDetener);
		mntmDetener.setIcon(GetResizedIcon("/resources/stop.png"));
		mntmDetener.addActionListener(this);
		
		mnConexion.addSeparator();
		
		mntmVentanaSalida = new JMenuItem("Ventana de salida");
		mnConexion.add(mntmVentanaSalida);
		mntmVentanaSalida.setIcon(GetResizedIcon("/resources/output.png"));		
		mntmVentanaSalida.addActionListener(this);
		
		JMenu mnAyuda = new JMenu("Ayuda");
		menuBar.add(mnAyuda);
		
		mntmAcercaDe = new JMenuItem("Acerca de...");
		mnAyuda.add(mntmAcercaDe);
		mntmAcercaDe.setIcon(GetResizedIcon("/resources/help.png"));
		mntmAcercaDe.addActionListener(this);
		
		toolBar = new JToolBar();
		frmKtUsbControl.getContentPane().add(toolBar, BorderLayout.NORTH);
		
		btnNuevo = new JButton();
		btnNuevo.setIcon(GetResizedIcon("/resources/new.png"));
		btnNuevo.setToolTipText("Nuevo");
		toolBar.add(btnNuevo);
		btnNuevo.addActionListener(this);
		
		btnAbrir = new JButton();
		btnAbrir.setIcon(GetResizedIcon("/resources/open.png"));
		btnAbrir.setToolTipText("Abrir");
		toolBar.add(btnAbrir);
		btnAbrir.addActionListener(this);
		
		btnGuardar = new JButton();
		btnGuardar.setIcon(GetResizedIcon("/resources/save.png"));
		btnGuardar.setToolTipText("Guardar");
		toolBar.add(btnGuardar);
		btnGuardar.addActionListener(this);
		
		toolBar.addSeparator();
		
		btnConectar = new JButton();
		btnConectar.setIcon(GetResizedIcon("/resources/noconnected.png"));
		btnConectar.setToolTipText("Conectar");
		toolBar.add(btnConectar);
		btnConectar.addActionListener(this);
		
		btnLeer = new JButton();
		btnLeer.setIcon(GetResizedIcon("/resources/download.png"));
		btnLeer.setToolTipText("Leer USB");
		toolBar.add(btnLeer);
		btnLeer.addActionListener(this);
		
		btnEscribir = new JButton();
		btnEscribir.setIcon(GetResizedIcon("/resources/upload.png"));
		btnEscribir.setToolTipText("Escribir USB");
		toolBar.add(btnEscribir);
		btnEscribir.addActionListener(this);
		
		btnRecargar = new JButton();
		btnRecargar.setIcon(GetResizedIcon("/resources/refresh.png"));
		btnRecargar.setToolTipText("Recargar USB");
		toolBar.add(btnRecargar);
		btnRecargar.addActionListener(this);
		
		toolBar.addSeparator();
		
		btnReproducir = new JButton();
		btnReproducir.setIcon(GetResizedIcon("/resources/play.png"));
		btnReproducir.setToolTipText("Reproducir USB");
		toolBar.add(btnReproducir);
		btnReproducir.addActionListener(this);
		
		btnDetener = new JButton();
		btnDetener.setIcon(GetResizedIcon("/resources/stop.png"));
		btnDetener.setToolTipText("Detener USB");
		toolBar.add(btnDetener);
		btnDetener.addActionListener(this);
		
		toolBar.addSeparator();
		
		btnVentanaSalida = new JButton();
		btnVentanaSalida.setIcon(GetResizedIcon("/resources/output.png"));
		btnVentanaSalida.setToolTipText("Ventana de salida");
		toolBar.add(btnVentanaSalida);
		btnVentanaSalida.addActionListener(this);
		
		statusBar = new JToolBar();
		frmKtUsbControl.getContentPane().add(statusBar, BorderLayout.SOUTH);
		
		lblCargando = new JLabel("En espera ...");
		statusBar.add(lblCargando);
		
		statusBar.addSeparator();
		
		pgStatus = new JProgressBar();
		JPanel panelProgress = new JPanel();	
		statusBar.add(panelProgress);
		statusBar.addSeparator();
		
		statusBar.add(pgStatus);
		
		Dimension pref = lblCargando.getPreferredSize();
		
		System.out.println(pref);		
		pref.width=18;
		lblCargando.setPreferredSize(pref);
		//pref.width=150;
		lblCargando.setSize(pref);
		
		System.out.println(pref);
		
		panelProgress.setPreferredSize(pref);
		
		pref.width = 30;
		pgStatus.setPreferredSize(pref);
		//pgStatus.setSize(pref);
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setResizeWeight(0.25);
		frmKtUsbControl.getContentPane().add(splitPane, BorderLayout.CENTER);
		
		JScrollPane scrollTree = new JScrollPane();
		splitPane.setLeftComponent(scrollTree);
		
		tree = new JTree();
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
	}
	
	public void showWindow()
	{
		frmKtUsbControl.setVisible(true);
	}
	
	public void close()
	{
		frmKtUsbControl.dispose();
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
		else if(e.getSource() == mntmVentanaSalida || e.getSource() == btnVentanaSalida)
		{
			JOptionPane.showMessageDialog(frmKtUsbControl, "No hay nada que mostrar.", "Alerta de KtUsbControl", JOptionPane.WARNING_MESSAGE);
		}
		else
		{
			JOptionPane.showMessageDialog(frmKtUsbControl, "No implementado.", "Error de KtUsbControl", JOptionPane.ERROR_MESSAGE);
		}
	}

}
