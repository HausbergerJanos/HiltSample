package com.hausberger.hiltsample

import com.google.gson.Gson
import javax.inject.Inject

class SomeClass
@Inject
constructor(
    // Constructor injection
    private val someInterfaceImpl: SomeInterface
) {

    fun doAThing(): String{
        return "Look I got: ${someInterfaceImpl.getAThing()}"
    }
}