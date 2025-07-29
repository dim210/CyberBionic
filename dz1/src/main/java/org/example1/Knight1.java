package org.example1;

public class Knight1 {
    private Quest quest;

    public void setQuest(Quest quest) {
        this.quest = quest;
    }
    public void DoQuest() {
        System.out.println("My goal now: " + this.quest.doQuest());
    }
}
