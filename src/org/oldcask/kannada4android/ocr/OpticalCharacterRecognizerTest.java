package org.oldcask.kannada4android.ocr;

import java.io.FileInputStream;
import java.io.InputStream;

import jjil.core.RgbImage;

import org.oldcask.kannada4android.activity.R;

import android.test.AndroidTestCase;

public class OpticalCharacterRecognizerTest extends AndroidTestCase {

	private OpticalCharacterRecognizer ocr;

	// over ride the training part
	protected void setUp() throws Exception {
		ocr = new OpticalCharacterRecognizer();
		InputStream trainingData = getContext().getResources().openRawResource(
				R.raw.network);
		ocr.trainNeuralNetwork(trainingData);
	}

	public void testRecognizeKannada() throws Exception {
		FileInputStream fis = new FileInputStream("sdcard/kannada.jpg");
		byte[] jpegData = new byte[1000000];
		fis.read(jpegData);

		RgbImage noiseRemoved = ocr.removeNoise(jpegData);
		RgbImage thresholdImage = ocr.thresholdImage(noiseRemoved);
		RgbImage localisedImage = ocr.localiseImage(thresholdImage);
		OCRResult result = ocr.recogniseImage(localisedImage);

		assertNotNull(result);
		assertEquals(
				"Some problem what It was recognized as "
						+ result.getLiteralTranslation(), "kannadha",
				result.getLiteralTranslation());
	}

	public void testShouldRecognizeAmma() throws Exception {
		FileInputStream fis = new FileInputStream("sdcard/amma.jpg");
		byte[] jpegData = new byte[1000000];
		fis.read(jpegData);

		RgbImage noiseRemoved = ocr.removeNoise(jpegData);
		RgbImage thresholdImage = ocr.thresholdImage(noiseRemoved);
		RgbImage localisedImage = ocr.localiseImage(thresholdImage);
		OCRResult result = ocr.recogniseImage(localisedImage);

		assertNotNull(result);
		assertEquals(
				"Some problem what It was recognized as "
						+ result.getLiteralTranslation(), "amma",
				result.getLiteralTranslation());
	}
}
