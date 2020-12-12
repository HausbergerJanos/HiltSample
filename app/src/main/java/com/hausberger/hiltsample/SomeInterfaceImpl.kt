package com.hausberger.hiltsample

import javax.inject.Inject

class SomeInterfaceImpl
@Inject
constructor() : SomeInterface {

    override fun getAThing() : String{
        return "A Thing"
    }
}