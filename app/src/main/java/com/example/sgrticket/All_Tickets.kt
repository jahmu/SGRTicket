package com.example.sgrticket

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import org.json.JSONObject
import java.io.OutputStreamWriter
import java.net.HttpURLConnection
import java.net.URL

class All_Tickets : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tickets)

    }
    class MyAsyncTask internal constructor(context: Context) : AsyncTask<String, String, String>() {
        lateinit var con: HttpURLConnection
        lateinit var resulta:String
        val builder = Uri.Builder()
        private val cont: Context =context
        override fun onPreExecute() {
            super.onPreExecute()

            progressBar.isIndeterminate()
            progressBar.visibility= View.GONE


            val progressBar= ProgressBar(cont)
            progressBar.isIndeterminate=true
            progressBar.visibility= View.VISIBLE


        }

        override fun doInBackground(vararg params: String?):  String? {
            try {

                var query = builder.build().encodedQuery
                val url: String = "http://sgrticket.000webhostapp.com/sgrApp/alltickets.php"
                val obj = URL(url)
                con = obj.openConnection() as HttpURLConnection
                con.setRequestMethod("GET")
                con.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.1)")
                con.setRequestProperty("Accept-Language", "UTF-8")
                con.setDoOutput(true)
                val outputStreamWriter = OutputStreamWriter(con.getOutputStream())
                outputStreamWriter.write(query)
                outputStreamWriter.flush()
                Log.e("pass 1", "connection success ")
            } catch (e: Exception) {
                Log.e("Fail 1", e.toString())
            }
            try {
                resulta = con.inputStream.bufferedReader().readText()
                Log.e("data", resulta)
            } catch (e: java.lang.Exception) {
                Log.e("Fail 2", e.toString())
            }
            return null;
        }
        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
            progressBar.visibility= View.GONE

            var json_data = JSONObject(resulta)
            val code: Int = json_data.getInt("code")
            Log.e("data",code.toString())
            if (code == 1) {
                //val com: JSONArray = json_data.getJSONArray("userdetails")
                //val comObject = com[0] as JSONObject
                //Log.e("data",""+comObject.optString("fname"))
                val toMain = Intent(cont, MainActivity::class.java)
                toMain.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
                cont.run {
                    startActivity(toMain)
                }
            }
        }


    }
}