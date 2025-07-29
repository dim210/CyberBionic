package org.example1;


import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestQuests1 {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml"
        );

        Knight1 artur = new Knight1();

        Quest goal = context.getBean("defeatEnemy", Quest.class);
        artur.setQuest(goal);
        artur.DoQuest();

        goal = context.getBean("winTournament", Quest.class);
        artur.setQuest(goal);
        artur.DoQuest();

        context.close();
    }
}