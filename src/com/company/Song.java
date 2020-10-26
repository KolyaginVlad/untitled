package com.company;

import com.sun.istack.internal.NotNull;

import java.util.ArrayList;
import java.util.Iterator;

public class Song implements Iterable {
    private ArrayList<Note> notes = new ArrayList<>();
    private MelodyNote parent;

    public ArrayList<Page> intoPages(int numNotesOnPage){
        return PageFactory.createPages(numNotesOnPage,notes);
    }
    public void addNote(Note note){
        notes.add(note);
    }
    public void addNote(Note [] notes1){
        for (Note note:notes1
             ) {
            notes.add(note);
        }
    }

    public void setParent(MelodyNote parent) {
        this.parent = parent;
    }

    public Song(Note[] notes1) {
        for (Note note:notes1
        ) {
            notes.add(note);
        }
    }

    public Song() {
    }

    public MelodyNote addSong(@NotNull Song song){
        if (parent != null) {
            parent.addSong(song);
        }
        else {
            Song [] songs = {this,song};
            parent = new MelodyNote(songs);
        }
        return parent;
    }

    public void changeMood(Note.Mood mood,int start, int end){
        for (int i = start; i <= end; i++) {
            notes.get(i).setMusicalMood(mood);
        }
    }
    public void changeMood(Note.Mood mood,int start){
        for (int i = start; i < notes.size(); i++) {
            notes.get(i).setMusicalMood(mood);
        }
    }
    public void changeMood(Note.Mood mood){
        for (int i = 0; i < notes.size(); i++) {
            notes.get(i).setMusicalMood(mood);
        }
    }
    public boolean compare(Song song,int start, int end){
        if (notes.size()!= song.notes.size()) return false;
        for (int i = start; i < end; i++) {
            if (notes.get(i).compare(song.notes.get(i))!=0) return false;
        }
        return true;
    }
    public boolean compare(Song song, int start){
        if (notes.size()!= song.notes.size()) return false;
        for (int i = start; i < notes.size(); i++) {
            if (notes.get(i).compare(song.notes.get(i))!=0) return false;
        }
        return true;
    }
    public boolean compare(Song song){
        if (notes.size()!= song.notes.size()) return false;
        for (int i = 0; i < notes.size(); i++) {
            if (notes.get(i).compare(song.notes.get(i))!=0) return false;
        }
        return true;
    }
    public void play(){
        for (Note note:notes
             ) {
            if (note.getMusicalMood()==Note.MAJOR) System.out.print((note.getNoteSign()+"").toUpperCase());
            else System.out.print(note.getNoteSign());
        }
        System.out.println();
    }

    @Override
    public String toString() {
        String s = "";
        for (Note note:notes
        ) {
            if (note.getMusicalMood()==Note.MAJOR) s+=((note.getNoteSign()+"").toUpperCase());
            else s+=(note.getNoteSign());
        }
        return s;
    }

    @Override
    public Iterator iterator() {

        return new Iterator() {
            int i = 0;
            @Override
            public boolean hasNext() {
                return i<notes.size();
            }

            @Override
            public Object next() {
                return notes.get(i++);
            }
        };
    }
}
