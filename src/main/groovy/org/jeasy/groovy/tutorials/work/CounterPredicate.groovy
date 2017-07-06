package org.jeasy.groovy.tutorials.work


import org.jeasy.flows.work.Work
import org.jeasy.flows.work.WorkReport
import org.jeasy.flows.work.WorkReportPredicate


class CounterPredicate implements WorkReportPredicate {

        private int times;
        private int counter = 0;

        public CounterPredicate(int times) {
            this.times = times;
        }

        @Override
        public boolean apply(WorkReport workReport) {
            counter++
            return counter < times;
        }

}
