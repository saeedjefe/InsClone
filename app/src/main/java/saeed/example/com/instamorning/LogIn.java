package saeed.example.com.instamorning;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;

public class LogIn extends AppCompatActivity implements View.OnClickListener{

    Button btnLog, btnSign;

    EditText edtLogInPassword, edtLogInUserName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_log_in );

        edtLogInPassword = findViewById( R.id.edtLogInPassword );
        edtLogInUserName = findViewById( R.id.edtLogInUserName );
        btnLog = findViewById( R.id.btnLog );
        btnSign = findViewById( R.id.btnSign );



        btnLog.setOnClickListener( this );
        btnSign.setOnClickListener( this );


        if( ParseUser.getCurrentUser()!=null)
        {
            transitionToSocialMedia();
        }




    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btnLog:

                final ProgressDialog progressDialog = new ProgressDialog(LogIn.this);
                progressDialog.setTitle( "logging in " );
                progressDialog.show();

                ParseUser.logInInBackground( edtLogInUserName.getText().toString(), edtLogInPassword.getText().toString(), new LogInCallback() {
                    @Override
                    public void done(ParseUser user, ParseException e) {
                        if(e==null && user!= null)
                        {
                            progressDialog.dismiss();
                            Toast.makeText( LogIn.this, "logged in ", Toast.LENGTH_LONG ).show();
                            transitionToSocialMedia();

                        }
                        else
                        {
                            progressDialog.dismiss();
                            Toast.makeText( LogIn.this, "failed", Toast.LENGTH_LONG ).show();


                        }
                    }
                } );

            break;


            case R.id.btnSign:

                Intent intent = new Intent( LogIn.this, SignUp.class );
                startActivity( intent );

                break;
        }
    }

    public void  transitionToSocialMedia()
    {
        Intent intent = new Intent( LogIn.this, SocialMedia.class );
        startActivity( intent );
    }
}
