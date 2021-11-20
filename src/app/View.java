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
	private ToolBar bar;

	public View(){
		Main.model.getShapeListProperty().addListener(new ListChangeListener<Shape>() {
			@Override
			public void onChanged(Change<? extends Shape> c) {draw();}
		});

		bar = new ToolBar();
		Image square = new Image(getClass().getClassLoader().getResourceAsStream("images/square.png"));
		ToggleButton squareButton = new ToggleButton("", new ImageView(square));

		Image circle = new Image(getClass().getClassLoader().getResourceAsStream("images/circle.png"));
		ToggleButton circleButton = new ToggleButton("", new ImageView(circle));

		Image copy = new Image(getClass().getClassLoader().getResourceAsStream("images/copy.png"));
		ToggleButton copyButton = new ToggleButton("", new ImageView(copy));

		Image cut = new Image(getClass().getClassLoader().getResourceAsStream("images/cut.png"));
		ToggleButton cutButton = new ToggleButton("", new ImageView(cut));

		Image paste = new Image(getClass().getClassLoader().getResourceAsStream("images/paste.png"));
		ToggleButton pasteButton = new ToggleButton("", new ImageView(paste));

		Image triangle = new Image(getClass().getClassLoader().getResourceAsStream("images/triangle.png"));
		ToggleButton triangleButton = new ToggleButton("", new ImageView(triangle));

		bar.getItems().add(squareButton);
		bar.getItems().add(circleButton);
		bar.getItems().add(triangleButton);
		bar.getItems().add(copyButton);
		bar.getItems().add(cutButton);
		bar.getItems().add(pasteButton);

		this.getChildren().add(bar);
	}

	@Override
	public void layoutChildren(){draw();}

	private void draw(){
		this.getChildren().clear();

		//this does not work and I am unsure why
		for(Shape s : Main.model.getShapeListProperty()){
			s.setFill(FILL_COLOR);
			this.getChildren().add(s);
		}
	}

}
