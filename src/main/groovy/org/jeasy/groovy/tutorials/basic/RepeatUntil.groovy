package org.jeasy.groovy.tutorials.basic

import org.jeasy.groovy.tutorials.work.MessageWork

import org.jeasy.flows.work.Work
import org.jeasy.flows.work.WorkReportPredicate
import org.jeasy.flows.workflow.RepeatFlow.Builder as builder

import java.util.Scanner

class RepeatUntil {

    static void main(String... args) {

        def label = 'Repeat Until Flow'.replaceAll(/./){it+' '}
        def width = 80

        println """${'='*width}
                  |${label.center width }
                  |${'='*width}""".stripMargin()


        def predicate = WorkReportPredicate.ALWAYS_FALSE;

        def wf = builder.aNewRepeatFlow()
                .named('Repeat Until Workflow')
                .repeat(new MessageWork('Hello from repeat until work'))
                .until(predicate)
                .build()

        println wf.name 
        wf.call()

    }
}
