package app;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Shape;

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

				}
			}
		});
	}
}
