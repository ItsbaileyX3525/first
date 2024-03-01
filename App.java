import java.util.Scanner;
import javax.sound.sampled.*;
import java.util.concurrent.TimeUnit;

public class App {
    static int score = 0;
    public static void main(String[] args){
        String answer;
        Scanner input = new Scanner(System.in);
        System.out.println("What is Rajesh's last name?\nA) Koothrapalli\nB) Cooper\nC) Wolowitz ");
        answer = input.nextLine().toUpperCase();
        if (answer.equals("A")){
            correct();
        }else{
            incorrect();
        }

        System.out.println("And what about his dog?\nA) Cinnamon\nB) Maisy\nC)  Max");
        answer = input.nextLine().toUpperCase();
        if (answer.equals("A")){
            correct();
        } else if (answer.equals("Gay")){
            System.out.println("Erm wtf, why did you put that?");
        } else {
            incorrect();
        }

    }
    public static void correct(){
        System.out.println("Correct!");
        score++;
        playSound("cotton.wav");
    }
    public static void incorrect(){
        System.out.println("WRONG!");
        score--;
        playSound("fail.wav");
    }
    public static void sleep(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void playSound(String filePath){
        try {
            Clip clip = AudioSystem.getClip();
            AudioInputStream inputStream = AudioSystem.getAudioInputStream(App.class.getResourceAsStream(filePath));
            clip.open(inputStream);
            clip.start();
            Thread.sleep(clip.getMicrosecondLength() / 1000); // Wait for the clip to finish playing
        } catch (Exception e) {
            System.err.println("Error playing sound: " + e.getMessage());
        }
    }
}