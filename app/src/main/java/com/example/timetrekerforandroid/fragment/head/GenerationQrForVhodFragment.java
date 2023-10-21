package com.example.timetrekerforandroid.fragment.head;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;
import com.example.timetrekerforandroid.R;
import com.example.timetrekerforandroid.fragment.BaseFragment;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import java.util.EnumMap;
import java.util.Map;
import android.os.Handler;

import butterknife.BindView;

public class GenerationQrForVhodFragment extends BaseFragment {
    public static final String NUM_CORPUS = "corpus";

    public static GenerationQrForVhodFragment newInstance(boolean num) {
        Bundle args = new Bundle();
        args.putBoolean(NUM_CORPUS, num);
        GenerationQrForVhodFragment fragment = new GenerationQrForVhodFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @BindView(R.id.qrcode) ImageView qrCode;
    @BindView(R.id.back_arrow) ImageView backArrow;
    private Handler qrCodeUpdateHandler;
    private static final long QR_CODE_UPDATE_INTERVAL = 5 * 60 * 1000;

    @Override
    protected void initViews() {
        super.initViews();

        qrCodeUpdateHandler = new Handler();
        updateQRCode();

        // Регулярно обновляем QR-код каждые 5 минут
        qrCodeUpdateHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                updateQRCode();
                qrCodeUpdateHandler.postDelayed(this, QR_CODE_UPDATE_INTERVAL);
            }
        }, QR_CODE_UPDATE_INTERVAL);

        backArrow.setOnClickListener(l->{getActivity().getSupportFragmentManager().popBackStack();});

    }

    private void updateQRCode() {
        String building = getArguments().getBoolean(NUM_CORPUS, true) ? "Корпус 1" : "Корпус 2";
        String exit = "Вход";
        String qrCodeData = building + "|" + exit;

        Bitmap qrCodeBitmap = generateQRCode(qrCodeData);

        qrCode.setImageBitmap(qrCodeBitmap);
    }

    private Bitmap generateQRCode(String data) {
        try {
            Map<EncodeHintType, ErrorCorrectionLevel> hints = new EnumMap<>(EncodeHintType.class);
            hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);

            QRCodeWriter qrCodeWriter = new QRCodeWriter();
            com.google.zxing.common.BitMatrix bitMatrix = qrCodeWriter.encode(data, BarcodeFormat.QR_CODE, 512, 512, hints);

            int width = bitMatrix.getWidth();
            int height = bitMatrix.getHeight();
            int[] pixels = new int[width * height];

            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    pixels[y * width + x] = bitMatrix.get(x, y) ? 0xFF000000 : 0xFFFFFFFF;
                }
            }

            Bitmap qrCodeBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            qrCodeBitmap.setPixels(pixels, 0, width, 0, 0, width, height);

            return qrCodeBitmap;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    protected int layoutId() {
        return R.layout.generation_code_for_vhod;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (qrCodeUpdateHandler != null) {
            qrCodeUpdateHandler.removeCallbacksAndMessages(null);
            qrCodeUpdateHandler = null;
        }
    }
}
