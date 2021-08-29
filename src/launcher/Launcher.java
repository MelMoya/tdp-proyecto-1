package launcher;

import entities.Student;
import gui.SimplePresentationScreen;

public class Launcher {
	public static void main(String [] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	String pathToImage = this.getClass().getResource("/images/mel.JPG").toString();
            	Student student = new Student (111484, "Moya", "Erika Melisa", "meelmoya@gmail.com", "https://github.com/MelMoya", pathToImage);
            	SimplePresentationScreen window = new SimplePresentationScreen(student);
            	
            	window.setVisible(true);
            }
        });
    }
}