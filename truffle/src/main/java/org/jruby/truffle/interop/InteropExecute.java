/*
 * Copyright (c) 2013, 2016 Oracle and/or its affiliates. All rights reserved. This
 * code is released under a tri EPL/GPL/LGPL license. You can use it,
 * redistribute it and/or modify it under the terms of the:
 *
 * Eclipse Public License version 1.0
 * GNU General Public License version 2
 * GNU Lesser General Public License version 2.1
 */
package org.jruby.truffle.interop;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.interop.ForeignAccess;
import com.oracle.truffle.api.source.SourceSection;
import org.jruby.truffle.RubyContext;
import org.jruby.truffle.language.RubyNode;

public class InteropExecute extends RubyNode {
    @Child private ExecuteMethodNode execute;

    public InteropExecute(RubyContext context, SourceSection sourceSection) {
        super(context, sourceSection);
        this.execute = ExecuteMethodNodeGen.create(context, sourceSection, null);
    }

    @Override
    public Object execute(VirtualFrame frame) {
        Object result = execute.executeWithTarget(frame, ForeignAccess.getReceiver(frame));
        return result;
    }
}
