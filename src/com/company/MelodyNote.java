package com.company;

import java.util.ArrayList;
import java.util.Iterator;

public class MelodyNote implements Iterable{
  private ArrayList<Song> songs = new ArrayList<>();
    private boolean isOpen;
    public MelodyNote(Song [] songs) {
        for (Song s:songs
             ) {
            this.songs.add(s);
            s.addInMelodyNote(this);
        }
        isOpen = false;
    }

    public MelodyNote() {
        isOpen = false;
    }

    public void addSong(Song song){
        if (isOpen){
            songs.add(song);
            song.addInMelodyNote(this);
        }
    }

    @Override
    public Iterator iterator() {
        isOpen= true;
        return new Iterator() {
           private int i = 0;
            @Override
            public boolean hasNext() {
                return i<songs.size();
            }

            @Override
            public Object next() {
                return songs.get(i++);
            }
        };
    }
}
