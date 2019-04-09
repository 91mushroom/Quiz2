package cn._91mushroom.Q1;

import java.util.ArrayList;
import java.util.List;

/**
 * 泛型冒泡排序类
 * @author Administrator
 *
 * @param <T>
 */
public class GenericBubbleSorter<T extends Animal> {
	
	List<T> list = new ArrayList<>();
	
	public void add(T t) {
		list.add(t);
	}
	
	public void sort(){
		
		
		for (int i = 0; i < list.size() - 1; i++) {
			for (int j = 0; j < list.size()  - i - 1; j++) {
				if (list.get(j).getWeight() > list.get(j+1).getWeight()) {
					T temp = list.remove(j);
					list.add(j + 1,temp);
				}
			}
		}
	}
	
	public void printElement() {
		for (T t : list) {
			System.out.println(t);
		}
	}
	
}
