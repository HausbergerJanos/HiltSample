package com.hausberger.hiltsample

import javax.inject.Inject

class SomeInterfaceImplB
@Inject
constructor() : SomeInterface {

    override fun getAThing() : String{
        return "A Thing2"
    }
}