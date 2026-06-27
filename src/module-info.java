/**
 * 
 */
/**
 * 
 */
module KtUsbControl {
	requires java.desktop;
	requires java.logging;

	exports com.formdev.flatlaf;
	exports com.formdev.flatlaf.icons;
	exports com.formdev.flatlaf.themes;
	exports com.formdev.flatlaf.ui;
	exports com.formdev.flatlaf.util;

	opens com.formdev.flatlaf.resources;
	uses com.formdev.flatlaf.FlatDefaultsAddon;
}