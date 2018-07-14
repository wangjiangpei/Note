package com.test.androidtexttospech;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.widget.Toast;

import java.util.Locale;

/**
 * Created name : wjp
 * time :  2018/06/12 14:39.
 * <p>
 * 系统 语音工具
 *
 *
 * public class App extends Application {
 *
 * @Override public void onCreate() {
 * super.onCreate();
 * SpeechUtils.init(this);
 * }
 * @Override public void onTerminate() {
 * super.onTerminate();
 * SpeechUtils.shutdown();
 * }
 * }
 *
 *
 * SpeechUtils.speak("13522909414");
 */

public class SpeechUtils {
    private static final String ROOY_PATH = "";
    public static Context mContext;
    private static TextToSpeech tts;
    private static SpeechUtils speechUtils;

    public static void init(Context context) {
        mContext = context;
        tts = new TextToSpeech(mContext, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                // 如果装载TTS引擎成功
                if (status == TextToSpeech.SUCCESS) {
                    Toast.makeText(mContext, "装载TTS引擎成功。", Toast.LENGTH_SHORT).show();
                    // 设置使用美式英语朗读
                    int result = tts.setLanguage(Locale.CHINA);
                    // 如果不支持所设置的语言
                    if (result != TextToSpeech.LANG_COUNTRY_AVAILABLE
                            && result != TextToSpeech.LANG_AVAILABLE) {
                        Toast.makeText(mContext, "TTS暂时不支持这种语言的朗读。", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(mContext, "装载TTS引擎失败。", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public static void shutdown() {
        if (tts != null) {
            tts.shutdown();
        }
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public static void speak(String args) {
        tts.speak(args, TextToSpeech.QUEUE_ADD, getParams(), "");
    }

    // 将朗读文本的音频记录到指定文件
    public static void synthesizeToFile(String text, String filename) {
        tts.synthesizeToFile(text, null, ROOY_PATH + filename);
        Toast.makeText(mContext, "声音记录成功！", Toast.LENGTH_SHORT).show();
    }

    public static Bundle getParams() {
        Bundle params = new Bundle();
//        verifyIntegerBundleParam(bundle, Engine.KEY_PARAM_STREAM);
//        verifyIntegerBundleParam(bundle, Engine.KEY_PARAM_SESSION_ID);
//        verifyStringBundleParam(bundle, Engine.KEY_PARAM_UTTERANCE_ID);//说话方式
//        verifyFloatBundleParam(bundle, Engine.KEY_PARAM_VOLUME);//音量
//        verifyFloatBundleParam(bundle, Engine.KEY_PARAM_PAN);
//
//        // Copy feature strings defined by the framework.
//        verifyBooleanBundleParam(bundle, Engine.KEY_FEATURE_NETWORK_SYNTHESIS);
//        verifyBooleanBundleParam(bundle, Engine.KEY_FEATURE_EMBEDDED_SYNTHESIS);
//        verifyIntegerBundleParam(bundle, Engine.KEY_FEATURE_NETWORK_TIMEOUT_MS);
//        verifyIntegerBundleParam(bundle, Engine.KEY_FEATURE_NETWORK_RETRIES_COUNT);
        return params;
    }
}
