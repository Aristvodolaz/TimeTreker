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
import butterknife.BindView;

import java.util.EnumMap;
import java.util.Map;

public class GenerationQrForVyhodFragment extends BaseFragment {
    public static final String NUM_CORPUS = "corpus";

    public static GenerationQrForVyhodFragment newInstance(boolean num) {
        Bundle args = new Bundle();
        args.putBoolean(NUM_CORPUS, num);
        GenerationQrForVyhodFragment fragment = new GenerationQrForVyhodFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @BindView(R.id.qrcode)
    ImageView qrCode;

    @Override
    protected void initViews() {
        super.initViews();

        String building = getArguments().getBoolean(NUM_CORPUS, true) ? "Корпус 1" : "Корпус 2";
        String exit = "Выход";
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
        return R.layout.generation_code_for_vyhod;
    }
}
