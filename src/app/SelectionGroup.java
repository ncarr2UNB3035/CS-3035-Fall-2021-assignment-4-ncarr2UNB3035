package app;

import java.util.ArrayList;

import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.geometry.BoundingBox;
import javafx.scene.shape.Shape;

public class SelectionGroup {
	private SimpleListProperty<Shape> items;
	private BoundingBox bounds = new BoundingBox(0, 0, 0, 0);

	public SelectionGroup(){
		ArrayList<Shape> list = new ArrayList<>();
		ObservableList<Shape> observableList = (ObservableList<Shape>) FXCollections.observableArrayList(list);
		items = new SimpleListProperty<Shape>(observableList);
	}

	public SimpleListProperty<Shape> getItems(){
		return items;
	}

	public void addShape(Shape s){
		items.add(s);
	}

	public void deleteShapeAt(int x, int y){
		Shape deleteShape = getShapeAt(x,y);
		items.remove(deleteShape);
	}

	private Shape getShapeAt(int x, int y){
		Shape shape = null;

		for(Shape s : items){
			if(s.contains(x,y)){
				shape = s;
			}
		}

		return shape;
	}

}
