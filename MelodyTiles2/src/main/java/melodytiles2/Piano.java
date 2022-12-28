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
    private final static int column = 3;
    private final static int row = 3;
    private ArrayList<Tile> TileList;
    protected Boolean enabled = true;
    protected int skor ;
    protected MidiChannel[] mChannels;
    protected int[] notes;
    protected int selection = 0;

    //Taş Kağıt Makas kontrolü
    public abstract void control(int a);

    //MIDI üzerinden ses modülü
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

    //Tile listesi
    public ArrayList<Tile> getTileList(){
        return TileList;
    }

    public Piano(){
        setBackground(Color.WHITE);
        TileList = new ArrayList<Tile>();
        start();
        repaint();
        try {
            //MIDI dosyasını içeri alır ve notaları alır
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

    //Devre dışı bırakma sistemi
    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
    
    //Piano ekran güncelleme
    protected void update(){
        for(Tile t : TileList){
            t.setRow(t.getRow()-1);
        }
        TileList.remove(0);
        Tile.a = 3;
        TileList.add(new Tile());
    }

    //Piano başlangıç
    private void start(){
        TileList.add(new Tile());
        TileList.add(new Tile());
        TileList.add(new Tile());
    }

    //Piano çizdirme
    public void paint(Graphics g){
        super.paint(g);
        g.setColor(Color.BLACK);
        for(Tile t : TileList){
            if(t.getRow() ==1 && t.getColumn()==1){
                g.drawRect(0, this.height-(height/row), width/column, height/row);
                g.fillRect(0,this.height-(height/row) , width/column, height/row);
            }
            else if(t.getRow() ==1 && t.getColumn()==2){
                g.drawRect(width/column, this.height-(height/row), width/column, height/row);
                g.fillRect(width/column, this.height-(height/row), width/column, height/row);
            }
            else if(t.getRow() ==1 && t.getColumn()==3){
                g.drawRect(2*width/column, this.height-(height/row), width/column, height/row);
                g.fillRect(2*width/column, this.height-(height/row), width/column, height/row);
            }
            else if(t.getRow() ==2 && t.getColumn()==1){
                g.drawRect(0, (height/row), width/column, height/row);
                g.fillRect(0, (height/row), width/column, height/row);
            }
            else if(t.getRow() ==2 && t.getColumn()==2){
                g.drawRect(width/column, (height/row), width/column, height/row);
                g.fillRect(width/column, (height/row), width/column, height/row);
            }
            else if(t.getRow() ==2 && t.getColumn()==3){
                g.drawRect(2*width/column, (height/row), width/column, height/row);
                g.fillRect(2*width/column, (height/row), width/column, height/row);
            }
            else if(t.getRow() ==3 && t.getColumn()==1){
                g.drawRect(0, 0, width/column, height/row);
                g.fillRect(0, 0, width/column, height/row);
            }
            else if(t.getRow() ==3 && t.getColumn()==2){
                g.drawRect(width/column, 0, width/column, height/row);
                g.fillRect(width/column, 0, width/column, height/row);
            }
            else if(t.getRow() ==3 && t.getColumn()==3){
                g.drawRect(2*width/column, 0, width/column, height/row);
                g.fillRect(2*width/column, 0, width/column, height/row);
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
    
    protected abstract void rpscontrol(int a);
}
