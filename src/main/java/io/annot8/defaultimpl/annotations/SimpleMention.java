package io.annot8.defaultimpl.annotations;

import io.annot8.core.annotations.Mention;
import io.annot8.core.annotations.Span;

/**
 * This class is identical to {@link SimpleSpan}, except that it also implements
 * {@link Mention} so that the class can be used to separate types of {@link Span}s.
 */
public class SimpleMention extends SimpleSpan implements Mention{

}
