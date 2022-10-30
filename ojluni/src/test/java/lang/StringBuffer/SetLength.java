/*
 * Copyright (c) 1997, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 */

/* @test
   @bug 4089062
   @summary A String created from a StringBuffer can be overwritten
   if setLength() to a value less than the buffer length is called
   on the StringBuffer and then the StringBuffer is appended to.
   @author Robert Field
*/

package test.java.lang.StringBuffer;

import org.testng.annotations.Test;

public class SetLength {
    // Android-changed: Add @Test annotation and remove empty arguments.
    // public static void main(String[] argv) throws Exception {
    @Test
    public static void main() throws Exception {
        StringBuffer active = new StringBuffer();
        active.append("first one");
        String a = active.toString();
        active.setLength(0);
        active.append("second");
        String b = active.toString();
        active.setLength(0);
        System.out.println("first: " + a);
        System.out.println("second: " + b);
        if (!a.equals("first one")) {
            throw new Exception("StringBuffer.setLength() overwrote string");
        }
    }
}
