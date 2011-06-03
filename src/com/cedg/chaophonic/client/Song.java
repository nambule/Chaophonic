package com.cedg.chaophonic.client;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import com.sun.j3d.audioengines.Sample;


/**
 * Morceau contenant les samples séquencés
 * @author ced
 *
 */
public class Song{

	private Browser browser;

	public Map<Integer, AudioSampleSequenced> soundSequencedArrayHM;
	private int lengthInMs;
	private int signatureTop;
	private int signatureBottom;
	private int bpm;
	// TODO : width should not be here
	private int width;

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public Map<Integer, AudioSampleSequenced> getSoundArrayHM() {
		return soundSequencedArrayHM;
	}

	public void setSoundArrayHM(Map<Integer, AudioSampleSequenced> soundArrayHM) {
		this.soundSequencedArrayHM = soundArrayHM;
	}

	public int getLengthInMs() {
		return lengthInMs;
	}

	public void setLengthInMs(int lengthInMs) {
		this.lengthInMs = lengthInMs;
	}

	public int getSignatureTop() {
		return signatureTop;
	}

	public void setSignatureTop(int signatureTop) {
		this.signatureTop = signatureTop;
	}

	public int getSignatureBottom() {
		return signatureBottom;
	}

	public void setSignatureBottom(int signatureBottom) {
		this.signatureBottom = signatureBottom;
	}

	public int getBpm() {
		return bpm;
	}

	public void setBpm(int bpm) {
		this.bpm = bpm;
	}

	public Browser getBrowser() {
		return browser;
	}

	public void setBrowser(Browser browser) {
		this.browser = browser;
	}
	
	public void init(){
		//soundArray.clear();
		soundSequencedArrayHM.clear();
	}

	public void addSoundsample(AudioSampleSequenced s){
		//soundArray.add(s);
		// TODO
		soundSequencedArrayHM.put(1, s);
	}

	public String toString(){
		String result = "\nsong hashmap->\n";
		result += ("Retrieving all values from the HashMap\n");
		Iterator iterator = soundSequencedArrayHM.entrySet().iterator();
		while(iterator.hasNext()){        
			result += (iterator.next().toString());
		}
		return result;
	}

	public void playSong(){

		System.out.println("playSong");
		
		System.out.println(this.toString());

		for (Iterator<AudioSampleSequenced> iterator = soundSequencedArrayHM.values().iterator() ; iterator.hasNext() ;){
			AudioSampleSequenced s = iterator.next();
		    if (s.getStarttime()!=0){
			    s.initTimer();
			    s.getTimer().schedule(s.getStarttime());	    
		
		    }    
		}
//		for (Iterator<AudioSample> iterator = soundArrayHM.values().iterator() ; iterator.hasNext() ;){
//		    AudioSample s = iterator.next();
//		    if (s.getStarttime()!=0){
//			    s.initTimer();
//			    s.getTimer().schedule(s.getStarttime());	    
//		
//		    }    
//		}
	}

//	public void sequenceSample(Soundsample s, Integer startTime){
//		final Soundsample s2 = s.getCopyOf();
//		s2.setStarttime(startTime);
//		this.addSoundsample(s2);
//	}

	public native void readyToGo()
	/*-{
		$wnd.alert("Ready to go ?");
	}-*/;

	public Song() {
		super();
		// TODO Auto-generated constructor stub
		soundSequencedArrayHM = new HashMap<Integer, AudioSampleSequenced>();
		browser = new Browser();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

//	public Soundsample getSoundSampleByIndex(int index){
//		// TODO correct it !
//		return getSoundArrayHM().get(index);
//	}

	public AudioSampleSequenced getAudioSampleSequencedById(int i){
		// TODO is the name correct ??!
		// TODO 
		return soundSequencedArrayHM.get(1);
	}
}
