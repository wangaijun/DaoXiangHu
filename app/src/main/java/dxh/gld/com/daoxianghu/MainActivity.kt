package dxh.gld.com.daoxianghu

import android.app.Activity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : Activity() {
    private val list = mutableListOf<Data>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = MyAdapter(list)

        list.add(
            Data("上车准备" ,
                    "右侧门递身份证，左侧门等考官摆手\n" +
                    "去车尾按钮，去车头按钮，一定要听到语音再松钮\n" +
                    "看一眼后方，后方无车，左手开门，右腿上车，考官您好\n" +
                    "踩一脚离合，调座椅前后，靠背，高低，系安全带")
        )
        list.add(Data("起步","打左灯，挂档，松手刹"))
        list.add(Data("直行通过路口","踩刹车"))
        list.add(Data("通过学校区域","踩刹车 30以内"))
        list.add(Data("路口左转弯","打左灯，踩刹车，看左后视镜，进左标线撤掉，完成左转弯"))
        list.add(Data("会车路段","踩刹车"))
        list.add(Data("直线行驶","语音提示后，保持车速 控制方向 匀速直线形式"))
        list.add(Data("掉头路段","打左灯，踩刹车，减速至一档，将车辆调整至掉头车道，绿化带与肩齐，打死，车正回正，掉头前注意观察时候有直行车"))
        list.add(Data("变更车道","打右灯3秒 向右变更\n" +
                "车速控制在50以内"))
        list.add(Data("公交车站","过指示牌30米，右侧路边涂有黄漆处，开始踩刹车，减速至30以内，匀速前进"))
        list.add(Data("路口右转弯","打右灯，踩刹车，减速减档将车辆驶到右转表现车道，车速控制在30以内"))
        list.add(Data("超车路段","打左灯，看左后视镜，向左变更车道，变更后直行一段距离，打右灯，看右边，驶回原"))
        list.add(Data("通过人行横道","踩刹车，减速至30以内"))
        list.add(Data("靠边停车","减速，打右灯，看右镜，驶入右侧车道，对白块，对齐后停车，拉手刹，挂空挡，松脚刹，松离合，开门，关门，考官签字"))
        recyclerView.adapter?.notifyDataSetChanged()
    }
}
