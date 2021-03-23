package uz.eldor.covidtestapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tvConfirmed = findViewById<TextView>(R.id.tvTotalConfirmed)
        val tvDeaths = findViewById<TextView>(R.id.tvTotalDeaths)
        val tvRecovered = findViewById<TextView>(R.id.tvTotalRecovered)
        val progressbar = findViewById<ProgressBar>(R.id.progress_circular_home)

        val api = ApiClient.retrofit.create(UserApi::class.java)

        api.getUserData().enqueue(object : Callback<UserData> {
            override fun onResponse(call: Call<UserData>, response: Response<UserData>) {
                val data = response.body()
                if (response.isSuccessful &&  data != null){
                    progressbar.visibility = View.GONE
                    tvConfirmed.text = data.cases.toString()
                    tvDeaths.text = data.deaths.toString()
                    tvRecovered.text = data.recovered.toString()
                }
            }

            override fun onFailure(call: Call<UserData>, t: Throwable) {
                t.printStackTrace()
            }
        })

    }
}