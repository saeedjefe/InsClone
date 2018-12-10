package saeed.example.com.instamorning;

import android.app.Application;

import com.parse.Parse;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("fPFYCNKR6pd5aitZN4fc1I3a8IsE7BQO7DGd2CVL")
                // if desired
                .clientKey("Sl87ohvFply7ZgNHSeSbSY6Ki1uG3rh6iyVCovL6")
                .server("https://parseapi.back4app.com/")
                .build()
        );
    }
    }




