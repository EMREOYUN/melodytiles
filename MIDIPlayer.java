import java.io.File;
import java.util.ArrayList;

import javax.sound.midi.*;


public class MIDIPlayer {
    public static void main(String[] args) {
        try {
            //Import a file and play it step by step only when a button is pressed
            Sequence sequence = MidiSystem.getSequence(new File("clean-bad-apple.mid"));
            int[] notes = noteList(sequence);
            for (int i = 0; i < notes.length; i++) {
                //System.out.println(notes[i]);
            }
            Synthesizer midiSynth = MidiSystem.getSynthesizer(); 
            midiSynth.open();
            Instrument[] instr = midiSynth.getDefaultSoundbank().getInstruments();
            MidiChannel[] mChannels = midiSynth.getChannels();
            midiSynth.loadInstrument(instr[0]);
            for (int i = 0; i < notes.length; i++) {
                //Thread sleep yokken bu iki fonsiyonu klavye evente bağlayacağız
                mChannels[0].noteOn(notes[i], 100);
                //System.out.println("Playing note: " + notes[i]);
                Thread.sleep(100);
                mChannels[0].noteOff(notes[i]);
            }
            System.exit(0);
            /*Sequencer sequencer = MidiSystem.getSequencer();
            sequencer.open();
            sequencer.setSequence(sequence);
            System.out.println("Playing the main sequence...");
            sequencer.start();
            while (true) {
                if (sequencer.isRunning()) {
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException ignore) {
                        Thread.currentThread().interrupt();
                        System.exit(0);
                        break;
                    }
                } else {
                    System.exit(0);
                    break;
                }
            }*/
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
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
