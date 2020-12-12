package com.hausberger.hiltsample

import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class SomeClass
@Inject
constructor(
    // Constructor injection
    private val someOtherClass: SomeOtherClass
) {

    fun doAThing(): String {
        return "Look, I do a thing!"
    }

    fun doSomeOtherThing(): String {
        return someOtherClass.doSomeOtherTing()
    }
}