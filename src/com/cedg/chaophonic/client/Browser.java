package com.cedg.chaophonic.client;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * Sound sample browser
 * 
 * @author ced
 *
 */
public class Browser {


	private Map<Integer, AudioSample> soundArrayHM;
	
	public Browser() {
		super();
		this.soundArrayHM = new HashMap<Integer, AudioSample>();
	}

	public void addSoundsample(AudioSample s){
		soundArrayHM.put(s.getId(), s);
	}

	public AudioSample getAudioSampleById(int i){
		// TODO is the name correct ??!
		return soundArrayHM.get(i);
	}
	
}
