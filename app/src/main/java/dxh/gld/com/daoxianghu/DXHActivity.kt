package dxh.gld.com.daoxianghu

import android.app.Activity
import android.app.AlertDialog
import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.PopupMenu
import kotlinx.android.synthetic.main.activity_dxh.*

class DXHActivity : Activity() {
    private lateinit var popupMenu:PopupMenu
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON,
            WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
        setContentView(R.layout.activity_dxh)

        popupMenu = PopupMenu(this, btnPlay)
        popupMenu.inflate(R.menu.pop_menu_items)

        popupMenu.setOnMenuItemClickListener {
            when(it.itemId){
                R.id.items->playMp3()
                R.id.record->playRecord()
                R.id.roadOneBeforeTest->playRoadOneBeforeTest()
            }
            return@setOnMenuItemClickListener true
        }

        btnPlay.setOnClickListener {
            popupMenu.show()
        }
    }

    private fun playRoadOneBeforeTest() {
        val mp = MediaPlayer.create(this,R.raw.road_one_before_test)
        mp.start()
        mp.setOnCompletionListener {
            it.release()
        }
    }

    private fun playRecord() {
        val mp = MediaPlayer.create(this,R.raw.record)
        mp.start()
        mp.setOnCompletionListener {
            it.release()
        }
    }

    private fun playMp3() {
        object : Thread(){
            override fun run() {
                for (i in arr.indices){
                    val mp = MediaPlayer.create(this@DXHActivity,arr[i])
                    mp.start()
                    mp.setOnCompletionListener {
                        it.release()
                    }
                    Thread.sleep(30000)
                }
            }
        }.start()
    }

    fun onClick(view: View) {
        when(view.id){
            R.id.tv1->toast("打灯，挂挡，松手刹")
            R.id.tv2->toast("踩刹车")
            R.id.tv3->toast("踩刹车，30以内")
            R.id.tv4->toast("打灯，踩刹车")
            R.id.tv5->toast("踩刹车")
            R.id.tv6->toast("直线，35左右")
            R.id.tv7->toast("打灯，踩刹车，换到1档，看直行车")
            R.id.tv8->toast("打右灯")
            R.id.tv9->toast("踩刹车，30以内")
            R.id.tv10->toast("打右灯，踩刹车，减至两档")
            R.id.tv11->toast("打左灯，直行，关左灯")
            R.id.tv12->toast("踩刹车")
            R.id.tv13->toast("打右灯，踩刹车，对白块内10公分，停车，拉手刹，挂空挡，松离合、松脚刹，开门，关门，考官签字")
        }
    }

    private fun toast(s: String) {
        AlertDialog.Builder(this).setMessage(s)
            .setPositiveButton("确定",null)
            .create().show()
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
