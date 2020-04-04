﻿package FlyweightPattern;

import java.util.HashMap;

//创建一个工厂ShapeFacory，生成基于给定信息的实体类的对象。
public class ShapeFacory {
	
	//String -- color , Shape -- circle
	private static final HashMap<String, Shape> circleMap = new HashMap();
	
	public static Shape getCircle(String color){
		Circle circle = (Circle) circleMap.get(color);
		
		if (circle == null) {
			circle = new Circle(color);
			circleMap.put(color, circle);
			System.out.println("Creating circle of color : " + color);
		}
		return circle;
	}
}
