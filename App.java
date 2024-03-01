import java.util.Scanner;
import javax.sound.sampled.*;
import java.util.concurrent.TimeUnit;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;


public class App {
    static int score = 0;
    public static void main(String[] args){


        String answer;
        Scanner input = new Scanner(System.in);

        System.out.println("What is your name? ");
        String username = input.nextLine();
        System.out.println("Welcome \u001B[32m"+ username+"\u001B[0m!");
        sleep(2);
        System.out.println("\u001B[0mThis is the java \u001B[31mThe Big Bang Theory \u001B[0mQuiz!");
        sleep(3);
        System.out.println("We wish the best of luck");
        sleep(3);

        

        System.out.println("What is Rajesh's last name?\nA) Koothrapalli\nB) Cooper\nC) Wolowitz ");
        answer = input.nextLine().toUpperCase();
        if (answer.equals("A")){
            correct();
        }else{
            incorrect();
        }

        System.out.println("And what about his dog?\nA) Cinnamon\nB) Maisy\nC) Max");
        answer = input.nextLine().toUpperCase();
        if (answer.equals("A")){
            correct();
        } else if (answer.equals("GAY")){
            System.out.println("Erm wtf, why did you put that?");
            sleep(2);
            score += 20;
            playSound("gay.wav");
        } else {
            incorrect();
        }

        System.out.println("What is Sheldon's sister called?\nA) Leah\nB) Missy\nC) Jonbon Quavious");
        answer = input.nextLine().toUpperCase();
        if (answer.equals("B")){
            correct();
        }
        else {
            incorrect();
        }

        System.out.println("What is Bert's last name?\nA) Kibbler\nB) Giant\nC) Francis");
        answer = input.nextLine().toUpperCase();
        if (answer.equals("A")){
            correct();
        }
        else {
            incorrect();
        }
        
        System.out.println("What is Leonard's middle name \nA) Lee\nB) Allan\nC) Leaky");
        answer = input.nextLine().toUpperCase();
        if (answer.equals("C")){
            correct();
        }
        else {
            incorrect();
        }

        Complete(username);
    }
    public static void correct(){
        System.out.println("\u001B[32mCorrect!\u001B[0m");
        score++;
        playSound("cotton.wav");
    }
    public static void incorrect(){
        System.out.println("\u001B[31mWRONG!\u001B[0m");
        score--;
        playSound("fail.wav");
    }
    public static void Complete(String username){
        WriteData("data.txt", username, score);
    }
    public static void sleep(Integer seconds) {
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
    public static void WriteData(String file, String username, Integer score) {
          try {
            FileWriter myWriter = new FileWriter(file, true);
            myWriter.write("\n"+username + " : " + score);
            myWriter.close();
            System.out.println("Successfully saved data!");
          } catch (IOException e) {
            System.out.println("An error occurred. Sorry :(");
            e.printStackTrace();
          }
      }
        public static void ReadFile(String path) {
          try {
            File myObj = new File(path);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
              String data = myReader.nextLine();
              System.out.println(data);
            }
            myReader.close();
          } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }
      }
}