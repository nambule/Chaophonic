package com.cedg.chaophonic.client;

import java.util.Iterator;

import com.allen_sauer.gwt.dnd.client.PickupDragController;
import com.gargoylesoftware.htmlunit.javascript.host.Window;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.RootPanel;
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
	}
	
	public MyPickupDragController(AbsolutePanel boundaryPanel,
			boolean allowDroppingOnBoundaryPanel, Song s) {
		super(boundaryPanel, allowDroppingOnBoundaryPanel);
		this.song=s;
	}
	
	public void dragStart(){
		super.dragStart();
		for (Widget w : this.getSelectedWidgets()) {
			System.out.println("dragstart="+w.getElement().getTitle());
		}
	}
	
	public void dragEnd(){
		super.dragEnd();
		System.out.println("DragEnd");
		for (Widget w : this.getSelectedWidgets()) {
			System.out.println(w.getElement().toString());
			System.out.println("classname="+w.getElement().getClassName());
			System.out.println(w.getClass());
			System.out.println(w.getAbsoluteLeft());	
			System.out.println("title from dragend="+w.getElement().getTitle());
			//System.out.println(w.getParent().toString());	
			
			String objectTitle = w.getElement().getTitle();
			
			// si c'est un AS alors on créé un ASS, sinon c'est un déplacement d'un ASS existant
			if (w instanceof AudioSample){
				// création d'un nouvel ASS
				AudioSampleSequenced ass = new AudioSampleSequenced((AudioSample) w);
				ass.setStarttime(((w.getAbsoluteLeft())*10)+1);
				RootPanel.get().add(ass,w.getAbsoluteLeft(),w.getAbsoluteTop());
				this.makeDraggable(ass);
				song.getSoundArrayHM().put(ass.getId(), ass);
				// back to original position
				RootPanel.get().add(w,((AudioSample) w).getX_orig(),((AudioSample) w).getY_orig());
			} else if (w instanceof AudioSampleSequenced) {
				// séquencage de l'ASS
				((AudioSampleSequenced) w).setStarttime(((w.getAbsoluteLeft())*10)+1);
			}
			
			System.out.println("display song:"+song.toString());
		}
	}

}
