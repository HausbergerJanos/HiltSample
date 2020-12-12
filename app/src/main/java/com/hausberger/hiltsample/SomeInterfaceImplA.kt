package com.hausberger.hiltsample

import javax.inject.Inject

class SomeInterfaceImplA
@Inject
constructor() : SomeInterface {

    override fun getAThing() : String{
        return "A Thing1"
    }
}