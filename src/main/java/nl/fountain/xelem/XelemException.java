/*
 * Created on Oct 26, 2004
 * Copyright 2013 Henk van den Berg
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 * see license.txt
 *
 */
package nl.fountain.xelem;

/**
 * A wrapper class for several exceptions that may occur while working with the
 * {@link XFactory}, {@link XSerializer} or
 * {@link nl.fountain.xelem.expat.XLDocument}.
 */
public class XelemException extends Exception {

	/**
     * 
     */
	private static final long serialVersionUID = 1L;

	public XelemException(Throwable cause) {
		super(cause);
	}

}
