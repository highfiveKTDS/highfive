package com.ktds.shoppingbell;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends ActionBarActivity {

    private Button btnLogin;

    private EditText etLoginId;
    private EditText etLoginPwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnLogin    = (Button)findViewById(R.id.btnLogin);

        etLoginId   = (EditText)findViewById(R.id.etLoginId);
        etLoginPwd  = (EditText)findViewById(R.id.etLoginPwd);

        //for debug.
        etLoginId.setText("taehun3718@naver.com");
        etLoginPwd.setText("taehun3718@naver.com");

        btnLogin.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO: 서버에서 요청했을 때 아이디 패스워드가 일치하는지 확인해야 함.
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);

                if (etLoginId.getText().toString().equals("")) {
                    AlertDialog.Builder alert = new AlertDialog.Builder(LoginActivity.this);
                    alert.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();     //닫기
                        }
                    });
                    alert.setMessage("ID를 확인해주세요!");
                    alert.show();
                    return;
                }

                if (etLoginPwd.getText().toString().equals("")) {
                    AlertDialog.Builder alert = new AlertDialog.Builder(LoginActivity.this);
                    alert.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();     //닫기
                        }
                    });
                    alert.setMessage("패스워드를 확인해주세요!");
                    alert.show();
                    return;
                }
                startActivity(intent);
            }
        });

        /*btnRegistAccount.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW
                                , Uri.parse(URLProtocol.IP_ADDRESS + URLProtocol.URL_MemberRegist));
                startActivity(intent);
            }
        });*/
    }


}
