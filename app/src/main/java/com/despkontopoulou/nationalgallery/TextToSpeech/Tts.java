package com.despkontopoulou.nationalgallery.TextToSpeech;
import android.content.Context;
import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnInitListener;
import java.util.Locale;

public class Tts {
    private TextToSpeech textToSpeech;
    private boolean initialized = false;
    public interface TtsInitListener {
        void onTtsInitialized(boolean isSuccessful);
    }
    public Tts(Context context,TtsInitListener listener){
        textToSpeech= new TextToSpeech(context, new OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status== TextToSpeech.SUCCESS){
                    Locale greek = new Locale("el","GR");
                    int langResult = textToSpeech.isLanguageAvailable(greek);
                    if(langResult==TextToSpeech.LANG_AVAILABLE){
                        textToSpeech.setLanguage(greek);
                    }else{
                        textToSpeech.setLanguage(Locale.US);
                    }
                    initialized=true;
                    listener.onTtsInitialized(true);
                }else{
                    listener.onTtsInitialized(false);
                }
            }
        });
    }
    public void speech(String text){
        if(initialized){
            textToSpeech.speak(text, TextToSpeech.QUEUE_FLUSH,null, null);
        }
    }

}