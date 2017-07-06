package org.jeasy.groovy.tutorials.basic

import org.jeasy.groovy.tutorials.work.MessageWork
import org.jeasy.groovy.tutorials.work.CounterPredicate

import org.jeasy.flows.work.Work
import org.jeasy.flows.workflow.RepeatFlow.Builder as builder

import java.util.Scanner

class RepeatTimes {

    static void main(String... args) {

        def label = 'Repeat Times Flow'.replaceAll(/./){it+' '}
        def width = 80

        println """${'='*width}
                  |${label.center width }
                  |${'='*width}""".stripMargin()

        def wf = builder.aNewRepeatFlow()
                .named('Repeating Workflow using embedded TimesPredicate')
                .repeat(new MessageWork('Hello from repeating work'))
                .times(3)
                .build()

        println wf.name 
        wf.call()

        wf = builder.aNewRepeatFlow()
                .named('Repeating Workflow using Custom predicate')
                .repeat(new MessageWork('Hello from repeating work'))
                .until(new CounterPredicate(3))
                .build()

        println wf.name 
        wf.call()

    }
}
