package com.cedg.chaophonic.client;

import com.allen_sauer.gwt.dnd.client.drop.GridConstrainedDropController;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Chaophonic implements EntryPoint {

	private Song song;
	
	public Song getSong() {
		return song;
	}

	public void setSong(Song song) {
		this.song = song;
	}

	/**
	 * The message displayed to the user when the server cannot be reached or
	 * returns an error.
	 */
	private static final String SERVER_ERROR = "An error occurred while "
		+ "attempting to contact the server. Please check your network "
		+ "connection and try again.";

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		// ensure the document BODY has dimensions in standards mode
		RootPanel.get().setPixelSize(800, 600);   
		
		song = new Song();
		song.readyToGo();
		
		// drop target
		AbsolutePanel gridConstrainedDropTarget = new AbsolutePanel();
		gridConstrainedDropTarget.setStyleName("sequencer");
		RootPanel.get().add(gridConstrainedDropTarget,0,400);
		gridConstrainedDropTarget.setPixelSize(600, 120);
		Label lDropSample = new Label("Drop your samples here :");
		RootPanel.get().add(lDropSample,0,370);
		
		// instantiate our drop controller
		GridConstrainedDropController gcdc = new Track(gridConstrainedDropTarget,1, 20);

		//Drag handler
		MyPickupDragController dragController2 = new MyPickupDragController(gridConstrainedDropTarget, true, song);
		dragController2.setBehaviorMultipleSelection(false);
		dragController2.registerDropController(gcdc);
		
		// Init des samples dans le sample browser
		final AudioSample sd = new AudioSample("sd","sounds/SD.mp3"); 
		sd.loadSample();
//		final AudioSample bd = new AudioSample("bd","sounds/BD.mp3");
//		bd.loadSample();
//		final AudioSample hh = new AudioSample("hh","sounds/HH.mp3");
//		hh.loadSample();

		
		song.getBrowser().addSoundsample(sd);
//		song.getBrowser().addSoundsample(bd);
//		song.getBrowser().addSoundsample(hh);
		
		// Séquençage des samples pour le séquenceur
//		final AudioSample bd1 = bd.getCopyOf();
		
//		song.addSoundsample(bd1);

		Label lBrowser = new Label("Browser");
		Label lBD = new Label("BD");
		Label lSD = new Label("SD");
		Label lHH = new Label("HH");
		
		// Ajout des images
		RootPanel.get().add(sd,100,200);
		
		RootPanel.get().add(lBrowser,0,30);
		RootPanel.get().add(lBD,0,70);
		RootPanel.get().add(lSD,0,130);
		RootPanel.get().add(lHH,0,190);

//		RootPanel.get().add(bd.getImg(), 40, 60);
	//	RootPanel.get().add(sd.getImg(), 40, 120);
//		RootPanel.get().add(hh.getImg(), 40, 180);


		dragController2.makeDraggable(sd);
		
//		dragController2.makeDraggable(bd.getImg());
		//dragController2.makeDraggable(sd.getImg());
//		dragController2.makeDraggable(hh.getImg());
		
		// Useless but might be a good example for a tête de lecture
		// work with the customAnimation class
		// CustomAnimation animation = new CustomAnimation(img.getElement());
		// animation.scrollTo(100, 500, 2000);

		Button b2 = new Button("play !");
		b2.setPixelSize(200, 40);
		b2.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				
				// example of animating an object
				//movePic(img2);
				System.out.println("Song play");
				System.out.println(song.toString());
				song.playSong();
				System.out.println("Song played");
			}
		});

		// Add it to the root panel.
		RootPanel.get().add(b2,400,530);
	}

	// Useless but still a good example
	private void movePic(Image img){
		CustomAnimation animation2 = new CustomAnimation(img.getElement());
		animation2.scrollTo(500, 0, 3000);	
	}

}
