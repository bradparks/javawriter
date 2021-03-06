/*
 * Copyright (C) 2014 Google, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.squareup.javawriter;

import java.io.IOException;

public final class ParameterWriter extends VariableWriter {
  private boolean varargs;

  ParameterWriter(TypeName type, String name) {
    super(type, name);
  }

  public void setVarargs(boolean varargs) {
    this.varargs = varargs;
  }

  @Override
  public Appendable write(Appendable appendable, Context context) throws IOException {
    writeAnnotations(appendable, context, ' ');
    writeModifiers(appendable);
    type().write(appendable, context);
    if (varargs) {
      appendable.append("...");
    }
    return appendable.append(' ').append(name());
  }
}
