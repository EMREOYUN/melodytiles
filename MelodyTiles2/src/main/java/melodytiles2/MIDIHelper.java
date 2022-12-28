package melodytiles2;

import java.util.ArrayList;
import javax.sound.midi.*;

public class MIDIHelper {
    //MIDI dosyasından notaları alır
    public static int[] noteList(Sequence sequence) {
        ArrayList<Integer> notes = new ArrayList<Integer>();
        for (Track track : sequence.getTracks()) {
            for (int i = 0; i < track.size(); i++) {
                MidiEvent event = track.get(i);
                MidiMessage message = event.getMessage();
                if (message instanceof ShortMessage) {
                    ShortMessage sm = (ShortMessage) message;
                    if (sm.getCommand() == ShortMessage.NOTE_ON) {
                        int key = sm.getData1();
                        notes.add(key);
                    }
                }
            }
        }
        int[] noteArray = new int[notes.size()];
        for (int i = 0; i < notes.size(); i++) {
            noteArray[i] = notes.get(i);
        }
        return noteArray;
    }
}
