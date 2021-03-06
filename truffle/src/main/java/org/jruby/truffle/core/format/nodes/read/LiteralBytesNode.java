/*
 * Copyright (c) 2015, 2016 Oracle and/or its affiliates. All rights reserved. This
 * code is released under a tri EPL/GPL/LGPL license. You can use it,
 * redistribute it and/or modify it under the terms of the:
 *
 * Eclipse Public License version 1.0
 * GNU General Public License version 2
 * GNU Lesser General Public License version 2.1
 */
package org.jruby.truffle.core.format.nodes.read;

import com.oracle.truffle.api.frame.VirtualFrame;
import org.jruby.truffle.RubyContext;
import org.jruby.truffle.core.format.nodes.PackNode;
import org.jruby.util.ByteList;

public class LiteralBytesNode extends PackNode {

    private final ByteList bytes;

    public LiteralBytesNode(RubyContext context, ByteList bytes) {
        super(context);
        this.bytes = bytes;
    }

    @Override
    public Object execute(VirtualFrame frame) {
        return bytes;
    }

}
