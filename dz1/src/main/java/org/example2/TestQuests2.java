package org.example2;

public class TestQuests2 {
    public static void main(String[] args) {

        Knight2 richard = new Knight2();

        richard.DoQuest(()-> ("defeat the enemy"));
        richard.DoQuest(()-> ("win the tournament"));
    }
}