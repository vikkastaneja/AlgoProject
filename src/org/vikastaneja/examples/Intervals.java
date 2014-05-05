package org.vikastaneja.examples;

import java.util.*;

/**
 * Created by vikastaneja on 5/5/14.
 */
public class Intervals {
	public int start;
	public int end;
	public Intervals(int start, int end) {
		if (start > end) {
			throw new RuntimeException("start can't be greater than end");
		}

		this.start = start;
		this.end = end;
	}
}
