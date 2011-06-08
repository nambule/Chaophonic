package com.cedg.chaophonic.client;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Style.BorderStyle;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.HasAllMouseHandlers;
import com.google.gwt.event.dom.client.MouseDownHandler;
import com.google.gwt.event.dom.client.MouseMoveEvent;
import com.google.gwt.event.dom.client.MouseMoveHandler;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.event.dom.client.MouseUpHandler;
import com.google.gwt.event.dom.client.MouseWheelHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * Audio samples available in the browser
 * @author ced
 *
 */
public class AudioSample extends HTML{

	private int id;
	private String label;
	private String filename;
	private int lengthInMs;
	private Object soundObject;
	private SimplePanel soundSamplePanel;
	private String title;
	private Image img;
	private static int cpt_id_as = 0;
	private int x_orig;
	private int y_orig;
	private String color;

//	private int startTimeInMs = 0;
//	private Timer timer;
//	private int positionOnTrackX;
//	private static int cpt_id = 0;

	
	public int getX_orig() {
		return x_orig;
	}

	public void setX_orig(int x_orig) {
		this.x_orig = x_orig;
	}

	public int getY_orig() {
		return y_orig;
	}

	public void setY_orig(int y_orig) {
		this.y_orig = y_orig;
	}

	public int getLengthInMs() {
		return lengthInMs;
	}

	public void setLengthInMs(int lengthInMs) {
		this.lengthInMs = lengthInMs;
	}

	public Image getImg() {
		return img;
	}

	public void setImg(Image img) {
		this.img = img;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

//	public int getPositionOnTrackX() {
//		return positionOnTrackX;
//	}
//
//	public void setPositionOnTrackX(int positionOnTrackX) {
//		this.positionOnTrackX = positionOnTrackX;
//	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

//	public int getStarttime() {
//		return startTimeInMs;
//	}
//
//	public void setStarttime(int starttime) {
//		this.startTimeInMs = starttime;
//	}

	public AudioSample() {
	}

	public AudioSample(String label, String filename, String color) {
		super();
		this.label = label;
		this.filename = filename;
		this.soundSamplePanel = new SimplePanel();
		soundSamplePanel.setPixelSize(40, 40);
		soundSamplePanel.setStyleName("soundSamplePanel");
		cpt_id_as++;
		this.id=cpt_id_as;
		this.img = new Image("http://code.google.com/webtoolkit/logo-185x175.png");
		this.img.setTitle("AS_"+cpt_id_as);
		this.img.setPixelSize(40, 40);
		this.color = color;
		
		//this.setElement(Document.get().createDivElement());
		this.getElement().getStyle().setBackgroundColor(color);
		this.getElement().getStyle().setBorderColor("red");
		this.getElement().getStyle().setBorderWidth(1, Unit.PX);
		this.getElement().getStyle().setBorderStyle(BorderStyle.DOTTED);
		this.getElement().setInnerText(label);
		
		this.setStyleName("audiosample");

	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public SimplePanel getSoundSamplePanel() {
		return soundSamplePanel;
	}

	public void setSoundSamplePanel(SimplePanel soundSamplePanel) {
		this.soundSamplePanel = soundSamplePanel;
	}

	public AudioSample(int id, String label, String filename, int length) {
		super();
		this.id = id;
		this.label = label;
		this.filename = filename;
		//this.lengthInMs = length;
	}

	// TODO : PB
	public native void loadSample()
	/*-{

		var label = this.@com.cedg.chaophonic.client.AudioSample::label;
		var filename = this.@com.cedg.chaophonic.client.AudioSample::filename;
		var durationInMs;
		this.@com.cedg.chaophonic.client.AudioSample::soundObject = $wnd.soundManager.createSound(
		{
			id : label,
			url : filename,
			//onload : function() {
				//durationInMs = parseInt(this.duration);
				//this.@com.cedg.chaophonic.client.AudioSample::lengthInMs = durationInMs+"";
				//$wnd.alert("durationInMs:"+durationInMs+ " " + this.@com.cedg.chaophonic.client.AudioSample::lengthInMs+"");				
			//} // Attention pas de virgule ici 		
		});		
		this.@com.cedg.chaophonic.client.AudioSample::soundObject.load();
	}-*/;


	public native void playSample()
	/*-{
		//$wnd.alert("Ready to play sample ?");
		this.@com.cedg.chaophonic.client.AudioSample::soundObject.play();	
	}-*/;

	public native int getSampleDuration()
	/*-{
		return this.@com.cedg.chaophonic.client.AudioSample::soundObject.duration;	
	}-*/;
	
	public String toString(){
		return "AS name:"+this.filename + " id:" +this.id + " lab:" + this.label + " len:" + this.lengthInMs + " imgTitle:"+img.getTitle()+"\n";
	}


	public AudioSample getCopyOf(){
//		AudioSample s2 = new AudioSample();
//		s2.filename=this.filename;
//		s2.label=this.label;
//		cpt_id++;
//		s2.id=cpt_id;
//		s2.soundObject=this.soundObject;
//		s2.soundSamplePanel=this.soundSamplePanel;
//		s2.img = new Image("http://code.google.com/webtoolkit/logo-185x175.png");
//		s2.img.setPixelSize(40, 40);
//		s2.img.setTitle(String.valueOf(cpt_id));
//		return s2;
		return this;

	}
	
//	public Timer getTimer() {
//		return timer;
//	}
//
//
//	public void setTimer(Timer timer) {
//		this.timer = timer;
//	}

//	public void initTimer() {
//		Timer t = new Timer() {
//			@Override
//			public void run() {
//				//refreshWatchList();
//				playSample();
//			}
//		};
//		setTimer(t);
//	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static boolean isAudioSample(String imgTitle){
		if (imgTitle.startsWith("AS_")) {
			return true;
		} else {			
			return false;
		}
	}
	
}
