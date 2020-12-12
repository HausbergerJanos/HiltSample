package com.hausberger.hiltsample

import com.google.gson.Gson
import javax.inject.Inject

class SomeClass
@Inject
constructor(
    // Constructor injection
    @ImplA private val someInterfaceImplA: SomeInterface,
    @ImplB private val someInterfaceImplB: SomeInterface,
    private val gson: Gson
) {

    fun doAThingA(): String{
        return "Look I got: ${someInterfaceImplA.getAThing()}"
    }

    fun doAThingB(): String{
        return "Look I got: ${someInterfaceImplB.getAThing()}"
    }
}