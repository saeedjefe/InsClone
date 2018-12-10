package saeed.example.com.instamorning;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseInstallation;
import com.parse.ParseUser;
import com.parse.SignUpCallback;


public class SignUp extends AppCompatActivity implements View.OnClickListener {

    EditText edtSignUpUserName, edtSignUpPassword, edtSignUpEmail;

    Button btnSignUp, btnLogIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_sign_up );

        ParseInstallation.getCurrentInstallation().saveInBackground();

        edtSignUpEmail = findViewById( R.id.edtSignUpEmail );
        edtSignUpPassword = findViewById( R.id.edtSignUpPassword );
        btnSignUp = findViewById( R.id.btnSignUp );
        btnLogIn = findViewById( R.id.btnLogIn );

        edtSignUpPassword.setOnKeyListener( new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {

                if(keyCode==KeyEvent.KEYCODE_ENTER&& event.getAction()==KeyEvent.ACTION_DOWN)
                {
                    onClick( btnSignUp );
                }
                return false;
            }
        } );

        edtSignUpUserName = findViewById( R.id.edtSignUpUserName );




        btnLogIn.setOnClickListener( this );
        btnSignUp.setOnClickListener( this );




      if(ParseUser.getCurrentUser()!=null)
      {
          transitionToSocialMedia();
      }



    }


    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btnSignUp:

              if(edtSignUpUserName.getText().toString().equals("")||edtSignUpPassword.getText().toString().equals("")||edtSignUpEmail.getText().equals(""))
                {
                  Toast.makeText( SignUp.this, "Please Enter UserName, Password, and Email", Toast.LENGTH_LONG ).show();
                }
                else {


                  final ProgressDialog progressDialog = new ProgressDialog( this );
                  progressDialog.setTitle( "signing up" );
                  progressDialog.show();


                  ParseUser parseUser = new ParseUser();
                  parseUser.setUsername( edtSignUpUserName.getText().toString() );
                  parseUser.setPassword( edtSignUpPassword.getText().toString() );
                  parseUser.setEmail( edtSignUpEmail.getText().toString() );

                  parseUser.signUpInBackground( new SignUpCallback() {

                      //                     if(edtSignUpUserName.getText().toString()==""||edtSignUpPassword.getText().toString()==""||edtSignUpEmail.getText().toString()=="")
//                    {
//                        Toast.makeText( SignUp.this, "Empthy Values Are Not Accepted", Toast.LENGTH_LONG ).show();
//                    }
                      @Override
                      public void done(ParseException e) {
                          if (e == null) {

                              progressDialog.dismiss();
                              Toast.makeText( SignUp.this, "signed up", Toast.LENGTH_LONG ).show();
                              transitionToSocialMedia();


                          } else {
                              progressDialog.dismiss();
                              Toast.makeText( SignUp.this, e.getMessage()+"" , Toast.LENGTH_LONG ).show();

                          }
                      }
                  } );
              }
                break;

            case R.id.btnLogIn:

                Intent intent = new Intent(SignUp.this, LogIn.class  );
                startActivity( intent );


                break;
        }


    }

    public void constraintIsTapped(View view)
    {
        try {

            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService( INPUT_METHOD_SERVICE );
            inputMethodManager.hideSoftInputFromWindow( getCurrentFocus().getWindowToken(), 0 );
        }

        catch (Exception e)
        {
            e.printStackTrace();
        }




    }
    public void  transitionToSocialMedia()
    {
      Intent intent = new Intent( SignUp.this, SocialMedia.class );
      startActivity( intent );
    }

    
}
