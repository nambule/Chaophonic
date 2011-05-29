package com.cedg.chaophonic.client;

import com.allen_sauer.gwt.dnd.client.DragContext;
import com.allen_sauer.gwt.dnd.client.drop.GridConstrainedDropController;
import com.allen_sauer.gwt.dnd.client.drop.SimpleDropController;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Widget;


/**
 * Représentation graphique du séquenceur
 * @author ced
 *
 */
public class Track extends GridConstrainedDropController {


	  public Track(AbsolutePanel ap, int x, int y) {
	    super(ap,x,y);
	  }
	  public void onDrop(DragContext context) {
	    super.onDrop(context);
	    System.out.println("dropped !!!");
	    System.out.println("desiredX "+context.desiredDraggableX);
	    System.out.println("desiredY "+context.desiredDraggableY);
	    System.out.println("mouseX "+context.mouseX);
	    System.out.println("mouseY "+context.mouseY);
	    System.out.println(context.dragController.toString());
	    System.out.println(context.draggable.toString());


	  }
	  public void onEnter(DragContext context) {
	    super.onEnter(context);
	  }
	  public void onLeave(DragContext context) {
	    super.onLeave(context);
	  }
	  public void dragEndCleanup(){
		    System.out.println("cleanup !!!");

	  }
	  
}