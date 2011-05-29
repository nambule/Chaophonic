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
		GridConstrainedDropController gcdc = new Track(gridConstrainedDropTarget,1, 40);

		//Drag handler
		MyPickupDragController dragController2 = new MyPickupDragController(gridConstrainedDropTarget, true, song);
		dragController2.setBehaviorMultipleSelection(false);
		dragController2.registerDropController(gcdc);
		
		// Init des samples dans le sample browser
		final AudioSample sd = new AudioSample("sd","sounds/SD.mp3"); 
		sd.loadSample();
		final AudioSample bd = new AudioSample("bd","sounds/BD.mp3");
		bd.loadSample();
		final AudioSample hh = new AudioSample("hh","sounds/HH.mp3");
		hh.loadSample();

		// Séquençage des samples pour le séquenceur
		final AudioSample bd1 = bd.getCopyOf();
		final AudioSample bd2 = bd.getCopyOf();
		final AudioSample bd3 = bd.getCopyOf();
		final AudioSample bd4 = bd.getCopyOf();
		
		final AudioSample hh1 = hh.getCopyOf();
		final AudioSample hh2 = hh.getCopyOf();
		final AudioSample hh3 = hh.getCopyOf();
		final AudioSample hh4 = hh.getCopyOf();
		final AudioSample hh5 = hh.getCopyOf();
		final AudioSample hh6 = hh.getCopyOf();
		
		final AudioSample sd1 = sd.getCopyOf();
		final AudioSample sd2 = sd.getCopyOf();
		final AudioSample sd3 = sd.getCopyOf();
		final AudioSample sd4 = sd.getCopyOf();
		
		song.addSoundsample(bd1);
		song.addSoundsample(bd2);
		song.addSoundsample(bd3);
		song.addSoundsample(bd4);

		song.addSoundsample(hh1);
		song.addSoundsample(hh2);
		song.addSoundsample(hh3);
		song.addSoundsample(hh4);
		song.addSoundsample(hh5);
		song.addSoundsample(hh6);
		
		song.addSoundsample(sd1);
		song.addSoundsample(sd2);
		song.addSoundsample(sd3);
		song.addSoundsample(sd4);

		Label lBD = new Label("BD");
		Label lSD = new Label("SD");
		Label lHH = new Label("HH");
		
		// Ajout des images
		// TODO : change that
		RootPanel.get().add(lBD,0,70);
		RootPanel.get().add(bd1.getImg(), 40, 60);
		RootPanel.get().add(bd2.getImg(), 80, 60);		
		RootPanel.get().add(bd3.getImg(), 120, 60);
		RootPanel.get().add(bd4.getImg(), 160, 60);
				
		RootPanel.get().add(lHH,0,190);
		RootPanel.get().add(hh1.getImg(), 40, 180);		
		RootPanel.get().add(hh2.getImg(), 80, 180);		
		RootPanel.get().add(hh3.getImg(), 120, 180);
		RootPanel.get().add(hh4.getImg(), 160, 180);		
		RootPanel.get().add(hh5.getImg(), 200, 180);		
		RootPanel.get().add(hh6.getImg(), 240, 180);

		RootPanel.get().add(lSD,0,130);
		RootPanel.get().add(sd1.getImg(), 40, 120);
		RootPanel.get().add(sd2.getImg(), 80, 120);
		RootPanel.get().add(sd3.getImg(), 120, 120);
		RootPanel.get().add(sd4.getImg(), 160, 120);

		dragController2.makeDraggable(bd1.getImg());
		dragController2.makeDraggable(bd2.getImg());
		dragController2.makeDraggable(bd3.getImg());
		dragController2.makeDraggable(bd4.getImg());
		dragController2.makeDraggable(hh1.getImg());
		dragController2.makeDraggable(hh2.getImg());
		dragController2.makeDraggable(hh3.getImg());
		dragController2.makeDraggable(hh4.getImg());
		dragController2.makeDraggable(hh5.getImg());
		dragController2.makeDraggable(hh6.getImg());
		dragController2.makeDraggable(sd1.getImg());
		dragController2.makeDraggable(sd2.getImg());
		dragController2.makeDraggable(sd3.getImg());
		dragController2.makeDraggable(sd4.getImg());
		
		// Useless but might be a good example for a tête de lecture
		// work with the customAnimation class
		// CustomAnimation animation = new CustomAnimation(img.getElement());
		// animation.scrollTo(100, 500, 2000);
		
		System.out.println(song.toString());

		//song.playSong();

		Button b2 = new Button("play !");
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
		RootPanel.get().add(b2,0,550);
	}

	// Useless but still a good example
	private void movePic(Image img){
		CustomAnimation animation2 = new CustomAnimation(img.getElement());
		animation2.scrollTo(500, 0, 3000);	
	}

}
