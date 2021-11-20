package app;

import java.lang.reflect.Array;
import java.util.ArrayList;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class Model {
	private SimpleListProperty<Shape> shapeListProperty;

	private double squareSideLength;

	public Model(double sideLength){
		squareSideLength = sideLength;

		ArrayList<Shape> list = new ArrayList<>();
		ObservableList<Shape> observableList = (ObservableList<Shape>) FXCollections.observableArrayList(list);
		shapeListProperty = new SimpleListProperty<>(observableList);
	}

	public SimpleListProperty getShapeListProperty(){
		return shapeListProperty;
	}

	public double getSquareSideLength(){
		return squareSideLength;
	}



}
