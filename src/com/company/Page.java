package com.company;

public class Page extends Song{
    private int numNotesOnPage;
    private int numberPage;
    private Page previousPage;
    private Page nextPage;

    public Page(int numNotesOnPage) {
        this.numNotesOnPage = numNotesOnPage;
    }

    public void setPreviousPage(Page previousPage) {
        this.previousPage = previousPage;
    }

    public Page getPreviousPage() {
        return previousPage;
    }

    public Page getNextPage() {
        return nextPage;
    }

    public void setNumberPage(int numberPage) {
        this.numberPage = numberPage;
    }

    public void setNextPage(Page nextPage) {
        this.nextPage = nextPage;
    }
}
