package com.company;

import java.util.ArrayList;

public class PageFactory {
    public static ArrayList<Page> createPages(int numNotesOnPage, ArrayList<Note> notes){
        ArrayList<Page> pages = new ArrayList<>();
        int i;
        for (i = 0; notes.size()>=numNotesOnPage*(i+1) ; i++) {
            Page page = new Page(numNotesOnPage);
            page.setNumberPage(i);
            if (!pages.isEmpty()) pages.get(i-1).setNextPage(page);
            for (int j = i*numNotesOnPage; j <(i+1)*numNotesOnPage ; j++) {
                page.addNote(notes.get(j));
            }
            if (!pages.isEmpty()) page.setPreviousPage(pages.get(i-1));
            pages.add(page);

        }
        if (notes.size()%numNotesOnPage!=0) {
            Page page = new Page(numNotesOnPage);
            page.setNumberPage(i);
            pages.get(i-1).setNextPage(page);
            for (int j = notes.size() - notes.size() % numNotesOnPage; j < notes.size(); j++) {
                page.addNote(notes.get(j));
            }
            page.setPreviousPage(pages.get(i-1));
            pages.add(page);
        }
        pages.get(0).setPreviousPage(null);
        pages.get(pages.size()-1).setNextPage(null);
        return pages;
    }
}
