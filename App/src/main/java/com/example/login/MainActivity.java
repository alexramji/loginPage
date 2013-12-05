package com.example.login;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {


    private EditText username;
    private EditText password;
    Button login;
    Button forgotpassword;
    Button signup;
    SpannableString spanLogin;
    SpannableString spanforgotpassword;
    SpannableString spansignup;

    ImageView redbar1;
    ImageView redbar2;
    TextView info;


    //TextView mess;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        //Remove notification bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }


        login = (Button)findViewById(R.id.button);
        forgotpassword = (Button)findViewById(R.id.button2);
        signup = (Button)findViewById(R.id.button3);

        username = (EditText)findViewById(R.id.username);
        username.setTextColor(Color.parseColor("#ffffff"));

        password = (EditText)findViewById(R.id.password);
        password.setTextColor(Color.parseColor("#ffffff"));


        info = new TextView(getApplicationContext());
        info = (TextView)findViewById(R.id.info);
        info.setText("mindCast aims to leverage technology to bring people back to the real world" +
                "by bridging the gap between connection and interaction. mindCast lets you see what's on " +
                "the mind of people near you. You can strike up a chat with them, or challenge them to a " +
                "simple game. Sign up now.\n\nAll material, unless otherwise stated, is the property of mindCast " +
                "(sample text)");


        redbar1 = (ImageView)findViewById(R.id.bar3);
        redbar2 = (ImageView)findViewById(R.id.bar4);

        redbar1.setVisibility(View.INVISIBLE);
        redbar2.setVisibility(View.INVISIBLE);
    }

    public void Login(View view) {


        if(username.getText().toString().equals("alexramji")
                && password.getText().toString().equals("mindCast"))
        {
            //mess.setText("Logged in\n" + "Username: " + username.getText().toString() + "\n"
            //        + "Password: " + password.getText().toString());

            username.setText("");
            password.setText("");

            moveTaskToBack(true);

            //spanLogin = new SpannableString("Login");
            //spanLogin.setSpan(new UnderlineSpan(), 0, 5, 0);
            //login.setText(spanLogin);

            redbar1.setVisibility(View.INVISIBLE);
            redbar2.setVisibility(View.INVISIBLE);

        }
        else
        {
            //mess.setText("User Not Found\n" + "Username: " + username.getText().toString() + "\n"
            //+ "Password: " + password.getText().toString());

            password.setText("");

            redbar1.setVisibility(View.VISIBLE);
            redbar2.setVisibility(View.VISIBLE);
        }

    }

    public void forgotPassword(View view) {

        //mess.setText("Forgot Password");

        username.setText("");
        password.setText("");

        Intent intent = new Intent(this, ForgotPasswordActivity.class);
        startActivity(intent);


        //forgotpassword.setText(spanforgotpassword);
    }

    public void signUp(View view) {

        //mess.setText("Sign Up");

        username.setText("");
        password.setText("");

        Intent intent = new Intent(this, SignUpActivity.class);
        startActivity(intent);


        //spansignup = new SpannableString("Sign Up");
        //spansignup.setSpan(new UnderlineSpan(), 0, 7, 0);
        //signup.setText(spansignup);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            return rootView;
        }
    }

}
