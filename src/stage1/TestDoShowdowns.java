
package stage1;

import java.io.IOException;


import _game.Card;
import _io.ReadBinaryScoreStream;
import _io.WriteBinaryScoreStream;
import _misc.Combinations;
import _misc.Constants;
import _misc.Helper;
import _io.*;

public class TestDoShowdowns {

	private static final String ROOT_OUTPUT_DIR = Constants.DATA_FILE_REPOSITORY +
		"stage1" + Constants.dirSep + "5" + Constants.dirSep;

	public final static int NUM_HOLE_HANDS = Constants.choose(Card.NUM_CARDS-5, 2);

	private static final int MAX_SIMULT_FILES_OPEN = Constants.choose(Card.NUM_CARDS, 2);

	public static void main(String[] args) {
        try {

			double timer1 = System.currentTimeMillis();

			
			String ROOT_INPUT_DIR = ROOT_OUTPUT_DIR;
			byte[] holeCards = new byte[] {1,4};
			String inFile = ROOT_INPUT_DIR + holeCards[0] + "_" + holeCards[1];
			
			BurstBufferedReader in =
					new BurstBufferedReader(inFile, Helper.getBufferSize(MAX_SIMULT_FILES_OPEN));
			
			short header[] = new short[10];
			for(int i = 0; i < 10; i++) {
				header[i] = in.readShort();
//				System.out.println(header[i]);	
			}
			System.out.println(header);	

			ReadBinaryScoreStream in1 =
					new ReadBinaryScoreStream(inFile, 5, Helper.getBufferSize(MAX_SIMULT_FILES_OPEN));
			
			HandRecordScore hr ;

//			while ((hr = (HandRecordScore)in1.readRecord()) != null) {
//				System.out.println(hr.score);
//			}

			in.close();
			
			System.out.println(System.currentTimeMillis() - timer1);
			
			int count1 = Constants.choose(Card.NUM_CARDS-5, 2);
			System.out.println("Number of hole hands exclude board5:"+count1);
			int count2 = Constants.choose(Card.NUM_CARDS, 5);
			System.out.println("Number of Board cards:"+count2);
			
	    } catch (IOException e) {
	    	System.out.println(e.getMessage());
	    	System.out.println(e.getCause());
	    	throw new RuntimeException();
	    }
	}
}
