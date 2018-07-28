package sample

import java.io.File
import java.io.File

class Sample {
    String name

    def doSomething (){
        if (name){
            println "has name"
        }
        name ? "abc" : "xyz"
    }
}
