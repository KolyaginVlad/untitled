package com.company;

import com.sun.istack.internal.NotNull;



public class Note {
    public static final Mood MAJOR = Mood.major;
    public static final Mood MINOR = Mood.minor;
    public enum Mood {major,minor}
    public enum NoteSignEnum {c,d,e,f,g,a,b}
    public static final NoteSignEnum C = NoteSignEnum.c;//до
    public static final NoteSignEnum D = NoteSignEnum.d;//ре
    public static final NoteSignEnum E = NoteSignEnum.e;//ми
    public static final NoteSignEnum F = NoteSignEnum.f;//фа
    public static final NoteSignEnum G = NoteSignEnum.g;//соль
    public static final NoteSignEnum A = NoteSignEnum.a;//ля
    public static final NoteSignEnum B = NoteSignEnum.b;//си
    private NoteSignEnum noteSign;
    private Mood musicalMood;

    public Note(@NotNull NoteSignEnum noteSign) {
        this.noteSign = noteSign;
        this.musicalMood = MAJOR;
    }
    public Note(@NotNull NoteSignEnum noteSign, @NotNull Mood musicalMood) {
        this.noteSign = noteSign;
        this.musicalMood = musicalMood;
    }

    public void setMusicalMood(@NotNull Mood musicalMood) {
        this.musicalMood = musicalMood;
    }

    public char getNoteSign() {
        return noteSign.toString().charAt(0);
    }

    public Mood getMusicalMood() {
        return musicalMood;
    }

    //if > '1'
    //if < '-1'
    //if = '0'
    public byte compare(@NotNull Note note){
        byte com = compareSign(noteSign,note.noteSign);
        if (com==0){
            if (musicalMood==MAJOR&&note.musicalMood==MINOR) return 1;
            else if (musicalMood==MINOR&&note.musicalMood==MAJOR) return -1;
        }
        return com;
    }

    private byte compareSign(NoteSignEnum sign1,NoteSignEnum sign2){
        NoteSignEnum [] noteSignEnums = NoteSignEnum.values();
        byte i1;
        byte i2;
        for (i1 = 0; noteSignEnums[i1]!=sign1 ; i1++);
        for (i2 = 0; noteSignEnums[i2]!=sign2 ; i2++);
        if (i1<i2) return -1;
        else if(i1>i2) return 1;
        else return 0;
    }
}
