package com.example.timetrekerforandroid.activity;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;

import com.example.timetrekerforandroid.R;
import com.example.timetrekerforandroid.db.TimeData;

import com.example.timetrekerforandroid.presenter.SendDataPresenter;
import com.example.timetrekerforandroid.util.SPHelper;
import com.example.timetrekerforandroid.view.SendDataView;
import com.google.android.gms.vision.CameraSource;
import com.google.android.gms.vision.Detector;
import com.google.android.gms.vision.barcode.Barcode;
import com.google.android.gms.vision.barcode.BarcodeDetector;

import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.BindView;
import io.reactivex.rxjava3.annotations.NonNull;

public class CameraActivity extends BaseActivity implements SendDataView {
    private static final int CAMERA_PERMISSION_REQUEST = 100;


    @BindView(R.id.camera_preview)
    SurfaceView cameraView;
    @BindView(R.id.empty_view)
    ImageView emptyView;
    private boolean cameraStarted = false;
    private CameraSource cameraSource;
    private BarcodeDetector barcodeDetector;
    private SendDataPresenter presenter;
    private ProgressDialog dialog;
    private boolean recordingEnabled = true; // Флаг, который позволяет записывать данные

    private void visableWaitDialog(){
        dialog = new ProgressDialog(this);
        dialog.setIndeterminate(false);
        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        dialog.setMessage("Пожалуйста подождите...");
        dialog.setCancelable(false);
        dialog.show();
    }
    private void initializeCamera() {
        barcodeDetector = new BarcodeDetector.Builder(this)
                .setBarcodeFormats(Barcode.QR_CODE)
                .build();

        cameraSource = new CameraSource.Builder(this, barcodeDetector)
                .setAutoFocusEnabled(true)
                .build();

        cameraView.getHolder().addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
            }

            @Override
            public void surfaceCreated(SurfaceHolder holder) {
                try {
                    if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                        requestCameraPermission();
                    } else {
                        cameraSource.start(cameraView.getHolder());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {
                // Остановка камеры
                cameraSource.stop();
            }
        });

        barcodeDetector.setProcessor(new Detector.Processor<Barcode>() {
            @Override
            public void release() {
                // Освобождение ресурсов
            }

            @Override
            public void receiveDetections(Detector.Detections<Barcode> detections) {
                final SparseArray<Barcode> barcodes = detections.getDetectedItems();
                if (barcodes.size() != 0 && !cameraStarted && recordingEnabled) {
                    String qrCodeData = barcodes.valueAt(0).displayValue;
                    String corpus = qrCodeData.substring(0, qrCodeData.indexOf("|"));
                    String type = qrCodeData.substring(qrCodeData.indexOf("|") + 1, qrCodeData.length());
                    finish();


                    presenter.sendFullInfo(new TimeData(SPHelper.getLogin(), getDate(), getTime(), corpus, type.equals("Вход")));

                }
            }
        });
    }

    private String getDate() {
        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        return dateFormat.format(currentDate);
    }

    private String getTime(){
        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        return dateFormat.format(currentDate);
    }

    private void requestCameraPermission() {
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, CAMERA_PERMISSION_REQUEST);
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == CAMERA_PERMISSION_REQUEST) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                initializeCamera();
            } else {
                Toast.makeText(this, "Предоставьте разрешение для камеры", Toast.LENGTH_SHORT).show();
                requestCameraPermission();
            }
        }
    }

    @Override
    public void errorMessage(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        recordingEnabled = false;
    }

    @Override
    public void successMessage(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    protected void initViews(@Nullable Bundle saveInstanceState) {
        presenter = new SendDataPresenter(this);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            requestCameraPermission();
        } else {
            if (!cameraStarted)
                initializeCamera();
        }
    }

    @Override
    protected int layoutResId() {
        return R.layout.scan_fragment;
    }

    @Override
    protected int titleResId() {
        return 0;
    }
}
