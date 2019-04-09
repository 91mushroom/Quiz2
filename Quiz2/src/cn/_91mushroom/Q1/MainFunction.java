package cn._91mushroom.Q1;

import java.util.Random;

public class MainFunction {
	public static void main(String[] args) {
		
		GenericBubbleSorter<Pig> pigBubbleSorter = new GenericBubbleSorter<>(); 
		Random random = new Random();
		
		for (int i = 0; i < 10; i++) {
			Pig pig = new Pig(i, random.nextInt(100) + 100);
			pigBubbleSorter.add(pig);
		}
		
		System.out.println("排序前：");
		pigBubbleSorter.printElement();
		
		pigBubbleSorter.sort();
		
		System.out.println("排序后：");
		pigBubbleSorter.printElement();
	}
}
