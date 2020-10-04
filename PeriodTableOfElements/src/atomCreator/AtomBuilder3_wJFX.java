package atomCreator;

import javafx.animation.AnimationTimer;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class AtomBuilder3_wJFX extends Application {
	
	private double screenFac = 2.5;
	private Rectangle2D screenSize;
	private double width;
	private double height;
	private Pane root;
	private Scene scene;
	
	
//	private AnimationTimer timer;
//	private TranslateTransition translateMarb;
	
	
	/*	versuch erstmal ein 2-Dimensionales Design mit Drag-and-Drop
	 * 	gut wäre wenn man nur Protonen und Neutronen zum Kern hinzufügen müsste
	 * 	die Elektronen folgen dann einfach 
	 *  die bilden ja die "Wahrscheinlichkeitsdichte-Wolken" die anscheinend noch keiner so recht verstanden hat oO'
	 * 
	 * 
	 */
	
	private Parent launchAtomViewer() {
		
		final DragDelta dragDelta = new DragDelta();

		screenSize = Screen.getPrimary().getBounds();
		System.out.println(screenSize);
		width = screenSize.getWidth();
		height = screenSize.getHeight();
		// later add screenFac to button/controller to enable custom resize during
		// run-time
		width /= screenFac;
		height /= screenFac;

		root = new Pane();
		root.setPrefSize(width, height);
		root.setStyle("-fx-background-color: rgba(200, 255, 200, 0.8);");
		
		Circle circ = new Circle(50);
		circ.setTranslateX(100);
		circ.setTranslateY(100);
		circ.setFill(Color.RED);
		
		
		// just to figure out where Mouse-Pointer is
		circ.setOnMouseEntered(e -> {
			System.out.println("Mouse over Circle");
			circ.setFill(Color.BLUE);
		});
		
		circ.setOnMouseExited(e -> {
			System.out.println("Mouse exited Circle");
			circ.setFill(Color.RED);
		});

		
		/* to MOVE the Node-Object we can use "setOnMousePressed" AND "setOnMouseDragged"
		 * this has NOTHING to do with DragAndDrop-logic yet..
		 * see also "CircleCollisonTester.java"
		 * --> works very good; simplified the logic a bit here
		 */
		
		circ.setOnMousePressed(e -> {
	        // record a delta distance for the drag and drop operation.
	        dragDelta.x = circ.getLayoutX() - e.getSceneX();
	        dragDelta.y = circ.getLayoutY() - e.getSceneY();
//	        circ.setCursor(Cursor.NONE); // might look cooler but not important ^^'
	    });
		
		circ.setOnMouseDragged(e -> {
			circ.setLayoutX(e.getSceneX() + dragDelta.x);
		    circ.setLayoutY(e.getSceneY() + dragDelta.y);
	    });
		

		/* here drag-and-pull implementation
		 * you need 5 Methods y
		 * you might use less depending on what you want to do
		 * 
		 * "setOnDragDetected"
		 * "setOnDragOver" 
		 * "setOnDragEntered"
		 * "setOnDragExited"
		 * "setOnDragDropped"
		 * 	
		 * the logic is comparable to the "Mouse-" Methods	 
		 * 
		 * also important is the "DragBoard"
		 *  Dragboard db = e.getDragboard();
		 *  because it defines "where" something is "dropped"
		 * 
		 */
		circ.setOnDragOver(e -> {
			
			 System.out.println("onDragOver");
			
		});
		
		
		
		
		root.getChildren().add(circ);
		
		
		return root;
	}
	
	
	@Override
	public void start(Stage stage) throws Exception {

		scene = new Scene(launchAtomViewer());

//		imgView.fitWidthProperty().bind(stage.widthProperty()); 
//		imgView.fitHeightProperty().bind(stage.heightProperty()); 
		
//		imgView.fitWidthProperty().set(scene.getWidth());
//		imgView.fitHeightProperty().set(scene.getHeight());
//		imgView.setPreserveRatio(true);
		
		scene.setFill(Color.TRANSPARENT); // !!
		stage.setScene(scene);
		stage.initStyle(StageStyle.UNDECORATED);
		stage.initStyle(StageStyle.TRANSPARENT); // !!
//		stage.setMaximized(true);
//		 stage.setFullScreen(true);
		stage.show();
		
		
	}

	public static void main(String[] args) {
		launch(args);
	}

}
// hier eine "Hilfs-"Klasse um x und y Positionen zu kommunizieren
class DragDelta { double x, y; }
