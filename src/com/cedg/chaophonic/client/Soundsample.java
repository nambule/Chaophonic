package com.cedg.chaophonic.client;

import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.SimplePanel;

/**
 * Sample audio
 * @author ced
 *
 */
public class Soundsample implements Cloneable{

	private int id;
	private String label;
	private String filename;
	private int lengthInMs;
	private int startTimeInMs = 0;
	private Object soundObject;
	private Timer timer;
	private SimplePanel soundSamplePanel;
	private int positionOnTrackX;
	private String title;
	private Image img;
	private static int cpt_id = 0;

	
	public Image getImg() {
		return img;
	}

	public void setImg(Image img) {
		this.img = img;
	}
	
	public String getTitle() {
		return title;
	}

	private void setTitle(String title) {
		this.title = title;
	}

	public int getPositionOnTrackX() {
		return positionOnTrackX;
	}

	public void setPositionOnTrackX(int positionOnTrackX) {
		this.positionOnTrackX = positionOnTrackX;
	}

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

	public int getLength() {
		return lengthInMs;
	}

	public void setLength(int length) {
		this.lengthInMs = length;
	}

	public int getStarttime() {
		return startTimeInMs;
	}

	public void setStarttime(int starttime) {
		this.startTimeInMs = starttime;
	}

	public Soundsample() {
	}

	public Soundsample(String label, String filename) {
		super();
		this.label = label;
		this.filename = filename;
		this.soundSamplePanel = new SimplePanel();
		soundSamplePanel.setPixelSize(40, 40);
		soundSamplePanel.setStyleName("soundSamplePanel");
		
		this.img = new Image("http://code.google.com/webtoolkit/logo-185x175.png");
		this.img.setPixelSize(40, 40);

	}

	public SimplePanel getSoundSamplePanel() {
		return soundSamplePanel;
	}

	public void setSoundSamplePanel(SimplePanel soundSamplePanel) {
		this.soundSamplePanel = soundSamplePanel;
	}

	public Soundsample(int id, String label, String filename, int length) {
		super();
		this.id = id;
		this.label = label;
		this.filename = filename;
		this.lengthInMs = length;
	}

	
	public native void loadSample()
	/*-{

		var label = this.@com.cedg.chaophonic.client.Soundsample::label;
		var filename = this.@com.cedg.chaophonic.client.Soundsample::filename;

		this.@com.cedg.chaophonic.client.Soundsample::soundObject = $wnd.soundManager.createSound(
		{
			id : label,
			url : filename
		});		
		this.@com.cedg.chaophonic.client.Soundsample::soundObject.load();
	}-*/;


	public native void playSample()
	/*-{
		//$wnd.alert("Ready to play sample ?");
		this.@com.cedg.chaophonic.client.Soundsample::soundObject.play();	
	}-*/;

	public String toString(){
		return "name:"+this.filename + " id:" +this.id + " lab:" + this.label + " len:" + this.lengthInMs + " start:" + this.startTimeInMs+" imgTitle:"+img.getTitle()+"\n";
	}


	public Soundsample getCopyOf(){
		Soundsample s2 = new Soundsample();
		s2.filename=this.filename;
		s2.label=this.label;
		cpt_id++;
		s2.id=cpt_id;
		s2.soundObject=this.soundObject;
		s2.soundSamplePanel=this.soundSamplePanel;
		//s2.lengthInMs=this.lengthInMs;
		s2.img = new Image("http://code.google.com/webtoolkit/logo-185x175.png");
		s2.img.setPixelSize(40, 40);
		s2.img.setTitle(String.valueOf(cpt_id));
		return s2;
	}
	
	public Timer getTimer() {
		return timer;
	}


	public void setTimer(Timer timer) {
		this.timer = timer;
	}

	public void initTimer() {
		Timer t = new Timer() {
			@Override
			public void run() {
				//refreshWatchList();
				playSample();
			}
		};
		setTimer(t);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
