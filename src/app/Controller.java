package app;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;
import javafx.scene.shape.Rectangle;

public class Controller {
	public enum State {READY, DRAG_SELECTION_STARTED, DRAG_ITEMS_STARTED}
	private State state;

	public Controller(State state){
		this.state = state;

		Main.view.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				if(event.getButton() == MouseButton.PRIMARY){
					int x = (int) event.getX() - (int)Main.model.getSquareSideLength()/2;
					int y = (int) event.getY() - (int)Main.model.getSquareSideLength()/2;
					//I could not get the selection thing but if I wasn't running out of time I would have it figure out which shape is selected in the tool bar
					//and then create the selected shape then add it to the list

					Rectangle r = new Rectangle(x,y,Main.model.getSquareSideLength(), Main.model.getSquareSideLength());
					Main.model.addShape(r);
				}
			}
		});
	}
}
