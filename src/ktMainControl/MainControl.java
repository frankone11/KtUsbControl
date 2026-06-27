/**
 * 
 */
package ktMainControl;
import java.awt.EventQueue;
import com.formdev.flatlaf.intellijthemes.FlatArcDarkIJTheme;
import ktWinControl.MainWindow;

/**
 * 
 */
class MainControl {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FlatArcDarkIJTheme.setup();
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
