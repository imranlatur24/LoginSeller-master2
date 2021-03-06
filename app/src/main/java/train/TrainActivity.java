package train;

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
import systemrestart.SystemrestartActivity;

/**
 * Created by root on 29/9/17.
 */

public class TrainActivity extends Activity implements TextToSpeech.OnInitListener {
    public TextToSpeech mTTS;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.train);
        mTTS = new TextToSpeech(this, this);
        Intent train = getPackageManager().getLaunchIntentForPackage("cris.org.in.prs.ima");
        startActivity(train);
    }
    public void backtrain(View view)
    {
        Intent intent = new Intent(TrainActivity.this, SpeakActivity.class);
        startActivity(intent);
    }
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onInit(int i) {
        mTTS.setLanguage(Locale.ENGLISH);
        mTTS.speak("IRCTC application started......................", TextToSpeech.QUEUE_ADD, null, null);
    }
}
