package com.company;


import java.util.Iterator;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Note [] notes = new Note[50];
        Note.NoteSignEnum [] noteSignEnums = Note.NoteSignEnum.values();
        Random random = new Random();
        for (int i = 0; i <50 ; i++) {
            notes[i] = new Note(noteSignEnums[random.nextInt(noteSignEnums.length)],random.nextInt(2)==0?Note.MAJOR:Note.MINOR);
        }
       MelodyNote melodyNote = new MelodyNote();
       Song song1 = new Song();
        Song song2 = new Song();
        Song song3 = new Song(notes);
        for (int i = 0; i <50 ; i++) {
          song1.addNote(new Note(noteSignEnums[random.nextInt(noteSignEnums.length)],random.nextInt(2)==0?Note.MAJOR:Note.MINOR));
            song2.addNote(new Note(noteSignEnums[random.nextInt(noteSignEnums.length)]));
        }
        Iterator<Song> iterator = melodyNote.iterator();
//        melodyNote.addSong(song1);
//        melodyNote.addSong(song3);
//        MelodyNote melodyNote1 = song1.addSong(song2);
        MelodyNote melodyNote1 = song1.addSong(song2);
        melodyNote.addSong(song1);
        melodyNote.addSong(song3);
        while (iterator.hasNext()){
            iterator.next().play();
            System.out.println();
        }
        System.out.println();
        iterator = melodyNote.iterator();
        while (iterator.hasNext()){
            Song song = iterator.next();
            song.changeMood(Note.MINOR);
            song.play();
            System.out.println();
        }
        System.out.println();
        iterator = melodyNote.iterator();
        while (iterator.hasNext()){
            Song song = iterator.next();
            song.changeMood(Note.MAJOR,10);
            song.play();
            System.out.println();
        }
        System.out.println();
        iterator = melodyNote.iterator();
        while (iterator.hasNext()){
            Song song = iterator.next();
            song.changeMood(Note.MINOR,10,30);
            song.play();
            System.out.println();
        }
        System.out.println();
        iterator = melodyNote.iterator();
        while (iterator.hasNext()){
            for (Page p:iterator.next().intoPages(10)
                 ) {
                p.play();
            }
            System.out.println();
        }
        System.out.println();
        System.out.println(song1.compare(song2));
        System.out.println(song1.compare(song1));
        System.out.println(song2.compare(song3,1,2));
        System.out.println(song3.compare(song1,49));
        System.out.println();
        System.out.println();
        iterator = melodyNote1.iterator();
        while (iterator.hasNext()){
            iterator.next().play();
            System.out.println();
        }

    }
}

