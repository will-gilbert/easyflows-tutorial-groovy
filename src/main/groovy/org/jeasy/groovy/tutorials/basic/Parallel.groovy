package org.jeasy.groovy.tutorials.basic

import org.jeasy.groovy.tutorials.work.MessageWork

import org.jeasy.flows.work.Work
import org.jeasy.flows.workflow.ParallelFlow
import org.jeasy.flows.workflow.ParallelFlowExecutor
import static org.jeasy.flows.workflow.ParallelFlow.Builder.aNewParallelFlow

import java.util.Scanner

class Parallel {

    static void main(String... args) {

        def label = 'Parallel Flow'.replaceAll(/./){it+' '}
        def width = 80

        println """${'='*width}
                  |${label.center width }
                  |${'='*width}""".stripMargin()


        def work1 = new MessageWork('Hello from work1')
        def work2 = new MessageWork('Hello from work2')

        def parallelFlow = aNewParallelFlow()
                .named("ParallelFlow")
                .execute(work1, work2)
                .build()

        // when
        def parallelFlowReport = parallelFlow.call();

        parallelFlowReport.reports.each {
            println it.status
        }

    }
}
