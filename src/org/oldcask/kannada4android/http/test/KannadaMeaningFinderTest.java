package org.oldcask.kannada4android.http.test;

import java.io.IOException;

import org.oldcask.kannada4android.http.KannadaMeaningFinder;

import junit.framework.TestCase;



public class KannadaMeaningFinderTest extends TestCase{

	
	
	public void testShouldFailIfKannadaWordDoesntExist() {
		KannadaMeaningFinder kannadaMeaningFinder = new KannadaMeaningFinder("boss");
		try {
			kannadaMeaningFinder.getKannadaMeaning();
			fail("Should have thrown Exception");
		} catch (Exception e) {
			
		}		
	}
	
	public void testShouldGetCorrectMeaningForAvailableKannadaWord(){
		KannadaMeaningFinder kannadaMeaningFinder = new KannadaMeaningFinder("Enri");
		try {
			assertEquals("hello", kannadaMeaningFinder.getKannadaMeaning());
		} catch (IOException e) {
			fail("This should have gotten the correct meaning");
		}
	}

}
