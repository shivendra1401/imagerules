package com.flipkart.image.rules;

import org.im4java.core.IM4JavaException;

import java.io.IOException;

/**
 * Created by shivendra.singh on 09/07/14.
 */
public interface ImageRule <V,U,W>{
    public V validate(U u,W w) throws InterruptedException, IOException, IM4JavaException;
}