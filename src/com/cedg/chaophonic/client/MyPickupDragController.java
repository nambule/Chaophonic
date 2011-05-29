package com.cedg.chaophonic.client;

import java.util.Iterator;

import com.allen_sauer.gwt.dnd.client.PickupDragController;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * Gestionnaire de drag and drop
 * @author ced
 *
 */
public class MyPickupDragController extends PickupDragController{

	private Song song;
	
	public MyPickupDragController(AbsolutePanel boundaryPanel,
			boolean allowDroppingOnBoundaryPanel) {
		super(boundaryPanel, allowDroppingOnBoundaryPanel);
		// TODO Auto-generated constructor stub
	}
	
	public MyPickupDragController(AbsolutePanel boundaryPanel,
			boolean allowDroppingOnBoundaryPanel, Song s) {
		super(boundaryPanel, allowDroppingOnBoundaryPanel);
		this.song=s;
		// TODO Auto-generated constructor stub
	}
	
	public void dragEnd(){
		super.dragEnd();
		System.out.println("DragEnd");
		for (Widget w : this.getSelectedWidgets()) {
			System.out.println(w.getElement().toString());
			System.out.println(w.getAbsoluteLeft());	
			System.out.println(w.getElement().getTitle());
			//System.out.println(w.getParent().toString());		
			// TODO 
			//Soundsample s = song.getSoundSampleByIndex(Integer.parseInt(w.getElement().getTitle()));
			//s.setStarttime((w.getAbsoluteLeft())*10);
			System.out.println("dragEnd "+song.toString());
			Soundsample s = song.getSoundSampleById(Integer.parseInt(w.getElement().getTitle()));
			s.setStarttime((w.getAbsoluteLeft())*10);
			System.out.println("from drag = " + s.toString());
		}
	}

}
