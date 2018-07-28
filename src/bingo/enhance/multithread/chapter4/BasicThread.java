package bingo.enhance.multithread.chapter4;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.Iterator;

public class BasicThread {
	public static void main(String[] args) {
		ThreadMXBean mxBean = ManagementFactory.getThreadMXBean();
		ThreadInfo[] dumpAllThreads = mxBean.dumpAllThreads(false, false);
		for (ThreadInfo threadInfo : dumpAllThreads) {
			System.out.println(threadInfo.getThreadId() + "--" + threadInfo.getThreadName());
		}
	}

}
