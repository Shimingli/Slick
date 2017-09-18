package com.github.slick.components;

import com.github.slick.AnnotatedPresenter;
import com.squareup.javapoet.MethodSpec;

/**
 * @author : Pedramrn@gmail.com
 *         Created on: 2017-03-06
 */

public class ViewCallbackGeneratorFragmentSupportImpl implements ViewCallbackGenerator {
    @Override
    public MethodSpec.Builder generate(MethodSpec.Builder builder, AnnotatedPresenter ap) {
        return builder.endControlFlow()
                .addStatement("$L.getFragmentManager().registerFragmentLifecycleCallbacks($L, false)",
                        ap.getViewVarName(), "delegate");
    }
}