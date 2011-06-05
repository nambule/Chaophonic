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
	private Sequencer sequencer;

	public Map<Integer, AudioSampleSequenced> soundSequencedArrayHM;
	private int lengthInS;
	private int signatureTop;
	private int signatureBottom;
	private int tempo;
	private int nbOfBeats;
	private MyPickupDragController dragController;
	
	public MyPickupDragController getDragController() {
		return dragController;
	}

	public void setDragController(MyPickupDragController dragController) {
		this.dragController = dragController;
	}

	public Sequencer getSequencer() {
		return sequencer;
	}

	public int getTempo() {
		return tempo;
	}

	public void setTempo(int tempo) {
		this.tempo = tempo;
	}

	public void setSequencer(Sequencer sequencer) {
		this.sequencer = sequencer;
	}
	
	public Map<Integer, AudioSampleSequenced> getSoundArrayHM() {
		return soundSequencedArrayHM;
	}

	public void setSoundArrayHM(Map<Integer, AudioSampleSequenced> soundArrayHM) {
		this.soundSequencedArrayHM = soundArrayHM;
	}

	public int getLengthInS() {
		return lengthInS;
	}

	public void setLengthInS(int lengthInMs) {
		this.lengthInS = lengthInMs;
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
		return tempo;
	}

	public void setBpm(int bpm) {
		this.tempo = bpm;
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

		soundSequencedArrayHM = new HashMap<Integer, AudioSampleSequenced>();
		browser = new Browser();
		// TODO 
		sequencer = new Sequencer(this,600,120);
		//Drag handler
		dragController = new MyPickupDragController(sequencer.getGridConstrainedDropTarget(), true, this);
		dragController.setBehaviorMultipleSelection(false);
		dragController.registerDropController(sequencer.getGcdc());
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
