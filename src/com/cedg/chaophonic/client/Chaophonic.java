package com.cedg.chaophonic.client;

import com.allen_sauer.gwt.dnd.client.drop.GridConstrainedDropController;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Panel;
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
		
		int trackWidth = 600;
		int songLengthInMs = 5000;
		
		// ensure the document BODY has dimensions in standards mode
		RootPanel.get().setPixelSize(800, 600);   
		
		song = new Song();
		song.setLengthInMs(songLengthInMs);
		song.setWidth(trackWidth);
		song.readyToGo();
		
		// drop target
		AbsolutePanel gridConstrainedDropTarget = new AbsolutePanel();
		gridConstrainedDropTarget.setStyleName("sequencer");
		RootPanel.get().add(gridConstrainedDropTarget,0,400);
		gridConstrainedDropTarget.setPixelSize(trackWidth, 120);
		Label lDropSample = new Label("Drop your samples here :");
		lDropSample.setStyleName("module_title");
		RootPanel.get().add(lDropSample,0,370);
		
//		Panel p = new HorizontalPanel();
//		p.setPixelSize(100, 10);
//		p.setStyleName("sequencer_rule");
//		RootPanel.get().add(p,200,200);
		
		// instantiate our drop controller
		GridConstrainedDropController gcdc = new Track(gridConstrainedDropTarget,1, 20);

		//Drag handler
		MyPickupDragController dragController2 = new MyPickupDragController(gridConstrainedDropTarget, true, song);
		dragController2.setBehaviorMultipleSelection(false);
		dragController2.registerDropController(gcdc);
		
		// Init des samples dans le sample browser
		final AudioSample sd = new AudioSample("sd","sounds/SD.mp3","#FE0101"); 
		sd.loadSample();
		final AudioSample bd = new AudioSample("bd","sounds/BD.mp3","#FE8800");
		bd.loadSample();
		final AudioSample hh = new AudioSample("hh","sounds/HH.mp3","#FEED00");
		hh.loadSample();

		// TODO : automate position
		bd.setX_orig(80);
		bd.setY_orig(220);
		sd.setX_orig(80);
		sd.setY_orig(260);
		hh.setX_orig(80);
		hh.setY_orig(300);
		
		song.getBrowser().addSoundsample(sd);
		song.getBrowser().addSoundsample(bd);
		song.getBrowser().addSoundsample(hh);

		Label lBrowser = new Label("Samples :");
		lBrowser.setStyleName("module_title");
		Label lBD = new Label("Bass Drum");
		Label lSD = new Label("Snare Drum");
		Label lHH = new Label("Hi Hat");
		
		RootPanel.get().add(lBrowser,0,180);
		RootPanel.get().add(lBD,0,220);
		RootPanel.get().add(lSD,0,260);
		RootPanel.get().add(lHH,0,300);

		// Ajout des images
		RootPanel.get().add(bd,bd.getX_orig(),bd.getY_orig());
		RootPanel.get().add(sd,sd.getX_orig(),sd.getY_orig());
		RootPanel.get().add(hh,hh.getX_orig(),hh.getY_orig());

		dragController2.makeDraggable(sd);
		dragController2.makeDraggable(bd);
		dragController2.makeDraggable(hh);
		
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

		RootPanel.get().add(b2,400,530);
		
		Label lClickTwice = new Label ("Please play twice : the 1st time does not work well yet");
		lClickTwice.setPixelSize(200, 200);
		RootPanel.get().add(lClickTwice,610,530);
	}

	// Useless but still a good example
	private void movePic(Image img){
		CustomAnimation animation2 = new CustomAnimation(img.getElement());
		animation2.scrollTo(500, 0, 3000);	
	}

}
