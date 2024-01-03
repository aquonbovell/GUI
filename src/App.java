// This is a Java class named App
public class App {
	// Private variable 'app' of type GUI
	private GUI app;

	// The main method which is the entry point of the program
	public static void main(String[] args) throws Exception {
		// Creating an instance of the App class
		App app = new App();
		// Calling the init method on the created instance
		app.init();
	}

	// Method to initialize the application
	public void init() {
		// Creating a new GUI object with a title "Data Structures: GUI" and dimensions
		// 400x300
		app = new GUI("Data Structures: GUI", 400, 300);
		app.init();
		// Setting the visibility of the GUI to true, making it visible on the screen
	}
}
