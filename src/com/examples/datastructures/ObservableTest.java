package com.examples.datastructures;

import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
public class ObservableTest {

	  public static void main(String[] args) {
	    List<String> list = new ArrayList<String>();
	    list.add("10");
	    ObservableList<String> observableList = FXCollections.observableList(list);
	    observableList.addListener(new ListChangeListener() {
	      @Override
	      public void onChanged(ListChangeListener.Change change) {
	        System.out.println("change!");
	      }
	    });
	   // observableList.add("item one");
	  //  list.add("item two");
	   
	    
	    observableList.add("0");
	    System.out.println("Size: " + observableList.size());

	  }
	}
