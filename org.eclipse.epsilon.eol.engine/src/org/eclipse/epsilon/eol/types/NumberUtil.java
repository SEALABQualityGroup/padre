/*******************************************************************************
 * Copyright (c) 2012 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.eol.types;

/*
 * NOTE: this class reimplements JLS sections 5.6.1 (unary numeric promotion)
 * and 5.6.2 (binary numeric promotion) to reduce casts and instanceof checks.
 */
public class NumberUtil {
	
	public static Number multiply(Number n1, Number n2) {
		if (n1 instanceof Double || n2 instanceof Double) {
			return n1.doubleValue() * n2.doubleValue();
		}
		else if (n1 instanceof Float || n2 instanceof Float) {
			return n1.floatValue() * n2.floatValue();
		}
		else if (n1 instanceof Long || n2 instanceof Long) {
			return n1.longValue() * n2.longValue();
		}
		else {
			return n1.intValue() * n2.intValue();
		}
	}

	public static Number add(Number n1, Number n2) {
		if (n1 instanceof Double || n2 instanceof Double) {
			return n1.doubleValue() + n2.doubleValue();
		}
		else if (n1 instanceof Float || n2 instanceof Float) {
			return n1.floatValue() + n2.floatValue();
		}
		else if (n1 instanceof Long || n2 instanceof Long) {
			return n1.longValue() + n2.longValue();
		}
		else {
			return n1.intValue() + n2.intValue();
		}
	}
	
	public static boolean greaterThan(Number n1, Number n2) {
		if (n1 instanceof Double || n2 instanceof Double) {
			return n1.doubleValue() > n2.doubleValue();
		}
		else if (n1 instanceof Float || n2 instanceof Float) {
			return n1.floatValue() > n2.floatValue();
		}
		else if (n1 instanceof Long || n2 instanceof Long) {
			return n1.longValue() > n2.longValue();
		}
		else {
			return n1.intValue() > n2.intValue();
		}
	}

	public static Number divide(Number n1, Number n2) {
		if (n1 instanceof Double || n2 instanceof Double) {
			return n1.doubleValue() / n2.doubleValue();
		}
		else if (n1 instanceof Float || n2 instanceof Float) {
			return n1.floatValue() / n2.floatValue();
		}
		else if (n1 instanceof Long || n2 instanceof Long) {
			return n1.longValue() / n2.longValue();
		}
		else {
			return n1.intValue() / n2.intValue();
		}
	}

	public static boolean lessThan(Number n1, Number n2) {
		if (n1 instanceof Double || n2 instanceof Double) {
			return n1.doubleValue() < n2.doubleValue();
		}
		else if (n1 instanceof Float || n2 instanceof Float) {
			return n1.floatValue() < n2.floatValue();
		}
		else if (n1 instanceof Long || n2 instanceof Long) {
			return n1.longValue() < n2.longValue();
		}
		else {
			return n1.intValue() < n2.intValue();
		}
	}

	public static Number subtract(Number n1, Number n2) {
		if (n1 instanceof Double || n2 instanceof Double) {
			return n1.doubleValue() - n2.doubleValue();
		}
		else if (n1 instanceof Float || n2 instanceof Float) {
			return n1.floatValue() - n2.floatValue();
		}
		else if (n1 instanceof Long || n2 instanceof Long) {
			return n1.longValue() - n2.longValue();
		}
		else {
			return n1.intValue() - n2.intValue();
		}
	}

	public static Number negative(Number n) {
		if (n instanceof Double) {
			return -n.doubleValue();
		}
		else if (n instanceof Float) {
			return -n.floatValue();
		}
		else if (n instanceof Long) {
			return -n.longValue();
		}
		else {
			return -n.intValue();
		}
	}

	public static boolean isEqual(Number n1, Number n2) {
		if (n1 instanceof Double || n2 instanceof Double) {
			return n1.doubleValue() == n2.doubleValue();
		}
		else if (n1 instanceof Float || n2 instanceof Float) {
			return n1.floatValue() == n2.floatValue();
		}
		else if (n1 instanceof Long || n2 instanceof Long) {
			return n1.longValue() == n2.longValue();
		}
		else {
			return n1.intValue() == n2.intValue();
		}
	}
	
}
