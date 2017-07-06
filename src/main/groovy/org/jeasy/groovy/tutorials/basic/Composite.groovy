package org.jeasy.groovy.tutorials.basic

import org.jeasy.groovy.tutorials.work.MessageWork

import org.jeasy.flows.work.Work
import org.jeasy.flows.work.WorkReportPredicate

import static org.jeasy.flows.workflow.SequentialFlow.Builder.aNewSequentialFlow
import static org.jeasy.flows.workflow.RepeatFlow.Builder.aNewRepeatFlow
import static org.jeasy.flows.workflow.ConditionalFlow.Builder.aNewConditionalFlow
import static org.jeasy.flows.workflow.ParallelFlow.Builder.aNewParallelFlow
import static org.jeasy.flows.engine.WorkFlowEngineBuilder.aNewWorkFlowEngine

class Composite {

    static void main(String... args) {

        def label = 'Composite Flow'.replaceAll(/./){it+' '}
        def width = 80

        println """${'='*width}
                  |${label.center width }
                  |${'='*width}""".stripMargin()


        def work1 = new MessageWork("repeating");
        def work2 = new MessageWork("hello");
        def work3 = new MessageWork("world");
        def work4 = new MessageWork("ok");
        def work5 = new MessageWork("nok");

        def workflow = aNewSequentialFlow()                    // flow 4
                .execute(aNewRepeatFlow()                      // flow 1
                    .named("print repeating 3 times")
                    .repeat(work1)
                    .times(3)
                    .build())
                .then(aNewConditionalFlow()                    // flow 3
                        .execute(aNewParallelFlow()            // flow 2
                            .named("print 'hello' and 'world' in parallel")
                            .execute(work2, work3)
                            .build())
                        .when(WorkReportPredicate.COMPLETED)
                        .then(work4)
                        .otherwise(work5)
                        .build())
                .build();

        workflow.call()
    }
}
