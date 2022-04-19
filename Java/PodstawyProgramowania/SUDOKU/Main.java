package com.company;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;
public class Main {
    public static void main(String[] args) throws Exception
    {
        try
        {
            File music=new File("play.wav");
            AudioInputStream audio= AudioSystem.getAudioInputStream(music);
            Clip clip=AudioSystem.getClip();
            clip.open(audio);
            clip.start();
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        }
        catch (Exception a)
        {
            a.printStackTrace();
        }
        new Menu();
    }
}

