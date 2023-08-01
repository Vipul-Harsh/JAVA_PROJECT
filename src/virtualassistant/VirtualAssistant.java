/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package virtualassistant;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;
import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.LiveSpeechRecognizer;
import edu.cmu.sphinx.api.SpeechResult;
import java.awt.Desktop;
import java.io.IOException;
import static java.lang.Compiler.command;
import java.net.URI;
import java.net.URISyntaxException;

/**
 *
 * @author b
 */
public class VirtualAssistant {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, URISyntaxException {
        // TODO code application logic here
        Configuration c = new Configuration();
        c.setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us");
        c.setDictionaryPath("src\\com\\voiceog\\resources\\1741.dic");
        c.setLanguageModelPath("src\\com\\voiceog\\resources\\1741.lm");
      try{  
       LiveSpeechRecognizer speech =new LiveSpeechRecognizer(c);
       speech.startRecognition(true);
       SpeechResult speechr=null;
       while((speechr=speech.getResult())!=null){
           String voicecommand=speechr.getHypothesis();
           System.out.println("Input is "+ voicecommand);
           String work=null;
           Desktop desk=Desktop.getDesktop();
           if(voicecommand.equalsIgnoreCase("open chrome")){
               URI u=new URI("www.google.co.in");
               desk.browse(u);
            }else if(voicecommand.equalsIgnoreCase("open youtube")){
              URI u=new URI("www.youtube.com");
               desk.browse(u);
       }
            else if(voicecommand.equalsIgnoreCase("what is your name")){
                System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
        Voice v; 
        VoiceManager vm=VoiceManager.getInstance() ;
        v=vm.getVoice("kevin16");
        v.allocate();
//        v.getPitch();
//        v.getVolume();
        v.speak("MY NAME IS FORD THE ASSISTANT");
        v.speak("WHAT CAN I DO FOR YOU");
        
            }
       }
    }catch(IOException e){
        e.printStackTrace(); 
    }
   
    }
}

