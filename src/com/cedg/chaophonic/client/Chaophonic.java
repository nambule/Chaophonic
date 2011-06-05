package com.cedg.chaophonic.client;

import com.allen_sauer.gwt.dnd.client.drop.GridConstrainedDropController;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
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


		// init the song
		final int songLengthInS = 10;
		final int tempo = 120;
		final int signatureTop = 4;
		final int signatureBottom = 4;
		
		// ensure the document BODY has dimensions in standards mode
		RootPanel.get().setPixelSize(800, 600);   

		song = new Song();
		song.setLengthInS(songLengthInS);
		song.setTempo(tempo);
		song.setSignatureTop(signatureTop);
		song.setSignatureBottom(signatureBottom);
		//	song.setWidth(trackWidth);
		song.readyToGo();

		// drop target
		//		AbsolutePanel gridConstrainedDropTarget = new AbsolutePanel();
		//		gridConstrainedDropTarget.setStyleName("sequencer");
		//		RootPanel.get().add(gridConstrainedDropTarget,0,400);
		//		gridConstrainedDropTarget.setPixelSize(trackWidth, 120);
		//		Label lDropSample = new Label("Drop your samples here :");
		//		lDropSample.setStyleName("module_title");
		//		RootPanel.get().add(lDropSample,0,370);

		//		// instantiate our drop controller
		//		final GridConstrainedDropController gcdc = new Sequencer(gridConstrainedDropTarget,1, 20);
		//		final GridConstrainedDropController gcdc2 = new Sequencer(gridConstrainedDropTarget,20, 20);
		//		final GridConstrainedDropController gcdc3 = new Sequencer(gridConstrainedDropTarget,40, 20);		
		//		//Drag handler
		//		final MyPickupDragController dragController2 = new MyPickupDragController(gridConstrainedDropTarget, true, song);
		//		dragController2.setBehaviorMultipleSelection(false);
		//		dragController2.registerDropController(gcdc);

		// Make a new list box, adding a few items to it.
		final ListBox lbQuantize = new ListBox();
		lbQuantize.addItem("1");
		lbQuantize.addItem("1/2");
		lbQuantize.addItem("1/4");

		// Make enough room for all five items (setting this value to 1 turns it
		// into a drop-down list).
		lbQuantize.setVisibleItemCount(1);

		// Add it to the root panel.
		RootPanel.get().add(lbQuantize,550,370);
		RootPanel.get().add(new Label("Quantize"),490,370);

		lbQuantize.addChangeHandler(new QuantizeChangeHandler(song));
		
		//	    lbQuantize.addChangeHandler(new ChangeHandler() {
		//			
		//			public void onChange(ChangeEvent event) {
		//				// TODO Auto-generated method stub
		//				int selectedIndex = lbQuantize.getSelectedIndex();
		//				GridConstrainedDropController gc = null; 
		//				switch (selectedIndex) {
		//				case 0:
		//					gc = gcdc;
		//					break;
		//				case 1:
		//					gc = gcdc2;
		//					break;
		//				case 2:
		//					gc = gcdc3;					
		//					break;
		//				default:
		//					break;
		//				}
		//				dragController2.unregisterDropControllers(); 
		//				dragController2.registerDropController(gc);		
		//			}
		//		});

		for (int i = 0; i < 8; i++) {		    
			AbsolutePanel trackGrid = new AbsolutePanel();
			trackGrid.setPixelSize(1, 120);
			trackGrid.setStyleName("trackGrid");
			RootPanel.get().add(trackGrid,i*80,400);
			for (int j = 1; j < 4; j++) {
				AbsolutePanel trackGrid2 = new AbsolutePanel();
				trackGrid2.setPixelSize(1, 120);
				trackGrid2.setStyleName("trackGrid2");
				RootPanel.get().add(trackGrid2,i*80+j*20,400);	
			}
		}

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

		song.getDragController().makeDraggable(sd);
		song.getDragController().makeDraggable(bd);
		song.getDragController().makeDraggable(hh);

		// Useless but might be a good example for a tte de lecture
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
	//	private void movePic(Image img){
	//		CustomAnimation animation2 = new CustomAnimation(img.getElement());
	//		animation2.scrollTo(500, 0, 3000);	
	//	}

}
