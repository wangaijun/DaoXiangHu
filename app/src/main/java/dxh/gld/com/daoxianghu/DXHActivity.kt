package dxh.gld.com.daoxianghu

import android.app.Activity
import android.media.MediaPlayer
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_dxh.*

class DXHActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dxh)

        btnPlay.setOnClickListener {
            playMp3()
        }
    }

    private fun playMp3() {
        object : Thread(){
            override fun run() {
                for (i in arr.indices){
                    val mp = MediaPlayer.create(this@DXHActivity,arr[i])
                    mp.start()
                    Thread.sleep(30000)
                    mp.release()
                }
            }
        }.start()
    }

    companion object {
        val arr = listOf(
            R.raw.a1,
            R.raw.a2,
            R.raw.a3,
            R.raw.a4,
            R.raw.a5,
            R.raw.a6,
            R.raw.a7,
            R.raw.a8,
            R.raw.a9,
            R.raw.a10,
            R.raw.a11,
            R.raw.a12,
            R.raw.a13,
            R.raw.a14
        )
    }
}
