/**
 * 
 */
package ktMainControl;
import java.awt.EventQueue;
import javax.swing.UnsupportedLookAndFeelException;
import ktWinControl.MainWindow;

/**
 * 
 */
class MainControl {

	private static boolean flatlookandfeel = true;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		if(flatlookandfeel)
		{
			com.formdev.flatlaf.intellijthemes.FlatArcDarkIJTheme.setup();
		}
		else
		{
			try {
				// Metal LookAndFeel
				javax.swing.UIManager.put("swing.boldMetal", Boolean.FALSE);
				javax.swing.UIManager.setLookAndFeel(new javax.swing.plaf.metal.MetalLookAndFeel());
			}
			catch (UnsupportedLookAndFeelException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.showWindow();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

}
