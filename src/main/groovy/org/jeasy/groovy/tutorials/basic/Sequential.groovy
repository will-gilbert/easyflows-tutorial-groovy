package org.jeasy.groovy.tutorials.basic

import org.jeasy.groovy.tutorials.work.MessageWork

import org.jeasy.flows.work.Work
import org.jeasy.flows.workflow.SequentialFlow.Builder as builder

import java.util.Scanner

class Sequential {

    static void main(String... args) {

        def label = 'Sequential Flow'.replaceAll(/./){it+' '}
        def width = 80

        println """${'='*width}
                  |${label.center width }
                  |${'='*width}""".stripMargin()


        // The 'then' and 'execute' methods are the equivalent
        def wf = builder.aNewSequentialFlow()
            .named('Use only the execute method')
            .execute( new MessageWork('Hello from work1') )
            .execute( new MessageWork('Hello from work2') )
            .execute( new MessageWork('Hello from work3') )
            .execute( new MessageWork('Hello from work4') )
            .execute( new MessageWork('Hello from work5') )
            .execute( new MessageWork('Hello from work6') )
            .execute( new MessageWork('Hello from work7') )
            .build()
    
        println wf.name
        wf.call()
        

        wf = builder.aNewSequentialFlow()
            .named('Use only the then method')
            .then( new MessageWork('Hello from work1') )
            .then( new MessageWork('Hello from work2') )
            .then( new MessageWork('Hello from work3') )
            .then( new MessageWork('Hello from work4') )
            .then( new MessageWork('Hello from work5') )
            .then( new MessageWork('Hello from work6') )
            .then( new MessageWork('Hello from work7') )
            .build()

        println wf.name
        wf.call()
        

        wf = builder.aNewSequentialFlow()
            .named('Alternate between the then and execute method')
            .execute( new MessageWork('Hello from work1') )
            .then( new MessageWork('Hello from work2') )
            .execute( new MessageWork('Hello from work3') )
            .then( new MessageWork('Hello from work4') )
            .execute( new MessageWork('Hello from work5') )
            .then( new MessageWork('Hello from work6') )
            .execute( new MessageWork('Hello from work7') )
            .build()

        println wf.name
        wf.call()
        


    }
}
