package com.suveb.s.sepsisprediction;

import android.app.Activity;
import android.content.res.AssetFileDescriptor;

import org.tensorflow.lite.Interpreter;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class Predictor {

    private Interpreter tflite;

    Predictor(Activity activity) throws IOException {
        tflite = new Interpreter(loadModelFile(activity));
     //   float[] input = {89f, 100f, 0f, 113f, 82f, 71f, 12f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 45f, 1f, 1f, 0f, -4.84f, 10f};
    }

    float predict(DataClass dc){

        float[] arr = {
                dc.component1(),
                dc.component2(),
                dc.component3(),
                dc.component4(),
                dc.component5(),
                dc.component6(),
                dc.component7(),
                dc.component8(),
                dc.component9(),
                dc.component10(),
                dc.component11(),
                dc.component12(),
                dc.component13(),
                dc.component14(),
                dc.component15(),
                dc.component16(),
                dc.component17(),
                dc.component18(),
                dc.component19(),
                dc.component20(),
                dc.component21(),
                dc.component22(),
                dc.component23(),
                dc.component24(),
                dc.component25(),
                dc.component26(),
                dc.component27(),
                dc.component28(),
                dc.component29(),
                dc.component30(),
                dc.component31(),
                dc.component32(),
                dc.component33(),
                dc.component34(),
                dc.component35(),
                dc.component36(),
                dc.component37(),
                dc.component38(),
                dc.component39(),
                dc.component40()
        };

        float[][] out = {{0}};
        tflite.run(arr, out);
        return  out[0][0];
    }

    private MappedByteBuffer loadModelFile(Activity activity) throws IOException {
        AssetFileDescriptor fileDescriptor = activity.getAssets().openFd("model.tflite");
        FileInputStream inputStream = new FileInputStream(fileDescriptor.getFileDescriptor());
        FileChannel fileChannel = inputStream.getChannel();
        long startOffset = fileDescriptor.getStartOffset();
        long declaredLength = fileDescriptor.getDeclaredLength();
        return fileChannel.map(FileChannel.MapMode.READ_ONLY, startOffset, declaredLength);
    }
}