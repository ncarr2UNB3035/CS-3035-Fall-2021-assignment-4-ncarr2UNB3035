package app;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ListChangeListener;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Separator;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.ToolBar;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;

public class View extends Pane {
	public static final Color FILL_COLOR = Color.GREEN;
	public static final Color SELECTED_FILL_COLOR = Color.BLUE;
	private static Group root;

	public View(){
		Main.model.getShapeListProperty().addListener(new ListChangeListener<Shape>() {
			@Override
			public void onChanged(Change<? extends Shape> c) {draw();}
		});
	}

	@Override
	public void layoutChildren(){draw();}

	private void draw(){
		this.getChildren().clear();

		for(Shape s : Main.model.getShapeListProperty()){
			s.setFill(FILL_COLOR);
			this.getChildren().add(s);
		}
	}

}
