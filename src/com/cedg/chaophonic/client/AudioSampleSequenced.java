/**
 * 
 */
package com.cedg.chaophonic.client;

import com.google.gwt.dom.client.Style.BorderStyle;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Image;

/**
 * Audio samples sequenced in the track
 * @author ced
 *
 */
public class AudioSampleSequenced extends HTML{
	
	private AudioSample audiosample;
	private int startTimeInMs = 0;
	private Timer timer;
	private int positionOnTrackX;
	private static int cpt_id_ass = 0;
	private int id;
	private Image img;

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int calculateWidth(Song s){
		return (audiosample.getSampleDuration()*s.getSequencer().getWidth())/(s.getLengthInS()*1000);
	}
	
	// TODO : modifier le height en dur
	public void setWidth(Song s){
		this.setPixelSize(calculateWidth(s), 20);
	}
	
	public AudioSampleSequenced(AudioSample audiosample) {
		//super();
		
		this.audiosample = audiosample;

		//s2.filename=this.filename;
		//s2.label=this.label;
		cpt_id_ass++;
		this.id=cpt_id_ass;
		//s2.soundObject=this.soundObject;
		//s2.soundSamplePanel=this.soundSamplePanel;
//		this.img = new Image("http://code.google.com/webtoolkit/logo-185x175.png");
//		this.img.setPixelSize(40, 40);
//		this.img.setTitle("ASS_"+cpt_id_ass);
		//this.img.setTitle(String.valueOf(cpt_id_asc));
		
		this.getElement().getStyle().setBackgroundColor(audiosample.getColor());
		this.getElement().getStyle().setBorderColor("black");
		this.getElement().getStyle().setBorderWidth(1, Unit.PX);
	//	this.getElement().getStyle().setBorderStyle(BorderStyle.SOLID);
//		this.getElement().getStyle().setHeight(20, Unit.PX);
		this.getElement().setInnerText(audiosample.getText());
		
		this.setStyleName("audiosamplesequenced");
		
	}
	
	public String toString(){
		return "ASS " + this.audiosample.toString() +  " startTimeInMs="+startTimeInMs + " cpt_id_asc=" + cpt_id_ass + "\n";
	}
	
	public void initTimer() {
		Timer t = new Timer() {
			@Override
			public void run() {
				//refreshWatchList();
				audiosample.playSample();
			}
		};
		setTimer(t);
	}
	
	public int getPositionOnTrackX() {
		return positionOnTrackX;
	}

	public void setPositionOnTrackX(int positionOnTrackX) {
		this.positionOnTrackX = positionOnTrackX;
	}
	
	public int getStarttime() {
		return startTimeInMs;
	}

	public void setStarttime(int starttime) {
		this.startTimeInMs = starttime;
	}
	
	public Timer getTimer() {
		return timer;
	}


	public void setTimer(Timer timer) {
		this.timer = timer;
	}
	

}
