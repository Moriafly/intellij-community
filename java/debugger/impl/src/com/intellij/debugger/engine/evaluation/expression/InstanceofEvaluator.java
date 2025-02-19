// Copyright 2000-2022 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license.

/*
 * Class InstanceofEvaluator
 * @author Jeka
 */
package com.intellij.debugger.engine.evaluation.expression;

import org.jetbrains.annotations.NotNull;

class InstanceofEvaluator extends PatternLabelEvaluator {
  InstanceofEvaluator(@NotNull Evaluator operandEvaluator, @NotNull PatternEvaluator patternEvaluator) {
    super(operandEvaluator, patternEvaluator);
  }

  @Override
  public String toString() {
    return myOperandEvaluator + " instanceof " + myPatternEvaluator;
  }
}
