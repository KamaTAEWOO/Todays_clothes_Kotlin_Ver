package com.eduforall.eduforall_launcher_app.util

import timber.log.Timber

class EduforallDebugTree : Timber.DebugTree() {
    override fun createStackElementTag(element: StackTraceElement): String? {
        return "${element.fileName}:${element.lineNumber}#${element.methodName}"
    }
}