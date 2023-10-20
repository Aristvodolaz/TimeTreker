package com.example.timetrekerforandroid.fragment;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.timetrekerforandroid.R;
import com.example.timetrekerforandroid.activity.HeadActivity;
import com.example.timetrekerforandroid.activity.UserActivity;
import com.example.timetrekerforandroid.presenter.GetTypeUserPresenter;
import com.example.timetrekerforandroid.view.GetTypeUserView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import butterknife.BindView;

public class LoginFragment extends BaseFragment implements GetTypeUserView {

    private FirebaseAuth auth;
    private FirebaseUser user;
    private GetTypeUserPresenter presenter;
    @BindView(R.id.login)
    EditText login;
    @BindView(R.id.password)
    EditText password;
    @BindView(R.id.start)
    Button btn;
    @BindView(R.id.warning)
    LinearLayout warning;
    boolean type_user;
    public static LoginFragment newInstance() {
        return new LoginFragment();
    }

    @Override
    protected void initViews() {
        super.initViews();

        presenter = new GetTypeUserPresenter(this);

        btn.setOnClickListener(l->{
            authentication(login.getText().toString(),password.getText().toString());
        });
    }

    private void authentication(String login, String password){
        auth = FirebaseAuth.getInstance();
        if(!login.equals("") && !password.equals("")){
            auth.signInWithEmailAndPassword(login,password)
                    .addOnCompleteListener(task -> {
                        if(task.isSuccessful()){
                            user = auth.getCurrentUser();
                            presenter.getTypeUser(user.getEmail());
                        } else  Toast.makeText(getContext(),"Ошибка аунтефикации",Toast.LENGTH_SHORT).show();

                    });
        } else warning.setVisibility(View.VISIBLE);
    }

    @Override
    protected int layoutId() {
        return R.layout.login_fragment;
    }

    @Override
    public void typeUser(String type) {
        type_user = type.equals("0");
        startActivity(type_user?new Intent(getActivity(),HeadActivity.class): new Intent(getActivity(), UserActivity.class));
    }

    @Override
    public void showMessage(String msg) {
        Toast.makeText(getContext(),msg,Toast.LENGTH_SHORT).show();
    }
}
