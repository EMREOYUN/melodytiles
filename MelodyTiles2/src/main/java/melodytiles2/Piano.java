package melodytiles2;

import javax.sound.midi.*;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;

public abstract class Piano extends JPanel {
    protected int index = 0;
    private final int width = 180;
    private final int height = 291;
    private final static int sütun = 3;
    private final static int satır = 3;
    private ArrayList<Tile> TileList;
    protected Boolean enabled = true;
    protected int skor ;
    protected MidiChannel[] mChannels;
    protected int[] notes;

    public abstract void control(int a);
    public void sound(){
        try {
            mChannels[0].noteOn(notes[index], 100);
            mChannels[0].noteOff(notes[index]);
            if (index == notes.length - 1) {
                index = 0;
            } else index++;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Tile> getTileList(){
        return TileList;

    }

    public Piano(){
        setBackground(Color.WHITE);
        TileList = new ArrayList<Tile>();
        start();
        repaint();
        try {
            Sequence sequence = MidiSystem.getSequence(new File("clean-bad-apple.mid"));
            notes = MIDIHelper.noteList(sequence);
            Synthesizer midiSynth = MidiSystem.getSynthesizer();
            midiSynth.open();
            Instrument[] instr = midiSynth.getDefaultSoundbank().getInstruments();
            mChannels = midiSynth.getChannels();
            midiSynth.loadInstrument(instr[0]);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        //setFocusable(true);
        //requestFocus();
    }
    public int getSkor() {
        return skor;
    }
    public void reset(){
        TileList.clear();
        Tile.a = 1;
        start();
        skor = 0;
        index = 0;
    }
    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
    protected void update(){
        for(Tile t : TileList){
            t.setBulunduğusatır(t.getBulunduğusatır()-1);
        }
        TileList.remove(0);
        Tile.a = 3;
        TileList.add(new Tile());
    }
    private void start(){
        TileList.add(new Tile());
        TileList.add(new Tile());
        TileList.add(new Tile());
    }

    public void paint(Graphics g){
        super.paint(g);
        g.setColor(Color.BLACK);
        for(Tile t : TileList){
            if(t.getBulunduğusatır() ==1 && t.getBulunduğusütun()==1){
                g.drawRect(0, this.height-(height/satır), width/sütun, height/satır);
                g.fillRect(0,this.height-(height/satır) , width/sütun, height/satır);
            }
            else if(t.getBulunduğusatır() ==1 && t.getBulunduğusütun()==2){
                g.drawRect(width/sütun, this.height-(height/satır), width/sütun, height/satır);
                g.fillRect(width/sütun, this.height-(height/satır), width/sütun, height/satır);
            }
            else if(t.getBulunduğusatır() ==1 && t.getBulunduğusütun()==3){
                g.drawRect(2*width/sütun, this.height-(height/satır), width/sütun, height/satır);
                g.fillRect(2*width/sütun, this.height-(height/satır), width/sütun, height/satır);
            }
            else if(t.getBulunduğusatır() ==2 && t.getBulunduğusütun()==1){
                g.drawRect(0, (height/satır), width/sütun, height/satır);
                g.fillRect(0, (height/satır), width/sütun, height/satır);
            }
            else if(t.getBulunduğusatır() ==2 && t.getBulunduğusütun()==2){
                g.drawRect(width/sütun, (height/satır), width/sütun, height/satır);
                g.fillRect(width/sütun, (height/satır), width/sütun, height/satır);
            }
            else if(t.getBulunduğusatır() ==2 && t.getBulunduğusütun()==3){
                g.drawRect(2*width/sütun, (height/satır), width/sütun, height/satır);
                g.fillRect(2*width/sütun, (height/satır), width/sütun, height/satır);
            }
            else if(t.getBulunduğusatır() ==3 && t.getBulunduğusütun()==1){
                g.drawRect(0, 0, width/sütun, height/satır);
                g.fillRect(0, 0, width/sütun, height/satır);
            }
            else if(t.getBulunduğusatır() ==3 && t.getBulunduğusütun()==2){
                g.drawRect(width/sütun, 0, width/sütun, height/satır);
                g.fillRect(width/sütun, 0, width/sütun, height/satır);
            }
            else if(t.getBulunduğusatır() ==3 && t.getBulunduğusütun()==3){
                g.drawRect(2*width/sütun, 0, width/sütun, height/satır);
                g.fillRect(2*width/sütun, 0, width/sütun, height/satır);
            }
        }
    }
    protected void correct(){
        skor++;
        sound();
        repaint();
        update();
    }
    protected void wrong(){
        if (skor > 0) {
            skor--;
        }
        repaint();
        update();
    }
}
