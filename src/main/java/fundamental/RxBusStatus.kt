package com.pos.lib.bus

import com.pos.lib.constant.Constant
import io.reactivex.subjects.PublishSubject

/**
 * Created by phkim on 2017-12-22.
 */
class RxBusStatus{
    companion object {
        private var behaviorSubject : PublishSubject<Pair<Constant.BleStatus,String>>? = null
        fun getSubject():PublishSubject<Pair<Constant.BleStatus,String>>?{
            if(behaviorSubject ==null){
                behaviorSubject =  PublishSubject.create<Pair<Constant.BleStatus,String>>()
            }
            return behaviorSubject
        }

        fun release(){
            behaviorSubject = null
        }
    }
}