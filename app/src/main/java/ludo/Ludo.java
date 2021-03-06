package ludo;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.annotation.Nullable;
import android.view.View;
import com.example.root.otpex2.R;
import java.util.Locale;
import speak.SpeakActivity;
public class Ludo extends Activity implements TextToSpeech.OnInitListener {
    public TextToSpeech mTTS;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ludo);
        mTTS = new TextToSpeech(this, this);
        Intent mIntent = getPackageManager().getLaunchIntentForPackage("com.ludo.king");
        startActivity(mIntent);
    }
    public void backludo(View view)
    {
        Intent ludo = new Intent(Ludo.this, SpeakActivity.class);
        startActivity(ludo);
    }
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onInit(int i) {
        mTTS.setLanguage(Locale.ENGLISH);
        mTTS.speak("Ludo Game Started......................", TextToSpeech.QUEUE_ADD, null, null);
    }
}

